package net.northking.cloudplatform.utils;

/**
 * Created by Administrator on 2017/12/25 0025.
 */


import org.apache.commons.net.ftp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author linsan
 */
public class FtpHelper implements Closeable {

    private FTPClient ftp = null;

    List<String> ftpFilePathList=new ArrayList<>();//用来存储查询的ftp上批次目录下所有的文件的路径

    public FTPClient getFtp() {
        return ftp;
    }

    boolean _isLogin = false;
    public static FtpHelper getInstance() {
        return new FtpHelper();
    }
    private final static Logger logger = LoggerFactory.getLogger(FtpHelper.class);

    /**
     *
     * ftp 匿名登录
     * @param ip ftp服务地址
     * @param port 端口号
     */
    public boolean login(String ip,int port){
        //如果没有设置ftp用户可将username设为anonymous，密码为任意字符串
        return login(ip, port,"yunce","north.king");
    }
    /**
     *
     * ftp登录
     * @param ip ftp服务地址
     * @param port 端口号
     * @param uname 用户名
     * @param pass 密码
     */
    public boolean login(String ip,int port, String uname, String pass) {
        ftp = new FTPClient();
        //      boolean flag=false;
        try {
            // 连接
            ftp.connect(ip,port);
            _isLogin = ftp.login(uname, pass);
            Debug.printFormat("ftp：{0}",_isLogin?"登录成功":"登录失败");
            // 检测连接是否成功
            int reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                System.err.println("FTP服务器拒绝连接 ");
                return false;
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    /**
     * 上传后触发
     */
    public Function<FtpFileInfo, Boolean> onUploadFileAfter;

    /**
     *
     * ftp上传文件
     * @param localFileName 待上传文件
     * @param ftpDirName ftp 目录名
     * @param ftpFileName ftp目标文件
     * @return true||false
     */
    public boolean uploadFile(String userPath,String localFileName
            ,String ftpDirName
            , String ftpFileName) {
        return uploadFile(userPath,localFileName, ftpDirName, ftpFileName,false);
    }
    /**
     *
     * ftp上传文件
     * @param localFileName 待上传文件
     * @param ftpDirName ftp 目录名
     * @param ftpFileName ftp目标文件
     * @param deleteLocalFile 是否删除本地文件
     * @return true||false
     */
    public boolean uploadFile(String userPath,String localFileName
            , String ftpDirName
            , String ftpFileName
            , boolean deleteLocalFile) {


        Debug.printFormat("准备上传 [{0}] 到 ftp://{1}/{2}"
                ,localFileName
                ,ftpDirName
                ,ftpFileName);
        //      if(StringExtend.isNullOrEmpty(ftpDirName))
        //          ftpDirName="/";
        if(StringExtend.isNullOrEmpty(ftpFileName))
            throw new RuntimeException("上传文件必须填写文件名！");

        File srcFile = new File(localFileName);
        if(!srcFile.exists())
            throw new RuntimeException("文件不存在："+localFileName);

        try (FileInputStream fis = new FileInputStream(srcFile)) {
            //上传文件
            boolean flag = uploadFile(userPath,fis,ftpDirName,ftpFileName);
            //上传前事件
            if(onUploadFileAfter!=null){
                onUploadFileAfter.apply(new FtpFileInfo(localFileName,ftpDirName,ftpFileName));
            }
            //删除文件
            if(deleteLocalFile){
                srcFile.delete();
                Debug.printFormat("ftp删除源文件：{0}",srcFile);
            }
            fis.close();
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
        }
    }
    /**
     *
     * 直接在ftp上写文件
     * @param ftpDirName ftp 目录名
     * @param jsonStr  要写入的内容
     * @param ftpFileName ftp目标文件
     * @return true||false
     */
    public boolean uploadFile2(String userPath,String jsonStr
            ,String ftpDirName
            , String ftpFileName) {
        OutputStream out=null;
        Debug.printFormat("准备上传 [流] 到 ftp://{0}/{1}"
                ,ftpDirName
                ,ftpFileName);
        //      if(StringExtend.isNullOrEmpty(ftpDirName))
        //          ftpDirName="/";
        if(StringExtend.isNullOrEmpty(ftpFileName))
            throw new RuntimeException("上传文件必须填写文件名！");

        try {
            // 设置上传目录(没有则创建)
            if(!createDir(userPath,ftpDirName)){
                throw new RuntimeException("切入FTP目录失败："+ftpDirName);
            }
            ftp.setBufferSize(1024*8);
            //解决上传中文 txt 文件乱码
            ftp.setControlEncoding("GBK");
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
            conf.setServerLanguageCode("zh");
            // 设置文件类型（二进制）
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            //因为ftp server可能每次开启不同的端口来传输数据，但是在linux上，由于安全限制，可能某些端口没有开启，所以就出现阻塞
            ftp.enterLocalPassiveMode();//这个方法的意思就是每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据式
            // 上传
            String fileName = new String(ftpFileName.getBytes("GBK"),"iso-8859-1");
//            OutputStream out = ftp.appendFileStream(ftpFileName);
             out = ftp.storeFileStream(ftpFileName);
            out.write(jsonStr.getBytes());
            out.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(" 上传文件失败uploadFile" + e);
            return false;
        } finally {
            try {
                if(out!=null){
                    out.close();
                    ftp.completePendingCommand();//当进行多文件操作时，必须加上这个表示对ftp的操作命令还未结束，并且要放在流close后面
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * 直接将ftp的文件读进来
     * @param ftpFileName ftp目标文件
     */
    public String downloadFileFromFtp(String ftpFileName) {
        InputStream in=null;
        StringBuilder builder=null;
        if(StringExtend.isNullOrEmpty(ftpFileName))
            throw new RuntimeException("上传文件必须填写文件名！");

        try {
            ftpFileName = new String(ftpFileName.getBytes("UTF-8"),"iso-8859-1");
            FTPFile ftpFile=new FTPFile();
            ftpFile.setName(ftpFileName);
            if(ftpFile.isFile()){
                System.out.println(ftpFile.getSize());
            }
            String[] strings = ftpFileName.split("/");//将传来的路径分割为路径和文件名
            StringBuffer sb=new StringBuffer();//用来存储路径
            for (int i = 0; i < strings.length-1; i++) {
//                sb.append("/"); //目录前不要加/，因为ftp用户权限被控制了在/home/yunce下，
                sb.append(strings[i]);
                sb.append("/");
            }
            if(!ftp.changeWorkingDirectory(sb.toString())){
                System.out.println("切换目录失败："+sb.toString());
                return null;
            }
            //因为ftp server可能每次开启不同的端口来传输数据，但是在linux上，由于安全限制，可能某些端口没有开启，所以就出现阻塞
            ftp.enterLocalPassiveMode();//这个方法的意思就是每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据式
            ftp.setBufferSize(1024*8);
            System.out.println("当前目录："+ftp.printWorkingDirectory());
            // 下载
            in = ftp.retrieveFileStream(strings[strings.length-1]);//这里要的是文件名，所以是分割数组的最后一个
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String line;
            builder = new StringBuilder(150);
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            String jsonStr = builder.toString();
            reader.close();
//            ftp.getReply();
            return jsonStr;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(" 下载失败downloadFile" + e);
            return null;
        } finally {
            try{
                if(in!=null){
                    in.close();
                    ftp.completePendingCommand();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * ftp上传文件 (使用inputstream)
     * @param ftpDirName ftp 目录名
     * @param ftpFileName ftp目标文件
     * @return true||false
     */
    public boolean uploadFile(String userPath,FileInputStream uploadInputStream
            ,String ftpDirName
            , String ftpFileName) {
        Debug.printFormat("准备上传 [流] 到 ftp://{0}/{1}"
                ,ftpDirName
                ,ftpFileName);
        //      if(StringExtend.isNullOrEmpty(ftpDirName))
        //          ftpDirName="/";
        if(StringExtend.isNullOrEmpty(ftpFileName))
            throw new RuntimeException("上传文件必须填写文件名！");

        try {
            // 设置上传目录(没有则创建)
            if(!createDir(userPath,ftpDirName)){
                throw new RuntimeException("切入FTP目录失败："+ftpDirName);
            }
            ftp.setBufferSize(1024);
            //解决上传中文 txt 文件乱码
            ftp.setControlEncoding("GBK");
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
            conf.setServerLanguageCode("zh");


            // 设置文件类型（二进制）
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            // 上传
            String fileName = new String(ftpFileName.getBytes("GBK"),"iso-8859-1");
            if(ftp.storeFile(fileName, uploadInputStream)){
                uploadInputStream.close();
                Debug.printFormat("文件上传成功：{0}/{1}"
                        ,ftpDirName
                        ,ftpFileName);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
        }
    }
    /**
     * 下载ftp整个目录
     * @param ftpDirName ftp目录名
     * @return
     *  @author linsan
     */
    public boolean downloadDir(String localPath,String ftpDirName) {
        try {
            if("".equals(ftpDirName))
                ftpDirName="/";
            String dir = new String(ftpDirName.getBytes("GBK"),"iso-8859-1");
            if(!ftp.changeWorkingDirectory(dir)){
                System.out.println("切换目录失败："+ftpDirName);
                return false;
            }
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (!ff.isDirectory()) {//如果是文件的话
                    String name = ff.getName();
                    String path=localPath+"/"+dir+"/"+name;
                    File file = new File(path);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.delete();
                    file.createNewFile();
                    System.out.println("file=====>"+file);
                    FileOutputStream is = new FileOutputStream(file);
                    ftp.retrieveFile(ff.getName(), is);
//                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                    System.out.println("下载ftp文件已下载："+name);
                }else{
                    String s=dir+"/"+ff.getName();
                    downloadDir(localPath,s);
                }
            }
//            System.out.println("下载ftp文件失败："+name+";目录："+ftpDirName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

/**
     * 下载文件
     * @param ftpDirName ftp目录名
     * @param ftpFileName ftp文件名
     * @param localFileFullName 本地文件名
     * @return
     *  @author linsan
     */

    public boolean downloadFile(String ftpDirName,
                                String ftpFileName, String localFileFullName) {
        try {
            if("".equals(ftpDirName))
                ftpDirName="/";
            String dir = new String(ftpDirName.getBytes("GBK"),"iso-8859-1");
            if(!ftp.changeWorkingDirectory(dir)){
                System.out.println("切换目录失败："+ftpDirName);
                return false;
            }
            FTPFile[] fs = ftp.listFiles();
            String fileName = new String(ftpFileName.getBytes("GBK"),"iso-8859-1");
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    FileOutputStream is = new FileOutputStream(new File(localFileFullName));
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                    System.out.println("下载ftp文件已下载："+localFileFullName);
                    return true;
                }
            }
            System.out.println("下载ftp文件失败："+ftpFileName+";目录："+ftpDirName);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 获取ftp上指定目录的所有文件的路径
     * @param ftpDirName 指定目录
     * @return
     */
    //获取ftp上对应文件夹里的所有文件
    public List<String> listFile(String ftpDirName){
        try {
            if("".equals(ftpDirName)) {
                ftpDirName="/";
            }
            if(!ftpDirName.startsWith("/")){
                ftpDirName="/"+ftpDirName;
            }
            if(!ftpDirName.endsWith("/")){
                ftpDirName=ftpDirName+"/";
            }
            ftpDirName=ftpDirName.replace("\\","/");// 替换成/，这样才能在服务器上创建目录
            ftpDirName = StringExtend.trimStart(ftpDirName, "/");
            ftpDirName = StringExtend.trimEnd(ftpDirName, "/");
            ftpDirName = new String(ftpDirName.getBytes("GBK"),"iso-8859-1");
            if(!ftp.changeWorkingDirectory(ftpDirName)){
                System.out.println("切换目录失败："+ftpDirName);
                System.out.println("是列表时");
                return null;
            }
            ftp.enterLocalPassiveMode();
            FTPFile[] ftpFiles = ftp.listFiles();
            for (FTPFile ftpFile:ftpFiles){
                if(ftpFile.isDirectory()){
                    ftpDirName=ftpDirName+"/"+ftpFile.getName();
                    listFile(ftpFile.getName());//继续递归
                } else {
                    String ftpFilePath = ftp.printWorkingDirectory()+"/"+ftpFile.getName();
                    ftpFilePathList.add(ftpFilePath);
                }
            }
            if(!ftp.changeToParentDirectory()){
                System.out.println("切换回上一层目录失败");
                return null;
            }
            return ftpFilePathList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            /*try {
                ftp.completePendingCommand();
            }catch (Exception e){
                e.printStackTrace();
            }*/
        }
    }
    /**
     *
     * 删除ftp上的文件
     *
     * @param ftpFileName
     * @return true || false
     */
    public boolean removeFile(String ftpFileName) {
        boolean flag = false;
        Debug.printFormat("待删除文件：{0}"
                ,ftpFileName);
        try {
            ftpFileName = new String(ftpFileName.getBytes("GBK"),"iso-8859-1");
            flag = ftp.deleteFile(ftpFileName);
            Debug.printFormat("删除文件：[{0}]"
                    ,flag?"成功":"失败");
            return flag;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 删除目录
     * @return
     */
    private String dirPath=null;
    public boolean removeDir(String ftpDirName,String userPath){
        try {
            if(StringUtils.isEmpty(dirPath)){
                dirPath=ftpDirName;
            }
            if("".equals(ftpDirName)) {
                ftpDirName="/";
            }
            if(!ftpDirName.endsWith("/")){
                ftpDirName=ftpDirName+"/";
            }
            ftpDirName=ftpDirName.replace("\\","/");// 替换成/，这样才能在服务器上创建目录
            if(!ftpDirName.startsWith(userPath)){
                ftpDirName = userPath+ftpDirName;
            }
            ftpDirName = new String(ftpDirName.getBytes("GBK"),"iso-8859-1");
            if(!ftp.changeWorkingDirectory(ftpDirName)){
                System.out.println("切换目录失败："+ftpDirName);
                return false;
            }
            ftp.enterLocalPassiveMode();
            FTPFile[] ftpFiles = ftp.listFiles();
            for (FTPFile ftpFile:ftpFiles){
                if(ftpFile.isDirectory()){
                    ftpDirName=ftpDirName+ftpFile.getName();
                    removeDir(ftpDirName,userPath);//继续递归
                    ftp.removeDirectory(ftpDirName);
                } else {
                    String ftpFilePath =ftpDirName+ftpFile.getName();
                    boolean b = ftp.deleteFile(ftpFilePath);
                }
            }
            if(!ftp.changeToParentDirectory()){
                System.out.println("切换回上一层目录失败");
                return false;
            }
            boolean b = ftp.removeDirectory(ftpDirName);
            if(b){
                removeDir(dirPath ,userPath);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            /*try {
                ftp.completePendingCommand();
            }catch (Exception e){
                e.printStackTrace();
            }*/
        }
    }
/*
    */
/**
     * 删除空目录
     * @param dir
     * @return
     *//*

    public boolean removeDir(String dir){
        if(!StringExtend.startWith(dir, "/"))
            dir="/"+dir;
        try {
            String d = new String(dir.toString().getBytes("GBK"),"iso-8859-1");
            boolean b = ftp.deleteFile(d);

            System.out.println("....>>"+b);
            System.out.println("....>>"+d);
            return ftp.removeDirectory(d);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
*/
    /**
     * 创建目录(有则切换目录，没有则创建目录)
     * @param dir
     * @return
     */
    public boolean createDir(String userPath,String dir){
        if(StringExtend.isNullOrEmpty(dir))
            return true;
        String d;
        try {
            //目录编码，解决中文路径问题
            System.out.println("进来创建目录方法了");
            d = new String(dir.toString().getBytes("GBK"),"iso-8859-1");
            //尝试切入目录
            if(ftp.changeWorkingDirectory(d))
                return true;
            dir = StringExtend.trimStart(dir, "/");
            dir = StringExtend.trimEnd(dir, "/");
            dir=dir.replace("\\","/");// 替换成/，这样才能在服务器上创建目录
            String[] arr =  dir.split("/");
            StringBuffer sbfDir=new StringBuffer();
            //循环生成子目录
            sbfDir.append(userPath);//由于ftp环境问题，在这里要加上该用户的根目录,userPath:/home/yunce/
            for(String s : arr){
                sbfDir.append(s);
                sbfDir.append("/");
                //目录编码，解决中文路径问题
                d = new String(sbfDir.toString().getBytes("GBK"),"iso-8859-1");
                //尝试切入目录
                if(ftp.changeWorkingDirectory(d)){
                    System.out.println("成功到切换目录："+d);
                    continue;
                }else{
                    System.out.println("没有到切换目录："+d);
                }
                if(!ftp.makeDirectory(d)){
                    System.out.println("[失败]ftp创建目录："+d);
                    return false;
                }
                System.out.println("[成功]创建ftp目录："+d);
            }
            //将目录切换至指定路径
            return ftp.changeWorkingDirectory(d);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    /**
     *
     * 销毁ftp连接
     *
     */
    private void closeFtpConnection() {
        _isLogin = false;
        if (ftp != null) {
            if (ftp.isConnected()) {
                try {
                    ftp.logout();
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     *
     * 销毁ftp连接
     *
     */
    @Override
    public void close() {
        this.closeFtpConnection();
    }

    public static class FtpFileInfo{
        public FtpFileInfo(String srcFile,String ftpDirName,String ftpFileName){
            this.ftpDirName=ftpDirName;
            this.ftpFileName=ftpFileName;
            this.srcFile=srcFile;
        }
        String srcFile;
        String ftpDirName;
        String ftpFileName;
        String ftpFileFullName;

        public String getSrcFile() {
            return srcFile;
        }
        public void setSrcFile(String srcFile) {
            this.srcFile = srcFile;
        }
        public String getFtpDirName() {
            return ftpDirName;
        }
        public void setFtpDirName(String ftpDirName) {
            this.ftpDirName = ftpDirName;
        }
        public String getFtpFileName() {
            return ftpFileName;
        }
        public void setFtpFileName(String ftpFileName) {
            this.ftpFileName = ftpFileName;
        }
        /**
         * 获取ftp上传文件的完整路径名
         * @return
         *  @author linsan
         */
        public String getFtpFileFullName() {
            return PathExtend.Combine("/",ftpDirName,ftpFileName);
        }

    }

    /**
     * 文件备份
     * @param sourceFileName
     * @param sourceDir
     * @param targetDir
     * @throws IOException
     */
    public void copyFile(String userPath,String sourceFileName, String sourceDir, String targetDir) throws IOException {
        ByteArrayInputStream in = null;
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        try {
            if (!createDir(userPath,targetDir)) {
                createDir(userPath,targetDir);
            }
            ftp.setBufferSize(1024 * 2);
            // 变更工作路径
            ftp.changeWorkingDirectory(sourceDir);
            // 设置以二进制流的方式传输
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 将文件读到内存中
            ftp.retrieveFile(new String(sourceFileName.getBytes("GBK"), "iso-8859-1"), fos);
            in = new ByteArrayInputStream(fos.toByteArray());
            if (in != null) {
                ftp.changeWorkingDirectory(targetDir);
                ftp.storeFile(new String(sourceFileName.getBytes("GBK"), "iso-8859-1"), in);
            }
        } finally {
            // 关闭流
            if (in != null) {
                in.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 复制文件夹.
     *
     * @param sourceDir
     * @param targetDir
     * @throws IOException
     */
    public void copyDirectiory(String userPath,String sourceDir, String targetDir) throws IOException {
        // 新建目标目录
        if (!createDir(userPath,targetDir)) {
            createDir(userPath,targetDir);
        }
        // 获取源文件夹当前下的文件或目录
        // File[] file = (new File(sourceDir)).listFiles();
        FTPFile[] ftpFiles = ftp.listFiles(sourceDir);
        for (int i = 0; i < ftpFiles.length; i++) {
            if (ftpFiles[i].isFile()) {
                copyFile(userPath,ftpFiles[i].getName(), sourceDir, targetDir);
            } else if (ftpFiles[i].isDirectory()) {
                copyDirectiory(userPath,sourceDir + "/" + ftpFiles[i].getName(), targetDir + "/" + ftpFiles[i].getName());
            }
        }
    }

    /**
     * 复制文件夹，采用移动的方式来备份
     *
     * @param sourceDir
     * @param targetDir
     * @throws IOException
     */
    public void moverDirectiory(String userPath, String sourceDir, String targetDir) throws IOException {
        if (!ftp.changeWorkingDirectory(userPath + targetDir)) {
            boolean b = ftp.makeDirectory(userPath + targetDir);
        }
        boolean flag = ftp.rename(userPath + sourceDir, userPath + targetDir + "/" + sourceDir);
        if (!flag) {
            logger.info("moverDirectiory方法：移动失败了");
        }
    }
}
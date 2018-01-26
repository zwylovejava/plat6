package net.northking.cloudplatform.utils;

import net.northking.cloudplatform.controller.JobController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/26 0026.
 */
public class FileUtil {

    private final static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static String rwFile(String ftpPath,String mrk,String filePath,String fileName,String json) throws Exception{
        FileWriter fw = null;
        BufferedWriter bw=null;
        String uuid = UUIDUtil.getUUID();
        String path=ftpPath+"/"+mrk+"/"+filePath+"/"+fileName+".txt";
//        "E:\\json.txt"
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

            file.delete();
            file.createNewFile();

        try {
            // 定义FileWriter对象，关联文件f:\text.txt，用来向文件写内容
            fw = new FileWriter(file, true);
             bw=new BufferedWriter(fw);
            bw.write(json);
            bw.flush();//强制输出下免得 en写入数据不完整
          return uuid;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.info(" rwFile" + e);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info(" rwFile" + e);
        } finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info(" rwFile" + e);
                }
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.info(" rwFile" + e);
                    }
                }
            }
        }
        return null;
    }
    public static String rbFile(String path){
        BufferedReader br = null;
        // 定义bufferedReader对象，用来读取d:\1.txt文件内容
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            StringBuffer sb=new StringBuffer();
            String line = "";// 用来保存每次读取一行的内容
            while ((line = br.readLine()) != null) {
                sb.append(line);
                System.out.println(line);
            }
            br.close();// 关闭输入流
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取目录下所有的文件
     * @param strPath
     * @return
     */
    public static List<File> getFileList(String strPath) {
        File dir = new File(strPath);
        List<File> filelist=new ArrayList<>();
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
                } else if (fileName.endsWith("text")) { // 判断文件名是否以.avi结尾
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println("---" + strFileName);
                    filelist.add(files[i]);
                } else {
                    continue;
                }
            }

        }
        return filelist;
    }
}

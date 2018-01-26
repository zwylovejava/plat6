package net.northking.cloudplatform.utils;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by laodeng on 2017/11/23.
 *
 * 发送邮件工具类
 */
public  class MailUtil {

        //smtp服务器
        private static String host = "";
        //发件人地址
        private static String from = "";
        //收件人地址
        private static String to = "";
        //用户名
        private static String userName = "";
        //密码
        private static String password = "";
        //邮件标题
        private static String subject = "";
        //邮件的正文
        private static String content = "";

        //地址信息赋值
        public static void setAddress(String fromStr , String toStr , String subjectStr ,String contentStr){
            from = fromStr ;
            to = toStr ;
            subject = subjectStr ;
            content = contentStr ;
        }


        //邮件发送方法
        public static void send(String hostStr ,String userNameStr ,String passwordStr ){
            host = hostStr ;
            userName = userNameStr ;
            password = passwordStr ;

            //创建参数配置
            Properties properties = new Properties();

            //授权
            properties.put("mail.smtp.auth" , "true");

            //创建session
            Session session = Session.getDefaultInstance(properties);

            //debug调试
            session.setDebug(true);

            //定义消息对象
            MimeMessage message = new MimeMessage(session);

            try {
                //加载发件人地址
                message.setFrom(new InternetAddress(from));
                //收件人地址
                message.addRecipient(Message.RecipientType.TO , new InternetAddress(to));
                //标题
                message.setSubject(subject);
                message.setContent(content,"text/html ;charset=UTF-8");

                // 保存邮件
                message.saveChanges();
                // 获取邮件传输对象
                Transport transport = session.getTransport("smtp");
                // 连接服务器的邮箱
                transport.connect(host ,userName, password);
                // 把邮件发送出去
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {


        MailUtil.setAddress("","","" ,"");

        //因为程序属于第三方登录，所有登录密码必须使用163的授权码
        MailUtil.send("smtp.163.com" ,"hbh_2015@163.com"  ,"r0010400880099");
    }
}

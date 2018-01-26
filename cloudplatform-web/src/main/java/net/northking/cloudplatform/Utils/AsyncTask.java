package net.northking.cloudplatform.Utils;

import com.alibaba.fastjson.JSONObject;
import net.northking.cloudplatform.constants.MQConstants;
import net.northking.cloudplatform.domain.project.CltCustomer;
import net.northking.cloudplatform.dto.cust.CustomerDTO;
import net.northking.cloudplatform.query.user.OrgQuery;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;
import net.northking.cloudplatform.sender.FanoutSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步类
 * Created by Administrator on 2018/1/12 0012.
 */
@Component
public class AsyncTask {

    @Autowired
    private FanoutSender sender;
    private final static Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    /**
     * 数据同步：用于云平台同步数据到客户端
     * @throws InterruptedException
     */
    @Async
    public void dsSask(CltCustomer cust, UserAndLoginQuery userAndLoginQuery, OrgQuery orgQuery) throws Exception{
        if(cust==null&&userAndLoginQuery==null&&orgQuery==null){
            throw new Exception("数据不完整，请确认");
        }
        CustomerDTO dto=new CustomerDTO();
        dto.setCust(cust);
        dto.setOrgQuery(orgQuery);
        dto.setUserAndLoginQuery(userAndLoginQuery);
        String dtoJson = JSONObject.toJSONString(dto);
        System.out.println("dtoJson:"+dtoJson);
        logger.info("dsSask===========>> dtoJson:"+dtoJson);
        //采用rabbitMQ方式发送到客户端
        sender.send(MQConstants.customerExchangeP,dtoJson);
    }
}

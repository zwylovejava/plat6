package net.northking.cloudplatform.utils;

import com.alibaba.fastjson.JSONObject;
import net.northking.cloudplatform.constants.MQConstants;
import net.northking.cloudplatform.dto.rabbitmq.CltBatchMQDTO;
import net.northking.cloudplatform.enums.CltBatchStatus;
import net.northking.cloudplatform.service.BatchService;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
@Component

public class FanoutReceiverA {
    @Autowired
    private BatchService batchService;
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(FanoutReceiverA.class);


    /**
     * 监听客户端同步过来的批次数据
     * @param jsonString
     */
    @RabbitHandler
    @RabbitListener(queues = MQConstants.batchQueueC)
    public void process(String jsonString) {
        CltBatchMQDTO cltBatchMQDTO=null;
        try {
             cltBatchMQDTO = JSONObject.parseObject(jsonString, CltBatchMQDTO.class);
            if(cltBatchMQDTO==null){
                throw new Exception("同步出错，没有数据");
            }
            if(StringUtils.isEmpty(cltBatchMQDTO.getBatchId())){
                throw new Exception("同步出错，没有批次id");
            }
            logger.info(cltBatchMQDTO.getMsg());
            //如果该批次状态为发送中，即2，并且success为true,则在云平台再同步数据
            if(CltBatchStatus.SENDING.getCode().equals(cltBatchMQDTO.getStatus())&&cltBatchMQDTO.isSuccess()){
                batchService.receiveBatch(cltBatchMQDTO.getBatchId());
            }else if(CltBatchStatus.CANCEL.getCode().equals(cltBatchMQDTO.getStatus())&&cltBatchMQDTO.isSuccess()){
                //如果同步过来的批次是撤回，先判断该批次在本地的状态，是否在分配主管之前
                batchService.canCelBatchById(cltBatchMQDTO.getBatchId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (cltBatchMQDTO!=null){
                logger.info("接收到客户端同步过来的批次为:"+cltBatchMQDTO.getBatchId()+"后加载出现错误："+e);
            }else{
                logger.info("接收到客户端同步过来的批次后加载出现错误："+e);
            }

        }
    }
}
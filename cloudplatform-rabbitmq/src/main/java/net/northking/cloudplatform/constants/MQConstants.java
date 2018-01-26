package net.northking.cloudplatform.constants;

/**
 * Created by Administrator on 2018/1/14 0014.
 */
public class MQConstants {


    /**
     * 批次业务相关交换机和队列
     */
    //客户端
    public final static String batchExchangeC="cloudtestBatchExchange";//批次数据同步交换机
    public  final static String batchQueueC="cloudtestbatchQueue";//批次数据同步队列
    //云端
    public final static String batchExchangeP="platfromBatchExchange";//批次数据同步交换机
    public  final static String batchQueueP="platfrombatchQueue";//批次数据同步队列


    /**
     * 顾客业务相关交换机和队列
     */
    //云端
    public final static String customerExchangeP="platfromcustomerExchange";//客户数据同步交换机
    public  final static String customerQueueP="platfromcustomerQueue";//客户数据同步队列
}

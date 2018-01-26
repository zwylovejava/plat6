package net.northking.cloudplatform.service;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.testbug.CltTestBug;
import net.northking.cloudplatform.query.testbug.TestBugQuery;

import java.util.List;


/**
 * @Title:
 * @Description: CltBug业务逻辑层
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-25 13:36
 * @UpdateUser:
 * @Version:0.1
 */
public interface TestBugService {

    //创建缺陷
    Integer addTestBug(TestBugQuery testBugQuery)throws Exception;

    //缺陷列表查询
    Page<CltTestBug> queryTestBugList(TestBugQuery testBugQuery)throws Exception;

    //根据bugId查询缺陷详情
    CltTestBug queryBugByBugId(String bugId)throws Exception;


    List<CltTestBug> queryTestBugById(TestBugQuery testBugQuery);
    //根据批次ID查询缺陷列表
    List<CltTestBug> queryTestBugByBathId(TestBugQuery testBugQuery);

    //根据caseId查询缺陷列表
    List<CltTestBug> queryTestBugByCaseId(TestBugQuery testBugQuery);






}

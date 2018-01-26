package net.northking.cloudplatform.service.testbug;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.testbug.CltTestBug;
import net.northking.cloudplatform.query.testbug.TestBugQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by liujinghao on 2017/12/26.
 */
public interface TestBugService {

    //添加缺陷信息
     ResultInfo<Integer> addTestBug(@RequestBody @Validated TestBugQuery testBugQuery) throws Exception;

    //缺陷信息列表
     ResultInfo<Page<CltTestBug>> queryAllTestBugs(@RequestBody TestBugQuery testBugQuery)throws Exception;

    //缺陷信息详情
     ResultInfo<CltTestBug> queryBugByBugId(@RequestBody TestBugQuery testBugQuery) throws Exception;
}

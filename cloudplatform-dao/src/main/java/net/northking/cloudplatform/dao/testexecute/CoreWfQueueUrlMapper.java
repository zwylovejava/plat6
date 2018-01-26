package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.testexecute.CltJob;
import net.northking.cloudplatform.domain.testexecute.CltJobExample;
import net.northking.cloudplatform.domain.testexecute.CoreWfQueueUrl;
import net.northking.cloudplatform.domain.testexecute.CoreWfQueueUrlExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CoreWfQueueUrlMapper  extends BaseDao<CoreWfQueueUrl,CoreWfQueueUrlExample,String> {

}
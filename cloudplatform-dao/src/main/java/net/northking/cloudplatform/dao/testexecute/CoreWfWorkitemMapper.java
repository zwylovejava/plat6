package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.testexecute.CoreWfWorkitem;
import net.northking.cloudplatform.domain.testexecute.CoreWfWorkitemExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CoreWfWorkitemMapper  extends BaseDao<CoreWfWorkitem,CoreWfWorkitemExample,String> {

}
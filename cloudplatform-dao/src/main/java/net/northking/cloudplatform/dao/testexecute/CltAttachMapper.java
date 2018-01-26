package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltAttach;
import net.northking.cloudplatform.domain.testexecute.CltAttachExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface CltAttachMapper {
    int countByExample(CltAttachExample example);

    int deleteByExample(CltAttachExample example);

    int deleteByPrimaryKey(String attachId);

    int insert(CltAttach record);

    int insertSelective(CltAttach record);

    List<CltAttach> selectByExample(CltAttachExample example);

    CltAttach selectByPrimaryKey(String attachId);

    int updateByExampleSelective(@Param("record") CltAttach record, @Param("example") CltAttachExample example);

    int updateByExample(@Param("record") CltAttach record, @Param("example") CltAttachExample example);

    int updateByPrimaryKeySelective(CltAttach record);

    int updateByPrimaryKey(CltAttach record);
}
package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltAppAnalyse;
import net.northking.cloudplatform.domain.testexecute.CltAppAnalyseExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CltAppAnalyseMapper {
    int countByExample(CltAppAnalyseExample example);

    int deleteByExample(CltAppAnalyseExample example);

    int deleteByPrimaryKey(String id);

    int insert(CltAppAnalyse record);

    int insertSelective(CltAppAnalyse record);

    List<CltAppAnalyse> selectByExample(CltAppAnalyseExample example);

    CltAppAnalyse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CltAppAnalyse record, @Param("example") CltAppAnalyseExample example);

    int updateByExample(@Param("record") CltAppAnalyse record, @Param("example") CltAppAnalyseExample example);

    int updateByPrimaryKeySelective(CltAppAnalyse record);

    int updateByPrimaryKey(CltAppAnalyse record);
}
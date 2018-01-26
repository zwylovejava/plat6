package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltRound;
import net.northking.cloudplatform.domain.testexecute.CltRoundExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface CltRoundMapper {
    int countByExample(CltRoundExample example);

    int deleteByExample(CltRoundExample example);

    int deleteByPrimaryKey(String roundId);

    int insert(CltRound record);

    int insertSelective(CltRound record);

    List<CltRound> selectByExample(CltRoundExample example);

    CltRound selectByPrimaryKey(String roundId);

    int updateByExampleSelective(@Param("record") CltRound record, @Param("example") CltRoundExample example);

    int updateByExample(@Param("record") CltRound record, @Param("example") CltRoundExample example);

    int updateByPrimaryKeySelective(CltRound record);

    int updateByPrimaryKey(CltRound record);
}
package com.linkcircle.mapper;

import com.linkcircle.entity.CtdVccidIp;
import com.linkcircle.entity.CtdVccidIpExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CtdVccidIpMapper {
    int countByExample(CtdVccidIpExample example);

    int deleteByExample(CtdVccidIpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CtdVccidIp record);

	public List<String> findIpByIp(Map<String, Object> map);
    
    int insertSelective(CtdVccidIp record);

    List<CtdVccidIp> selectByExample(CtdVccidIpExample example);

    CtdVccidIp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CtdVccidIp record, @Param("example") CtdVccidIpExample example);

    int updateByExample(@Param("record") CtdVccidIp record, @Param("example") CtdVccidIpExample example);

    int updateByPrimaryKeySelective(CtdVccidIp record);

    int updateByPrimaryKey(CtdVccidIp record);
}
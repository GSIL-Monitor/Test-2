package com.linkcircle.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.linkcircle.entity.CtdDisplayNum;
import com.linkcircle.entity.CtdDisplayNumExample;

@Repository
public interface CacheNumberMapper {
	public List<String> findDisplayNum(Map<String, Object> map);
	public List<String> findDisplayNumByCode(Map<String, Object> map);
	int countByExample(CtdDisplayNumExample example);
	int deleteByExample(CtdDisplayNumExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(CtdDisplayNum record);
	int insertSelective(CtdDisplayNum record);
	List<CtdDisplayNum> selectByExample(CtdDisplayNumExample example);
	CtdDisplayNum selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") CtdDisplayNum record, @Param("example") CtdDisplayNumExample example);
	int updateByExample(@Param("record") CtdDisplayNum record, @Param("example") CtdDisplayNumExample example);
	int updateByPrimaryKeySelective(CtdDisplayNum record);
	int updateByPrimaryKey(CtdDisplayNum record);
}

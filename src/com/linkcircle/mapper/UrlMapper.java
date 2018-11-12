/**
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: UrlIpMapper.java
 * @Prject: CTDNOTICE
 * @Package: com.linkcircle.mapper
 * @Description: TODO
 * @author: awbsheng@gmail.com
 * @date: 2017年8月29日 上午10:09:32
 * @version: V1.0
 */
package com.linkcircle.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.linkcircle.entity.CtdVccidUrl;
import com.linkcircle.entity.CtdVccidUrlExample;

/** 
 * @ClassName: UrlIpMapper 
 * @Description: TODO
 * @author: wbsheng@gmail.com
 * @date: 2017年8月29日 上午10:09:32  
 */
@Repository
public interface UrlMapper {
	public List<String> findUrlByVTS(Map<String, Object> map);

	int countByExample(CtdVccidUrlExample example);
	int deleteByExample(CtdVccidUrlExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(CtdVccidUrl record);
	int insertSelective(CtdVccidUrl record);
	List<CtdVccidUrl> selectByExample(CtdVccidUrlExample example);
	CtdVccidUrl selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") CtdVccidUrl record, @Param("example") CtdVccidUrlExample example);
	int updateByExample(@Param("record") CtdVccidUrl record, @Param("example") CtdVccidUrlExample example);
	int updateByPrimaryKeySelective(CtdVccidUrl record);
	int updateByPrimaryKey(CtdVccidUrl record);
}

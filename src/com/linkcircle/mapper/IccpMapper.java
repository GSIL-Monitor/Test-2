package com.linkcircle.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.linkcircle.entity.IccpConfigureInfo;

/**
 * @author youngder
 * @date 2017年12月28日 下午15:37:47
 */

@Repository
public interface IccpMapper {
	//查询所有iccp-sn信息
	public List<IccpConfigureInfo> findIccpSnInfo(String source);
	//查询sn的ip是否存在
	public List<String> findAllSnIp(String ip);
	//查询所有iccp-sbc信息
	public List<IccpConfigureInfo> findIccpSbcInfo(String source);
	//查询sbc的ip是否存在
	public List<String> findAllSbcIp(String ip);
	//增加sb節點
	public void addSn(IccpConfigureInfo iccpConfigureInfo);
	//新增sbc节点
	public void addSbc(IccpConfigureInfo iccpConfigureInfo);
	//删除sn节点
	public void removeSn(String ip);
	//删除sbc节点
	public void removeSbc(String ip);
	//恢复sn节点
	public void resetSn(String ip);
	//恢复sbc节点
	public void resetSbc(String ip);
}

package com.linkcircle.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.linkcircle.entity.VoiceNum;

@Repository
public interface NoticeMapper {
	public int insertVoice(VoiceNum voiceNum);

	public int updateVoiceById(VoiceNum voiceNum);

	public List<String> findVoiceByVDBS(Map<String, Object> map);
}

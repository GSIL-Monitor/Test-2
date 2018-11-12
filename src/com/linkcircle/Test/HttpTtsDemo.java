/**
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: HttpTtsDemo.java
 * @Prject: CTDNOTICE
 * @Package: com.linkcircle.Test
 * @Description: TODO
 * @author: awbsheng@gmail.com
 * @date: 2017年7月14日 下午2:49:09
 * @version: V1.0
 */
package com.linkcircle.Test;

import java.io.IOException;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.linkcircle.json.entity.HttpResponse;
import com.linkcircle.json.entity.TtsRequest;
import com.linkcircle.utils.AliHttpUtil;

/** 
 * @ClassName: HttpTtsDemo 
 * @Description: TODO
 * @author: wbsheng@gmail.com
 * @date: 2017年7月14日 下午2:49:09  
 */
public class HttpTtsDemo {
	private String url = "http://nlsapi.aliyun.com/speak?";
	private static final Logger logger = Logger.getLogger(HttpTtsDemo.class);
	private static String tts_text = "1234";

	public static void main(String[] args) throws IOException {
		// 请使用https://ak-console.aliyun.com/ 页面获取的Access 信息
		// 请提前开通智能语音服务(https://data.aliyun.com/product/nls)
		String ak_id = "LTAIUOS9xBmVxHmx";
		String ak_secret = "aUU3QRIMQ5gJGTAtW27Tim1FNw9lzF";
		// 设置TTS的参数,详细参数说明详见文档部分2.1 参数配置
		HttpTtsDemo ttsDemo = new HttpTtsDemo();
		TtsRequest ttsRequest = new TtsRequest();
		ttsRequest.setEncodeType("wav");
		ttsRequest.setVoiceName("xiaoyun");
		ttsRequest.setVolume(50);
		ttsRequest.setSampleRate(16000);
		ttsRequest.setSpeechRate(0);
		ttsRequest.setPitchRate(0);
		ttsRequest.setTtsNus(1);
		ttsRequest.setBackgroundMusicId(0);
		ttsRequest.setBackgroundMusicOffset(0);
		ttsRequest.setBackgroundMusicVolume(100);
		String url = ttsDemo.url + "encode_type=" + ttsRequest.getEncodeType() + "&voice_name="
				+ ttsRequest.getVoiceName() + "&volume=" + ttsRequest.getVolume() + "&sample_rate="
				+ ttsRequest.getSampleRate() + "&speech_rate=" + ttsRequest.getSpeechRate() + "&pitch_rate="
				+ ttsRequest.getPitchRate() + "&tts_nus=" + ttsRequest.getTtsNus() + "&background_music_id="
				+ ttsRequest.getBackgroundMusicId() + "&background_music_offset="
				+ ttsRequest.getBackgroundMusicOffset() + "&background_music_volume="
				+ ttsRequest.getBackgroundMusicVolume();
		logger.info("TTS request is: "+ url);
		String fileName = UUID.randomUUID().toString().replace("-", "")+".wav";
		// tts demo 会在项目根目录生产语音文件
		HttpResponse response = AliHttpUtil.sendTtsPost(tts_text, ttsRequest.getEncodeType(), "I:/test/"+fileName, url, ak_id,
				ak_secret);
		logger.info("200".equals(response.getStatus()+""));
	}
}

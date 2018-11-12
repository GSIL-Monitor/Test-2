package com.linkcircle.controller;

import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import com.linkcircle.entity.AccessToken;
import com.linkcircle.utils.HttpClientUtil;
import com.linkcircle.utils.JsonUtil;
import com.linkcircle.utils.StringUtil;
import com.linkcircle.utils.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;


public class TTSTest {
	
	@Test
	public void TTS(){



	    //王峰TTS
//        String apiKey = "iNRKjODfIz1aaMohBajnH77i";
//        String secretKey = "8iHis9jZ0DWUIecmRHoO74lGlUl0uinj";


        //董总TTS
//        String apiKey = "wODEVFDcTL5C0HhdxitkBWuf";
//        String secretKey = "zt73qGKzk5G5k5HWCKEG8egeiaGfyrMn";


        //chengqitongtts
//        String apiKey = "Q8SqgQVXoU0bFWmoqyH65MXs";
//        String secretKey = "w2Z0Uw2vGT949VKub2RkTgX4hU38pkdX";


        //chengqitongtts01
//        String apiKey = "1Qn8h3jOBcHnN29gKSsBGH1f";
//        String secretKey = "zgAiryZsHjGtSTTkSUEY2svm9WyClv66";










        //ps:目前测试发现合成的内容不能带空格，换行符，"%"


//        String apiKey = "DAeGcFs6SRuEWbkVar8jV2Kk";
//        String secretKey = "50b0b614c72e2de68a155a22f14950f8";
		//请求百度接口获取语音合成的token
		//String accessTokenString = HttpClientUtil.doGet("https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id="+apiKey+"&client_secret="+secretKey);
        String accessTokenString = HttpClientUtil.doGet("https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id=DAeGcFs6SRuEWbkVar8jV2Kk&client_secret=50b0b614c72e2de68a155a22f14950f8");
		//下载合成的语音文件到本地

        String content = "";
        String id = "88888";
        String url = "";
        AccessToken accessToken = JsonUtil.jsonToPojo(accessTokenString, AccessToken.class);
        String token=accessToken.getAccess_token();
        String name = ".wav";
        String fileName = "";
        String path = "/Users/youngder/Desktop/TTSFile/"+StringUtils.getRegDate("yyyy-MM-dd")+"/test";
        String filePath="";
        String filePaths="";
        int count = 1;
        //Thread t = new Thread();
        /* 读取数据 */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/Users/youngder/Desktop/TTSFile/FlowTts.txt")),
                    "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                lineTxt = lineTxt.replaceAll(" ","");
                fileName = ""+count+name;
                System.err.println("fileName"+fileName);
                filePath = path+"/"+fileName;
                filePaths = path+"/"+fileName;
                url = "http://tsn.baidu.com/text2audio?tex=" + lineTxt + "&lan=zh&cuid=" + id + "&ctp=1&tok=" + token;
                HttpClientUtil.getFile(url,path,fileName);
                System.err.println(StringUtil.fileCheck(filePath,filePaths));
                count++;
                System.err.println(lineTxt);
                //t.sleep(500);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }



		//System.err.println(accessToken);
		//合成内容您好,现在是我司非办公时间,您可以在上午8点至下午6点来电咨询,结束请挂机,留言请按井号键
//		String content = "正在为您转接，请稍后";
//		String id = "88886";
//		String url = "http://tsn.baidu.com/text2audio?tex=" + content + "&lan=zh&cuid=" + id + "&ctp=1&tok=" + token;
		




	}

	@Test
    public void tts() throws it.sauronsoftware.jave.EncoderException {
        //董总TTS
//        String apiKey = "iNRKjODfIz1aaMohBajnH77i";
//        String secretKey = "8iHis9jZ0DWUIecmRHoO74lGlUl0uinj";


        //王峰TTS
//        String apiKey = "wODEVFDcTL5C0HhdxitkBWuf";
//        String secretKey = "zt73qGKzk5G5k5HWCKEG8egeiaGfyrMn";


        //chengqitongtts
//        String apiKey = "Q8SqgQVXoU0bFWmoqyH65MXs";
//        String secretKey = "w2Z0Uw2vGT949VKub2RkTgX4hU38pkdX";


        //chengqitongtts01
//        String apiKey = "1Qn8h3jOBcHnN29gKSsBGH1f";
//        String secretKey = "zgAiryZsHjGtSTTkSUEY2svm9WyClv66";




        //李桥生TTS√√√√√√√√√√√√√√

//        String apiKey = "cGpNbv3Ev8aIzWbZ7toNiAiH";
//        String secretKey = "7bc62f32d609c3061d8913c8192ad6ac";



        //youngderTTSXXXXXXXXXXXXX

//        String apiKey = "cGpNbv3Ev8aIzWbZ7toNiAiH";
//        String secretKey = "59c60bbfb4d9618354fef3c94efd5892";



        //youngderTTS1

        String apiKey = "F2qfkuPAKccFcb6WTxElrf28";
        String secretKey = "Gsu8q1csgB8AkwC0egp80Tfw6Ugg0OG1";




        //youngder2
//        String apiKey = "mRp7zQjGSE13zGWV0GpS6MQj";
//        String secretKey = "9854735e3047d17eecd6acffe48c4acb";


        //youngder3
//        String apiKey = "BoKoIQpLBsOPwq1WAcVHh1n8";
//        String secretKey = "59c60bbfb4d9618354fef3c94efd5892";



        //https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id="+apiKey+"&client_secret="+secretKey);
//https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id=DAeGcFs6SRuEWbkVar8jV2Kk&client_secret=50b0b614c72e2de68a155a22f14950f8
        //String apiKey="BoKoIQpLBsOPwq1WAcVHh1n8";
//        String apiKey = "DAeGcFs6SRuEWbkVar8jV2Kk";
//        //String secretKey = "59c60bbfb4d9618354fef3c94efd5892";
//        String secretKey =    "50b0b614c72e2de68a155a22f14950f8";

//
//        String apiKey = "wODEVFDcTL5C0HhdxitkBWuf";
//
//        String secretKey = "zt73qGKzk5G5k5HWCKEG8egeiaGfyrMn";

        Long beginTime = new Date().getTime();
        Long totalConsumedTime=0L;


        //请求百度接口获取语音合成的token
        String accessTokenString = HttpClientUtil.doGet("https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id="+apiKey+"&client_secret="+secretKey);
        //String accessTokenString = HttpClientUtil.doGet("https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id=DAeGcFs6SRuEWbkVar8jV2Kk&client_secret=50b0b614c72e2de68a155a22f14950f8");
        //下载合成的语音文件到本地


        AccessToken accessToken = JsonUtil.jsonToPojo(accessTokenString, AccessToken.class);
        String token=accessToken.getAccess_token();
        System.err.println(accessToken);
        //合成内容您好,现在是我司非办公时间,您可以在上午8点至下午6点来电咨询,结束请挂机,留言请按井号键
        String content = "广东省韶关市乳源瑶族自治县乳源经济技术开发";
        String id = "88886";
        String url = "http://tsn.baidu.com/text2audio?tex=" + content + "&lan=zh&cuid=" + id + "&ctp=1&tok=" + token;

        String fileName = content+StringUtil.getDate14()+".wav";

        String path = "/Users/youngder/Desktop/TTSFile/"+StringUtils.getRegDate("yyyy-MM-dd")+"";
        String filePath = path+"/"+fileName;
        //下载百度合成的音频
        try{
            System.err.println(HttpClientUtil.getFile(url,path,fileName));
        }catch(Exception e){

        }


        //转码
        System.err.println(StringUtil.fileCheck(filePath,filePath));
    }


    @Test
    public void ttsd(){

//        String filePath = "/Users/youngder/Desktop/TTSFile/"+StringUtils.getRegDate("yyyy-MM-dd")+"/tests/1.wav";
//        String filePaths = "/Users/youngder/Desktop/TTSFile/"+StringUtils.getRegDate("yyyy-MM-dd")+"/tests1";
//        System.err.println(StringUtil.fileCheck(filePath,filePath));
//        System.err.println(StringUtil.fileCheck(filePath,filePath));
//        System.err.println(StringUtil.fileCheck(filePath,filePath));
        System.err.println("12 34 64 ".replace(" ",""));
    }


}

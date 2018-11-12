package com.linkcircle.controller;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.stereotype.Controller;

import com.linkcircle.utils.HttpClientUtil;

/**
 * 
 * @author youngder
 *
 */
@Controller
public class ChickToDial {
	private static final Logger logger = Logger.getLogger(ChickToDial.class);
	
	public  static HttpClientUtil httpUtil = new HttpClientUtil();
	public static void main(String[] args) throws InterruptedException {
		//String[] numList = {"13108950417","13108950427","13108950438","13108950457","13108950462","13108950471","13108950472","13108950473","13108950487","13108950493","13108950495","13108950510","13108950517","13108950520","13108950537","13108950546","13108950553","13108950560","13108950570","13108950573","13108950601","13108950625","13108950641","13108950645","13108950648"};
		String[] numList = {"13108950417"};
		 for (String calledNum: numList) {
			 String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			 
//			 //正式环境【提交南京AS2】
//		     String json ="<callOutService version=\"1.0\"> \n" +
//					"  <service name=\"callRequest\"> \n" +
//					"    <messageID>111111111222222222222</messageID>  \n" +
//					"    <callingNumber>15159961793</callingNumber>  \n" +
//					"    <calledNumber>18649760218</calledNumber>  \n" +
//					"    <callerDisplayNum>"+calledNum+"</callerDisplayNum>  \n" +
//					"    <calledDisplayNum>"+calledNum+"</calledDisplayNum>  \n" +
//					"    <maxDuration>120</maxDuration>  \n" +
//					"    <vccID>1007</vccID>  \n" +
//					"    <isRecord>0</isRecord> \n" +
//					"  </service> \n" +
//					"</callOutService>";
//
		     //测试环境【提交南京测试机】
//		     String jsons ="<callOutService version=\"1.0\"> \n" +
//		    		 "  <service name=\"callRequest\"> \n" +
//		    		 "    <messageID>111111111222222222222</messageID>  \n" +
//		    		 "    <callingNumber>15159961793</callingNumber>  \n" +
//		    		 "    <calledNumber>18649760218</calledNumber>  \n" +
//		    		 "    <callerDisplayNum>00861086469999</callerDisplayNum>  \n" +
//		    		 "    <calledDisplayNum>00861086469999</calledDisplayNum>  \n" +
//		    		 "    <maxDuration>120</maxDuration>  \n" +
//		    		 "    <vccID>1007</vccID>  \n" +
//		    		 "    <isRecord>0</isRecord> \n" +
//		    		 "  </service> \n" +
//		    		 "</callOutService>";
//


             String json ="{\n" +
                     "    \"header\": {\n" +
                     "        \"serviceName\": \"SFIVRRequest\",\n" +
                     "        \"messageId\": \"1413513535135235113311451\"\n" +
                     "    },\n" +
                     "    \"body\": {\n" +
                     "        \"displayNum\": \"9533885\",\n" +
                     "        \"calledNum\": \"15159961793\",\n" +
                     "        \"serviceKey\": \"900013\",\n" +
                     "        \"mediaContent\": \"软件园F区4号楼18层\",\n" +
                     "        \"numCode\": \"1234\"\n" +
                     "    }\n" +
                     "}";
		   Thread.sleep(100);
		   System.out.println(json);
		   
		   //正式环境点击拨号xml版本
		   String reMsg = httpUtil.doPostStr("http://58.220.51.44:15407/CTDNOTICE/CTD?mac=cqt1234", json.toString());
		   
		   //c测试环境点击拨号xml版本
		   //String reMsg = httpUtil.doPostStr("http://153.3.49.41:8078/linkcircle/ctd", jsons.toString());
		   
		   //CQTTest点击拨号
		   //String reMsg = httpUtil.doPostStr("http://153.3.49.41:8078/CQTTest/callBack/dial.do", json.toString());
		   System.err.println(reMsg);
		   /*
		   查话单
		   正式环境
		   
		   
		   */
		 }
	}
}

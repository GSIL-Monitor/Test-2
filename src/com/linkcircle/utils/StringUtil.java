package com.linkcircle.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.wav.WavFileReader;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linkcircle.json.entity.AccessToken;
import com.linkcircle.json.entity.HttpResponse;
import com.linkcircle.json.entity.TtsRequest;

/**
 * @Title: StringUtils
 * @Description: 一些基础工具类
 * @author awbsheng@gmail.com
 * @date 2017年5月15日下午10:43:23
 */
public class StringUtil {
	// 指定加密key
	public static String key = "8445C55CB635FB10B667872001BFD9AE";
	//正是环境端口是15410
	//测试环境是15406
	//172.16.42.6:15407  127.0.4.0:15407
	//172.16.42.7:15410  127.0.6.8:33368
	//public static String REQUESTURLFIX = "http://127.0.6.8:33368/cincc/ivrcall";//youngder本机测试
	//public static String REQUESTURL95 = "http://127.0.6.8:33368/cincc/ivrcall";//youngder本机测试
	public static String REQUESTURLFIX = "http://172.16.42.61:15406/cincc/ivrcall";
	public static String REQUESTURL95 = "http://172.16.42.61:15406/cincc/ivrcall";
	private static final Logger logger = Logger.getLogger(StringUtil.class);
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	
	//顺丰智能外呼通用的mac
	private static String ALLUSEMAC = "cqt1234";

	/**
	 * @Description(检查list是否为null,是返回true,否则返回false) @param list
	 * @return
	 */
	public static boolean CheckListIsNull(List<?> list) {
		if (list != null && list.size() > 0) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * @Description(检查京东token) @param token
	 * @param key
	 * @return
	 */
	public static boolean checkJdToken(String token) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		Calendar cals = Calendar.getInstance();
		Date startDate = new Date();
		cal.setTime(startDate);
		cals.setTime(startDate);
		String date = "";
		boolean result = false;
		for (int i = 1; i <= 600; i++) {
			if (i != 1) {
				cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) - 1);
			}
			date = sdf.format(cal.getTime());
			cal.setTime(cal.getTime());
			if (token.equals(md5(StringUtil.key + date))) {
				result = true;
				break;
			}
		}
		if (!result) {
			for (int i = 1; i <= 600; i++) {
				if (i != 1) {
					cals.set(Calendar.SECOND, cals.get(Calendar.SECOND) + 1);
				}
				date = sdf.format(cals.getTime());
				cals.setTime(cals.getTime());
				if (token.equals(md5(key + date))) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
	/**
	 * 对字符串md5加密
	 * 
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		return MD5.getMD5Str(str);
		/*try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes("utf-8"));
			String md5 = new BigInteger(1, md.digest()).toString(16);
			if (md5.length() < 32) {
				md5 = "0" + md5;
			}
			return md5;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}*/
	}
	/**
	 * @Description(检查参数是否为空) @param param
	 * @return
	 */
	public static boolean checkParamIsNull(String param) {
		if (param != null && !param.replaceAll(" ", "").equals("")) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * @Description(文件格式转换) @param filePath
	 * @return
	 */
	public static boolean fileCheck(String filePath, String targetFile)throws java.lang.IllegalArgumentException {
        //需要转码的文件
        File source = new File(filePath);

        System.err.println(source.getAbsolutePath());
        //转码后生成的文件
        File target = new File(targetFile);
//        File source = new File("source.avi");
//        File target = new File("target.wav");
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("pcm_s16le");
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("wav");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();
        try {
            encoder.encode(source, target, attrs);
            return true;
        } catch (EncoderException e) {
            e.printStackTrace();
            return false;
        }


//
//        //需要转码的文件
//        File source = new File(filePath);
//
//        System.err.println(source.getAbsolutePath());
//        //转码后生成的文件
//        File target = new File(targetFile);
//
//		AudioAttributes audio = new AudioAttributes();
//
//		audio.setCodec("pcm_s16le");
//        audio.setBitRate(16);
//		audio.setSamplingRate(new Integer(8000));
//		EncodingAttributes attrs = new EncodingAttributes();
//		attrs.setFormat("");
//		attrs.setAudioAttributes(audio);
//        Encoder encoder = new Encoder();
////		Encoder encoder = new Encoder();
//        try {
//            System.err.println(encoder.getSupportedDecodingFormats().toString());
//        } catch (EncoderException e) {
//            e.printStackTrace();
//        }
//        try {
//			encoder.encode(source, target, attrs);
//		} catch (Exception e) {
//		    e.printStackTrace();
//			return false;
//		}
//		return true;
	}
	/**
	 * @Description(获取文件的播放时长) @param path
	 * @return
	 */
	public static int getWavFileLength(File source) {
		try {
			WavFileReader reader = new WavFileReader();
			AudioFile audioFile = reader.read(source);
			AudioHeader header = audioFile.getAudioHeader();
			return header.getTrackLength();
		} catch (Exception e) {
			return 0;
		}
	}
	/**
	 * @Description(检查文件夹是否存在，否则穿件) @param basePath
	 * @param filePath
	 */
	public static void checkFileIsExitAndCreatFiles(String basePath, String filePath) {
		String[] dirs = filePath.split("/");
		File file = null;
		for (String dir : dirs) {
			basePath += "/" + dir;
			file = new File(basePath);
			if (!file.exists()) {
				file.mkdirs();
			}
		}
	}
	/**
	 * @Description(获取request内容) @param request
	 * @return
	 */
	public static String getReqMsg(HttpServletRequest request) {
		InputStream in;
		StringBuffer json = null;
		try {
			in = request.getInputStream();
			json = new StringBuffer();
			byte[] b = new byte[4096];
			for (int n; (n = in.read(b)) != -1;) {
				json.append(new String(b, 0, n));
			}
			String msg = json.toString();
			if (msg.indexOf("text=\"") > -1) {
				msg = msg.substring(0, msg.indexOf("text=\"") + 5) + "\\\""
						+ msg.substring(msg.indexOf("text=\"") + 6, msg.indexOf("\"\"")) + "\\\"\""
						+ msg.substring(msg.indexOf("\"\"") + 2, msg.length());
			}
			return msg;
		} catch (Exception e) {
			json.append("");
		}
		return json.toString();
	}
	/**
	 * @Description(获取serviceName) @param json
	 * @return
	 */
	public static String getServiceName(String json) {
		ObjectMapper mapper = new ObjectMapper();
		// Jackson提供一个树节点被称为”JsonNode”,ObjectMapper提供方法来读json作为树的JsonNode根节点
		JsonNode node;
		try {
			node = mapper.readTree(json);
			JsonNode jsonNode = node.get("header");
			if (jsonNode.get("serviceName") != null) {
				return jsonNode.get("serviceName").asText().trim();
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * @Description(获取servicekey) @param json
	 * @return
	 */
	public static String getServiceKey(String json) {
		ObjectMapper mapper = new ObjectMapper();
		// Jackson提供一个树节点被称为”JsonNode”,ObjectMapper提供方法来读json作为树的JsonNode根节点
		JsonNode node;
		try {
			node = mapper.readTree(json);
			JsonNode jsonNode = node.get("body");
			if (jsonNode.get("serviceKey") != null) {
				return jsonNode.get("serviceKey").asText().trim();
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * @Description(填写日志,日志文件大于100mde 重新创建日志)
	 * @param basepath
	 * @param filepath
	 * @param fileName
	 * @param content
	 */
	public static void writeLogs(String filepath, String fileName, String content) {
		File file = new File(filepath);
		if (!file.exists()) {
			file.mkdirs();
		}
		filepath += "/" + fileName;
		try {
			FileWriter writer = new FileWriter(filepath, true);
			writer.write(content);
			if (writer != null) {
				writer.close();
			}
		} catch (IOException e) {
		}
	}
	// 判断一个字符串是否含有中文
	public static boolean isChinese(String str) {
		String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";// 其他需要，直接修改正则表达式就好
		return str.matches(regex);
	}
	/**
	 * @Description(是否为数字校验) @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
	/**
	 * @Description(获取访问ip) @param request
	 * @return
	 */
	public static String ipAllowAccess(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.trim();
	}
	/**
	 * @Description (获取是否ip检验)
	 * @return
	 */
	@SuppressWarnings("resource")
	public static boolean getIpIsAccess() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("/home/smp/ipaccess.txt")));
			String tempData = br.readLine();
			// 0不确定1确定
			if ("1".equals(tempData.trim())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * @Description (获取是否推送成功)
	 * @return
	 */
	@SuppressWarnings("resource")
	public static boolean getIsSucc() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("/home/smp/isSuccess.txt")));
			String tempData = br.readLine();
			// 0不确定1确定
			if ("1".equals(tempData.trim())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * @Description(去掉换行，空格，制表符) @param dest
	 * @return
	 */
	public static String deleteN(String dest) {
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(dest);
		dest = m.replaceAll("");
		return dest;
	}
	/**
	 * @Description(检查号码的合法想) @param num
	 * @return
	 */
	public static String checkNumber(String callingNumber) {
		if (callingNumber != null && callingNumber.length() > 0) {
			if (callingNumber.startsWith("0")) {
				if (callingNumber.startsWith("01") && (!callingNumber.startsWith("010"))) {
					callingNumber = "0086" + callingNumber;
				} else {
					callingNumber = "0086" + callingNumber.substring(1);
				}
			} else {
				callingNumber = "0086" + callingNumber;
			}
		}
		return callingNumber.trim();
	}
	
	/**
	 * @author youngder
	 * @Description(校验顺丰的token【mac】)
	 *  key：md5(vccid)生成，
	 *  mac:用SHA256进行加密
	 * @param tok
	 * @return
	 */
	public static boolean checkSFToken(String json, String mac, String vccid) {
		boolean result = false;
		String token = getSHA256StrJava(getSHA256StrJava(deleteN(json)) + md5(vccid + md5(vccid + md5(vccid))).toUpperCase());
		logger.info("key:" + md5(vccid + md5(vccid + md5(vccid))).toUpperCase());
		logger.info("token:" + token + "  mac:" + mac);
		//增加通用的mac【ALLUSEMAC】便于测试
		if (token.equals(mac) || mac.equals(ALLUSEMAC)) {
			result = true;
		}
		return result;
	}
	
	/**
	* 利用java原生的摘要实现SHA256加密
	* @param str 加密后的报文
	* @return
	*/
	public static String getSHA256StrJava(String str) {
		MessageDigest messageDigest;
		String encodeStr = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes("UTF-8"));
			encodeStr = byte2Hex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodeStr;
	}
	
	/**
	 * 将byte转为16进制
	 * @param bytes
	 * @return
	 */
	private static String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length() == 1) {
				// 1得到一位的进行补0操作
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}
	
	/**
	 * @Description(校验其他企业的token) @param vccid
	 * @param tok
	 * @return
	 */
	public static boolean checkToken(String json, String mac, String vccid) {
		boolean result = false;
		String token = md5(md5(deleteN(json)) + md5(vccid + md5(vccid + md5(vccid))).toUpperCase());
		logger.info("key:" + md5(vccid + md5(vccid + md5(vccid))).toUpperCase());
		logger.info("token:" + token + "  mac:" + mac);
		if (token.equals(mac)) {
			result = true;
		}
		return result;
	}
	/**
	 * @Description (向客户端输出xml数据)
	 * @param response
	 * @param xml
	 */
	public static void responToClient(HttpServletResponse response, String data) {
		try {
			OutputStream outputStream = response.getOutputStream();
			response.setHeader("content-type", "text/html;charset=UTF-8");// 通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
			byte[] dataByteArr = data.getBytes("UTF-8");// 将字符转换成字节数组，指定以UTF-8编码进行转换
			outputStream.write(dataByteArr);// 使用OutputStream流向客户端输出字节数组
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @Title: numberAndNumber 
	 * @Description: 往相连的数字中加入空格
	 * @param string
	 * @return
	 * @return: String
	 */
	public static String numberAndNumber(String string) {
		char[] array = string.toCharArray();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (isNumeric(array[i] + "")) {
				result.append(changeNumber(Integer.parseInt(array[i] + "")));
			} else {
				result.append(array[i]);
			}
		}
		return result.toString();
	}
	private static String changeNumber(Integer number) {
		String[] CurrNumHz = new String[] { "零", "壹", "贰", "叁", "肆", "伍", "六", "柒", "捌", "玖" };
		return CurrNumHz[number];
	}
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
	/**
	 * Convert hex string to byte[]
	 * 
	 * @param hexString
	 *            the hex string
	 * @return byte[]
	 */
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}
	/**
	 * Convert char to byte
	 * 
	 * @param c
	 *            char
	 * @return byte
	 */
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	/**
	 * @Description (获取是否加密)
	 * @return
	 */
	public static boolean getTextStatus(String path) {
		try {
			// BufferedReader br = new BufferedReader(new FileReader(new
			// File("D:/CQT/CQTTest/recourse/aes.txt")));
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(new File(path)));
			String tempData = br.readLine();
			// 1不加密0加密
			if ("1".equals(tempData)) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}
	public static String getVccid(String json) {
		ObjectMapper mapper = new ObjectMapper();
		// Jackson提供一个树节点被称为”JsonNode”,ObjectMapper提供方法来读json作为树的JsonNode根节点
		JsonNode node;
		try {
			node = mapper.readTree(json);
			JsonNode jsonNode = node.get("header");
			if (jsonNode.get("vccId") != null) {
				return jsonNode.get("vccId").asText().trim();
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	/** 
	 * @Title: getVccidDefaultNumber 
	 * @Description: 获取是否配置本地号码呼出配置
	 * @param vccid
	 * @return
	 * @return: String
	 */
	public static String getVccidDefaultNumber(String vccid) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File("/home/smp/vccid_default_number.xml"));
			// Document doc = reader.read(new File("c:/home/smp/vccid_default_number.xml"));
			Element root = doc.getRootElement();
			Element foo;
			for (Iterator<?> i = root.elementIterator("number"); i.hasNext();) {
				foo = (Element) i.next();
				String v = foo.attribute("vccid").getData().toString();
				if (vccid.equals(v)) {
					String[] numbers = foo.getTextTrim().split(",");
					Random r = new Random();
					return numbers[r.nextInt(numbers.length)].replaceAll(" ", "");
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
		return null;
	}
	/** 
	 * @Title: transformCalledRelCause 
	 * @Description: 转换CalledRelCause字段值
	 * @param calledRelCause
	 * @return
	 * @return: String
	 */
	public static String transformCalledRelCause(String calledRelCause) {
		String result = "3";
		switch (calledRelCause) {
			case "1":
				result = "1";
				break;
			case "99":
				result = "3";
				break;
			case "5":
				result = "770";
				break;
			case "7":
				result = "771";
				break;
			case "6":
				result = "774";
				break;
			case "4":
				result = "775";
				break;
			case "3":
				result = "778";
				break;
			case "2":
				result = "773";
				break;
			default:
				result = "3";
				break;
		}
		return result;
	}
	public static boolean aliTTS(String content, String uuid, String vccid) {
		boolean result = false;
		try {
			String ak_id = "LTAIUOS9xBmVxHmx";
			String ak_secret = "aUU3QRIMQ5gJGTAtW27Tim1FNw9lzF";
			// 设置TTS的参数,详细参数说明详见文档部分2.1 参数配置
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
			String url = "http://nlsapi.aliyun.com/speak?encode_type=" + ttsRequest.getEncodeType() + "&voice_name="
					+ ttsRequest.getVoiceName() + "&volume=" + ttsRequest.getVolume() + "&sample_rate="
					+ ttsRequest.getSampleRate() + "&speech_rate=" + ttsRequest.getSpeechRate() + "&pitch_rate="
					+ ttsRequest.getPitchRate() + "&tts_nus=" + ttsRequest.getTtsNus() + "&background_music_id="
					+ ttsRequest.getBackgroundMusicId() + "&background_music_offset="
					+ ttsRequest.getBackgroundMusicOffset() + "&background_music_volume="
					+ ttsRequest.getBackgroundMusicVolume();
			// tts demo 会在项目根目录生产语音文件
			HttpResponse response = AliHttpUtil.sendTtsPost(content, ttsRequest.getEncodeType(),
					"/home/media/media/mediaTemp/temp/" + vccid + "/" + formatter.format(new Date()) + "/" + uuid, url,
					ak_id, ak_secret);
			if ("200".equals(response.getStatus() + "")) {
				// 转换文件夹格式
				if (StringUtil.fileCheck(
						"/home/media/media/mediaTemp/temp/" + vccid + "/" + formatter.format(new Date()) + "/" + uuid
								+ ".wav",
						"/home/media/media/mediaTemp/" + vccid + "/" + formatter.format(new Date()) + "/" + uuid
								+ ".wav")) {
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("path", "/home/media/media/" + vccid + "/notice/" + formatter.format(new Date()) + "/"
							+ uuid + ".wav");
					Map<String, String> fileParam = new HashMap<String, String>();
					fileParam.put("file", "/home/media/media/mediaTemp/" + vccid + "/" + formatter.format(new Date())
							+ "/" + uuid + ".wav");
					if ("true".equals(HttpClientUtil.doPostMultipartEntity(
							//youngder本机测试
							//"http://127.0.4.6:33346/FTPMedia/upload.do", param, fileParam))) {
						"http://ctdnoticemedia:8078/FTPMedia/upload.do", param, fileParam))) {
						result = true;
						logger.info("ali tts");
					} else {
						StringUtil.writeLogs("/home/smp/logs", "tts" + formatter.format(new Date()) + ".log",
								"alishangchuan" + "\r\n");
					}
				} else {
					StringUtil.writeLogs("/home/smp/logs", "tts" + formatter.format(new Date()) + ".log",
							"aligeshihua" + "\r\n");
				}
			}
			StringUtil.writeLogs("/home/smp/logs", "tts" + formatter.format(new Date()) + ".log", "alihouqu" + "\r\n");
		} catch (Exception e) {
			StringUtil.writeLogs("/home/smp/logs", "tts" + formatter.format(new Date()) + ".log",
					"aliyichang" + "\r\n");
		}
		return result;
	}
//	public static boolean TTS(String content, String uuid, String vccId) {
//		boolean fileopertion = false;
//		String apiKey = "cGpNbv3Ev8aIzWbZ7toNiAiH";
//		String secretKey = "7bc62f32d609c3061d8913c8192ad6ac";
//		try {
//			// 上传的临时文件路径
//			String tempPath = "/home/media/media/mediaTemp/temp/" + vccId + "/" + formatter.format(new Date()) + "/"
//					+ uuid + ".wav";
//			String filePath = "/home/media/media/mediaTemp/" + vccId + "/" + formatter.format(new Date()) + "/" + uuid
//					+ ".wav";
//			StringUtil.checkFileIsExitAndCreatFiles("/home",
//					"media/media/mediaTemp/temp/" + vccId + "/" + formatter.format(new Date()) + "/");
//			StringUtil.checkFileIsExitAndCreatFiles("/home",
//					"media/media/mediaTemp/" + vccId + "/" + formatter.format(new Date()) + "/");
//			String token = CacheUtil.get("baiduttstoken").toString();
//			logger.info("baiduTTStoken======"+token);
//			if (StringUtil.checkParamIsNull(token)) {
//				String accessTokenString = HttpClientUtil.doGet(
//						//wbsb百度TTS
//						//"https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id=1SmGfV1Y07IfM62oVO62nUWD&client_secret=215c551f94b4142f3437247e2021c8aa");
//						//李巧生百度TTS
//						"https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id="+apiKey+"&client_secret="+secretKey);
//				AccessToken accessToken = JsonUtil.jsonToPojo(accessTokenString, AccessToken.class);
//				token = accessToken.getAccess_token();
//				//将新生产的token写入缓存，并设置过期时间
//				CacheUtil.put("baiduttstoken", token, accessToken.getExpires_in());
//			}
//			//为false则为token过期
//			if (HttpClientUtil.getFile(
//					"http://tsn.baidu.com/text2audio?tex=" + content + "&lan=zh&cuid=" + vccId + "&ctp=1&tok=" + token,
//					tempPath)) {
//				// 转换文件夹格式
//				if (StringUtil.fileCheck(tempPath, filePath)) {
//					Map<String, Object> param = new HashMap<String, Object>();
//					param.put("path", "/home/media/media/" + vccId + "/notice/" + formatter.format(new Date()) + "/"
//							+ uuid + ".wav");
//					Map<String, String> fileParam = new HashMap<String, String>();
//					fileParam.put("file", filePath);
//					if ("true".equals(HttpClientUtil.doPostMultipartEntity(
//							//youngder本机测试
//							//"http://127.0.4.6:33346/FTPMedia/upload.do", param, fileParam))) {
//						"http://172.16.40.51:8078/FTPMedia/upload.do", param, fileParam))) {
//						fileopertion = true;
//						logger.info("baidu tts");
//					} else {
//						StringUtil.writeLogs("/home/smp/logs", "tts" + formatter.format(new Date()) + ".log",
//								"baidushangchuan" + "\r\n");
//					}
//				} else {
//					StringUtil.writeLogs("/home/smp/logs", "tts" + formatter.format(new Date()) + ".log",
//							"baidugeshihua" + "\r\n");
//				}
//			} else {
//				String accessTokenString = HttpClientUtil.doGet(
//						//"https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id=1SmGfV1Y07IfM62oVO62nUWD&client_secret=215c551f94b4142f3437247e2021c8aa");
//						"https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id="+apiKey+"&client_secret="+secretKey);
//				AccessToken accessToken = JsonUtil.jsonToPojo(accessTokenString, AccessToken.class);
//				token = accessToken.getAccess_token();
//				CacheUtil.put("baiduttstoken", token, accessToken.getExpires_in());
//				fileopertion = StringUtil.aliTTS(content, uuid, vccId);
//				StringUtil.writeLogs("/home/smp/logs", "tts" + formatter.format(new Date()) + ".log",
//						"baihouqu" + "\r\n");
//			}
//		} catch (Exception ee) {
//			try {
//				logger.info(ee.getMessage());
//				String accessTokenString = HttpClientUtil.doGet(
//						//"https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id=1SmGfV1Y07IfM62oVO62nUWD&client_secret=215c551f94b4142f3437247e2021c8aa");
//						"https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials&client_id="+apiKey+"&client_secret="+secretKey);
//				AccessToken accessToken = JsonUtil.jsonToPojo(accessTokenString, AccessToken.class);
//				CacheUtil.put("baiduttstoken", accessToken.getAccess_token(), accessToken.getExpires_in());
//				StringUtil.writeLogs("/home/smp/logs", "tts" + formatter.format(new Date()) + ".log",
//						"baiduyichang" + "\r\n");
//			} catch (Exception ex) {
//				logger.info(ex.getMessage());
//			}
//		}
//		return fileopertion;
//	}
	
	/** 
	 * @Title: getVccids 
	 * @Description: 获取指定文件夹下的vccid
	 * @param filePath
	 * @return
	 * @return: List<String>
	 */
	public static List<String> getVccids(String filePath) {
		List<String> list = new ArrayList<String>();
		try {
			File file = new File(filePath);
			File[] tempList = file.listFiles();
			for (File file2 : tempList) {
				if (file2.isDirectory()) {
					if (StringUtil.isNumeric(file2.getName())) {
						list.add(file2.getName());
					}
				}
			}
		} catch (Exception e) {
		}
		list.add("1007");
		return list;
	}
	
	/** 
	 * @Title: fileExists 
	 * @Description: 判断文件是否存在
	 * @param path
	 * @return
	 * @return: boolean
	 */
	public static boolean fileExists(String path) {
		return new File(path).exists();
	}
	
	/** 
	 * @Title: is95Number 
	 * @Description: 检查是否是95号码
	 * @param num
	 * @return
	 * @return: boolean
	 */
	public static boolean is95Number(String num) {
		if (num.startsWith("0086")) {
			num = num.substring(4);
		}
		if (num.startsWith("95078") || num.startsWith("95056") ||
				num.startsWith("95066") || num.startsWith("95338")) {
			return true;
		}
		return false;
	}
	
	/** 
	 * @Title: getLocalIp  
	 * @Description: 获取本地ip
	 * @return: String
	 */
	public static List<String> getLocalIp() {
		List<String> ipList = new ArrayList<String>();
		InetAddress ip = null;
		try {
			Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
					.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
				// 遍历所有ip
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					ip = (InetAddress) ips.nextElement();
					if (null == ip || "".equals(ip)) {
						continue;
					}
					String sIP = ip.getHostAddress();
					if (sIP == null || sIP.indexOf(":") > -1) {
						continue;
					}
					ipList.add(sIP);
				}
			}
			return ipList;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	* 修改人：	@author youngder 
	* 修改时间：	2017-12-26 下午02:14:52   
	* 修改备注：   判断字符串是否为空
	 */
	public static boolean isNotEmpty(String str) {
		if(str == null || "".equals(str) || str.length() == 0){
			return false;
		}else{
			return true;
		}
		
	}
	
	public static String getCallId() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Random r = new Random();
		Integer rr = r.nextInt(1000);
		String callId = sdf.format(new Date());
		callId = "C" + sdf.format(new Date()) + "AC" + StringUtil.md5(callId).substring(0, 12).toUpperCase()
				+ (rr + 1000);
		return callId;
	}
	
	/**
	 * 根据json vccid 生成mac
	 * @author youngder sb
	 * @param json
	 * @param vccid
	 * @return mac
	 */
	public static String getMac(String json,String vccid) {
		return getSHA256StrJava(getSHA256StrJava(deleteN(json)) + md5(vccid + md5(vccid + md5(vccid))).toUpperCase());
	}
	
	/**
	 * @author youngder
	 * @Title: getDate
	 * @Description: 生成当前14位时间戳 ，例20171219101722
	 */
	public static String getDate14(){
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}
	
	/**
	 * @author youngder
	 * @Title: getDate
	 * @Description: 生成指定格式的时间
	 */
	public static String getRegDate(String regular){
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat(regular);
		return sdf.format(date);
	}



    /**
     * 获取当前日期是星期几<br>
     *
     * @param date
     * @return 当前日期是星期几
     */
    public String getWeekOfDate(Date date) {
        //String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        String[] weekDays = { "7", "1", "2", "3", "4", "5", "6" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }


    /**
     * @author youngder
     * @Title: getDate
     * @Description: 获取当前时期
     */
    public static String getDate(){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }


    /**
     * @author youngder
     * @Title: getTime24
     * @Description: 获取当前24小时制的时间
     */
    public static String getTime24(){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        return sdf.format(date);
    }

    /**
     * @author youngder
     * 判断a是否小于等于b
     * @param a
     * @param b
     * @return
     */
    private boolean isLess(String a,String b){
        //compareTo 是从左到右对比字符数字的大小，返回相同位置的字符数字差值，a[i]-b[i],值小相同测返回a[i+1]-b[i+1],所有都相等则返回0
        if(a.compareTo(b)<1){
            return true;
        }else{
            return false;
        }
    }


    /**
     * 判断a是否大于等于b
     * @param a
     * @param b
     * @return
     */
    private boolean isBigger(String a,String b){
        //compareTo 是从左到右对比字符数字的大小，返回相同位置的字符数字差值，a[i]-b[i],值小相同测返回a[i+1]-b[i+1],所有都相等则返回0
        if(a.compareTo(b)>-1){
            return true;
        }else{
            return false;
        }
    }



    @Test
    public void Test(){
        System.err.println(getWeekOfDate(new Date()));
        System.err.println("当前日期"+getDate());
        System.err.println("当前时间（24）"+getTime24());
    }




}

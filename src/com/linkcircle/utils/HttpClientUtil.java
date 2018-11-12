package com.linkcircle.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * @Title: HttpClientUtil
 * @Description: 网络请求工具类
 * @author 
 * @date 2017年5月9日上午2:11:08
 */
@SuppressWarnings("deprecation")
public class HttpClientUtil {
	private static final Logger logger = Logger.getLogger(HttpClientUtil.class);

	public static String doGet(String url, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000)
					.build();// 设置请求和传输超时时间
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();
			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setConfig(requestConfig);
			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), Consts.ISO_8859_1);
			}
		} catch (Exception e) {
			logger.info("dopostJson_exception:" + e.getMessage());
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				logger.info("dopostJson_exception:" + e.getMessage());
			}
		}
		return resultString;
	}
	public static String doGet(String url) {
		return doGet(url, null);
	}
	public static String doPost(String url, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000)
					.build();// 设置请求和传输超时时间
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<NameValuePair>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			logger.info("dopostJson_exception:" + e.getMessage());
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.info("dopostJson_exception:" + e.getMessage());
			}
		}
		return resultString;
	}
	public static String doPost(String url) {
		return doPost(url, null);
	}
	public static String doPostJson(String url, String json) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000)
					.build();// 设置请求和传输超时时间
			URL uri = new URL(url);
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(uri.toURI());
			httpPost.setConfig(requestConfig);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			logger.info("dopostJson_exception:" + e.getMessage());
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				logger.info("dopostjson_ioexception:" + e.getMessage());
			}
		}
		return resultString;
	}
	
	public static String doPostText(String url, String json) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000)
					.build();// 设置请求和传输超时时间
			URL uri = new URL(url);
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(uri.toURI());
			httpPost.setConfig(requestConfig);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.TEXT_HTML);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			logger.info("dopostJson_exception:" + e.getMessage());
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				logger.info("dopostjson_ioexception:" + e.getMessage());
			}
		}
		return resultString;
	}
	
	public static String doPostStr(String url, String xml) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).build();//设置请求和传输超时时间
			URL uri = new URL(url);
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(uri.toString());
			httpPost.setConfig(requestConfig);
			// 创建请求内容
			StringEntity entity = new StringEntity(xml);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			logger.info("dopostJson_exception:" + e.getMessage());
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.info("dopostJson_exception:" + e.getMessage());
			}
		}
		return resultString;
	}
	public static String doPostXml(String url, String xml) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000)
					.build();// 设置请求和传输超时时间
			URL uri = new URL(url);
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(uri.toString());
			httpPost.setConfig(requestConfig);
			StringEntity entity = new StringEntity(xml, ContentType.APPLICATION_XML);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			logger.info("dopostJson_exception:" + e.getMessage());
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.info("dopostJson_exception:" + e.getMessage());
			}
		}
		return resultString;
	}
	public static String doPostString(String url, String str) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000)
					.build();// 设置请求和传输超时时间
			url = url.replaceAll(" ", "");
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			// 创建请求内容
			StringEntity entity = new StringEntity(str, "utf-8");
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			logger.info("dopostJson_exception:" + e.getMessage());
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.info("dopostJson_exception:" + e.getMessage());
			}
		}
		return resultString;
	}
	/**
	 * @Description(使用MultipartEntity上传文件) @param url
	 * @param param
	 * @param files
	 * @return
	 */
	public static String doPostMultipartEntity(String url, Map<String, Object> param, Map<String, String> fileParam) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		MultipartEntity entity = new MultipartEntity();
		String resultString = "";
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000)
					.build();// 设置请求和传输超时时间
			// 创建请求内容
			if (param != null) {
				for (String key : param.keySet()) {
					entity.addPart(key, new StringBody(param.get(key).toString(), Charset.forName("UTF-8")));
				}
			}
			// 设置带上传文件
			if (fileParam != null) {
				for (String key : fileParam.keySet()) {
					entity.addPart(key, new FileBody(new File(fileParam.get(key))));
				}
			}
			HttpPost httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			// 设置请求体
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			logger.info("dopostJson_exception:" + e.getMessage());
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				logger.info("dopostJson_exception:" + e.getMessage());
			}
		}
		return resultString;
	}
	/** 
	* 下载文件 
	* @param url            http://www.xxx.com/img/333.jpg 
	* @param destFileName   xxx.jpg/xxx.png/xxx.txt 
	* @throws ClientProtocolException 
	* @throws IOException 
	*/
	public static boolean getFile(String url, String path,String destFileName) {
		// 生成一个httpclient对象
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(100000).setConnectTimeout(100000)
					.build();// 设置请求和传输超时时间
			HttpGet httpget = new HttpGet(url);
			httpget.setConfig(requestConfig);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			InputStream in = entity.getContent();
			File file = new File(path);
			if(!file.exists()){
				file.mkdirs();
			}
			FileOutputStream fout = new FileOutputStream(path+"/"+destFileName);
			int l = -1;
			byte[] tmp = new byte[1024];
			while ((l = in.read(tmp)) != -1) {
				fout.write(tmp, 0, l);
				// 注意这里如果用OutputStream.write(buff)的话，图片会失真，大家可以试试
			}
			fout.flush();
			fout.close();
			// 关闭低层流。
			in.close();
			httpclient.close();
			return true;
		} catch (Exception ee) {
			logger.info("getFile_exception:" + ee.getMessage());
			return false;
		}
	}
	
	
	/** 
	* 下载文件 
	* @param url            http://www.xxx.com/img/333.jpg 
	* @param destFileName   xxx.jpg/xxx.png/xxx.txt 
	* @throws ClientProtocolException 
	* @throws IOException 
	*/
	public static boolean getFiles(String url, String destFileName, String content) {
		// 生成一个httpclient对象
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000)
					.build();// 设置请求和传输超时时间
			URL uri = new URL(url);
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(uri.toString());
			httpPost.setConfig(requestConfig);
			// 创建请求内容
			StringEntity entity = new StringEntity(content);
			httpPost.setEntity(entity);
			// 执行http请求
			HttpResponse response = httpclient.execute(httpPost);
			HttpEntity entitys = response.getEntity();
			InputStream in = entitys.getContent();
			File file = new File(destFileName);
			FileOutputStream fout = new FileOutputStream(file);
			int l = -1;
			byte[] tmp = new byte[1024];
			while ((l = in.read(tmp)) != -1) {
				fout.write(tmp, 0, l);
				// 注意这里如果用OutputStream.write(buff)的话，图片会失真，大家可以试试
			}
			fout.flush();
			fout.close();
			// 关闭低层流。
			in.close();
			httpclient.close();
			return true;
		} catch (Exception ee) {
			logger.info("getFile_exception:" + ee.getMessage());
			return false;
		}
	}
}

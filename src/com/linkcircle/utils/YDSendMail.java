package com.linkcircle.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.MimeUtility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class YDSendMail {

	private static Log logger = LogFactory.getLog(YDSendMail.class);

	/* SMTP发送服务器的名字 */
	private static final String hostName = "smtp.qiye.163.com";
	/* 发送地址 */
	private static final String from = "zentao@linkcircle.cn";
	/* 发送名称 */
	private static final String fromName = "zentao@linkcircle.cn";
	/* 编码 */
	private static final String charSet = "utf-8";
	/* 邮箱用户名 */
	private static final String username = "zentao@linkcircle.cn";
	/* 密码或授权码    密码cqt@01086469999*/
	private static final String password = "Cqt@ResearchMail";

	/* 邮件主题 */
	private String subject;
	/* 附件名称 */
	private String[] attachmentNames;
	/* 附件Path */
	private String[] attachmentFilePaths;
	/* 邮件主体消息 */
	private String message;
	/* 邮件发送对象 */
	private String[] ToAddrs;
	/* 邮件发送抄送人 */
	private String[] CcAddrs;
	/* 邮件发送密送人 */
	private String[] BccAddrs;

	/* 主机集合 */
	private static Map<String, String> hostMap = new HashMap<String, String>();
	static {
		// 126
		hostMap.put("smtp.126", "smtp.126.com");
		// qq
		hostMap.put("smtp.qq", "smtp.qq.com");
		// 163
		hostMap.put("smtp.163", "smtp.163.com");
		// sina
		hostMap.put("smtp.sina", "smtp.sina.com.cn");
		// tom
		hostMap.put("smtp.tom", "smtp.tom.com");
		// 263
		hostMap.put("smtp.263", "smtp.263.net");
		// yahoo
		hostMap.put("smtp.yahoo", "smtp.mail.yahoo.com");
		// hotmail
		hostMap.put("smtp.hotmail", "smtp.live.com");
		// gmail
		hostMap.put("smtp.gmail", "smtp.gmail.com");
		hostMap.put("smtp.port.gmail", "465");
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAttachmentName() {
		StringBuffer stb = new StringBuffer();
		int le = attachmentNames.length;
		for (int i = 0; i < le; i++) {
			stb.append(attachmentNames[i]);
			if (i < le - 1)
				stb.append(",");
		}
		return stb.toString();
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentNames = attachmentName.split(",");
	}

	public String getAttachmentFilePath() {
		StringBuffer stb = new StringBuffer();
		int le = attachmentFilePaths.length;
		for (int i = 0; i < le; i++) {
			stb.append(attachmentFilePaths[i]);
			if (i < le - 1)
				stb.append(",");
		}
		return stb.toString();
	}

	public void setAttachmentFilePath(String attachmentFilePath) {
		this.attachmentFilePaths = attachmentFilePath.split(",");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToAddrs() {
		StringBuffer stb = new StringBuffer();
		int le = ToAddrs.length;
		for (int i = 0; i < le; i++) {
			stb.append(ToAddrs[i]);
			if (i < le - 1)
				stb.append(",");
		}
		return stb.toString();
	}

	public void setToAddrs(String toAddrs) {
		ToAddrs = toAddrs.split(",");
	}

	public String getCcAddrs() {
		StringBuffer stb = new StringBuffer();
		int le = CcAddrs.length;
		for (int i = 0; i < le; i++) {
			stb.append(CcAddrs[i]);
			if (i < le - 1)
				stb.append(",");
		}
		return stb.toString();
	}

	public void setCcAddrs(String ccAddrs) {
		CcAddrs = ccAddrs.split(",");
	}

	public String getBccAddrs() {
		StringBuffer stb = new StringBuffer();
		int le = BccAddrs.length;
		for (int i = 0; i < le; i++) {
			stb.append(BccAddrs[i]);
			if (i < le - 1)
				stb.append(",");
		}
		return stb.toString();
	}

	public void setBccAddrs(String bccAddrs) {
		BccAddrs = bccAddrs.split(",");
	}

	public static String getHost(String email) throws Exception {
		Pattern pattern = Pattern.compile("\\w+@(\\w+)(\\.\\w+){1,2}");
		Matcher matcher = pattern.matcher(email);
		String key = "unSupportEmail";
		if (matcher.find()) {
			key = "smtp." + matcher.group(1);
		}
		if (hostMap.containsKey(key)) {
			return hostMap.get(key);
		} else {
			throw new Exception("unSupportEmail");
		}
	}

	public static int getSmtpPort(String email) throws Exception {
		Pattern pattern = Pattern.compile("\\w+@(\\w+)(\\.\\w+){1,2}");
		Matcher matcher = pattern.matcher(email);
		String key = "unSupportEmail";
		if (matcher.find()) {
			key = "smtp.port." + matcher.group(1);
		}
		if (hostMap.containsKey(key)) {
			return Integer.parseInt(hostMap.get(key));
		} else {
			return 25;
		}
	}

	/* 发送html邮件 */
	public boolean sendHtmlMail() throws Exception {

		if (subject == null && "".equals(subject))
			throw new Exception("未设置邮件主题");
		if (message == null && "".equals(message))
			throw new Exception("未设置邮件主体消息");
		if (ToAddrs == null && ToAddrs.length == 0)
			throw new Exception("邮件发送对象");

		return sendHtmlMailUtil();
	}

	private boolean sendHtmlMailUtil() {

		// 不要使用SimpleEmail,会出现乱码问题
		HtmlEmail email = new HtmlEmail();
		try {
			// 这里是SMTP发送服务器的名字：
			if (hostName != null && !"".equals(hostName))
				email.setHostName(hostName);
			else
				email.setHostName(getHost(from));

			email.setSmtpPort(getSmtpPort(from));
			// 字符编码集的设置
			email.setCharset(charSet);
			// 收件人的邮箱
			for (String ToAddr : ToAddrs) {
				email.addTo(ToAddr);
			}
			// 设置抄送人信息
			if (CcAddrs != null) {
				for (String CcAddr : CcAddrs) {
					email.addCc(CcAddr);
				}
			}
			// 设置密送人信息
			if (BccAddrs != null) {
				for (String BccAddr : BccAddrs) {
					email.addBcc(BccAddr);
				}
			}
			// 发送人的邮箱
			email.setFrom(from, fromName);
			// 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
			email.setAuthentication(username, password);
			// 标题
			email.setSubject(subject);
			// 将邮件主体设置成一部分添加
			email.addPart(message, "text/html;charset=utf-8");

			// 判断是否有有附件，添加邮件附件
			if (attachmentFilePaths != null) {
				for (int i = 0; i < attachmentFilePaths.length; i++) {
					EmailAttachment attachment = new EmailAttachment();
					attachment.setPath(attachmentFilePaths[i]);

					String attachmentName = "";
					if (attachmentNames[i] != null) {
						attachmentName = attachmentNames[i];
					} else {
						String[] efp = attachmentFilePaths[i].split("/");
						attachmentName = efp[efp.length - 1];
					}
					attachment.setName(MimeUtility.encodeText(attachmentName));
					email.attach(attachment);
				}
			}

			// 发送
			email.send();

			logger.info("==============>邮件发送成功!");
			return true;
		} catch (EmailException e) {
			logger.info("==============>EmailException:邮件发送失败!");
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("==============>Exception:邮件发送失败!");
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {

	}

}

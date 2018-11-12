package com.linkcircle.jd.json.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CallVerifyBody {
	private String messageId;
	private String calledNumber;
	private String calledDisplayNumber;
	private String playTimes;
	private String content;
	private String playMediaName;
	private String welcomeMediaName;
	private String backgroundMediaName;

	
	
	public String getWelcomeMediaName() {
		return welcomeMediaName;
	}

	public void setWelcomeMediaName(String welcomeMediaName) {
		this.welcomeMediaName = welcomeMediaName;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getCalledNumber() {
		return calledNumber;
	}

	public void setCalledNumber(String calledNumber) {
		this.calledNumber = calledNumber;
	}

	public String getCalledDisplayNumber() {
		return calledDisplayNumber;
	}

	public void setCalledDisplayNumber(String calledDisplayNumber) {
		this.calledDisplayNumber = calledDisplayNumber;
	}

	public String getPlayTimes() {
		return playTimes;
	}

	public void setPlayTimes(String playTimes) {
		this.playTimes = playTimes;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPlayMediaName() {
		return playMediaName;
	}

	public void setPlayMediaName(String playMediaName) {
		this.playMediaName = playMediaName;
	}

	public String getBackgroundMediaName() {
		return backgroundMediaName;
	}

	public void setBackgroundMediaName(String backgroundMediaName) {
		this.backgroundMediaName = backgroundMediaName;
	}

	@Override
	public String toString() {
		return "CallVerifyBody [messageId=" + messageId + ", calledNumber=" + calledNumber + ", calledDisplayNumber="
				+ calledDisplayNumber + ", playTimes=" + playTimes + ", content=" + content + ", playMediaName="
				+ playMediaName + ", welcomeMediaName=" + welcomeMediaName + ", backgroundMediaName="
				+ backgroundMediaName + "]";
	}


}

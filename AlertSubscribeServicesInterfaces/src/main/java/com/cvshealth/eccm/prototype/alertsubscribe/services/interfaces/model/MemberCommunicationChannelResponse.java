package com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model;

import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class MemberCommunicationChannelResponse {

	private String memberId;
	private String clientId;
	
	// https://github.com/FasterXML/jackson-dataformat-xml/issues/159
    @JacksonXmlElementWrapper(localName = "channels")
    @JacksonXmlProperty(localName = "channel")
	private ArrayList<Channel> channels;

    private Communication communication;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public ArrayList<Channel> getChannels() {
		return channels;
	}

	public void setChannels(ArrayList<Channel> channels) {
		this.channels = channels;
	}

	public Communication getCommunication() {
		return communication;
	}

	public void setCommunication(Communication communication) {
		this.communication = communication;
	}
}

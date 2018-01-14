package com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model;

import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "MemberSubscriptionsResponse") //namespace = "urn:cvshealth:eccm",
public class MemberSubscriptionsResponse {

	private String memberId;
	private String clientId;
	
    @JacksonXmlElementWrapper(localName = "channels")
    @JacksonXmlProperty(localName = "channel")
	private ArrayList<Channel> channels;

    @JacksonXmlElementWrapper(localName = "programs")
    @JacksonXmlProperty(localName = "program")
	private ArrayList<Program> programs;
    
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
	public ArrayList<Program> getPrograms() {
		return programs;
	}
	public void setPrograms(ArrayList<Program> programs) {
		this.programs = programs;
	}

}

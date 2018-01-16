package com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model;

public class Communication {

	private String communicationId;
	private char programDefaultOptIn = 'N';
	private int chanEmailPriority = 0;
	private int chanIvrPriority = 0;
	private int chanSmsPriority = 0;
	private int chanSecurePriority = 0;
	private int chanMailPriority = 0;
	private int chanMobilePriority = 0;
	private String chanDefault = "No";
	private char required = 'N';
	private char mandatory ='N';

	public String getCommunicationId() {
		return communicationId;
	}
	public void setCommunicationId(String communicationId) {
		this.communicationId = communicationId;
	}
	public char getProgramDefaultOptIn() {
		return programDefaultOptIn;
	}
	public void setProgramDefaultOptIn(char programDefaultOptIn) {
		this.programDefaultOptIn = programDefaultOptIn;
	}
	public int getChanEmailPriority() {
		return chanEmailPriority;
	}
	public void setChanEmailPriority(int chanEmailPriority) {
		this.chanEmailPriority = chanEmailPriority;
	}
	public int getChanIvrPriority() {
		return chanIvrPriority;
	}
	public void setChanIvrPriority(int chanIvrPriority) {
		this.chanIvrPriority = chanIvrPriority;
	}
	public int getChanSmsPriority() {
		return chanSmsPriority;
	}
	public void setChanSmsPriority(int chanSmsPriority) {
		this.chanSmsPriority = chanSmsPriority;
	}
	public int getChanSecurePriority() {
		return chanSecurePriority;
	}
	public void setChanSecurePriority(int chanSecurePriority) {
		this.chanSecurePriority = chanSecurePriority;
	}
	public int getChanMailPriority() {
		return chanMailPriority;
	}
	public void setChanMailPriority(int chanMailPriority) {
		this.chanMailPriority = chanMailPriority;
	}
	public int getChanMobilePriority() {
		return chanMobilePriority;
	}
	public void setChanMobilePriority(int chanMobilePriority) {
		this.chanMobilePriority = chanMobilePriority;
	}
	public String getChanDefault() {
		return chanDefault;
	}
	public void setChanDefault(String chanDefault) {
		this.chanDefault = chanDefault;
	}
	public char getRequired() {
		return required;
	}
	public void setRequired(char required) {
		this.required = required;
	}
	public char getMandatory() {
		return mandatory;
	}
	public void setMandatory(char mandatory) {
		this.mandatory = mandatory;
	}
}

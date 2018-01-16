package com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model;

public class ProgramChannel {

	private char chanEmail = 'N'; // Y/N
	private char chanIvr = 'N'; // Y/N
	private char chanSms = 'N'; // Y/N
	private char chanSecure = 'N'; // Y/N
	private char chanMail = 'N'; // Y/N
	private char chanMobile = 'N'; // Y/N

	public char getChanEmail() {
		return chanEmail;
	}
	public void setChanEmail(char chanEmail) {
		this.chanEmail = chanEmail;
	}
	public char getChanIvr() {
		return chanIvr;
	}
	public void setChanIvr(char chanIvr) {
		this.chanIvr = chanIvr;
	}
	public char getChanSms() {
		return chanSms;
	}
	public void setChanSms(char chanSms) {
		this.chanSms = chanSms;
	}
	public char getChanSecure() {
		return chanSecure;
	}
	public void setChanSecure(char chanSecure) {
		this.chanSecure = chanSecure;
	}
	public char getChanMail() {
		return chanMail;
	}
	public void setChanMail(char chanMail) {
		this.chanMail = chanMail;
	}
	public char getChanMobile() {
		return chanMobile;
	}
	public void setChanMobile(char chanMobile) {
		this.chanMobile = chanMobile;
	}
}

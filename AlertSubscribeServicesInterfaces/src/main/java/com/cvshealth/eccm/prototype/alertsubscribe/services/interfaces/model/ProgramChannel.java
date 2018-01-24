package com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model;

public class ProgramChannel {

	private char chanEmailShowOpt = 'N'; // Y/N
	private char chanIvrShowOpt = 'N'; // Y/N
	private char chanSmsShowOpt = 'N'; // Y/N
	private char chanSecureShowOpt = 'N'; // Y/N
//	private char chanMailShowOpt = 'N'; // Y/N
//	private char chanMobileShowOpt = 'N'; // Y/N

	private char chanEmailMemberEnroll = 'N'; // Y/N
	private char chanIvrMemberEnroll = 'N'; // Y/N
	private char chanSmsMemberEnroll = 'N'; // Y/N
	private char chanSecureMemberEnroll = 'N'; // Y/N
//	private char chanMailMemberEnroll = 'N'; // Y/N
//	private char chanMobileMemberEnroll = 'N'; // Y/N
	public char getChanEmailShowOpt() {
		return chanEmailShowOpt;
	}
	public void setChanEmailShowOpt(char chanEmailShowOpt) {
		this.chanEmailShowOpt = chanEmailShowOpt;
	}
	public char getChanIvrShowOpt() {
		return chanIvrShowOpt;
	}
	public void setChanIvrShowOpt(char chanIvrShowOpt) {
		this.chanIvrShowOpt = chanIvrShowOpt;
	}
	public char getChanSmsShowOpt() {
		return chanSmsShowOpt;
	}
	public void setChanSmsShowOpt(char chanSmsShowOpt) {
		this.chanSmsShowOpt = chanSmsShowOpt;
	}
	public char getChanSecureShowOpt() {
		return chanSecureShowOpt;
	}
	public void setChanSecureShowOpt(char chanSecureShowOpt) {
		this.chanSecureShowOpt = chanSecureShowOpt;
	}
	public char getChanEmailMemberEnroll() {
		return chanEmailMemberEnroll;
	}
	public void setChanEmailMemberEnroll(char chanEmailMemberEnroll) {
		this.chanEmailMemberEnroll = chanEmailMemberEnroll;
	}
	public char getChanIvrMemberEnroll() {
		return chanIvrMemberEnroll;
	}
	public void setChanIvrMemberEnroll(char chanIvrMemberEnroll) {
		this.chanIvrMemberEnroll = chanIvrMemberEnroll;
	}
	public char getChanSmsMemberEnroll() {
		return chanSmsMemberEnroll;
	}
	public void setChanSmsMemberEnroll(char chanSmsMemberEnroll) {
		this.chanSmsMemberEnroll = chanSmsMemberEnroll;
	}
	public char getChanSecureMemberEnroll() {
		return chanSecureMemberEnroll;
	}
	public void setChanSecureMemberEnroll(char chanSecureMemberEnroll) {
		this.chanSecureMemberEnroll = chanSecureMemberEnroll;
	}


}

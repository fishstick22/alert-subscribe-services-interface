package com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model;

public class Channel {
	private String subscriptionType;     // This attribute will provide information on the subscription type. 
	                                    // Valid channels are Call, Text, Email
	private String subscriptionCode;   //
	private String subscriptionStatus; // This attribute will provide active phone number along with other statuses 
	                                  // like NOT ENROLLED, Off (No Alerts) for a given channel.
	private String subscriptionContact; // This is the phone number or email address
	
	public String getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	public String getSubscriptionCode() {
		return subscriptionCode;
	}
	public void setSubscriptionCode(String subscriptionCode) {
		this.subscriptionCode = subscriptionCode;
	}	
	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	public String getSubscriptionContact() {
		return subscriptionContact;
	}
	public void setSubscriptionContact(String subscriptionContact) {
		this.subscriptionContact = subscriptionContact;
	}

}

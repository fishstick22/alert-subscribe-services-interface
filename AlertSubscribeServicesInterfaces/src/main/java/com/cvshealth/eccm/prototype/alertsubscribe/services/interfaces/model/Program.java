package com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model;

public class Program {
	
	private String programId; // Program Id for the program added in Maintenance Panel
	private String programName; // This attribute will provide program name information to be display on PeopleSafe and Portal.
	private String programDescription; // This attribute will provide program description to be display on Portal.
	private String programChannel; // This attribute will identify the channel applicable for the program
	private String visibleInUi; // This attribute identify: 
	                           // •	if the program visible on the UI (Yes)
	                          // •	Promote program.
    private String programRule; // This attribute display the source where rule is applied from. 
                               // CVS program rule, Client program exceptions, Member program customization

    public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
	public String getProgramChannel() {
		return programChannel;
	}
	public void setProgramChannel(String programChannel) {
		this.programChannel = programChannel;
	}
	public String getVisibleInUi() {
		return visibleInUi;
	}
	public void setVisibleInUi(String visibleInUi) {
		this.visibleInUi = visibleInUi;
	}
	public String getProgramRule() {
		return programRule;
	}
	public void setProgramRule(String programRule) {
		this.programRule = programRule;
	}

}

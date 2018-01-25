package com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model.Channel;
import com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model.Communication;
import com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model.MemberCommunicationChannelResponse;
import com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model.MemberSubscriptionsResponse;
import com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model.Program;
import com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model.ProgramChannel;
import com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model.ServiceError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


@SpringBootApplication
public class AlertSubscribeServicesInterfacesApplication implements CommandLineRunner {
	// Services Interface Prototype for Alert Subscribe project
	//
	// references:
	// https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html
	// https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring
	// http://www.baeldung.com/java-xml
	// http://www.baeldung.com/jackson-xml-serialization-and-deserialization
	// http://javasampleapproach.com/java-integration/convert-java-object-intofrom-xml-spring-boot
	// https://dzone.com/articles/solving-the-xml-problem-with-jackson
	// https://github.com/eugenp/tutorials/tree/master/jackson
	
	public static void main(String[] args) {
		SpringApplication.run(AlertSubscribeServicesInterfacesApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		String xml = "";
		String memberId = "131073109";
		String clientId = "16983";
		String communicationId = "261";
		
		xml = getMemberSubscriptionsResponseXML(memberId, clientId);	
		System.out.println(xml);
		
		xml = getMemberCommunicationChannelResponseXML(memberId, clientId, communicationId);
		System.out.println(xml);

		System.out.println("MemberSubscriptionsResponse : "+getMemberSubscriptionsResponseJSON(memberId, clientId));
		System.out.println("MemberCommunicationChannelResponse : "+getMemberCommunicationChannelResponseJSON(memberId, clientId, communicationId));

	}

	private String getMemberCommunicationChannelResponseXML(String memberId, String clientId, String communicationId) throws JsonProcessingException {
		String xml;
		MemberCommunicationChannelResponse response = getMemberCommunicationChannelResponse(memberId, clientId, communicationId);
		
		ObjectMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		xml = xmlMapper.writeValueAsString(response);
		return xml;
	}
	
	private String getMemberCommunicationChannelResponseJSON(String memberId, String clientId, String communicationId) throws JsonProcessingException {
		
		MemberCommunicationChannelResponse response = getMemberCommunicationChannelResponse(memberId, clientId, communicationId);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		return mapper.writeValueAsString(response);
	}

	private MemberCommunicationChannelResponse getMemberCommunicationChannelResponse(String memberId, String clientId, String communicationId) {
		MemberCommunicationChannelResponse response = new MemberCommunicationChannelResponse();
		response.setMemberId(memberId);
		response.setClientId(clientId);
		
		ArrayList<Channel> channels = getSubscriptionChannels();
		
		response.setChannels(channels);
		
		response.setCommunication(getCommunicationChannels(communicationId));
		
		response.setPrograms(getSubscribedPrograms());
		
		return response;
	}

	private ArrayList<Program> getSubscribedPrograms() {
		ArrayList<Program> programs = new ArrayList<Program>();
		
		Program prescriptionAlertsProgram = new Program();
		
		prescriptionAlertsProgram.setProgramId("101");
		prescriptionAlertsProgram.setProgramName("Prescription Alerts");
//		prescriptionAlertsProgram.setProgramDescription("Notifications about Status of your Prescription Orders");
		prescriptionAlertsProgram.setProgramChannel(getProgramChannel());
//		prescriptionAlertsProgram.setVisibleInUi("Yes");
		prescriptionAlertsProgram.setProgramRule("Standard");
		programs.add(prescriptionAlertsProgram);
		
		Program showRxProgram = new Program();
		
		showRxProgram.setProgramId("103");
		showRxProgram.setProgramName("Show Full Drug Name");
//		prescriptionAlertsProgram.setProgramDescription("Notifications about Status of your Prescription Orders");
		showRxProgram.setProgramChannel(getProgramChannel());
//		prescriptionAlertsProgram.setVisibleInUi("Yes");
		showRxProgram.setProgramRule("Standard");
		programs.add(showRxProgram);
		
		return programs;
	}

	private Communication getCommunicationChannels(String communicationId) {
		Communication communication = new Communication();
		communication.setProgramDefaultOptIn('Y');
		communication.setCommunicationId(communicationId);
		communication.setChanEmailPriority(1);
		communication.setChanIvrPriority(3);
		communication.setChanSmsPriority(2);
		communication.setChanSecurePriority(1);
		communication.setChanDefault("Email");
		communication.setRequired('Y');
		communication.setMandatory('Y');
		
		return communication;
	}

	private String getMemberSubscriptionsResponseXML(String memberId, String clientId) throws JsonProcessingException {
		String xml;
		MemberSubscriptionsResponse response = getMemberSubscriptionResponse(memberId, clientId);
		
		ObjectMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		xml = xmlMapper.writeValueAsString(response);
		return xml;
	}
	
	private String getMemberSubscriptionsResponseJSON(String memberId, String clientId) throws JsonProcessingException {
		
		MemberSubscriptionsResponse response = getMemberSubscriptionResponse(memberId, clientId);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		return mapper.writeValueAsString(response);
	}

	private MemberSubscriptionsResponse getMemberSubscriptionResponse(String memberId, String clientId) {
		
		MemberSubscriptionsResponse response = new MemberSubscriptionsResponse();
		response.setMemberId(memberId);
		response.setClientId(clientId);
		response.setChannels(getSubscriptionChannels());
		response.setPrograms(getSubscribablePrograms());
		response.setErrors(getErrors(memberId));
		
		return response;
	}

	private ArrayList<ServiceError> getErrors(String memberId) {
		ArrayList<ServiceError> errors = new ArrayList<ServiceError>();
		
		ServiceError error = new ServiceError();
		error.setErrorCode("000");
		error.setErrorMessage("Could not get member subscriptions for " + memberId);
		
		errors.add(error);
		
		return errors;
	}

	private ArrayList<Program> getSubscribablePrograms() {
		
		ArrayList<Program> programs = new ArrayList<Program>();
		
		Program prescriptionAlertsProgram = new Program();
		
		prescriptionAlertsProgram.setProgramId("101");
		prescriptionAlertsProgram.setProgramName("Prescription Alerts");
		prescriptionAlertsProgram.setProgramDescription("Notifications about Status of your Prescription Orders");
		prescriptionAlertsProgram.setProgramChannel(getProgramChannel());
		prescriptionAlertsProgram.setVisibleInUi("Yes");
		prescriptionAlertsProgram.setProgramRule("Standard");
		programs.add(prescriptionAlertsProgram);
		
		Program showRxProgram = new Program();
		
		showRxProgram.setProgramId("103");
		showRxProgram.setProgramName("Show Full Drug Name");
		showRxProgram.setProgramDescription("Show full drug names on emails");
		showRxProgram.setProgramChannel(getEmailOnlyProgramChannel());
		showRxProgram.setVisibleInUi("Promote");
		showRxProgram.setProgramRule("Standard");
		programs.add(showRxProgram);
		
		
		return programs;
	}

	private ProgramChannel getEmailOnlyProgramChannel() {
		ProgramChannel programChannel = new ProgramChannel();
		programChannel.setChanEmailShowOpt('Y');
		programChannel.setChanIvrShowOpt('N');
		programChannel.setChanSmsShowOpt('N');
		programChannel.setChanSecureShowOpt('N');
		
//		programChannel.setChanEmailMemberEnroll('');
//		programChannel.setChanIvrMemberEnroll('N');
//		programChannel.setChanSmsMemberEnroll('N');
//		programChannel.setChanSecureMemberEnroll('Y');
		
		return programChannel;
	}

	private ProgramChannel getProgramChannel() {
		ProgramChannel programChannel = new ProgramChannel();
		programChannel.setChanEmailShowOpt('Y');
		programChannel.setChanIvrShowOpt('Y');
		programChannel.setChanSmsShowOpt('Y');
		programChannel.setChanSecureShowOpt('Y');
		
		programChannel.setChanEmailMemberEnroll('Y');
		programChannel.setChanIvrMemberEnroll('N');
		programChannel.setChanSmsMemberEnroll('N');
		programChannel.setChanSecureMemberEnroll('Y');
		
		return programChannel;
	}

	private ArrayList<Channel> getSubscriptionChannels() {
		
		ArrayList<Channel> channels = new ArrayList<Channel>();
		
		Channel emailChannel = new Channel();
		emailChannel.setSubscriptionType("Email");
		emailChannel.setSubscriptionCode("001");
		emailChannel.setSubscriptionStatus("ENROLLED");
		emailChannel.setSubscriptionContact("user@domain.tld");
		channels.add(emailChannel);

		Channel callChannel = new Channel();
		callChannel.setSubscriptionType("Call");
		callChannel.setSubscriptionCode("002");
		callChannel.setSubscriptionStatus("NOT ENROLLED");
		callChannel.setSubscriptionContact("");
		channels.add(callChannel);

		Channel textChannel = new Channel();
		textChannel.setSubscriptionType("Text");
		textChannel.setSubscriptionCode("999");
		textChannel.setSubscriptionStatus("OFF");
		textChannel.setSubscriptionContact("");
		channels.add(textChannel);
		return channels;
	}
}

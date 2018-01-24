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
		
		String json; 
		MemberSubscriptionsResponse response = getMemberSubscriptionResponse(memberId, clientId);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		System.out.println(mapper.writeValueAsString(response));
	}

	private String getMemberCommunicationChannelResponseXML(String memberId, String clientId, String communicationId) throws JsonProcessingException {
		String xml;
		MemberCommunicationChannelResponse response = getMemberCommunicationChannelResponse(memberId, clientId, communicationId);
		
		ObjectMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		xml = xmlMapper.writeValueAsString(response);
		return xml;
	}

	private MemberCommunicationChannelResponse getMemberCommunicationChannelResponse(String memberId, String clientId, String communicationId) {
		MemberCommunicationChannelResponse response = new MemberCommunicationChannelResponse();
		response.setMemberId(memberId);
		response.setClientId(clientId);
		
		ArrayList<Channel> channels = getSubscriptionChannels();
		
		response.setChannels(channels);
		
		response.setCommunication(getCommunicationChannels(communicationId));
		
		return response;
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

	private MemberSubscriptionsResponse getMemberSubscriptionResponse(String memberId, String clientId) {
		
		MemberSubscriptionsResponse response = new MemberSubscriptionsResponse();
		response.setMemberId(memberId);
		response.setClientId(clientId);

		ArrayList<Channel> channels = getSubscriptionChannels();
		
		response.setChannels(channels);
		
		ArrayList<Program> programs = getSubscribablePrograms();
		
		response.setPrograms(programs);
		return response;
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
		return programs;
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

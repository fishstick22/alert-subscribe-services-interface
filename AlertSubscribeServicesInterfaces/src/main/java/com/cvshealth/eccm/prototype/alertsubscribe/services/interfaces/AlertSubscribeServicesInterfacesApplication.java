package com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model.Channel;
import com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model.MemberSubscriptionsResponse;
import com.cvshealth.eccm.prototype.alertsubscribe.services.interfaces.model.Program;
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
	
	public static void main(String[] args) {
		SpringApplication.run(AlertSubscribeServicesInterfacesApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		MemberSubscriptionsResponse response = new MemberSubscriptionsResponse();
		response.setMemberId("131073109");
		response.setClientId("16983");

		ArrayList<Channel> channels = new ArrayList<Channel>();
		
		Channel emailChannel = new Channel();
		emailChannel.setSubscriptionType("Email");
		emailChannel.setSubscriptionStatus("ENROLLED");
		emailChannel.setSubscriptionContact("user@domain.tld");
		channels.add(emailChannel);

		Channel callChannel = new Channel();
		callChannel.setSubscriptionType("Call");
		callChannel.setSubscriptionStatus("NOT ENROLLED");
		callChannel.setSubscriptionContact("");
		channels.add(callChannel);

		Channel textChannel = new Channel();
		textChannel.setSubscriptionType("Text");
		textChannel.setSubscriptionStatus("NOT ENROLLED");
		textChannel.setSubscriptionContact("123-456-7890");
		channels.add(textChannel);
		
		response.setChannels(channels);
		
		ArrayList<Program> programs = new ArrayList<Program>();
		
		Program prescriptionAlertsProgram = new Program();
		
		prescriptionAlertsProgram.setProgramId("101");
		prescriptionAlertsProgram.setProgramName("Prescription Alerts");
		prescriptionAlertsProgram.setProgramDescription("Notifications about Status of your Prescription Orders");
		prescriptionAlertsProgram.setProgramChannel("");
		prescriptionAlertsProgram.setVisibleInUi("Yes");
		prescriptionAlertsProgram.setProgramRule("Standard");
		programs.add(prescriptionAlertsProgram);
		
		response.setPrograms(programs);
		
		ObjectMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		String xml = xmlMapper.writeValueAsString(response);
		
		System.out.println(xml);
		
	}
}

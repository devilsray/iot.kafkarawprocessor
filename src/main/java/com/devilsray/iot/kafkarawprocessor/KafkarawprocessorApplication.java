package com.devilsray.iot.kafkarawprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication
public class KafkarawprocessorApplication {

	public static void main(String[] args) {

		SpringApplication.run(KafkarawprocessorApplication.class, args);
	}


	@KafkaListener(id = "myId", topics = "rawfrommqtt")
	public void listen(@Payload String message, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {
		System.out.println(key + " - " + message);
	}

}
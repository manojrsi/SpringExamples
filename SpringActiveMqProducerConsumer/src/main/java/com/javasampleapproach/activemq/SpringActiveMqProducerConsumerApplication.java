package com.javasampleapproach.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.activemq.jms.producer.JmsProducer;
import com.javasampleapproach.activemq.model.Product;

@SpringBootApplication
public class SpringActiveMqProducerConsumerApplication implements CommandLineRunner{
	
	@Autowired
	JmsProducer producer;
 
	public static void main(String[] args) {
		SpringApplication.run(SpringActiveMqProducerConsumerApplication.class, args);
	}
 
	@Override
	public void run(String... args) throws Exception {
		/*
		 * APPLE
		 */
		Product iphone7 = new Product("Iphone 7", "iphone");
		Product iPadPro = new Product("IPadPro", "ipad");
		
		// sending
        producer.send(iphone7, "apple");
        producer.send(iPadPro, "apple");
	}
}
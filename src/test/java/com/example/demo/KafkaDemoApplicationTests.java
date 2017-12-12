package com.example.demo;


import org.apache.commons.io.FileUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaDemoApplicationTests {


	@Test
	public void maintest(){
		try {
			//FileInputStream messageAll = new FileInputStream("/home/codes/test/kafka-demo/src/main/resources/message.properties");
			File file=new File("/home/codes/test/kafka-demo/src/main/resources/message.properties");
			//Properties properties = new Properties();
			//properties.load(messageAll);
			String message = FileUtils.readFileToString(file, "UTF-8");
			String messageStr = message;
			Long timestamp = System.currentTimeMillis();
			message = messageStr.replaceAll("recv_ts_val",timestamp.toString()).replaceAll("pkg_ts_val",timestamp.toString());

			Properties props = new Properties();
			//props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.20.61.117:9092");
			//props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.20.61.32:9092");
			props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.20.66.120:9092");
			props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
			props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
			Producer<String, Object> producer = new KafkaProducer<String, Object>(props);
			System.out.println("================data: "+message);
			//ProducerRecord record = new ProducerRecord("drive-behavior-devtest",message);
			ProducerRecord record = new ProducerRecord("veh.status.all",message);

			producer.send(record);
			producer.close();
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}

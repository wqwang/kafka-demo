package com.example.demo.producer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by david on 17-8-11.
 */
@Component
public class ProducerHadler {
    public static Map<String, Object> getProducerConfigs() {
        Map<String, Object> props = new HashMap<String, Object>();
        //props.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "jmctsphadoop01.dev2:9092");
        props.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "fawmctsphadoop.dev:9092");
        props.put(org.apache.kafka.clients.producer.ProducerConfig.RETRIES_CONFIG, 0);
        props.put(org.apache.kafka.clients.producer.ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(org.apache.kafka.clients.producer.ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(org.apache.kafka.clients.producer.ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        props.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,  "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

    public void sendToKafka(String topic,String message) {
        Properties props = new Properties();
        Map<String, Object> producerConfigs = getProducerConfigs();
        for (Map.Entry entry : producerConfigs.entrySet()) {
            props.put(entry.getKey(), entry.getValue());
        }
        Producer<String, Object> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, Object>(props);
        ObjectMapper objectMapper = new ObjectMapper();

        ProducerRecord record = null;
        try {
            message = objectMapper.writeValueAsString(message);
            //ProducerRecord keyedMessage = new ProducerRecord(TOPIC, message);
            record = new ProducerRecord(topic, String.valueOf(System.currentTimeMillis()), message.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        producer.send(record);

    }

}

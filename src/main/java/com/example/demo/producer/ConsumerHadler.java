/*
package com.example.demo.producer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.BatchAcknowledgingMessageListener;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;
import org.springframework.kafka.support.Acknowledgment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumerHadler {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerHadler.class);

    private ContainerProperties getContainerProps() {
        ContainerProperties containerProps = new ContainerProperties("topics");
        containerProps.setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL_IMMEDIATE);

        containerProps.setMessageListener(new BatchAcknowledgingMessageListener<byte[], byte[]>() {
                                              @Override
                                              public void onMessage(List<ConsumerRecord<byte[], byte[]>> consumerRecords, Acknowledgment acknowledgment) {
                                                  Map<String, List<MessageDTO>> contentMap = new HashMap<>();
                                                  long startTime = System.currentTimeMillis();
                                                  logger.info("***************************************start*******************************************");
                                                  logger.info("|drive-behavior|start|" + consumerRecords.size() + "|" + startTime + "| Enter onMesage handler!");
                                                  for (ConsumerRecord<byte[], byte[]> record : consumerRecords) {
                                                      List<MessageDTO> messageDTOs = null;
                                                      if (contentMap.get(record.topic()) != null) {
                                                          messageDTOs = contentMap.get(record.topic());
                                                          MessageDTO messageDTO = new MessageDTO();
                                                          messageDTO.setTopic(record.topic());
                                                          messageDTO.setKey(String.valueOf(record.key()));
                                                          messageDTO.setContent(record.value());
                                                          messageDTO.setExtendInfo(new HashMap<String, String>() {{
                                                              put("partition", String.valueOf(record.partition()));
                                                              put("offset", String.valueOf(record.offset()));
                                                          }});
                                                          messageDTOs.add(messageDTO);
                                                      } else {
                                                          messageDTOs = new ArrayList<MessageDTO>();
                                                          MessageDTO messageDTO = new MessageDTO();
                                                          messageDTO.setTopic(record.topic());
                                                          messageDTO.setKey(String.valueOf(record.key()));
                                                          messageDTO.setContent(record.value());
                                                          messageDTO.setExtendInfo(new HashMap<String, String>() {{
                                                              put("partition", String.valueOf(record.partition()));
                                                              put("offset", String.valueOf(record.offset()));
                                                          }});
                                                          messageDTOs.add(messageDTO);
                                                          logger.info("messageDTO:" + messageDTO.toString());
                                                          contentMap.put(record.topic(), messageDTOs);
                                                      }
                                                  }
                                                  //inputHandler.process(contentMap);
                                                  logger.info("===========开始提交offset=============");
                                                  acknowledgment.acknowledge();//提交offset
                                                  logger.info("===========已经提交offset=============");
                                                  logger.info("|drive-behavior|end|" + consumerRecords.size() + "|" + (System.currentTimeMillis() - startTime) + "| onMesage handler over!");

                                              }
                                          }
        );
        return containerProps;
    }

    public Map<String, Object> getProducerConfigs() {
        Map<String, Object> props = new HashMap<String, Object>();
           */
/* props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getSenderBootstrapServers());
            props.put(ProducerConfig.RETRIES_CONFIG, config.getSenderRetries());
            props.put(ProducerConfig.BATCH_SIZE_CONFIG, config.getSenderBatchSize());
            props.put(ProducerConfig.LINGER_MS_CONFIG, config.getSenderLingerMs());
            props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, config.getSenderBufferMemory());
            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);*//*

        return props;
    }

    private Map<String, Object> getConsumerConfigs() {
        Map<String, Object> props = new HashMap<String, Object>();
           */
/* props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getConsumerBootstrapServers());
            props.put(ConsumerConfig.GROUP_ID_CONFIG, config.getConsumerGroupId());
            props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, config.getConsumerAutoCommitIntervalMs());
            props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, config.getConsumerSessionTimeoutMs());
            props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, config.isConsumerEnableAutoCommit());
            props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
            props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
            props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, config.getMaxPollRecords());
            props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, config.getHeartbeatInterval());*//*

        return props;
    }


    public ConcurrentMessageListenerContainer<byte[], byte[]> kafkaAckMessageListenerContainer() {
        ConsumerFactory<byte[], byte[]> cf = new DefaultKafkaConsumerFactory<>(getConsumerConfigs());
        ConcurrentMessageListenerContainer<byte[], byte[]> container = new ConcurrentMessageListenerContainer<byte[], byte[]>(cf, getContainerProps());
        container.setBeanName("kafkaAckMessageListenerContainer");
        container.setConcurrency(2);
        container.setAutoStartup(true);
        return container;
    }


   */
/* public KafkaTemplate<byte[], byte[]> kafkaTemplate() {
        return new KafkaTemplate<byte[], byte[]>(new DefaultKafkaProducerFactory<byte[], byte[]>(getProducerConfigs()), true);
    }*//*



}

*/
/**
 * Created by dukla on 11/25/16.
 *//*

class MessageDTO implements Serializable {
    String topic;
    String key;
    byte[] content;
    Map<String, String> extendInfo;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Map<String, String> getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(Map<String, String> extendInfo) {
        this.extendInfo = extendInfo;
    }

}*/

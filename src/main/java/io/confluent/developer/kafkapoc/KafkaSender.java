package io.confluent.developer.kafkapoc;

import ingress.Notification;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaSender {
  private final KafkaTemplate<String, Notification> kafkaTemplate;

  public KafkaSender(KafkaTemplate<String, Notification> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String key, Notification value) {
    String topic = "msk.notification.directnotification.topic.internal.any.v2";
    kafkaTemplate.send(topic, key, value);
  }
}

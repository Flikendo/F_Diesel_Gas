package com.flikendo.F_Diesel_Gas.Connection;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * Date: 02-02-2023
 * Author: Flikendo
 *
 * KafkaPublication class. This class is used to send protobuf through Kafka to database service
 * (Publication-Subscription)
 */
public class KafkaProducer {
    // Properties for Kafka's configuration
    Properties props;

    /**
     * Constructor
     */
    public KafkaProducer() {
        this.props = new Properties();

        fillInProps();
    }

    /**
     * Fills in all properties with setting of Kafka
     */
    private void fillInProps() {
        this.props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        this.props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        this.props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer");
        this.props.put("schema.registry.url", "http://127.0.0.1:8081");
    }

    /**
     * Send protobuf to Kafka service
     *
     * @param protoTub protobuf to be sent
     * @param <T> generic type of protobuf
     */
    public <T> void sendProtobuf(T protoTub) throws ExecutionException, InterruptedException {

        Producer<String, T> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, T>(this.props);

        String topic = "testproto";
        String key = "testkey";

        ProducerRecord<String, T> record = new ProducerRecord<String, T>(topic, key, protoTub);
        producer.send(record).get();
        producer.close();
    }
}

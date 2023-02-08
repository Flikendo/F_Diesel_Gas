package com.flikendo.F_Diesel_Gas.Connection;

import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * Date: 02-02-2023
 * Author: Flikendo
 *
 * KafkaPublication class. This class is used to send protobuf through Kafka to database service
 * (Publication-Subscription)
 */
public class KafkaProtoProducer {
    // Properties for Kafka's configuration
    Properties props;

    /**
     * Constructor
     */
    public KafkaProtoProducer() {
        this.props = new Properties();
        fillInProps();
    }

    /**
     * Fills in all properties with setting of Kafka
     */
    private void fillInProps() {
        this.props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        this.props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        this.props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaProtobufSerializer.class);
        this.props.put(KafkaProtobufSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");
    }

    /**
     * Send protobuf to Kafka service
     *
     * @param protoTub protobuf to be sent
     * @param <T> generic type of protobuf
     */
    public <T> void sendProtobuf(T protoTub) throws ExecutionException, InterruptedException {
        Producer<String, T> producer = new KafkaProducer<>(this.props);

        ProducerRecord<String, T> record = new ProducerRecord<>("testproto", null, protoTub);
        producer.send(record);
        producer.close();
    }
}

package com.flikendo.F_Diesel_Gas.Connection;

import com.flikendo.F_Diesel_Gas.Station.FuelStation;
import com.flikendo.proto.FuelStationTub;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Date: 02-02-2023
 * Author: Flikendo
 *
 * KafkaPublication class. This class is used to send protobuf through Kafka to database service
 * (Publication-Subscription)
 */
public class KafkaProtoProducer {
    // Properties for Kafka's configuration
    private static Properties props;

    /**
     * Fills in all properties with setting of Kafka
     */
    public static void fillInProps() {
        props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaProtobufSerializer.class);
        props.put(KafkaProtobufSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");
    }

    /**
     * Sends protobuf to Kafka service
     *
     * @param protoTub protobuf to be sent
     * @param <T> generic type of protobuf
     */
    private static <T> void sendProtobuf(T protoTub) {
        Producer<String, T> producer = new KafkaProducer<>(props);
        ProducerRecord<String, T> record = new ProducerRecord<>("protoTub", null, protoTub);
        producer.send(record);
        producer.close();
    }

    /**
     * Creates a protobuf then it is sent to Kafka
     *
     * @param protoTub object to send
     */
    public static void createProto(FuelStation protoTub) {

        FuelStationTub.FuelStation fuelStationProto = FuelStationTub.FuelStation
                .newBuilder()
                .setFuel(protoTub.getFuels().get(0))
                .setLocation(protoTub.getLocation())
                .setDate(protoTub.getTime())
                .setAddress(protoTub.getAddress())
                .setBusiness(protoTub.getCompany())
                .build();

        sendProtobuf(fuelStationProto);
    }
}

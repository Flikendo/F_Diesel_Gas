# F_Diesel_Gas
This is the main piece of a bunch of projects. It connects with a URL and get their data, then it stores it in a 
database. All these things are microservices, thus to connect this project with the one which stores data in database,
it has been used Kafka.
Protobuf has been used to send data from one to another service.

***

# What it is needed for use Kafka in Raspberry Pi
Follow the link below:
https://novagenio.medium.com/verdad-1-apache-kafka-en-raspberry-pi-funciona-8ff7651c5f72

## 1.Java installation
```
sudo apt install default-jdk
```

## 2.Apache Kafka installation
```
wget https://apache.brunneis.com/kafka/2.5.0/kafka_2.12-2.5.0.tgz

tar -xzf kafka_2.12–2.5.0.tgz

rm kafka_2.12–2.5.0.tgz
```

## 3.Configure memory and server name
In /projects/kafka_2.11-2.4.0/bin change a parameter in the next files: kafka-server-start.sh & zookeeper-server-start.sh
```
export KAFKA_HEAP_OPTS=”-Xmx512M -Xms512M”
```

If we want to call Kafka from other machines, it is necessary to change some parameters 
inside of /proyectos/kafka_2.11–2.4.0/config, where 'listener' is private IP and 'advertised.listeners' is public IP, e.g:
```
listeners=PLAINTEXT://172.31.21.226:9092

advertised.listeners=PLAINTEXT://ec2–34–250–190–216.eu-west-1.compute.amazonaws.com:9092
```

## 4.Start processes in zookeeper and server
```
sudo bin/zookeeper-server-start.sh config/zookeeper.properties

sudo bin/kafka-server-start.sh config/server.properties
```

## 5.Topics
Change directory to /proyectos/kafka_2.11–2.4.0/bin . Swap 'localhost' for IP of point "3.Configure memory and server name".
```
cd /proyectos/kafka_2.11–2.4.0/bin
```

Creating topics:
```
./kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic topic-basic-test

./kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic demo02
```

Deleting topics:
```
./kafka-topics.sh --delete --zookeeper localhost:2181 --topic demo02
```

Watch topics:
```
./kafka-topics.sh --describe --zookeeper localhost:2181 --topic demo01
```

List topics:
```
./kafka-topics.sh --list --zookeeper localhost:2181
```

## 6.Production and consume tests
Inside of /proyectos/kafka_2.11–2.4.0/bin start the consumer.
```
cd /proyectos/kafka_2.11–2.4.0/bin

./kafka-console-consumer.sh --bootstrap-server localhost:9092 --from-beginning --topic demo01
```

In other terminal, start the producer. In this terminal ">" is going to appear. Everything is written will be sent
```
./kafka-console-producer.sh --broker-list localhost:9092 --topic demo01
```

Instructions to send and receive protobuf with Kafka
https://docs.confluent.io/platform/current/schema-registry/serdes-develop/serdes-protobuf.html#protobuf-deserializer
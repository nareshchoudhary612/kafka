package productoffering.kafka_testing;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConsumerDemo {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		Logger logger = LoggerFactory.getLogger(ConsumerDemo.class.getName());

		String bootstrapServers = "10.123.189.70:9092";
		// String groupId = "my-fourth-application";
		String groupId = "lab-productoffering-ms";
		String topic = "Payment_Key";
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		// properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "none");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

		consumer.subscribe(Arrays.asList(topic));

		// KeyExchangeMessage kem = new KeyExchangeMessage();
		//boolean x = true;
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

			for (ConsumerRecord<String, String> record : records) {

			//	KeyExchangeMessage kem  = mapper.readValue(record.value(), KeyExchangeMessage.class);
				
				System.out.println("key: " + record.key() + ",Raw value: " + record.value());
				
			//	System.out.println("key: " + record.key() + ",value: " + kem.getField());
				//x = false;
				/*
				 * logger.info("key: " + record.key() + ",value: " +record.value());
				 * logger.info("Partition: " + record.partition() + ",Offset:" + record.offset()
				 * + ", Group id " + ConsumerConfig.GROUP_ID_CONFIG.toString());
				 */
			}
		}

	}

}

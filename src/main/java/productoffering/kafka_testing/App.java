package productoffering.kafka_testing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "{\"releaseId\":\"7cdbeb046d9c4e678acd70d677ed7163\"}" );
        
        //Logger logger = LoggerFactory.getILoggerFactory(helloWorld.class);
        
        String bootstrapServers = "10.123.189.70:9092";
        
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");  
        Date date = new Date(System.currentTimeMillis());  
        System.out.println(formatter.format(date));
        
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        
        KafkaProducer<String,String> producer = new KafkaProducer<String,String>(properties);
       // {"releaseId":"7c"}
        for(int i =0; i<1; i++) {
 //       String message = "{\"releaseId\":\"" + formatter.format(date) + " " +i + "\"}";
        	String message = "{\"messageKey\": \"KeyExchangeMessage-xfDVer7v9+uACexLIabLEw==\",\"field\":\"test_key\"}";
       // 	String message = "{\"eventType\":\"KeyExchangeMessage\",\"eventId\":\"KeyExchangeMessage-xfDVer7v9+uACexLIabLEw==\",\"eventTime\":\"2019-07-25T15:02:34.290-05:00\",\"eventClass\":\"com.amdocs.digital.ms.payments.keyexchange.asyncmessages.implementation.KeyExchangeMessage\",\"deprecated\":false,\"event\":{\"messageKey\":\"KeyExchangeMessage-xfDVer7v9+uACexLIabLEw==\",\"field\":\"test_key\"}}";
//        System.out.println(message);
        ProducerRecord<String, String> record = new ProducerRecord<String,String>("Payment_Key", message);
//        System.out.println("before sending");
        producer.send(record);
   
        }
        producer.flush();
//        System.out.println("before clsing");        
        producer.close();

        
        
        
        
        
        
    }
}

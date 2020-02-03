package br.nom.marcelomenezes.access;

import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import br.nom.marcelomenezes.core.ConfigurationHelper;


public class KafkaDAO {
	private String topicName = "test";
	
	private Properties getProperties(Boolean isProducer) {
		
		// read project properties
		Properties projectProps = ConfigurationHelper.getProperties();
		
		// create instance for properties to access producer configs   
		Properties props = new Properties();

		//Assign localhost id
		props.put("bootstrap.servers", projectProps.getProperty("bootstrap.servers"));


		if (isProducer) {
			//Set acknowledgements for producer requests.      
			props.put("acks", "all");

			//If the request fails, the producer can automatically retry,
			props.put("retries", 0);

			//Specify buffer size in config
			props.put("batch.size", 16384);

			//Reduce the no of requests less than 0   
			props.put("linger.ms", 1);

			//The buffer.memory controls the total amount of memory available to the producer for buffering.   
			props.put("buffer.memory", 33554432);

			props.put("key.serializer", 
					"org.apache.kafka.common.serialization.StringSerializer");

			props.put("value.serializer", 
					"org.apache.kafka.common.serialization.StringSerializer");
		}else {
			props.put("group.id", "CountryCounter");

			props.put("key.deserializer",
					"org.apache.kafka.common.serialization.StringDeserializer");
			props.put("value.deserializer",
					"org.apache.kafka.common.serialization.StringDeserializer");
		}

		//Assign topicName to string variable		
		topicName= projectProps.getProperty("topicName");
		
		return props;
	}

	public String receive() {

		StringBuilder sb = new StringBuilder();
		
		Properties props = this.getProperties(false);
		
		KafkaConsumer<String, String> consumer =
				new KafkaConsumer<String, String>(props);
		consumer.subscribe(Collections.singletonList(topicName));
		try {
			ConsumerRecords<String, String> records = consumer.poll(100); 
			for (ConsumerRecord<String, String> record : records) 
			{
				sb.append(record.value());
			}

		} finally {
			consumer.close(); 
		}

		return sb.toString();

	}

	public void send(String message) throws Exception{
		//Assign topicName to string variable
		String topicName = "test";

		Properties props = this.getProperties(true);

		Producer<String, String> producer = new KafkaProducer
				<String, String>(props);

		producer.send(new ProducerRecord<String, String>(topicName, 
				"ABC", message));
		System.out.println("Message sent successfully");
		producer.close();
	}
}



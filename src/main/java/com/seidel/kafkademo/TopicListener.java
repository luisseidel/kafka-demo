package com.seidel.kafkademo;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TopicListener {

	@Value("${topic.name.consumer}")
	private String topicName;
	private int tweetsCapturados = 0;
	private int tweetsPositivos = 0;
	private int tweetsNegativos = 0;

	private String contabilidadeTweets = "Tweets Capturados: %s, Tweets Positivos: %s, Tweets Negativos: %s";

	public String analisarContabilizar(String tweetText) {
		this.tweetsCapturados++;

		tweetText = tweetText.replaceAll("[^\\sa-zA-Z0-9]", "");
		List<String> palavras = List.of(tweetText.split(" "));

		boolean positivos = palavras.stream().anyMatch(new FeelingHelper().getPositivos()::contains);
		boolean negativos = palavras.stream().anyMatch(new FeelingHelper().getNegativos()::contains);

		if (positivos) {
			this.tweetsPositivos++;
		}
		if (negativos) {
			this.tweetsNegativos++;
		}

		return String.format(contabilidadeTweets, tweetsCapturados, tweetsPositivos, tweetsNegativos);
	}

	@KafkaListener(topics = "${topic.name.consumer}", groupId = "${spring.kafka.producer.group-id}")
	private void consumeTweet(ConsumerRecord<String, String> tweetText) {
//		log.info("Tópico: {} ", topicName);
//		log.info("Key: {}", tweetText.key());
//		log.info("Headers: {}", tweetText.headers());
//		log.info("Partition: {}", tweetText.partition());
//		log.info("Order: {}", tweetText.value());

		log.info(analisarContabilizar(tweetText.value()));
	}



}

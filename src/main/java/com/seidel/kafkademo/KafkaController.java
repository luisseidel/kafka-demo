package com.seidel.kafkademo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/kafka", consumes = MediaType.APPLICATION_JSON_VALUE)
public class KafkaController {

	private final TopicProducer topicProducer;

	@PostMapping(value = "/send")
	private void sendTweet(@RequestBody Tweet tweet) {
		log.info("Tweet recebido via post: " + tweet);
		topicProducer.send(tweet);
	}
}


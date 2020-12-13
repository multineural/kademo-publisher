package net.multineural.kademo.publisher;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Random;

@Service
public class StockTickerPublisher {

    Logger logger = LoggerFactory.getLogger(StockTickerPublisher.class);

    private final String tickerTopic = "DIA_TEST";
    private final Random random = new Random();

    private KafkaTemplate<String, String> kafkaTemplate;

    public StockTickerPublisher(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void updateTickers() {

        // this is our one simulated ticker symbol: DIA_TEST
        final int price = random.nextInt(100) + 200;
        final String message = "{\"" + tickerTopic + "\":" + price + "}";

        ProducerRecord<String, String> record = generateRecord(message);

        kafkaTemplate.send(record)
            .addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    logger.info("FAILED");
                }

                @Override
                public void onSuccess(SendResult<String, String> sendResult) {
                    logger.info("Sent " + record.toString());
                }
            });

    }


    private ProducerRecord<String, String> generateRecord(final String message) {

        final String key = tickerTopic + "-" + System.currentTimeMillis();
        ProducerRecord<String, String> record = new ProducerRecord<>(tickerTopic, key, message);
        return record;
    }


}

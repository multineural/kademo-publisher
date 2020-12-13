package net.multineural.kademo.publisher;

import org.springframework.stereotype.Service;

@Service
public class StockTickerPublisher {

    public static boolean OPEN = false;

    public void openMarket() {
        OPEN = true;
    }

    public void closeMarket() {
        OPEN = false;
    }

    public void sendTicker() {
        while(OPEN) {

        }
    }
}

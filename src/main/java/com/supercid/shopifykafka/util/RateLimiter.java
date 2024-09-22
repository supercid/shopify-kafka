package com.supercid.shopifykafka.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component
public class RateLimiter {

    private static final long INITIAL_BACKOFF = 1000; // 1 second
    private static final int MAX_RETRIES = 5;

    public <T> T execute(Callable<T> task) throws Exception {
        int retries = 0;
        long backoff = INITIAL_BACKOFF;

        while (true) {
            try {
                return task.call();
            } catch (Exception e) {
                if (++retries == MAX_RETRIES) {
                    throw e;
                }
                Thread.sleep(backoff);
                backoff *= 2; // Exponential backoff
            }
        }
    }
}
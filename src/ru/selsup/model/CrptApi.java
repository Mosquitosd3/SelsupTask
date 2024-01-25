package ru.selsup.model;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CrptApi {
    private final Lock lock = new ReentrantLock();
    private final long timeInterval;
    private final int requestLimit;
    private long lastRequestTime;
    private int requestCount;

    public CrptApi(TimeUnit timeUnit, int requestLimit) {
        this.timeInterval = timeUnit.toMillis(1);
        this.requestLimit = requestLimit;
        this.lastRequestTime = System.currentTimeMillis();
        this.requestCount = 0;
    }

    public void createDocument(Document document, String signature) {
        lock.lock();
        try {
            long currentTime = System.currentTimeMillis();

            if (currentTime - lastRequestTime > timeInterval) {
                // Если прошло достаточно времени, сбрасываем счетчик запросов
                requestCount = 0;
                lastRequestTime = currentTime;
            }

            // Проверка на превышение лимита запросов
            if (requestCount >= requestLimit) {
                // Заблокировать вызов, если лимит превышен
                return;
            }

            // Выполнение запроса

            // Увеличение счетчика запросов
            requestCount++;
        } finally {
            lock.unlock();
        }
    }
}

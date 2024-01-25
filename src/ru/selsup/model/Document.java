package ru.selsup.model;

import java.util.List;

public class Document {
    private Description description;
    private String docId;
    private String docStatus;
    private String docType;
    private boolean importRequest;
    private String ownerInn;
    private String participantInn;
    private String producerInn;
    private String productionDate;
    private String productionType;
    private List<Product> products;
    private String regDate;
    private String regNumber;

    // Геттеры и сеттеры

    // Внутренний класс для представления "description"
    public static class Description {
        private String participantInn;

        // Геттеры и сеттеры
    }

    // Внутренний класс для представления элемента "products"
    public static class Product {
        private String certificateDocument;
        private String certificateDocumentDate;
        private String certificateDocumentNumber;
        private String ownerInn;
        private String producerInn;
        private String productionDate;
        private String tnvedCode;
        private String uitCode;
        private String uituCode;

        // Геттеры и сеттеры для каждого поля
    }
}

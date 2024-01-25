package ru.selsup;

import ru.selsup.model.CrptApi;
import ru.selsup.model.Document;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        CrptApi crptApi = new CrptApi(TimeUnit.MINUTES, 5);

        Document document = new Document();
        String signature = "example_signature";

        crptApi.createDocument(document, signature);
    }
}
package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            // Описываем, что загрузится по адресу /
            config.routes.get("/", ctx -> ctx.result("Hello World"));

            // Пример диспетчеризации запросов
            config.routes.get("/hello", ctx -> ctx.result("GET /hello"));
            config.routes.post("/hello", ctx -> ctx.result("POST /hello"));

        });
        app.start(7070); // Стартуем веб-сервер
    }
}
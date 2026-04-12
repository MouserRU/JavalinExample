package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            // Включаем логирование
            config.bundledPlugins.enableDevLogging();

            // Описываем, что загрузится по адресу /
            config.routes.get("/", ctx -> ctx.result("Hello World"));

            // Пример диспетчеризации запросов
            config.routes.get("/request", ctx -> ctx.result("GET /request"));
            config.routes.post("/request", ctx -> ctx.result("POST /request"));

            // Получаем параметр запроса
            config.routes.get("/hello", ctx -> {
                var name = ctx.queryParam("name");
                if (name == null) {
                    ctx.redirect("/");
                } else {
                    ctx.result("Hello " + name);
                }
            });

            // Пример работы с динамическими маршрутами
            config.routes.get("/users/{id}/post{postid}", ctx -> {
                var id = ctx.pathParam("id");
                var postid = ctx.pathParam("postid");
                ctx.result("User " + id + " post " + postid);
            });
        });
        app.start(7070); // Стартуем веб-сервер
    }
}

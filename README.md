# Тестовое задание от ООО Инсайд 

## Стек примененных технологий.
* Spring Boot
* Spring Data
* Spring Security
* Mysql Database
* JWT Token Generator
* Паттерн "Стратегия" для реализации различной модели поведениея при получении соответствующей команды в теле сообщения.


## Инструкция по запуску приложений.

Для того что бы собрать приложение - необходимо выполнить следующую команду
1. Перейдите в каталог в который был склонирован репозиторий.
2. Выполните в консоле следующую команду для сборки `docker-compose up`
3. После того как контейнер будет собран можно будет выполнить следующие комнды по работе с приложением.
4. Регистрация пользователя

`curl --location --request POST 'http://localhost:9090/auth/register' \
   --header 'Content-Type: application/json' \
   --data-raw '{
   "name":"user",
   "password": "12345"
   }'`
   
5. Авторизация пользователя - получение токена

`curl --location --request POST 'http://localhost:9090/auth/' \
--header 'Content-Type: application/json' \
--data-raw '{
"name":"user",
"password": "12345"
}'`

6. Создание сообщения от имени зарегистрированного пользователя

`curl --location --request POST 'http://localhost:9090/message/' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjYyMTUyNDAwfQ.s6QBi21u19QmwaMoyyImpwgIHcxprspbixY3dNF2pkzAAdWSoAuApZIrEzeEmuqonAth-RhLW6DTDiZln-VoSw' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "user",
"message": "My first message!"
}'`

7. Получение сообщений от пользователя. Так же в теле сообщения можно указать "history 10" число может быть призвольным.

`curl --location --request POST 'http://localhost:9090/message/get' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjYyMTUyNDAwfQ.s6QBi21u19QmwaMoyyImpwgIHcxprspbixY3dNF2pkzAAdWSoAuApZIrEzeEmuqonAth-RhLW6DTDiZln-VoSw' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "user",
"message": "history 10"
}'`

Спасибо.

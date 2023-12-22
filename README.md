# Проект "Сравнение страховых продуктов"

#### backend:
- Java 17
- docker
- hibernate
- postgres

1. Структура БД: ER-диаграмма https://docs.google.com/document/d/1HbKorjpZAMQ0h8RNKP_9IUanLDZTQodkYkNE6U_o048/edit?usp=sharing
2. Пользовательские сценарии: https://docs.google.com/document/d/1yGQFTlRTslMNAadolFd6Tf0E_SYPAIGYnXJgghP8POE/edit#heading=h.eze2imstzvax
3. Архитектура backend на miro: https://miro.com/app/board/uXjVNNdisX8=/

### API

http://propolis.acceleratorpracticum.ru:8080/swagger-ui/index.html


### Заявка на консультацию
#### Отправить заявку на консультацию
[ссылка на ТЗ](https://docs.google.com/document/d/1S7jVxwizJAurR7hgyirhOIWoInb9id4IDP_WGXPQ2Ko/edit?pli=1)

http://localhost:8080/consultation-request
#### Корректный POST запрос
```json
{
"firstName": "Peppa",
"lastName": "Pig",
"phoneNumber": "+74951112233",
"situation": "I have a big trouble. My car is broken. My house was burned. My health will be lost"
} 
```

#### Ожидаемый ответ
```json
{
"firstName": "Peppa",
"lastName": "Pig",
"phoneNumber": "+74951112233",
"situation": "I have a big trouble. My car is broken. My house was burned. My health will be lost"
}
```
<br>

### Создание заявки с описанием ситуации, если её нет в каталоге
#### Отправить заявку с описанием ситуации
[ссылка на ТЗ](https://docs.google.com/document/d/1mLDkJoQ8oGVjYOBk-w_tuwawR5KIbM0Xs8dlI-ESvf8/edit?pli=1#heading=h.zaexo44qsqti)

http://localhost:8080/new-insurance-request
#### Корректный POST запрос
```json
{
"fullName": "Вася Pupkin",
"phoneNumber": "+79909123457",
"email": "vpupkin@mail.com",
"situation": "Когда у тебя в кармане загораются спички, то радуйся и благодари небо, что у тебя в кармане не пороховой погреб.",
"insuranceAsAGift": true
}
```

#### Ожидаемый ответ
```json
{
"id": 1,
"fullName": "Вася Pupkin",
"phoneNumber": "+79909123457",
"email": "vpupkin@mail.com",
"situation": "Когда у тебя в кармане загораются спички, то радуйся и благодари небо, что у тебя в кармане не пороховой погреб.",
"insuranceAsAGift": true
}
```
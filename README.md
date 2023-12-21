# Проект "Сравнение страховых продуктов"
## backend

1. Структура БД: ER-диаграмма https://docs.google.com/document/d/1HbKorjpZAMQ0h8RNKP_9IUanLDZTQodkYkNE6U_o048/edit?usp=sharing
2. Пользовательские сценарии: https://docs.google.com/document/d/1yGQFTlRTslMNAadolFd6Tf0E_SYPAIGYnXJgghP8POE/edit#heading=h.eze2imstzvax
3. Архитектура backend на miro: https://miro.com/app/board/uXjVNNdisX8=/


### Заявка на консультацию
#### Отправить заявку на консультацию

http:localhost:8080/consultation-request
#### Корректный POST запрос
{
"firstName": "Peppa",
"lastName": "Pig",
"phoneNumber": "+74951112233",
"situation": "I have a big trouble. My car is broken. My house was burned. My health will be lost"
} 
#### Ожидаемый ответ
{
"firstName": "Peppa",
"lastName": "Pig",
"phoneNumber": "+74951112233",
"situation": "I have a big trouble. My car is broken. My house was burned. My health will be lost"
}
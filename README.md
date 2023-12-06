# Проект "Сравнение страховых продуктов"
## backend

1. Структура БД: ER-диаграмма https://docs.google.com/document/d/1HbKorjpZAMQ0h8RNKP_9IUanLDZTQodkYkNE6U_o048/edit?usp=sharing 
2. Ползовательские сценарии: https://docs.google.com/document/d/1yGQFTlRTslMNAadolFd6Tf0E_SYPAIGYnXJgghP8POE/edit#heading=h.eze2imstzvax
3. Архитектура backend на miro: https://miro.com/app/board/uXjVNNdisX8=/  


### Расчет ОСАГО - Территориальный Коэффициент
#### Получить весь список 

http://localhost:8080/region-coefficient/all
json:
> {
> "id": 1,
> "name": "Республика Адыгея (Адыгея)",
> "subRegionList": [
> {
> "id": 1,
> "name": "Республика Адыгея (Адыгея)",
> "coefficientExclude": 1.240,
> "coefficientInclude": 1.000
> } ]
> }

#### Произвести поиск вхождения по списку

http://localhost:8080/region-coefficient/search?query=test
json:
> [ {
> "id": 6,
> "name": "Благовещенск, Октябрьский",
> "coefficientExclude": 1.160,
> "coefficientInclude": 0.840
> }
> ]

#### Вернуть регион по ID

http://localhost:8080/region-coefficient/{regionId}
json:
> {
> "id": 6,
> "name": "Благовещенск, Октябрьский",
> "coefficientExclude": 1.160,
> "coefficientInclude": 0.840
> }
> {


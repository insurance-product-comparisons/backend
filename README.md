# Проект "Сравнение страховых продуктов"
## backend


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


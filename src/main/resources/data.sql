INSERT INTO companies (name, description, rating, logo)
VALUES ('Альфа', 'Альфа страхование - это уверенность', 5.0, 'logo/alpha.png'),
       ('Бета', 'Бета страхование - это тревожность', 3.9, 'logo/beta.png');


INSERT INTO licenses (company_id, license)
VALUES (1, 'licences/alpha-license.pdf'),
       (2, 'licenses/beta-license.pdf');


INSERT INTO insurances (company_id, type, name, description, processing_time)
VALUES (1, 'KASKO', 'КАСКО для Альфачей', 'КАСКО для Альфачей - это уверенность и переплата в 1000%', 1),
       (2, 'OSAGO', 'Просто Осаго', 'Просто Осаго - и ничего лишнего. Просто плати и иди', 1);


INSERT INTO required_documents (insurance_id, document)
VALUES (1, 'Заявление на получение страховки'),
       (1, 'Паспорт или иное удостоверение личности'),
       (1, 'Регистрационные документы на ТС'),
       (1, 'Водительские удостоверения или их копии для всех лиц, допущенных к управлению ТС'),
       (1, 'Предыдущий полис страхования КАСКО (при наличии)'),
       (1, 'Документы на противоугонные системы'),
       (1, 'Два комплекта ключей'),
       (1, 'Диагностическая карта машины'),
       (2, 'Заявление на получение страховки'),
       (2, 'Паспорт или иное удостоверение личности'),
       (2, 'Регистрационные документы на ТС'),
       (2, 'Водительские удостоверения или их копии для всех лиц, допущенных к управлению ТС'),
       (2, 'Диагностическая карта машины');


INSERT INTO features (insurance_id, feature_name, feature_description)
VALUES (1, 'Ущерб от ДТП',
        'Полис КАСКО покрывает ущерб, который может произойти в результате дорожно-транспортного происшествия, включая случаи, когда владелец автомобиля является виновником ДТП'),
       (1, 'Угон', 'Если ваш автомобиль угоняют, полис КАСКО покрывает этот риск'),
       (1, 'Повреждения от стихийных бедствий',
        'Полис КАСКО также покрывает ущерб от стихийных бедствий, таких как ураганы или наводнения'),
       (1, 'Повреждения от падения предметов',
        'Если на ваш автомобиль упадет, например, дерево и повредит его, полис КАСКО покрывает этот риск'),
       (1, 'Возможность выбора франшизы',
        'Франшиза - это часть ущерба, которую не возмещает страховая компания. Вы можете выбрать размер франшизы, что позволяет снизить стоимость полиса'),
       (2, 'Ущерб, причиненный жизни или здоровью третьих лиц',
        'Если в результате ДТП по вине водителя пострадали другие люди, страховая компания возмещает расходы на их лечение'),
       (2, 'Ущерб, причиненный имуществу третьих лиц',
        'Если в результате ДТП было повреждено имущество других людей (например, автомобиль или забор), страховая компания возмещает расходы на его восстановление');


INSERT INTO validity_periods (insurance_id, validity_period)
VALUES (1, 30),
       (1, 90),
       (1, 365),
       (2, 365);


INSERT INTO driver_number_coefficient (driver_number, coefficient)
VALUES ('1 и более', 1.0),
       ('Без ограничений для физических лиц', 2.32),
       ('Без ограничений для юридических лиц', 1.97);


INSERT INTO age (age)
VALUES ('16-21'),
       ('22-24'),
       ('25-29'),
       ('30-34'),
       ('35-39'),
       ('40-49'),
       ('50-59'),
       ('60+');


INSERT INTO driving_experience (driving_experience)
VALUES ('0'),
       ('1'),
       ('2'),
       ('3-4'),
       ('5-6'),
       ('7-9'),
       ('10-14'),
       ('15+');


INSERT INTO age_experience_coefficient (age_id, experience_id, coefficient)
VALUES (1, 1, 2.27),
       (1, 2, 1.92),
       (1, 3, 1.84),
       (1, 4, 1.65),
       (1, 5, 1.62),
       (2, 1, 1.88),
       (2, 2, 1.72),
       (2, 3, 1.71),
       (2, 4, 1.13),
       (2, 5, 1.1),
       (2, 6, 1.09),
       (3, 1, 1.72),
       (3, 2, 1.6),
       (3, 3, 1.54),
       (3, 4, 1.09),
       (3, 5, 1.08),
       (3, 6, 1.07),
       (3, 7, 1.02),
       (4, 1, 1.56),
       (4, 2, 1.5),
       (4, 3, 1.48),
       (4, 4, 1.05),
       (4, 5, 1.04),
       (4, 6, 1.01),
       (4, 7, 0.97),
       (4, 8, 0.95),
       (5, 1, 1.54),
       (5, 2, 1.47),
       (5, 3, 1.46),
       (5, 4, 1),
       (5, 5, 0.97),
       (5, 6, 0.95),
       (5, 7, 0.94),
       (5, 8, 0.93),
       (6, 1, 1.5),
       (6, 2, 1.44),
       (6, 3, 1.43),
       (6, 4, 0.96),
       (6, 5, 0.95),
       (6, 6, 0.94),
       (6, 7, 0.93),
       (6, 8, 0.91),
       (7, 1, 1.46),
       (7, 2, 1.4),
       (7, 3, 1.39),
       (7, 4, 0.93),
       (7, 5, 0.92),
       (7, 6, 0.91),
       (7, 7, 0.9),
       (7, 8, 0.86),
       (8, 1, 1.43),
       (8, 2, 1.36),
       (8, 3, 1.35),
       (8, 4, 0.91),
       (8, 5, 0.9),
       (8, 6, 0.89),
       (8, 7, 0.88),
       (8, 8, 0.83)
ON CONFLICT (age_id, experience_id) DO NOTHING;


INSERT INTO kmb_coefficient (kbm, coefficient)
VALUES ('Класс M', 3.92),
       ('Класс 0', 2.94),
       ('Класс 1', 2.25),
       ('Класс 2', 1.76),
       ('Класс 3', 1.17),
       ('Класс 4', 1),
       ('Класс 5', 0.91),
       ('Класс 6', 0.83),
       ('Класс 7', 0.78),
       ('Класс 8', 0.74),
       ('Класс 9', 0.68),
       ('Класс 10', 0.63),
       ('Класс 11', 0.57),
       ('Класс 12', 0.52),
       ('Класс 13', 0.46);


INSERT INTO season_coefficient (usage_period, coefficient)
VALUES ('3', 0.5),
       ('4', 0.6),
       ('5', 0.65),
       ('6', 0.7),
       ('7', 0.8),
       ('8', 0.9),
       ('9', 0.95),
       ('10-12', 1);


INSERT INTO engine_power_coefficient (engine_power, coefficient)
VALUES ('до 50 л.с', '0.6'),
       ('51-70 л.с', '1.0'),
       ('71-100 л.с', '1.1'),
       ('101-120 л.с', '1.2'),
       ('121-150 л.с', '1.4'),
       ('151 л.с и выше', '1.6');


INSERT INTO base_rate_coefficient (transport_type, min_coefficient, max_coefficient)
VALUES ('Мотоциклы, мопеды и лёгкие квадроциклы ("А", "М")', 324, 2536),
       ('Легковые автомобили юр. лиц ("В", "ВЕ")', 852, 5722),
       ('Легковые автомобили физ. лиц ("В", "ВЕ")', 1646, 7535),
       ('Легковые автомобили такси ("В", "ВЕ")', 1490, 15756),
       ('Грузовые автомобили с разрешённой максимальной массой 16 тонн и менее ("С", "CE")', 1163, 9934),
       ('Грузовые автомобили с разрешённой максимальной массой более 16 тонн ("С", "CE")', 1752, 14957),
       ('Автобусы с числом пассажирских не более 16, помимо сиденья водителя ("D", "DE")', 1106, 6823),
       ('Автобусы с числом пассажирских мест более 16 ("D", "DE")', 1382, 8526),
       ('Автобусы, используемые на регулярных перевозках с посадкой и высадкой пассажиров ("D", "DE")', 3053, 9144),
       ('Троллейбусы ("Tb")', 1668, 4997),
       ('Трамваи ("Tm")', 1041, 3116),
       ('Тракторы и иная специальная колёсная техника', 451, 3198);


INSERT INTO region (id, name) OVERRIDING SYSTEM VALUE
VALUES (1, 'Республика Адыгея (Адыгея)'),
       (2, 'Республика Алтай'),
       (3, 'Республика Башкортостан'),
       (4, 'Республика Бурятия'),
       (5, 'Республика Дагестан'),
       (6, 'Республика Ингушетия'),
       (7, 'Кабардино-Балкарская Республика'),
       (8, 'Республика Калмыкия'),
       (9, 'Карачаево-Черкесская Республика'),
       (10, 'Республика Карелия'),
       (11, 'Республика Коми'),
       (12, 'Республика Крым'),
       (13, 'Республика Марий Эл'),
       (14, 'Республика Мордовия'),
       (15, 'Республика Саха (Якутия)'),
       (16, 'Республика Северная Осетия - Алания'),
       (17, 'Республика Татарстан (Татарстан)'),
       (18, 'Республика Тыва'),
       (19, 'Удмуртская Республика'),
       (20, 'Республика Хакасия'),
       (21, 'Чеченская Республика'),
       (22, 'Чувашская Республика - Чувашия'),
       (23, 'Алтайский край'),
       (24, 'Забайкальский край'),
       (25, 'Камчатский край'),
       (26, 'Краснодарский край'),
       (27, 'Красноярский край'),
       (28, 'Пермский край'),
       (29, 'Приморский край'),
       (30, 'Ставропольский край'),
       (31, 'Хабаровский край'),
       (32, 'Амурская область'),
       (33, 'Архангельская область'),
       (34, 'Астраханская область'),
       (35, 'Белгородская область'),
       (36, 'Брянская область'),
       (37, 'Владимирская область'),
       (38, 'Волгоградская область'),
       (39, 'Вологодская область'),
       (40, 'Воронежская область'),
       (41, 'Ивановская область'),
       (42, 'Иркутская область'),
       (43, 'Калининградская область'),
       (44, 'Калужская область'),
       (45, 'Кемеровская область - Кузбасс'),
       (46, 'Кировская область'),
       (47, 'Костромская область'),
       (48, 'Курганская область'),
       (49, 'Курская область'),
       (50, 'Ленинградская область'),
       (51, 'Липецкая область'),
       (52, 'Магаданская область'),
       (53, 'Московская область'),
       (54, 'Мурманская область'),
       (55, 'Нижегородская область'),
       (56, 'Новгородская область'),
       (57, 'Новосибирская область'),
       (58, 'Омская область'),
       (59, 'Оренбургская область'),
       (60, 'Орловская область'),
       (61, 'Пензенская область'),
       (62, 'Псковская область'),
       (63, 'Ростовская область'),
       (64, 'Рязанская область'),
       (65, 'Самарская область'),
       (66, 'Саратовская область'),
       (67, 'Сахалинская область'),
       (68, 'Свердловская область'),
       (69, 'Смоленская область'),
       (70, 'Тамбовская область'),
       (71, 'Тверская область'),
       (72, 'Томская область'),
       (73, 'Тульская область'),
       (74, 'Тюменская область'),
       (75, 'Ульяновская область'),
       (76, 'Челябинская область'),
       (77, 'Ярославская область'),
       (78, 'Москва'),
       (79, 'Санкт-Петербург'),
       (80, 'Севастополь'),
       (81, 'Еврейская автономная область'),
       (82, 'Ненецкий автономный округ'),
       (83, 'Ханты-Мансийский автономный округ - Югра'),
       (84, 'Чукотский автономный округ'),
       (85, 'Ямало-Ненецкий автономный округ'),
       (86, 'Байконур'),
       (87, 'Донецкая Народная Республика'),
       (88, 'Луганская Народная Республика'),
       (89, 'Херсонская область'),
       (90, 'Запорожская область');


INSERT INTO region_coefficient (region_id, name, coefficient_exclude, coefficient_include)
VALUES (1, 'Республика Адыгея (Адыгея)', 1.24, 1),
       (2, 'Горно-Алтайск', 1.24, 0.84),
       (2, 'Прочие города и населенные пункты', 0.76, 0.6),
       (3, 'Благовещенск, Октябрьский', 1.16, 0.84),
       (3, 'Ишимбай, Кумертау, Салават', 1.08, 0.84),
       (3, 'Стерлитамак, Туймазы', 1.24, 0.84),
       (3, 'Уфа', 1.64, 1),
       (3, 'Прочие города и населенные пункты', 1, 0.84),
       (4, 'Улан-Удэ', 1.24, 0.84),
       (4, 'Прочие города и населенные пункты', 0.76, 0.7),
       (5, ' Буйнакск, Дербент, Каспийск, Махачкала, Хасавюрт ', 0.96, 0.76),
       (5, 'Прочие города и населенные пункты', 0.9, 0.76),
       (6, 'Малгобек', 0.94, 0.76),
       (6, 'Назрань', 0.82, 0.76),
       (6, 'Прочие города и населенные пункты', 0.82, 0.76),
       (7, ' Нальчик, Прохладный ', 1, 0.84),
       (7, 'Прочие города и населенные пункты', 0.88, 0.76),
       (8, 'Элиста', 1.24, 0.84),
       (8, 'Прочие города и населенные пункты', 0.82, 0.76),
       (9, 'Карачаево-Черкесская Республика', 1, 0.88),
       (10, 'Петрозаводск', 1.24, 0.84),
       (10, 'Прочие города и населенные пункты', 0.84, 0.6),
       (11, 'Сыктывкар', 1.48, 1),
       (11, 'Ухта', 1.24, 0.84),
       (11, 'Прочие города и населенные пункты', 1, 0.84),
       (12, 'Симферополь', 0.76, 0.76),
       (12, 'Прочие города и населенные пункты', 0.68, 0.68),
       (13, 'Волжск', 1, 0.84),
       (13, 'Йошкар-Ола', 1.32, 0.84),
       (13, 'Прочие города и населенные пункты', 0.76, 0.6),
       (14, 'Рузаевка', 1.16, 1),
       (14, 'Саранск', 1.4, 1),
       (14, 'Прочие города и населенные пункты', 0.84, 0.68),
       (15, 'Нерюнгри', 0.84, 0.6),
       (15, 'Якутск', 1.16, 0.76),
       (15, 'Прочие города и населенные пункты', 0.68, 0.6),
       (16, 'Владикавказ', 1, 0.88),
       (16, 'Прочие города и населенные пункты', 0.94, 0.76),
       (17, ' Альметьевск, Зеленодольск, Нижнекамск ', 1.24, 0.84),
       (17, ' Бугульма, Лениногорск, Чистополь ', 1, 0.84),
       (17, 'Елабуга', 1.16, 0.84),
       (17, 'Казань', 1.8, 1.16),
       (17, 'Набережные Челны', 1.56, 1),
       (17, 'Прочие города и населенные пункты', 1.08, 0.84),
       (18, 'Кызыл', 0.82, 0.76),
       (18, 'Прочие города и населенные пункты', 0.82, 0.76),
       (19, 'Воткинск', 1.08, 0.84),
       (19, ' Глазов, Сарапул ', 1, 0.84),
       (19, 'Ижевск', 1.48, 1),
       (19, 'Прочие города и населенные пункты', 0.84, 0.6),
       (20, ' Абакан, Саяногорск, Черногорск ', 1, 0.84),
       (20, 'Прочие города и населенные пункты', 0.82, 0.76),
       (21, 'Чеченская Республика', 0.82, 0.76),
       (22, 'Канаш', 1.08, 0.84),
       (22, 'Новочебоксарск', 1.16, 0.84),
       (22, 'Чебоксары', 1.56, 1),
       (22, 'Прочие города и населенные пункты', 0.88, 0.7),
       (23, 'Барнаул', 1.56, 1),
       (23, 'Бийск', 1.16, 0.84),
       (23, ' Заринск, Новоалтайск, Рубцовск ', 1.08, 0.84),
       (23, 'Прочие города и населенные пункты', 0.76, 0.6),
       (24, 'Краснокаменск', 0.82, 0.76),
       (24, 'Чита', 0.82, 0.7),
       (24, 'Прочие города и населенные пункты', 0.68, 0.6),
       (25, 'Петропавловск-Камчатский', 1.24, 1),
       (25, 'Прочие города и населенные пункты', 1, 0.68),
       (26, ' Анапа, Геленджик ', 1.24, 0.84),
       (26, ' Армавир, Сочи, Туапсе ', 1.16, 0.84),
       (26, ' Белореченск, Ейск, Кропоткин, Крымск, Курганинск, Лабинск, Славянск - на - Кубани, Тимашевск, Тихорецк ',
        1.08, 0.84),
       (26, ' Краснодар, Новороссийск ', 1.64, 1),
       (26, 'Прочие города и населенные пункты', 1, 0.84),
       (27, ' Ачинск, Зеленогорск ', 1.08, 0.84),
       (27, ' Железногорск, Норильск ', 1.24, 0.84),
       (27, ' Канск, Лесосибирск, Минусинск, Назарово ', 1, 0.84),
       (27, 'Красноярск', 1.64, 1),
       (27, 'Прочие города и населенные пункты', 0.92, 0.6),
       (28, ' Березники, Краснокамск ', 1.24, 0.84),
       (28, ' Лысьва, Чайковский ', 1, 0.84),
       (28, 'Пермь', 1.8, 1.16),
       (28, 'Соликамск', 1.16, 0.84),
       (28, 'Прочие города и населенные пункты', 1.08, 0.84),
       (29, ' Арсеньев, Артем, Находка, Спасск - Дальний, Уссурийск ', 1, 0.88),
       (29, 'Владивосток', 1.36, 1),
       (29, 'Прочие города и населенные пункты', 0.96, 0.76),
       (30, ' Буденновск, Георгиевск, Ессентуки, Минеральные Воды, Невинномысск, Пятигорск ', 1, 0.84),
       (30, ' Кисловодск, Михайловск, Ставрополь ', 1.16, 0.84),
       (30, 'Прочие города и населенные пункты', 0.76, 0.6),
       (31, 'Амурск', 1, 0.84),
       (31, 'Комсомольск-на-Амуре', 1.27, 0.88),
       (31, 'Хабаровск', 1.56, 1),
       (31, 'Прочие города и населенные пункты', 0.88, 0.7),
       (32, ' Белогорск, Свободный ', 1.08, 0.92),
       (32, 'Благовещенск', 1.48, 0.92),
       (32, 'Прочие города и населенные пункты', 1, 0.68),
       (33, 'Архангельск', 1.64, 1),
       (33, 'Котлас', 1.48, 1),
       (33, 'Северодвинск', 1.56, 1),
       (33, 'Прочие города и населенные пункты', 0.88, 0.6),
       (34, 'Астрахань', 1.32, 1),
       (34, 'Прочие города и населенные пункты', 0.84, 0.6),
       (35, 'Белгород', 1.24, 0.84),
       (35, ' Губкин, Старый Оскол', 1, 0.88),
       (35, 'Прочие города и населенные пункты', 0.84, 0.6),
       (36, 'Брянск', 1.4, 1),
       (36, 'Клинцы', 1, 0.84),
       (36, 'Прочие города и населенные пункты', 0.76, 0.6),
       (37, 'Владимир', 1.48, 1),
       (37, 'Гусь-Хрустальный', 1.08, 0.84),
       (37, 'Муром', 1.16, 0.84),
       (37, 'Прочие города и населенные пункты', 1, 0.84),
       (38, 'Волгоград', 1.24, 0.84),
       (38, 'Волжский', 1.08, 0.84),
       (38, ' Камышин, Михайловка ', 1, 0.84),
       (38, 'Прочие города и населенные пункты', 0.76, 0.6),
       (39, 'Вологда', 1.56, 1),
       (39, 'Череповец', 1.64, 1),
       (39, 'Прочие города и населенные пункты', 0.92, 0.6),
       (40, ' Борисоглебск, Лиски, Россошь ', 1.08, 0.92),
       (40, 'Воронеж', 1.4, 1.08),
       (40, 'Прочие города и населенные пункты', 0.84, 0.68),
       (41, 'Иваново', 1.64, 1),
       (41, 'Кинешма', 1.08, 0.84),
       (41, 'Шуя', 1, 0.84),
       (41, 'Прочие города и населенные пункты', 0.92, 0.6),
       (42, 'Ангарск', 1.16, 0.84),
       (42, ' Братск, Тулун, Усть - Илимск, Усть - Кут, Черемхово ', 1, 0.84),
       (42, 'Иркутск', 1.56, 1),
       (42, 'Усолье-Сибирское', 1.08, 0.84),
       (42, 'Шелехов', 1.24, 0.84),
       (42, 'Прочие города и населенные пункты', 0.84, 0.6),
       (43, 'Калининград', 1.08, 0.84),
       (43, 'Прочие города и населенные пункты', 0.84, 0.6),
       (44, 'Калуга', 1.16, 0.84),
       (44, 'Обнинск', 1.24, 0.84),
       (44, 'Прочие города и населенные пункты', 0.92, 0.6),
       (45, 'Анжеро-Судженск, Киселевск, Юрга ', 1.16, 0.84),
       (45, ' Белово, Березовский, Междуреченск, Осинники, Прокопьевск ', 1.24, 0.84),
       (45, 'Кемерово', 1.72, 1),
       (45, 'Новокузнецк', 1.64, 1),
       (45, 'Прочие города и населенные пункты', 1.08, 0.84),
       (46, 'Киров', 1.32, 1),
       (46, 'Кирово-Чепецк', 1.16, 0.84),
       (46, 'Прочие города и населенные пункты', 0.84, 0.6),
       (47, 'Кострома', 1.24, 0.84),
       (47, 'Прочие города и населенные пункты', 0.76, 0.6),
       (48, 'Курган', 1.32, 0.84),
       (48, 'Шадринск', 1.08, 0.84),
       (48, 'Прочие города и населенные пункты', 0.76, 0.7),
       (49, 'Железногорск', 1, 0.84),
       (49, 'Курск', 1.16, 0.84),
       (49, 'Прочие города и населенные пункты', 0.76, 0.6),
       (50, 'Ленинградская область', 1.24, 0.84),
       (51, 'Елец', 1, 0.84),
       (51, 'Липецк', 1.4, 1),
       (51, 'Прочие города и населенные пункты', 0.84, 0.6),
       (52, 'Магадан', 0.82, 0.7),
       (52, 'Прочие города и населенные пункты', 0.76, 0.7),
       (53, 'Московская область', 1.56, 1),
       (54, ' Апатиты, Мончегорск ', 1.24, 1),
       (54, 'Мурманск', 1.88, 1.16),
       (54, 'Североморск', 1.48, 1),
       (54, 'Прочие города и населенные пункты', 1.16, 1),
       (55, ' Арзамас, Выкса, Саров ', 1.08, 0.84),
       (55, ' Балахна, Бор, Дзержинск ', 1.24, 0.84),
       (55, 'Кстово', 1.16, 0.84),
       (55, 'Нижний Новгород', 1.64, 1),
       (55, 'Прочие города и населенные пункты', 1, 0.84),
       (56, 'Боровичи', 1, 0.84),
       (56, 'Великий Новгород', 1.24, 0.84),
       (56, 'Прочие города и населенные пункты', 0.92, 0.6),
       (57, 'Бердск', 1.24, 0.84),
       (57, 'Искитим', 1.16, 0.84),
       (57, 'Куйбышев', 1, 0.84),
       (57, 'Новосибирск', 1.63, 1),
       (57, 'Прочие города и населенные пункты', 1, 0.76),
       (58, 'Омск', 1.48, 1),
       (58, 'Прочие города и населенные пункты', 0.92, 0.6),
       (59, ' Бугуруслан, Бузулук, Новотроицк ', 1, 0.84),
       (59, 'Оренбург', 1.56, 1),
       (59, 'Орск', 1.08, 0.84),
       (59, 'Прочие города и населенные пункты', 0.84, 0.6),
       (60, ' Ливны, Мценск ', 1, 0.84),
       (60, 'Орел', 1.16, 0.84),
       (60, 'Прочие города и населенные пункты', 0.76, 0.6),
       (61, 'Заречный', 1.16, 0.84),
       (61, 'Кузнецк', 1, 0.84),
       (61, 'Пенза', 1.32, 1),
       (61, 'Прочие города и населенные пункты', 0.76, 0.6),
       (62, 'Великие Луки', 1, 0.84),
       (62, 'Псков', 1.16, 0.84),
       (62, 'Прочие города и населенные пункты', 0.76, 0.6),
       (63, 'Азов', 1.16, 0.84),
       (63, 'Батайск', 1.24, 0.84),
       (63, ' Волгодонск, Гуково, Каменск - Шахтинский, Новочеркасск, Новошахтинск, Сальск, Таганрог ', 1, 0.84),
       (63, 'Ростов-на-Дону', 1.64, 1),
       (63, 'Шахты', 1.08, 0.84),
       (63, 'Прочие города и населенные пункты', 0.84, 0.6),
       (64, 'Рязань', 1.32, 1),
       (64, 'Прочие города и населенные пункты', 0.92, 0.6),
       (65, ' Новокуйбышевск, Сызрань ', 1.08, 0.84),
       (65, 'Самара', 1.48, 1),
       (65, 'Тольятти', 1.4, 1),
       (65, 'Чапаевск', 1.16, 0.84),
       (65, 'Прочие города и населенные пункты', 0.92, 0.6),
       (66, ' Балаково, Балашов, Вольск ', 1, 0.84),
       (66, 'Саратов', 1.48, 1),
       (66, 'Энгельс', 1.16, 0.84),
       (66, 'Прочие города и населенные пункты', 0.76, 0.6),
       (67, 'Южно-Сахалинск', 1.4, 1),
       (67, 'Прочие города и населенные пункты', 0.92, 0.6),
       (68, ' Асбест, Ревда ', 1.08, 0.84),
       (68, ' Березовский, Верхняя Пышма, Новоуральск, Первоуральск ', 1.24, 0.84),
       (68, 'Верхняя Салда, Полевской ', 1.16, 0.84),
       (68, 'Екатеринбург', 1.64, 1),
       (68, 'Прочие города и населенные пункты', 1, 0.84),
       (69, ' Вязьма, Рославль, Сафоново, Ярцево ', 1, 0.84),
       (69, 'Смоленск', 1.16, 0.84),
       (69, 'Прочие города и населенные пункты', 0.76, 0.6),
       (70, 'Мичуринск', 1, 0.84),
       (70, 'Тамбов', 1.16, 0.84),
       (70, 'Прочие города и населенные пункты', 0.84, 0.6),
       (71, 'Вышний Волочек, Кимры, Ржев ', 1, 0.84),
       (71, 'Тверь', 1.4, 1),
       (71, 'Прочие города и населенные пункты', 0.84, 0.6),
       (72, 'Северск', 1.16, 0.84),
       (72, 'Томск', 1.48, 1),
       (72, 'Прочие города и населенные пункты', 0.92, 0.6),
       (73, ' Алексин, Ефремов, Новомосковск ', 1, 0.84),
       (73, 'Тула', 1.4, 1),
       (73, ' Узловая, Щекино ', 1.16, 0.84),
       (73, 'Прочие города и населенные пункты', 0.92, 0.6),
       (74, 'Тобольск', 1.24, 0.84),
       (74, 'Тюмень', 1.8, 1.16),
       (74, 'Прочие города и населенные пункты', 1.08, 0.84),
       (75, 'Димитровград', 1.16, 0.92),
       (75, 'Ульяновск', 1.4, 1.08),
       (75, 'Прочие города и населенные пункты', 0.92, 0.68),
       (76, ' Златоуст, Миасс ', 1.32, 0.84),
       (76, 'Копейск', 1.48, 1),
       (76, 'Магнитогорск', 1.64, 1),
       (76, ' Сатка, Чебаркуль ', 1.16, 0.84),
       (76, 'Челябинск', 1.88, 1.24),
       (76, 'Прочие города и населенные пункты', 1, 0.84),
       (77, 'Ярославль', 1.4, 1),
       (77, 'Прочие города и населенные пункты', 0.92, 0.6),
       (78, 'Москва', 1.8, 1.16),
       (79, 'Санкт-Петербург', 1.64, 1),
       (80, 'Севастополь', 0.82, 0.82),
       (81, 'Биробиджан', 0.82, 0.76),
       (81, 'Прочие города и населенные пункты', 0.82, 0.76),
       (82, 'Ненецкий автономный округ', 0.84, 0.6),
       (83, 'Когалым', 1, 0.84),
       (83, ' Нефтеюганск, Нягань ', 1.24, 0.84),
       (83, 'Сургут', 1.8, 1.16),
       (83, 'Нижневартовск', 1.64, 1),
       (83, 'Ханты-Мансийск', 1.4, 1),
       (83, 'Прочие города и населенные пункты', 1.08, 0.84),
       (84, 'Чукотский автономный округ', 0.76, 0.7),
       (85, 'Новый Уренгой', 1, 0.84),
       (85, 'Ноябрьск', 1.56, 1),
       (85, 'Прочие города и населенные пункты', 1.08, 0.84),
       (86, 'Байконур', 0.82, 0.76),
       (87, 'Донецкая Народная Республика', 0.68, 0.68),
       (88, 'Луганская Народная Республика', 0.68, 0.68),
       (89, 'Херсонская область', 0.68, 0.68),
       (90, 'Запорожская область', 0.68, 0.68);
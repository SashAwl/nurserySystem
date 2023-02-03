create database Mans_Friends;
show databases;
use Mans_Friends;

create table Commands(ID_command int primary key auto_increment,
					  Name_command varchar(10)
);

insert into Commands(Name_command)
values
("name"), ("sit"), ("stay"), ("come"), ("down"),("stop"), ("bark"), ("place"), ("playDead"), ("wait"), ("goodBoy"), ("goodGirl"), ("leavIt");

select * from Commands;

create table Class(ID_class int primary key auto_increment,
				   Name_class varchar(20)
);

insert into Class(Name_class)
values
("Pets"),
("Pack_animals");

select *from Class;

create table Type_animal(ID_type int primary key auto_increment,
						 Name_type varchar(15),
                         Class_type int,
                         Foreign key (Class_type) references Class(ID_class)
);

insert into Type_animal(Name_type, Class_type)
values
("Dog", 1),
("Cat", 1),
("Hamster", 1),
("Hors", 2),
("Camel", 2),
("Donkey", 2);

select *from Type_animal;

create table Animals(ID_animal int primary key auto_increment,
					Name_animal varchar(10),
                    Type_animal integer,
                    foreign key (Type_animal) references Type_animal(ID_type),
                    Birthdate date,
                    Command_animal integer,
                    foreign key (Command_animal) references Commands(ID_command)
);

insert into Animals(Name_animal, Type_animal, Birthdate, Command_animal)
values
("Abbigale", 2, "2020-02-22", 12),
("Abbigale", 2, "2020-02-22", 5),
("Abbigale", 2, "2020-02-22", 1),
("Bonita", 2, "2020-02-23", 12),
("Bonita", 2, "2018-02-23", 1),
("Bonita", 2, "2018-02-23", 6),
("Bonita", 2, "2018-02-23", 12),
("Cain", 2, "2019-05-13", 11),
("Cain", 2, "2019-05-13", 5),
("Cain", 2, "2019-05-13", 6),
("Buzz", 1, "2021-05-10", 11),
("Buzz", 1, "2021-05-10", 1),
("Buzz", 1, "2021-05-10", 6),
("Buzz", 1, "2021-05-10", 8),
("Buzz", 1, "2021-05-10", 4),
("Drake", 1, "2022-03-16", 11),
("Drake", 1, "2022-03-16", 13),
("Drake", 1, "2022-03-16", 7),
("Drake", 1, "2022-03-16", 2),
("Drake", 1, "2022-03-16", 3),
("Drake", 1, "2022-03-16", 9),
("Duffy", 1, "2018-09-26", 3),
("Duffy", 1, "2018-09-26", 7),
("Duffy", 1, "2018-09-26", 1),
("Ferris", 1, "2018-09-21", 11),
("Ferris", 1, "2018-09-21", 1),
("Ferris", 1, "2018-09-21", 4),
("Ferris", 1, "2018-09-21", 13),
("Ferris", 1, "2018-09-21", 2),
("Flurry", 3, "2019-10-21", 1),
("Flurry", 3, "2019-10-21", 8),
("Flurry", 3, "2019-10-21", 9),
("Gabby", 3, "2021-11-11", 1),
("Gabby", 3, "2021-11-11", 8),
("Gabby", 3, "2021-11-11", 12),
("Gabby", 3, "2021-11-11", 4),
("Grace", 4, "2015-06-17", 1),
("Grace", 4, "2015-06-17", 12),
("Grace", 4, "2015-06-17", 6),
("Grace", 4, "2015-06-17", 5),
("Grace", 4, "2015-06-17", 8),
("Grace", 4, "2015-06-17", 4),
("Hobbs", 4, "2015-04-27", 1),
("Hobbs", 4, "2015-04-27", 11),
("Hobbs", 4, "2015-04-27", 5),
("Hobbs", 4, "2015-04-27", 3),
("Harvey", 5, "2014-08-08", 1),
("Harvey", 5, "2014-08-08", 2),
("Harvey", 5, "2014-08-08", 3),
("Harvey", 5, "2014-08-08", 4),
("Harvey", 5, "2014-08-08", 6),
("Harvey", 5, "2014-08-08", 5),
("Inky", 6, "2020-02-28", 1),
("Inky", 6, "2020-02-28", 2),
("Inky", 6, "2020-02-28", 3),
("Inky", 6, "2020-02-28", 4),
("Inky", 6, "2020-02-28", 5),
("Inky", 6, "2020-02-28", 6);

/*
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку, объединить таблицы лошади и ослы в одну таблицу.
*/

-- Удаление верблюдов
delete from Animals
where Type_animal=5;

select * from Animals;

-- Поскольку в моей БД данные представлены в едной таблице, то я попробовала составить несколько вариантов запросов с разными операторами
-- Выборка данных о лошадях и ослах, объединение данных
with Hors as
	(select Name_animal, Type_animal, Birthdate, Command_animal from Animals where Animals.Type_animal="4"),
Donkey As
	(select  Name_animal, Type_animal, Birthdate, Command_animal from Animals where Animals.Type_animal="6")
select * from Hors 
union (select * from Donkey)
order by Name_animal;

-- Или

select Animals.Name_animal,  Type_animal.Name_type, Animals.Birthdate, Commands.Name_command
from Animals
Join Commands ON Commands.ID_command=Animals.command_animal
Join Type_animal ON Type_animal.ID_type=Animals.type_animal
where Animals.Type_animal="4" or Animals.Type_animal="6"
order by name_animal;

/* 
11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
       до месяца подсчитать возраст животных в новой таблице
*/
create table Young_animals 
as select distinct Name_animal, Birthdate, 
	  (concat(TIMESTAMPDIFF (month, Birthdate, CURRENT_DATE()) DIV 12, "  year ", TIMESTAMPDIFF(month, Birthdate, CURRENT_DATE()) MOD 12, " month")) as Age
   from Animals
   where TIMESTAMPDIFF(month, Birthdate, CURRENT_DATE())>12 and TIMESTAMPDIFF(month, Birthdate, CURRENT_DATE())<36;

select * from Young_animals;

/* 
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам. 
*/
-- не сосвсем понятно, что значит "указывающие на прошлую принадлежность..". Интерпритировала как включая поля с ID
select * from Animals
Join Type_animal ON Type_animal.ID_type = Animals.type_animal
Join Class ON Class.ID_class = Type_animal.Class_type
Join Commands ON Commands.ID_command = Animals.Command_animal;

-- или в немного сокращенном виде
select ID_animal, Name_animal, Birthdate, 
	   Type_animal.Name_type, Type_animal.ID_type, 
       Commands.Name_command, Commands.ID_command,
       Class.Name_class, Class.ID_class
       from Animals
Join Type_animal ON Type_animal.ID_type = Animals.type_animal
Join Class ON Class.ID_class = Type_animal.Class_type
Join Commands ON Commands.ID_command = Animals.Command_animal;
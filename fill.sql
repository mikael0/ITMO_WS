CREATE TABLE "persons" (
 id bigserial NOT NULL,
 name character varying(200),
 surname character varying(200),
 age integer,
 sex CHARACTER VARYING (2) NOT NULL,
 birth DATE NOT NULL DEFAULT CURRENT_DATE,
 CONSTRAINT "Persons_pkey" PRIMARY KEY (id)
);

INSERT INTO persons(name, surname, age, sex, birth) values ('Петр', 'Петров', 25, 'M', '1991-04-26' );
INSERT INTO persons(name, surname, age, sex, birth) values ('Владимир', 'Иванов', 26, 'M', '1990-04-26' );
INSERT INTO persons(name, surname, age, sex, birth) values ('Иван', 'Иванов', 27, 'M', '1989-04-26' );
INSERT INTO persons(name, surname, age, sex, birth) values ('Иммануил', 'Кант', 28, 'M', '1988-04-26' );
INSERT INTO persons(name, surname, age, sex, birth) values ('Джордж', 'Клуни', 29, 'M', '1987-04-26' );
INSERT INTO persons(name, surname, age, sex, birth) values ('Билл', 'Рубцов', 30, 'M', '1986-04-26' );
INSERT INTO persons(name, surname, age, sex, birth) values ('Марк', 'Марков', 31, 'M', '1985-04-26' );
INSERT INTO persons(name, surname, age, sex, birth) values ('Галина', 'Матвеева', 32, 'Ж', '1984-04-26' );
INSERT INTO persons(name, surname, age, sex, birth) values ('Святослав', 'Павлов', 33, 'M', '1983-04-26' );
INSERT INTO persons(name, surname, age, sex, birth) values ('Ольга', 'Бергольц', 34, 'Ж', '1982-04-26' );
INSERT INTO persons(name, surname, age, sex, birth) values ('Лев', 'Рабинович', 35, 'M', '1981-04-26' );

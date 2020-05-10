CREATE DATABASE shop;
CREATE TABLE Customer
(
    Id SERIAL PRIMARY KEY,
    Lastname CHARACTER VARYING(30),
    Location CHARACTER VARYING(30),
    Discount INTEGER
);

CREATE TABLE Shop
(
    Id SERIAL PRIMARY KEY,
    Name CHARACTER VARYING(30),
    Area CHARACTER VARYING(30),
    commission INTEGER
);

CREATE TABLE Book
(
    Id SERIAL PRIMARY KEY,
    Name CHARACTER VARYING(30),
    Price INTEGER,
    Storage CHARACTER VARYING(30),
    Number INTEGER
);


CREATE TABLE Purchase
(
    id SERIAL PRIMARY KEY,
	Date DATE,
	Seller Integer REFERENCES Shop (Id),
	CustomerId Integer REFERENCES Customer (Id),
	BookId Integer REFERENCES Book (Id),
	Number INTEGER,
            Sum INTEGER
);

INSERT INTO public.book( id, name, price, storage, number)
	VALUES
	(1, '1984', 350, 'Нижегорожский', 6),
	(2, 'Java', 1550, 'Советский', 5),
           (3, 'Windows', 740, 'Нижегорожский', 4);
	

INSERT INTO public.customer( id, lastname, location, discount)
	VALUES 
	(1, 'Захарова', 'Нижегородский', 5),
	(2, 'Минеева', 'Сормовский', 5),
	(3, 'Бажанова', 'Приокский', 15),
	(4, 'Елизаров', 'Советский', 10);

INSERT INTO public.shop(id, name, area, Сommission)
	VALUES 
	 (1, 'One', 'Нижегородский', 25),
	 (2, 'Book24', 'Советский', 10),
	 (3, 'Litress', 'Сормовский', 15),
	 (4, 'Labirint', 'Приокский', 20);
INSERT INTO public.purchase(
	id, data, seller, customerid, bookid, number, sum)
	VALUES 
	(1, '2020-01-12', 1, 1, 3, 2, 1480),
	(2, '2020-02-04', 2, 2, 1, 1, 350),
	(3, '2020-02-08', 3, 3, 2, 4, 5200),
	(4, '2020-03-12', 4, 1, 3, 3, 2220),
	(5, '2020-01-28', 2, 4, 1, 2, 700);

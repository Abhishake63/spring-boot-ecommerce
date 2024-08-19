DROP TABLE IF EXISTS "customers";
DROP SEQUENCE IF EXISTS customers_id_seq;
CREATE SEQUENCE customers_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

CREATE TABLE "public"."customers" (
    "id" bigint DEFAULT nextval('customers_id_seq') NOT NULL,
    "first_name" character varying(255) NOT NULL,
    "last_name" character varying(255) NOT NULL,
    "phone_number" character varying(255) NOT NULL,
    CONSTRAINT "customers_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "uk_6v6x92wb400iwh6unf5rwiim4" UNIQUE ("phone_number")
) WITH (oids = false);


DROP TABLE IF EXISTS "order_items";
DROP SEQUENCE IF EXISTS order_items_id_seq;
CREATE SEQUENCE order_items_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

CREATE TABLE "public"."order_items" (
    "id" bigint DEFAULT nextval('order_items_id_seq') NOT NULL,
    "price" numeric(38,2) NOT NULL,
    "quantity" integer NOT NULL,
    "order_id" bigint NOT NULL,
    "product_id" bigint NOT NULL,
    CONSTRAINT "order_items_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


DROP TABLE IF EXISTS "orders";
DROP SEQUENCE IF EXISTS orders_id_seq;
CREATE SEQUENCE orders_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

CREATE TABLE "public"."orders" (
    "id" bigint DEFAULT nextval('orders_id_seq') NOT NULL,
    "order_date" date NOT NULL,
    "total_amount" numeric(38,2) NOT NULL,
    "customer_id" bigint NOT NULL,
    CONSTRAINT "orders_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


DROP TABLE IF EXISTS "products";
DROP SEQUENCE IF EXISTS products_id_seq;
CREATE SEQUENCE products_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

CREATE TABLE "public"."products" (
    "id" bigint DEFAULT nextval('products_id_seq') NOT NULL,
    "description" character varying(255),
    "name" character varying(255) NOT NULL,
    "price" numeric(38,2) NOT NULL,
    "stock_quantity" integer NOT NULL,
    CONSTRAINT "products_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


DROP TABLE IF EXISTS "wishlist";
DROP SEQUENCE IF EXISTS wishlist_id_seq;
CREATE SEQUENCE wishlist_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

CREATE TABLE "public"."wishlist" (
    "id" bigint DEFAULT nextval('wishlist_id_seq') NOT NULL,
    "customer_id" bigint NOT NULL,
    "product_id" bigint NOT NULL,
    CONSTRAINT "wishlist_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


INSERT INTO "customers" ("id", "first_name", "last_name", "phone_number") VALUES
(1,	'John',	'Doe',	'+8801711111111'),
(2,	'Jane',	'Smith',	'+8801711111112'),
(3,	'Michael',	'Johnson',	'+8801711111113'),
(4,	'Emily',	'Williams',	'+8801711111114'),
(5,	'David',	'Brown',	'+8801711111115'),
(6,	'Sarah',	'Davis',	'+8801711111116'),
(7,	'Robert',	'Miller',	'+8801711111117'),
(8,	'Jessica',	'Wilson',	'+8801711111118'),
(9,	'Daniel',	'Moore',	'+8801711111119'),
(10,	'Ashley',	'Taylor',	'+8801711111120');


INSERT INTO "order_items" ("id", "price", "quantity", "order_id", "product_id") VALUES
(1,	19.99,	2,	1,	1),
(2,	14.99,	1,	1,	3),
(3,	29.99,	1,	2,	2),
(4,	24.99,	1,	2,	4),
(5,	39.99,	1,	3,	5),
(6,	9.99,	5,	3,	6),
(7,	49.98,	1,	4,	7),
(8,	19.99,	3,	5,	1),
(9,	25.00,	4,	5,	8),
(10,	34.97,	5,	6,	9);


INSERT INTO "orders" ("id", "order_date", "total_amount", "customer_id") VALUES
(1, '2024-04-21', 50.00, 1),
(2, '2024-04-22', 74.98, 2),
(3, '2024-04-23', 89.97, 3),
(4, '2024-04-24', 49.98, 4),
(5, '2024-04-25', 119.97, 5),
(6, '2024-04-26', 29.97, 6),
(7, '2024-04-27', 99.97, 7),
(8, '2024-04-28', 69.98, 8),
(9, '2024-04-29', 100.00, 9),
(10, '2024-04-30', 20.00, 10);


INSERT INTO "products" ("id", "description", "name", "price", "stock_quantity") VALUES
(1,	'Description for Product 1',	'Product 1',	19.99,	100),
(2,	'Description for Product 2',	'Product 2',	29.99,	50),
(3,	'Description for Product 3',	'Product 3',	14.99,	75),
(4,	'Description for Product 4',	'Product 4',	24.99,	25),
(5,	'Description for Product 5',	'Product 5',	39.99,	60),
(6,	'Description for Product 6',	'Product 6',	9.99,	200),
(7,	'Description for Product 7',	'Product 7',	49.99,	30),
(8,	'Description for Product 8',	'Product 8',	25.00,	150),
(9,	'Description for Product 9',	'Product 9',	34.99,	40),
(10,	'Description for Product 10',	'Product 10',	22.99,	80);


INSERT INTO "wishlist" ("id", "customer_id", "product_id") VALUES
(1,	1,	2),
(2,	1,	5),
(3,	2,	3),
(4,	2,	7),
(5,	3,	1),
(6,	3,	9),
(7,	4,	4),
(8,	4,	8),
(9,	5,	6),
(10,	5,	10);


ALTER TABLE ONLY "public"."order_items" ADD CONSTRAINT "fkbioxgbv59vetrxe0ejfubep1w" FOREIGN KEY (order_id) REFERENCES orders(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."order_items" ADD CONSTRAINT "fkocimc7dtr037rh4ls4l95nlfi" FOREIGN KEY (product_id) REFERENCES products(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."orders" ADD CONSTRAINT "fkpxtb8awmi0dk6smoh2vp1litg" FOREIGN KEY (customer_id) REFERENCES customers(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."wishlist" ADD CONSTRAINT "fk6p7qhvy1bfkri13u29x6pu8au" FOREIGN KEY (product_id) REFERENCES products(id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."wishlist" ADD CONSTRAINT "fkk6lal9w7ut5e4xvta479rq06y" FOREIGN KEY (customer_id) REFERENCES customers(id) NOT DEFERRABLE;

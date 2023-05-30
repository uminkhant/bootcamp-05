insert into category(name) values ('Diary');
insert into category(name) values ('Snacks');
insert into category(name) values ('Drinks');
insert into category(name) values ('Fruits');
insert into category(name) values ('Vegetables');
insert into category(name) values ('Cleaning');
insert into category(name) values('Others');


insert into item (name,price,category_id) values('Milk',2500,1);
insert into item (name,price,category_id) values('Eggs',2200,1);
insert into item (name,price,category_id) values('Butter',4000,1);
insert into item (name,price,category_id) values('Cheese',3000,1);
insert into item (name,price,category_id) values('Yogurt',1200,1);
insert into item (name,price,category_id) values('Candy',700,2);
insert into item (name,price,category_id) values('Dried Fruit',1500,2);
insert into item (name,price,category_id) values('Popcorn',800,2);
insert into item (name,price,category_id) values('Sunflower Seeds',1200,2);
insert into item (name,price,category_id) values('Tiger Beer',2500,3);
insert into item (name,price,category_id) values('Su Coffee',3500,3);
insert into item (name,price,category_id) values('Lemon Juice',3200,3);
insert into item (name,price,category_id) values('Red Bull',1000,3);
insert into item (name,price,category_id) values('Red level',42000,3);
insert into item (name,price,category_id) values('Super Tea',300,3);
insert into item (name,price,category_id) values('Aye thar yar Wine',4500,3);
insert into item (name,price,category_id) values('Apple',1500,4);
insert into item (name,price,category_id) values('Avocados',1500,4);
insert into item (name,price,category_id) values('Cherries',2000,4);
insert into item (name,price,category_id) values('Grapefruit',1500,4);
insert into item (name,price,category_id) values('Watermelon',2000,4);
insert into item (name,price,category_id) values('Broccoli',2000,5);
insert into item (name,price,category_id) values('Chilies',500,5);
insert into item (name,price,category_id) values('Onions',3200,5);
insert into item (name,price,category_id) values('Potatoes',1000,5);
insert into item (name,price,category_id) values('Tomatos',1200,5);
insert into item (name,price,category_id) values('Air fresher',4000,6);
insert into item (name,price,category_id) values('Garbage bag',700,6);
insert into item (name,price,category_id) values('Glass cleaner',1300,6);
insert into item (name,price,category_id) values('Dish soap',500,6);
insert into item (name,price,category_id) values('Laundry soap',2200,6);
insert into item (name,price,category_id) values('Body Wash soap',2200,null);

insert into address(street,township,city) values('19st','aungmyaytharzan','mandalay');
insert into address(street,township,city) values('35st','mahar aung myay','mandalay');
insert into address(street,township,city) values('41st','mahar aung myay','mandalay');

insert into customer (name,address_id) values ('Andrew',1);
insert into customer (name,address_id) values ('Sophia',1);
insert into customer (name,address_id) values ('William',1);
insert into customer (name,address_id) values ('John',1);
insert into customer (name,address_id) values ('Arnel',2);
insert into customer (name,address_id) values ('Upul Sampah',3);

insert into cus_item values (1,1);
insert into cus_item values (5,1);
insert into cus_item values (10,1);
insert into cus_item values (20,1);

insert into cus_item values (11,2);
insert into cus_item values (13,2);
insert into cus_item values (25,2);

insert into cus_item values (9,3);
insert into cus_item values (14,3);
insert into cus_item values (22,3);
insert into cus_item values (16,3);
insert into cus_item values (30,3);

insert into cus_item values (19,4);
insert into cus_item values (14,4);
insert into cus_item values (22,4);

insert into cus_item values (11,5);
insert into cus_item values (30,5);

insert into cus_item values (21,6);

insert into voucher(customer_id,voucher_date) values (1,'20220112');
insert into voucher(customer_id,voucher_date) values (2,'20220405');
insert into voucher(customer_id,voucher_date) values (3,'20230107');
insert into voucher(customer_id,voucher_date) values (4,'20230222');
insert into voucher(customer_id,voucher_date) values (5,'20230303');
insert into voucher(customer_id,voucher_date) values (6,'20230411');
insert into voucher(customer_id,voucher_date) values (6,'20230510');
insert into voucher(customer_id,voucher_date) values (5,'20230512');
insert into voucher(customer_id,voucher_date) values (3,'20230512');
insert into voucher(customer_id,voucher_date) values (4,'20230512');


insert into voucher_detail (item_id,voucher_id,qty,total) values (1,1,3,7500);
insert into voucher_detail (item_id,voucher_id,qty,total) values (3,1,2,8000);
insert into voucher_detail (item_id,voucher_id,qty,total) values (5,1,5,6000);

insert into voucher_detail (item_id,voucher_id,qty,total) values (11,2,1,3500);
insert into voucher_detail (item_id,voucher_id,qty,total) values (12,2,2,6400);
insert into voucher_detail (item_id,voucher_id,qty,total) values (13,2,2,2000);

insert into voucher_detail (item_id,voucher_id,qty,total) values (1,3,3,7500);
insert into voucher_detail (item_id,voucher_id,qty,total) values (3,3,2,8000);
insert into voucher_detail (item_id,voucher_id,qty,total) values (5,3,5,6000);

insert into voucher_detail (item_id,voucher_id,qty,total) values (1,4,3,7500);
insert into voucher_detail (item_id,voucher_id,qty,total) values (3,4,2,8000);
insert into voucher_detail (item_id,voucher_id,qty,total) values (2,4,5,11000);

insert into voucher_detail (item_id,voucher_id,qty,total) values (22,5,3,6000);
insert into voucher_detail (item_id,voucher_id,qty,total) values (1,5,2,5000);
insert into voucher_detail (item_id,voucher_id,qty,total) values (30,5,3,6600);

insert into voucher_detail (item_id,voucher_id,qty,total) values (1,6,3,7500);
insert into voucher_detail (item_id,voucher_id,qty,total) values (3,6,2,8000);
insert into voucher_detail (item_id,voucher_id,qty,total) values (5,6,5,6000);

insert into voucher_detail (item_id,voucher_id,qty,total) values (11,7,1,3500);
insert into voucher_detail (item_id,voucher_id,qty,total) values (12,7,2,6400);


insert into voucher_detail (item_id,voucher_id,qty,total) values (1,8,3,7500);
insert into voucher_detail (item_id,voucher_id,qty,total) values (3,8,2,8000);
insert into voucher_detail (item_id,voucher_id,qty,total) values (5,8,5,6000);

insert into voucher_detail (item_id,voucher_id,qty,total) values (1,9,3,7500);

insert into voucher_detail (item_id,voucher_id,qty,total) values (22,10,3,6000);
insert into voucher_detail (item_id,voucher_id,qty,total) values (1,10,2,5000);
insert into voucher_detail (item_id,voucher_id,qty,total) values (30,10,3,6600);



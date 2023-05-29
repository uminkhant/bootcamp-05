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



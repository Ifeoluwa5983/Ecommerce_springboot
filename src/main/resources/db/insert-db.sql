set foreign_key_checks = 0;

truncate table store_customer;
truncate table address;
truncate table store_customer_address_list;
truncate table card;

insert into address(`id`,`country`,`state`,`city`,`street`,`zipcode`)
values(1, "Nigeria","Lagos","Ayobo","3, parakoyi street", "1234"),
(2, "Nigeria","Lagos","Yaba","312, herbert macaulay", "5678");

insert into store_customer(`id`,`contact`,`email`,`fname`,`lname`,`password`)
values(1,"07042441564","ife@gmail.com","Oluwafemi","Ifeoluwa","1fe5883"),
(2,"07098765432","test@gmail.com","Exam","Test","testexam");

insert into store_customer_address_list(`store_customer_id`,`address_list_id`)
values(1, 1),
(1, 2),
(2, 1);

insert into card(`id`,`cardcvv`,`card_name`, `card_number`,`card_type`,`exp`,`store_customer_id`)
values(1,"5678", "My card", "5785876856485","credit", "12-10-2020",1 ),
        (2,"5678", "sweet", "1234567876436","debit", "12-10-2020",null );

set foreign_key_checks = 1;
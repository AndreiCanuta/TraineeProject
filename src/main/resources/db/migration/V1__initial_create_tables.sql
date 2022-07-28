CREATE SCHEMA traineeproject;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SET search_path = traineeproject, pg_catalog;

create sequence traineeproject.hibernate_sequence start with 1 increment by 1;

create table credit_data (
    id int primary key,
    credit_limit int not null,
    product varchar(50) not null,
    credit_period int not null,
    type varchar(50) not null
);

create table customer (
    id uuid DEFAULT public.uuid_generate_v4 (),
	current_credit_data int,
	store_number varchar(50) not null,
	customer_number varchar(50) not null,
	country varchar(50) not null,
	name varchar(250) not null,
	vat varchar(50) not null,
	checkout_check_code varchar(50),
	customer_type varchar(50) not null,
	registration_date date not null,
    primary key (id),
	CONSTRAINT fk_customer FOREIGN KEY(current_credit_data)
		REFERENCES credit_data(id)
);


create table request (
	id int primary key,
	customer_id uuid not null,
	status varchar(50) not null,
	request_data timestamp without time zone not null,
	CONSTRAINT fk_customer FOREIGN KEY(customer_id)
		REFERENCES customer(id)
);

create table request_credit_data (
	id int primary key,
	request_id int not null,
	customer_id uuid not null,
	credit_data_id int not null,
	CONSTRAINT fk_request FOREIGN KEY(request_id)
		REFERENCES request(id),
	CONSTRAINT fk_customer FOREIGN KEY(customer_id)
		REFERENCES customer(id),
	CONSTRAINT fk_credit_data FOREIGN KEY(credit_data_id)
		REFERENCES credit_data(id)
);

DROP DATABASE IF EXISTS storedb;

CREATE DATABASE storedb;

USE storedb;

CREATE TABLE users (
  user_id INT(11) NOT NULL AUTO_INCREMENT,
  email VARCHAR(64) NOT NULL,
  password VARCHAR(32) NOT NULL,
  full_name VARCHAR(64) NOT NULL,
  birthday date null,
  phone varchar(11) null,
  gender boolean null,
  role boolean null,
  PRIMARY KEY (user_id),
  UNIQUE KEY email_UNIQUE (email)
);

INSERT INTO users (user_id, email, password, full_name) 
VALUES 
(1,'giang@java3.com','giang1999','Nguyen Dang Giang');

CREATE TABLE category (
  category_id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  PRIMARY KEY (category_id)
);

CREATE TABLE product (
  product_id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  author VARCHAR(64) NOT NULL,
  description MEDIUMTEXT NULL,
  image nvarchar(255) NULL,
  price FLOAT NOT NULL,
  publish_date DATE NOT NULL,
  last_update_time DATETIME NOT NULL,
  category_id INT(11) NOT NULL,
  PRIMARY KEY (product_id),
  UNIQUE KEY title_UNIQUE (name),
  CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category (category_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE customer (
  customer_id INT(11) NOT NULL AUTO_INCREMENT,
  email VARCHAR(64) NOT NULL,
  firstname VARCHAR(30) NOT NULL,
  lastname VARCHAR(30) NOT NULL,
  address_line1 VARCHAR(128) NOT NULL,
  address_line2 VARCHAR(128) DEFAULT NULL,
  city VARCHAR(32) NOT NULL,
  state VARCHAR(45) NOT NULL,
  country VARCHAR(4) NOT NULL,
  phone VARCHAR(15) NOT NULL,
  zipcode VARCHAR(24) NOT NULL,
  password VARCHAR(16) NOT NULL,
  register_date DATETIME NOT NULL,
  PRIMARY KEY (customer_id),
  UNIQUE KEY email_UNIQUE (email)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


INSERT INTO customer (customer_id, email, firstname, lastname, address_line1, city, state, country, phone, zipcode, password, register_date) 
VALUES 
(1, 'billy.jane@gmail.com', 'Jane', 'Billy', '100 North Ave', 'New York', 'NY', 'US', '123456789', '10001', 'password123', NOW());

CREATE TABLE review (
  review_id INT(11) NOT NULL AUTO_INCREMENT,
  product_id INT(11) NOT NULL,
  customer_id INT(11) NOT NULL,
  rating INT(11) NOT NULL,
  headline VARCHAR(128) NOT NULL,
  comment VARCHAR(500) NOT NULL,
  review_time DATETIME NOT NULL,
  PRIMARY KEY (review_id),
  CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product(product_id) 
    ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

CREATE TABLE product_order (
  order_id int(11) NOT NULL AUTO_INCREMENT,
  customer_id int(11) NOT NULL,
  order_date datetime NOT NULL,
  r_address_line1 varchar(256) NOT NULL,
  r_address_line2 varchar(256) DEFAULT NULL,
  r_firstname varchar(30) NOT NULL,
  r_lastname varchar(30) DEFAULT NULL,
  r_phone varchar(15) NOT NULL,
  r_country varchar(4) DEFAULT NULL,
  r_city varchar(32) DEFAULT NULL,
  r_state varchar(45) DEFAULT NULL,
  r_zipcode varchar(24) DEFAULT NULL,
  payment_method varchar(20) NOT NULL,
  shipping_fee float DEFAULT NULL,
  tax float DEFAULT NULL,
  subtotal float DEFAULT NULL,
  total float NOT NULL,
  status varchar(20) NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY order_id_UNIQUE (`order_id`),
  KEY customer_fk_2_idx (`customer_id`),
  CONSTRAINT `customer_fk_2` FOREIGN KEY (`customer_id`) REFERENCES customer (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

CREATE TABLE order_detail (
  order_id INT(11) NOT NULL,
  product_id INT(11) NOT NULL,
  quantity INT(11) NOT NULL,
  subtotal FLOAT NOT NULL,
  CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES product_order(order_id),
  CONSTRAINT fk_order_product FOREIGN KEY (product_id) REFERENCES product(product_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


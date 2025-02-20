DROP
DATABASE IF EXISTS storedb;

CREATE
DATABASE storedb;

USE
storedb;

CREATE TABLE users
(
    user_id   INT(11) NOT NULL AUTO_INCREMENT,
    email     VARCHAR(64)  NOT NULL,
    password  VARCHAR(255) NOT NULL, -- for hash password
    full_name VARCHAR(64)  NOT NULL,
    birthday  date null,
    phone     varchar(11) null,
    gender    boolean null,
    role      boolean null,
    PRIMARY KEY (user_id),
    UNIQUE KEY email_UNIQUE (email)
);

CREATE TABLE category
(
    category_id INT(11) NOT NULL AUTO_INCREMENT,
    name        VARCHAR(64) NOT NULL,
    PRIMARY KEY (category_id)
);

CREATE TABLE product
(
    product_id       INT(11) NOT NULL AUTO_INCREMENT,
    name             VARCHAR(128) NOT NULL,
    author           VARCHAR(64)  NOT NULL, -- ?
    description      MEDIUMTEXT NULL,
    image            nvarchar(255) NULL,
    price            FLOAT        NOT NULL,
    publish_date     DATE         NOT NULL,
    last_update_time DATETIME     NOT NULL,
    category_id      INT(11) NOT NULL,
    PRIMARY KEY (product_id),
    UNIQUE KEY title_UNIQUE (name),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category (category_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE customer
(
    customer_id   INT(11) NOT NULL AUTO_INCREMENT,
    email         VARCHAR(64)  NOT NULL,
    firstname     VARCHAR(30)  NOT NULL,
    lastname      VARCHAR(30)  NOT NULL,
    address_line1 VARCHAR(128) NOT NULL,
    address_line2 VARCHAR(128) DEFAULT NULL,
    city          VARCHAR(32)  NOT NULL,
    state         VARCHAR(45)  NOT NULL,
    country       VARCHAR(4)   NOT NULL,
    phone         VARCHAR(15)  NOT NULL,
    zipcode       VARCHAR(24)  NOT NULL,
    password      VARCHAR(255) NOT NULL, -- for hash password
    register_date DATETIME     NOT NULL,
    PRIMARY KEY (customer_id),
    UNIQUE KEY email_UNIQUE (email)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


INSERT INTO customer (customer_id, email, firstname, lastname, address_line1, city, state, country, phone, zipcode,
                      password, register_date)

CREATE TABLE review
(
    review_id   INT(11) NOT NULL AUTO_INCREMENT,
    product_id  INT(11) NOT NULL,
    customer_id INT(11) NOT NULL,
    rating      INT(11) NOT NULL,
    headline    VARCHAR(128) NOT NULL,
    comment     VARCHAR(500) NOT NULL,
    review_time DATETIME     NOT NULL,
    PRIMARY KEY (review_id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product (product_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

CREATE TABLE product_order
(
    order_id        int(11) NOT NULL AUTO_INCREMENT,
    customer_id     int(11) NOT NULL,
    order_date      datetime     NOT NULL,
    r_address_line1 varchar(256) NOT NULL,
    r_address_line2 varchar(256) DEFAULT NULL,
    r_firstname     varchar(30)  NOT NULL,
    r_lastname      varchar(30)  DEFAULT NULL,
    r_phone         varchar(15)  NOT NULL,
    r_country       varchar(4)   DEFAULT NULL,
    r_city          varchar(32)  DEFAULT NULL,
    r_state         varchar(45)  DEFAULT NULL,
    r_zipcode       varchar(24)  DEFAULT NULL,
    payment_method  varchar(20)  NOT NULL,
    shipping_fee    float        DEFAULT NULL,
    tax             float        DEFAULT NULL,
    subtotal        float        DEFAULT NULL,
    total           float        NOT NULL,
    status          varchar(20)  NOT NULL,
    PRIMARY KEY (`order_id`),
    UNIQUE KEY order_id_UNIQUE (`order_id`),
    KEY             customer_fk_2_idx (`customer_id`),
    CONSTRAINT `customer_fk_2` FOREIGN KEY (`customer_id`) REFERENCES customer (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

CREATE TABLE order_detail
(
    id         INT(11) primary key auto_increment,
    order_id   INT(11) NOT NULL,
    product_id INT(11) NOT NULL,
    quantity   INT(11) NOT NULL,
    subtotal   FLOAT NOT NULL,
    CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES product_order (order_id),
    CONSTRAINT fk_order_product FOREIGN KEY (product_id) REFERENCES product (product_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Insert data
INSERT INTO users (user_id, email, password, full_name)
VALUES
    (1, 'nguyendanggiang99@gmail.com', 'giang', 'Nguyen Dang Giang'),
    (2, 'hungnplps39152@fpt.edu.vn', 'hung', 'Nguyen Phan Lam Hung'),
    (3, 'havulam1998z@gmail.com', 'lam', 'Ha Vu Lam'),
    (4, 'tai30799@gmail.com', 'tai', 'Nguyen Chi Tai'),
    (5, 'peterdamlinh1215@gmail.com', 'linh', 'Nguyen Dam Hoang Linh'),
    (6, 'haithach.01202@gmail.com', 'thach', 'Nguyen Dung Hai Thach');


INSERT INTO storedb.category (category_id, name) VALUES (1, 'top');
INSERT INTO storedb.category (category_id, name) VALUES (2, 'bottom');
INSERT INTO storedb.category (category_id, name) VALUES (3, 'outerwear');
INSERT INTO storedb.category (category_id, name) VALUES (4, 'accessories');

INSERT INTO product (name, author, description, image, price, publish_date, last_update_time, category_id)
VALUES
-- TOP
('SWE Basic Tee', 'SWE', 'Áo thun cotton 100%, thoáng mát và thoải mái.', 'swe_basic_tee.jpg', 250000, '2024-01-10', NOW(), 1),
('SWE Oversized Tee', 'SWE', 'Áo thun form rộng, phù hợp streetwear.', 'swe_oversized_tee.jpg', 290000, '2024-02-01', NOW(), 1),
('SWE Polo Shirt', 'SWE', 'Áo polo cao cấp, thiết kế đơn giản nhưng tinh tế.', 'swe_polo_shirt.jpg', 320000, '2024-01-20', NOW(), 1),
('SWE Tank Top', 'SWE', 'Áo tank top thể thao, thoáng mát khi vận động.', 'swe_tank_top.jpg', 270000, '2024-01-15', NOW(), 1),
('SWE Crop Top', 'SWE', 'Áo crop top dành cho nữ, chất vải co giãn.', 'swe_crop_top.jpg', 280000, '2024-01-25', NOW(), 1),

-- BOTTOM
('SWE Cargo Pants', 'SWE', 'Quần cargo túi hộp, chất liệu kaki cao cấp.', 'swe_cargo_pants.jpg', 450000, '2024-02-05', NOW(), 2),
('SWE Jogger Pants', 'SWE', 'Quần jogger thoải mái, phù hợp streetwear.', 'swe_jogger_pants.jpg', 420000, '2024-01-30', NOW(), 2),
('SWE Denim Jeans', 'SWE', 'Quần jeans basic, phù hợp nhiều phong cách.', 'swe_denim_jeans.jpg', 500000, '2024-01-12', NOW(), 2),
('SWE Shorts', 'SWE', 'Quần short nam nữ, thích hợp mùa hè.', 'swe_shorts.jpg', 350000, '2024-02-08', NOW(), 2),
('SWE Sweatpants', 'SWE', 'Quần nỉ, phù hợp mặc ở nhà và tập luyện.', 'swe_sweatpants.jpg', 390000, '2024-01-28', NOW(), 2),

-- OUTERWEAR
('SWE Hoodie', 'SWE', 'Hoodie unisex, vải nỉ dày dặn và ấm áp.', 'swe_hoodie.jpg', 550000, '2024-02-10', NOW(), 3),
('SWE Zipper Hoodie', 'SWE', 'Áo khoác nỉ có khóa kéo tiện lợi.', 'swe_zipper_hoodie.jpg', 580000, '2024-02-02', NOW(), 3),
('SWE Bomber Jacket', 'SWE', 'Áo khoác bomber phong cách streetwear.', 'swe_bomber_jacket.jpg', 690000, '2024-01-18', NOW(), 3),
('SWE Varsity Jacket', 'SWE', 'Áo khoác varsity phối màu đẹp.', 'swe_varsity_jacket.jpg', 750000, '2024-01-22', NOW(), 3),
('SWE Windbreaker', 'SWE', 'Áo gió chống nước, thích hợp đi phượt.', 'swe_windbreaker.jpg', 600000, '2024-01-14', NOW(), 3),

-- ACCESSORIES
('SWE Cap', 'SWE', 'Mũ lưỡi trai phong cách streetwear.', 'swe_cap.jpg', 250000, '2024-02-04', NOW(), 4),
('SWE Beanie', 'SWE', 'Mũ len giữ ấm, phong cách tối giản.', 'swe_beanie.jpg', 270000, '2024-01-29', NOW(), 4),
('SWE Tote Bag', 'SWE', 'Túi tote vải canvas, bền bỉ và tiện dụng.', 'swe_tote_bag.jpg', 300000, '2024-01-26', NOW(), 4),
('SWE Backpack', 'SWE', 'Balo rộng rãi, phù hợp đi học và đi làm.', 'swe_backpack.jpg', 550000, '2024-02-09', NOW(), 4),
('SWE Socks', 'SWE', 'Vớ cổ cao chất liệu cotton co giãn.', 'swe_socks.jpg', 120000, '2024-01-19', NOW(), 4),
('SWE Belt', 'SWE', 'Thắt lưng vải, phong cách trẻ trung.', 'swe_belt.jpg', 180000, '2024-02-06', NOW(), 4),
('SWE Crossbody Bag', 'SWE', 'Túi đeo chéo gọn nhẹ, phù hợp streetwear.', 'swe_crossbody_bag.jpg', 320000, '2024-01-17', NOW(), 4),
('SWE Bracelet', 'SWE', 'Vòng tay da cao cấp, phong cách minimal.', 'swe_bracelet.jpg', 200000, '2024-01-23', NOW(), 4);

INSERT INTO customer (email, firstname, lastname, address_line1, address_line2, city, state, country, phone, zipcode, password, register_date)
VALUES
    ('nguyenvana@gmail.com', 'Nguyễn Văn', 'An', '123 Đường Lê Lợi', NULL, 'Hà Nội', 'Hà Nội', 'VN', '0987654321', '100000', 'matkhau123', NOW()),
    ('tranthib@gmail.com', 'Trần Thị', 'Bích', '456 Đường Trần Hưng Đạo', NULL, 'TP. Hồ Chí Minh', 'Hồ Chí Minh', 'VN', '0912345678', '700000', 'matkhau456', NOW()),
    ('phamvanc@gmail.com', 'Phạm Văn', 'Cường', '789 Đường Nguyễn Huệ', 'Chung cư Block A', 'Đà Nẵng', 'Đà Nẵng', 'VN', '0909123456', '550000', 'matkhau789', NOW()),
    ('lethid@gmail.com', 'Lê Thị', 'Duyên', '12 Đường Hoàng Văn Thụ', NULL, 'Hải Phòng', 'Hải Phòng', 'VN', '0968345678', '180000', 'matkhau234', NOW()),
    ('doanquangh@gmail.com', 'Đoàn Quang', 'Hải', '321 Đường Cách Mạng Tháng 8', NULL, 'Cần Thơ', 'Cần Thơ', 'VN', '0937567890', '900000', 'matkhau567', NOW()),
    ('vuquangk@gmail.com', 'Vũ Quang', 'Khang', '567 Đường Nguyễn Trãi', NULL, 'Huế', 'Thừa Thiên Huế', 'VN', '0971234567', '530000', 'matkhau678', NOW()),
    ('dangthimin@gmail.com', 'Đặng Thị', 'Minh', '888 Đường Trường Chinh', NULL, 'Bình Dương', 'Bình Dương', 'VN', '0945671234', '820000', 'matkhau910', NOW()),
    ('nguyenthianh@gmail.com', 'Nguyễn Thị', 'Anh', '999 Đường Lý Thường Kiệt', NULL, 'Nha Trang', 'Khánh Hòa', 'VN', '0956784321', '650000', 'matkhau111', NOW()),
    ('buitienp@gmail.com', 'Bùi Tiến', 'Phát', '111 Đường Phan Đình Phùng', NULL, 'Vũng Tàu', 'Bà Rịa - Vũng Tàu', 'VN', '0923456789', '790000', 'matkhau222', NOW()),
    ('hoangkiml@gmail.com', 'Hoàng Kim', 'Linh', '222 Đường Điện Biên Phủ', NULL, 'Đà Lạt', 'Lâm Đồng', 'VN', '0918765432', '670000', 'matkhau333', NOW());

INSERT INTO review (product_id, customer_id, rating, headline, comment, review_time)
VALUES
    (1, 1, 5, 'Chất liệu tuyệt vời', 'Chiếc áo này rất thoải mái và chất lượng tốt.', NOW()),
    (2, 2, 4, 'Phong cách đẹp', 'Áo polo mặc rất đẹp, nhưng giá hơi cao.', NOW()),
    (3, 3, 5, 'Quá tuyệt!', 'Quần jeans này rất vừa vặn và bền.', NOW()),
    (4, 4, 3, 'Bình thường', 'Quần cargo ổn nhưng hơi rộng hơn mong đợi.', NOW()),
    (5, 5, 5, 'Giữ ấm tốt', 'Áo khoác mùa đông rất ấm áp và đẹp.', NOW()),
    (6, 6, 4, 'Nón chất lượng', 'Nón có chất vải tốt, giá hợp lý.', NOW()),
    (7, 7, 5, 'Hoodie đẹp', 'Mặc hoodie này cảm thấy rất ấm và phong cách.', NOW()),
    (8, 8, 4, 'Quần thể thao', 'Thoải mái khi vận động, vải co giãn tốt.', NOW()),
    (9, 9, 5, 'Mắt kính chất lượng', 'Đeo rất dễ chịu, không gây mỏi mắt.', NOW()),
    (10, 10, 3, 'Dây nịt ổn', 'Thiết kế đẹp nhưng khóa hơi khó mở.', NOW()),
    (11, 1, 4, 'Giày chạy tốt', 'Đế giày bám đường tốt, rất phù hợp để chạy bộ.', NOW()),
    (12, 2, 5, 'Ba lô đẹp', 'Ba lô rộng rãi, đựng được nhiều đồ.', NOW()),
    (13, 3, 5, 'Sneakers thoải mái', 'Đi cả ngày không bị đau chân.', NOW()),
    (14, 4, 4, 'Suit cao cấp', 'Rất vừa vặn và sang trọng.', NOW()),
    (15, 5, 5, 'Smartwatch xịn', 'Chức năng theo dõi sức khỏe rất hữu ích.', NOW());

INSERT INTO product_order (customer_id, order_date, r_address_line1, r_address_line2, r_firstname, r_lastname, r_phone, r_country, r_city, r_state, r_zipcode, payment_method, shipping_fee, tax, subtotal, total, status)
VALUES
    (1, NOW(), '123 Đường Lê Lợi', NULL, 'Nguyễn Văn', 'A', '0987654321', 'VN', 'Hà Nội', 'Hà Nội', '100000', 'COD', 30000, 50000, 600000, 680000, 'Đang xử lý'),
    (2, NOW(), '456 Đường Trần Hưng Đạo', NULL, 'Trần Thị', 'B', '0912345678', 'VN', 'TP. Hồ Chí Minh', 'Hồ Chí Minh', '700000', 'Chuyển khoản', 25000, 45000, 550000, 620000, 'Đã xác nhận'),
    (3, NOW(), '789 Đường Nguyễn Huệ', 'Chung cư Block A', 'Phạm Văn', 'C', '0909123456', 'VN', 'Đà Nẵng', 'Đà Nẵng', '550000', 'COD', 40000, 60000, 720000, 820000, 'Đang giao'),
    (4, NOW(), '12 Đường Hoàng Văn Thụ', NULL, 'Lê Thị', 'D', '0968345678', 'VN', 'Hải Phòng', 'Hải Phòng', '180000', 'Chuyển khoản', 20000, 30000, 500000, 550000, 'Hoàn thành'),
    (5, NOW(), '321 Đường Cách Mạng Tháng 8', NULL, 'Đoàn Quang', 'H', '0937567890', 'VN', 'Cần Thơ', 'Cần Thơ', '900000', 'COD', 35000, 50000, 650000, 735000, 'Đã xác nhận'),
    (6, NOW(), '567 Đường Nguyễn Trãi', NULL, 'Vũ Quang', 'K', '0971234567', 'VN', 'Huế', 'Thừa Thiên Huế', '530000', 'Chuyển khoản', 30000, 45000, 580000, 655000, 'Đang xử lý'),
    (7, NOW(), '888 Đường Trường Chinh', NULL, 'Đặng Thị', 'Minh', '0945671234', 'VN', 'Bình Dương', 'Bình Dương', '820000', 'COD', 32000, 50000, 620000, 702000, 'Đang giao'),
    (8, NOW(), '999 Đường Lý Thường Kiệt', NULL, 'Nguyễn Thị', 'Anh', '0956784321', 'VN', 'Nha Trang', 'Khánh Hòa', '650000', 'Chuyển khoản', 28000, 40000, 540000, 608000, 'Hoàn thành'),
    (9, NOW(), '111 Đường Phan Đình Phùng', NULL, 'Bùi Tiến', 'Phát', '0923456789', 'VN', 'Vũng Tàu', 'Bà Rịa - Vũng Tàu', '790000', 'COD', 26000, 35000, 470000, 531000, 'Đang giao'),
    (10, NOW(), '222 Đường Điện Biên Phủ', NULL, 'Hoàng Kim', 'Linh', '0918765432', 'VN', 'Đà Lạt', 'Lâm Đồng', '670000', 'Chuyển khoản', 30000, 45000, 590000, 665000, 'Hoàn thành')

    INSERT INTO order_detail (order_id, product_id, quantity, subtotal) VALUES
    (1, 1, 2, 400000),
    (1, 5, 1, 200000),
    (2, 3, 1, 300000),
    (2, 7, 2, 250000),
    (3, 2, 3, 450000),
    (3, 6, 1, 270000),
    (4, 8, 2, 400000),
    (4, 10, 1, 100000),
    (5, 4, 1, 350000),
    (5, 9, 2, 300000),
    (6, 11, 1, 300000),
    (6, 13, 1, 280000),
    (7, 12, 2, 400000),
    (7, 15, 1, 220000),
    (8, 14, 1, 320000),
    (8, 16, 1, 220000),
    (9, 17, 1, 260000),
    (9, 18, 2, 270000),
    (10, 19, 2, 400000),
    (10, 20, 1, 190000);

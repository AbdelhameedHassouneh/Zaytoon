-- user tables
DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user (
                         id int NOT NULL AUTO_INCREMENT,
                         first_name varchar(255) NOT NULL,
                         last_name varchar(255) NOT NULL,
                         age int,
                         gender ENUM('MALE', 'FEMALE'),
                         email varchar(255) NOT NULL,
                         phone varchar(10) ,
                         weight double NOT NULL,
                         height double NOT NULL,
                         password varchar(50) NOT NULL,
                         PRIMARY KEY (id),
                         UNIQUE (email)
);
delete from user where id > 0;
INSERT INTO user values (1,'Mahmood','Abu Awwad' , 24, 'MALE','abuawwadmahmood@gmail.com','0569391236',82,182,'123123');
INSERT INTO user values (2,'test','test' , null, 'FEMALE','test@test',null,100,100,'123123');

DROP TABLE IF EXISTS food_item;
CREATE TABLE IF NOT EXISTS food_item (
    id int NOT NULL AUTO_INCREMENT,
    food_section varchar(255) NOT NULL,
    picture_name varchar(255) NOT NULL,
    sub_title varchar(255) NOT NULL,
    quantity varchar(255) NOT NULL,
    food_size varchar(255) NOT NULL,
    side_notes varchar(255) NOT NULL,
    fats varchar(255) NOT NULL,
    carbs varchar(255) NOT NULL,
    calories varchar(255) NOT NULL,
    protein varchar(255) NOT NULL,
    food_item varchar(255) NOT NULL,
    zayton_section varchar(255) NOT NULL,
    PRIMARY KEY (id)
);
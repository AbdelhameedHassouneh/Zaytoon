-- user tables
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
INSERT INTO user values (1,'Mahmood','Abu Awwad' , 24, 'MALE','abuawwadmahmood@gmail.com','0569391236',82,182,'123123');
INSERT INTO user values (2,'test','test' , null, 'FEMALE','test@test',null,100,100,'123123');
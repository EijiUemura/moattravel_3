create table if not exists houses
(
   id integer not null auto_increment primary key,
   name varchar (50) not null,
   image_name varchar (255),
   description varchar (255) not null,
   price integer not null,
   capacity integer not null,
   postal_code varchar (50) not null,
   address varchar (255) not null,
   phone_number varchar (50) not null,
   created_at datetime not null default current_timestamp,
   updated_at datetime not null default current_timestamp on update current_timestamp
);
create table if not exists roles
(
   id integer not null auto_increment primary key,
   name varchar (50) not null
);
create table if not exists users
(
   id integer not null auto_increment primary key,
   name varchar (50) not null,
   furigana varchar (50) not null,
   postal_code varchar (50) not null,
   address varchar (255) not null,
   phone_number varchar (50) not null,
   email varchar (255) not null unique,
   password varchar (255) not null,
   role_id integer not null,
   enabled boolean not null,
   created_at datetime not null default current_timestamp,
   updated_at datetime not null default current_timestamp on update current_timestamp,
   foreign key (role_id) references roles (id)
);
create table if not exists verification_tokens
(
   id integer not null auto_increment primary key,
   user_id integer not null unique,
   token varchar (255) not null,
   created_at datetime not null default current_timestamp,
   updated_at datetime not null default current_timestamp on update current_timestamp,
   foreign key (user_id) references users (id)
);
CREATE TABLE IF NOT EXISTS reservations
(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   house_id INT NOT NULL,
   user_id INT NOT NULL,
   checkin_date DATE NOT NULL,
   checkout_date DATE NOT NULL,
   number_of_people INT NOT NULL,
   amount INT NOT NULL,
   created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   FOREIGN KEY (house_id) REFERENCES houses (id),
   FOREIGN KEY (user_id) REFERENCES users (id)
);
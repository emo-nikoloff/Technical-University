create database news;
use news;

create table users(
	id int auto_increment primary key,
    username varchar(50) not null unique,
    email varchar(100) not null unique,
    password varchar(255) not null,
    role enum('admin', 'editor', 'reader')
);

create table categories(
	id int auto_increment primary key,
    name varchar(100) not null unique
);

create table news(
	id int auto_increment primary key,
    title varchar(255) not null,
    content text not null,
    created_at datetime default current_timestamp,
    category_id int,
    foreign key (category_id) references categories(id) on delete cascade,
    author_id int,
    foreign key (author_id) references users(id) on delete cascade
);

create table images(
	id int auto_increment primary key,
    image_url varchar(255) not null,
    news_id int,
    foreign key (news_id) references news(id) on delete cascade
);

create table videos(
	id int auto_increment primary key,
    video_url varchar(255) not null,
    news_id int,
    foreign key (news_id) references news(id) on delete cascade
);

create table comments(
	id int auto_increment primary key,
    content text not null,
    created_at datetime default current_timestamp,
    users_id int,
    foreign key (users_id) references users(id) on delete cascade,
    news_id int,
    foreign key (news_id) references news(id) on delete cascade
);
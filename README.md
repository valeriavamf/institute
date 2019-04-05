# institute


# Required
java 8

Rest client

mysql

# Data Base

A mysql database is required:
user: root

password: root

run the next comand to create the tables:

create table course_student(course_id VARCHAR(255), student_id int  )engine=innodb;

create table course( code VARCHAR(255), title VARCHAR(255), description VARCHAR(255), primary key (code) )engine=innodb;

create table student( id INT auto_increment, first_name VARCHAR(255), last_name VARCHAR(255), primary key (id) )engine=innodb;


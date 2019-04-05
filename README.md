# institute


# Required
java 8

Rest client

mysql

# Data Base

A mysql database is required:


user: root

password: root

Run the next comand to create the tables:

create table course_student(course_id VARCHAR(255), student_id int  )engine=innodb;

create table course( code VARCHAR(255), title VARCHAR(255), description VARCHAR(255), primary key (code) )engine=innodb;

create table student( id INT auto_increment, first_name VARCHAR(255), last_name VARCHAR(255), primary key (id) )engine=innodb;

OR Run the dump.sql file


# Code

- Programing: Use Spring boot and Spring Data in order to create the rest service and manage the database conection. This framework provides a simple way to solve the problem. With spring create rest service is very simple and using String Data manage the relation from students and courses.

- Strucutre: The project implements MVC. Also the use of interfaces to keep low coupling and high cohesion.

- Test: Create unit test using Junit and Mockito.

# Services

GET all students: /institute/students/all

POST student: /institute/students/
    Request body:
      {
        "lastName": "name2",
        "firstName": "nname1"
      }
      
PUT Student: /institute/students/{id}
    RequestBody:
          {
           "id": 2,
           "lastName": "name2",
           "firstName": "update",
           "courses": [
        	  {
        		    "code": "code1",
        		    "title": "test",
                "description": "desc"
    		    },
    		    {
        		  "code": "code2"
    		    }
        	  ]
      }
      
 DELETE Student:  /institute/students/{id}
 
 GET Students by field: /institute/students/  
 
    Params: id,  firstName, lastName
    
 GET Students by courses fields: /institute/students/courses
 
    Params: code, title, description
    
 
---------------------------------------


GET all courses: /institute/courses/all

POST courses: /institute/courses/
    Request body:
      {
	      "code": "code2",
	      "title": "title1",
	      "description": "desc"
      }
      
PUT courses: /institute/courses/{id}
    RequestBody:
        {
          "code": "code1",
          "title": "title1",
           "description": "updated",
          "students": [
            {
                "id": 2
            },
            {
                "id": 3
            }
          ]
       }
      
 DELETE courses:  /institute/courses/{id}
 
 GET courses: /institute/courses/  
 
     Params: code, title, description
    
 GET courses: /institute/courses/students
 
    Params: id,  firstName, lastName



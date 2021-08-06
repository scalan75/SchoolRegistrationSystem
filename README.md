# School registration system REST API application

This is a java spring-boot REST API application to implement school registration system.

## Install

```
mvn clean install
docker-compose build
```

## Run the app

```
docker-compose up -d
```

## Endpoint

```
http://localhost:8080
```

## Directory structure

```
src - sources
pom.xml - maven project configuration file to build application
Dockerfile - Docker configuration file for application
docker-compose.yml - Docker-compose configuration file to build environment
build.sh - bash script to build application
run.sh - bash script to run environment
test.sh - make test requests to working application
readme.md - this file
target - directory with compiled java sources and result jar file (will be created after build)
```



# REST API(s)

List of REST API endpoints:

1. Students API
   1. Get list of all students: GET http://localhost:8080/api/students
   2. Get student by ID: GET  http://localhost:8080/api/students/{id}
   3. Create new student: POST http://localhost:8080/api/students
   4. Update existing student: PUT http://localhost:8080/api/students/{id}
   5. Delete existing student: DELETE http://localhost:8080/api/students/{id}
2. Cources API
   1. Get list of all courses: GET http://localhost:8080/api/courses
   2. Get course by ID: GET  http://localhost:8080/api/courses/{id}
   3. Create new course: POST http://localhost:8080/api/courses
   4. Update existing course: PUT http://localhost:8080/api/courses/{id}
   5. Delete existing course: DELETE http://localhost:8080/api/courses/{id}
3. Registration API
   1. Register student to course by ID: POST http://localhost:8080/api/students/{id}/register/{id}
4. Reports API
   1. Get list of all student's courses by ID: GET http://localhost:8080/api/reports/student/{id}/courses
   2. Get list of all courses' students by ID: GET http://localhost:8080/api/reports/course/{id}/students
   3. Get list of all students without any courses: GET http://localhost:8080/api/reports/studentsWithoutAnyCourses
   4. Get list of all courses without any students: GET http://localhost:8080/api/reports/coursesWithoutAnyCourses



## Get list of all students

### Request

```
GET http://localhost:8080/api/students
```

### Response

```
[
{
"id": 1,
"firstName": "Alex",
"lastName": "Sco"
},
{
"id": 2,
"firstName": "John",
"lastName": "Doe"
},
{
"id": 3,
"firstName": "Mari",
"lastName": "Lui"
},
{
"id": 4,
"firstName": "Jill",
"lastName": "Sun"
},
{
"id": 5,
"firstName": "Debi",
"lastName": "Fox"
}
]
```



## Add new student

### Request

```
POST http://localhost:8080/api/students
{
"firstName": "Test",
"lastName": "User"
}
```

### Response

```
{
"id": 6,
"firstName": "Test",
"lastName": "User"
}
```



## Update student by ID

### Request

```
PUT http://localhost:8080/api/students/6
{
"firstName": "Test new name",
"lastName": "User new last name"
}
```

### Response

```
{
"id": 6,
"firstName": "Test new name",
"lastName": "User new last name"
}
```



## Delete student by ID

### Request

```
DELETE http://localhost:8080/api/students/6
```

### Response

```
[No content]
```

## 

## Get list of all courses

### Request

```
GET http://localhost:8080/api/courses
```

### Response

```
[
{
"id": 1,
"name": "Java"
},
{
"id": 2,
"name": "PHP"
},
{
"id": 3,
"name": "JS"
},
{
"id": 4,
"name": "Python"
},
{
"id": 5,
"name": ".NET"
},
{
"id": 6,
"name": "Bash"
},
{
"id": 7,
"name": "Linux"
},
{
"id": 8,
"name": "Windows"
},
{
"id": 9,
"name": "MacOS"
},
{
"id": 10,
"name": "Docker"
},
{
"id": 11,
"name": "AWS"
}
]
```



## Add new course

### Request

```
POST http://localhost:8080/api/courses
{
"name": "New course"
}
```

### Response

```
{
"id": 12,
"name": "New course"
}
```



## Update course by ID

### Request

```
PUT http://localhost:8080/api/courses/12
{
"name": "New course name"
}
```

### Response

```
{
"id": 12,
"name": "New course name"
}
```



## Delete course by ID

### Request

```
DELETE http://localhost:8080/api/courses/12
```

### Response

```
[No content]
```



## Register student to course by ID

### Request

```
POST http://localhost:8080/api/students/2/register/6
```

### Response

```
{
    "id": 2,
    "firstName": "John",
    "lastName": "Doe"
}
```

## 

## Report to get list of students registered on course by ID

### Request

```
GET http://localhost:8080/api/reports/course/1/students
```

### Response

```
[
{
"id": 1,
"firstName": "Alex",
"lastName": "Sco"
}
]
```

## 

## Report to get list of courses registered by student by ID

### Request

```
GET http://localhost:8080/api/reports/student/1/courses
```

### Response

```
[
{
"id": 3,
"name": "JS"
},
{
"id": 1,
"name": "Java"
},
{
"id": 2,
"name": "PHP"
}
]
```

## 

## Report to get list of all students without any courses

### Request

```
GET http://localhost:8080/api/reports/studentsWithoutAnyCourses
```

### Response

```
[
{
"id": 2,
"firstName": "John",
"lastName": "Doe"
},
{
"id": 3,
"firstName": "Mari",
"lastName": "Lui"
},
{
"id": 4,
"firstName": "Jill",
"lastName": "Sun"
},
{
"id": 5,
"firstName": "Debi",
"lastName": "Fox"
}
]
```

## 

## Report to get list of all courses without any students

### Request

```
GET http://localhost:8080/api/reports/coursesWithoutAnyStudents
```

### Response

```
[
{
"id": 4,
"name": "Python"
},
{
"id": 5,
"name": ".NET"
},
{
"id": 6,
"name": "Bash"
},
{
"id": 7,
"name": "Linux"
},
{
"id": 8,
"name": "Windows"
},
{
"id": 9,
"name": "MacOS"
},
{
"id": 10,
"name": "Docker"
},
{
"id": 11,
"name": "AWS"
}
]
```


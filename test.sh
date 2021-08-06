#!/bin/sh


curl -i -H "Accept: application/json" -H "Content-Type:application/json" \
-X POST --data '{"name":"TestCourse"}' http://localhost:8080/api/courses

curl -i -H "Accept: application/json" -H "Content-Type:application/json" \
-X POST --data '{"firstName":"Test", "lastName": "User"}' http://localhost:8080/api/students

curl -i -H "Accept: application/json" -H "Content-Type:application/json" \
-X POST --data '' http://localhost:8080/api/students/1/register/1

curl -i -H "Accept: application/json" -H "Content-Type:application/json" \
-X GET http://localhost:8080/api/reports/course/1/students

curl -i -H "Accept: application/json" -H "Content-Type:application/json" \
-X GET http://localhost:8080/api/reports/student/1/courses

curl -i -H "Accept: application/json" -H "Content-Type:application/json" \
-X GET http://localhost:8080/api/reports/studentsWithoutAnyCourses

curl -i -H "Accept: application/json" -H "Content-Type:application/json" \
-X GET http://localhost:8080/api/reports/coursesWithoutAnyStudents

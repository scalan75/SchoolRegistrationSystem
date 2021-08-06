package com.scalan.schoolRegistrationSystem.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scalan.schoolRegistrationSystem.model.Student;

@Transactional
public interface StudentsDao extends JpaRepository<Student, Long> {

}

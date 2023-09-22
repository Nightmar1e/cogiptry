package admin_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import admin_user.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}

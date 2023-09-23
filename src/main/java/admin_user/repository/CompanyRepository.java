package admin_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import admin_user.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}

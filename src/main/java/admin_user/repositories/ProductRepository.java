package admin_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import admin_user.model.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{

}

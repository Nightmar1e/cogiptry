package admin_user.service;

import admin_user.model.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Products> getAllProducts();

    Products saveProduct(Products product);

    Products getProductById(Long id);

    Products updateProduct(Products product);

    void deleteProductById(Long id);
}

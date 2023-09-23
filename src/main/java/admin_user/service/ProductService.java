package admin_user.service;

import admin_user.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Product saveProduct(Product product);

    Product getProductById(Long id);

    Product updateProduct(Product product);

    void deleteProductById(Long id);
}

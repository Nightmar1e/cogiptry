package admin_user.controller;

import admin_user.model.Product;
import admin_user.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin-page")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("product", products);
        return "admin";
    }

    @GetMapping("/new")
    public String createProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add";
    }

    @PostMapping("/save_products")
    public String saveProducts(@ModelAttribute Product product, HttpSession session) {
        productService.saveProduct(product);
        return "redirect:/admin-page/new";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateProduct(@PathVariable Long id,
                                @ModelAttribute("product") Product product,
                                Model model) {

        Product existingProduct = productService.getProductById(id);
        existingProduct.setId(id);
        existingProduct.setName(product.getName());
        existingProduct.setNumber(product.getNumber());
        existingProduct.setDate(product.getDate());
        existingProduct.setCompany(product.getCompany());
        existingProduct.setContact(product.getContact());

        productService.updateProduct(existingProduct);
        return "redirect:/admin-page";
    }

    @GetMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/admin-page";
    }
}

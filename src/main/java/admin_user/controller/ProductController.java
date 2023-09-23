package admin_user.controller;

import admin_user.model.Product;
import admin_user.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin-page")
public class ProductController {

    @Autowired
    private ProductRepository productService;

    @GetMapping("/")
    public String home(Model m) {
        List<Product> list = productService.findAll(); m.addAttribute("all_products",
                list);
        return "admin";
    }

    @GetMapping("/load_form")
    public String loadForm(Model model) {
        return "add";
    }

    @GetMapping("/edit_form/{id}")
    public String editForm(@PathVariable(value = "id") long id, Model model) {
        Optional<Product> product = productService.findById(id);
        Product pro = product.orElse(new Product()); // Handle not-found case gracefully
        model.addAttribute("product", pro);
        return "edit"; // Return the view name for the product edit form
    }

    @PostMapping("/save_products")
    public String saveProducts(@ModelAttribute Product product, HttpSession session) {
        productService.save(product);
//        session.setAttribute("msg", "Product Added Successfully..");
        return "redirect:/admin-page/load_form";
    }

    @PostMapping("/update_products")
    public String updateProducts(@ModelAttribute Product product, HttpSession session) {
        productService.save(product);
//        session.setAttribute("msg", "Product Update Successfully..");
        return "redirect:/admin-page";
    }

    @GetMapping("/delete/{id}")
    public String deleteProducts(@PathVariable(value = "id") long id, HttpSession session) {
        productService.deleteById(id);
//        session.setAttribute("msg", "Product Delete Successfully..");
        return "redirect:/admin-page";
    }
}

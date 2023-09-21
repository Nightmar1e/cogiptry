package admin_user.controller;

import admin_user.model.Products;
import admin_user.repositories.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

//    @GetMapping("/")
//    public String home(Model m) {
//        List<Products> list = productService.findAll(); m.addAttribute("all_products",
//                list);
//        return "admin";
//    }

    @GetMapping("/load_form")
    public String loadForm(Model model) {
        return "add";
    }

    @GetMapping("/edit_form/{id}")
    public String editForm(@PathVariable(value = "id") long id, Model model) {
        Optional<Products> product = productService.findById(id);
        Products pro = product.orElse(new Products()); // Handle not-found case gracefully
        model.addAttribute("product", pro);
        return "edit"; // Return the view name for the product edit form
    }

    @PostMapping("/save_products")
    public String saveProducts(@ModelAttribute Products products, HttpSession session) {
        productService.save(products);
        session.setAttribute("msg", "Product Added Successfully..");
        return "redirect:admin-page/load_form";
    }

    @PostMapping("/update_products")
    public String updateProducts(@ModelAttribute Products products, HttpSession session) {
        productService.save(products);
        session.setAttribute("msg", "Product Update Successfully..");
        return "redirect:admin-page/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProducts(@PathVariable(value = "id") long id, HttpSession session) {
        productService.deleteById(id);
        session.setAttribute("msg", "Product Delete Successfully..");
        return "admin";
    }
}

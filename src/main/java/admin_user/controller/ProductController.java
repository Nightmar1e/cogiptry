package admin_user.controller;

import admin_user.model.Products;
import admin_user.model.User;
import admin_user.repository.ProductRepository;
import admin_user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin-page")
public class ProductController {

    @Autowired
    private ProductRepository productService;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
//    public String home(Model m) {
//        List<Products> list = productService.findAll(); m.addAttribute("all_products",
//                list);
//        return "admin";
//    }
    public String adminPage(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        List<Products> allProducts = productService.findAll();
        model.addAttribute("all_products", allProducts);

        return "admin";
    }

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
    public String saveProducts(@ModelAttribute Products products, Principal principal) {
        String userEmail = principal.getName(); // Assuming the email is used as the username
        User user = userRepository.findByEmail(userEmail);

        products.setUser(user);
        products.setUserEmail(userEmail);
        products.setUserName(user.getFullname()); // Set the user's full name

        productService.save(products);

        return "redirect:/admin-page/load_form";
    }



    @PostMapping("/update_products")
    public String updateProducts(@ModelAttribute Products products, HttpSession session) {
        productService.save(products);
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

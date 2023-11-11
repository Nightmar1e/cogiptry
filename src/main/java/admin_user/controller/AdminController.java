package admin_user.controller;

import admin_user.model.Products;
import admin_user.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/v1")
public class AdminController {

    @Autowired
    private ProductRepository productService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().iterator().next().getAuthority();

        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        model.addAttribute("userRole", role);
        model.addAttribute("user", userDetails);

        List<Products> allProducts = productService.findAll();
        model.addAttribute("all_products", allProducts);

        return "dashboard";
    }

    @GetMapping("/dashboard/admin/load_form")
    public String loadForm(Model model) {
        return "add";
    }

    @GetMapping("/dashboard/admin/edit_form/{id}")
    public String editForm(@PathVariable(value = "id") long id, Model model) {
        Optional<Products> product = productService.findById(id);
        Products pro = product.orElse(new Products());
        model.addAttribute("product", pro);
        return "edit";
    }

    @PostMapping("/dashboard/admin/save_products")
    public String saveProducts(@ModelAttribute Products products) {
        productService.save(products);
        return "redirect:/v1/dashboard/admin/load_form";
    }

    @PostMapping("/dashboard/admin/update_products")
    public String updateProducts(@ModelAttribute Products products) {
        productService.save(products);
        return "redirect:/v1/dashboard/admin";
    }

    @GetMapping("/dashboard/admin/delete/{id}")
    public String deleteProducts(@PathVariable(value = "id") long id) {
        productService.deleteById(id);
        return "redirect:/v1/dashboard/admin";
    }
}

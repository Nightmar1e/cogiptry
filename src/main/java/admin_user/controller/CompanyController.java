package admin_user.controller;



import admin_user.model.Company;
import admin_user.service.CompanyService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/v1/dashboard")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        super();
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public String listCompanies(Model model, Authentication authentication) {
        String role = authentication.getAuthorities().iterator().next().getAuthority();
        model.addAttribute("userRole", role);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("user", userDetails);

        model.addAttribute("companies", companyService.getAllCompanies());
        return "companies";
    }


    @GetMapping("/companies/new")
    public String createCompanyForm(Model model) {

        Company company = new Company();
        model.addAttribute("company", company);
        return "add_company";

    }

    @PostMapping("/companies")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);
        return "redirect:/v1/dashboard/companies";
    }

    @GetMapping("/companies/edit/{id}")
    public String editCompanyForm(@PathVariable Long id, Model model) {
        model.addAttribute("company", companyService.getCompanyById(id));
        return "edit_company";
    }

    @PostMapping("/companies/{id}")
    public String updateCompany(@PathVariable Long id,
                                @ModelAttribute("company") Company company,
                                Model model) {

        Company existingCompany = companyService.getCompanyById(id);
        existingCompany.setId(id);
        existingCompany.setFirstName(company.getFirstName());
        existingCompany.setLastName(company.getLastName());
        existingCompany.setEmail(company.getEmail());

        companyService.updateCompany(existingCompany);
        return "redirect:/v1/dashboard/companies";
    }


    @GetMapping("/companies/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return "redirect:/v1/dashboard/companies";
    }

}

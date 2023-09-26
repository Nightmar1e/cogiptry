package admin_user.controller;



import admin_user.model.Company;
import admin_user.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin-page")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        super();
        this.companyService = companyService;
    }

    // handler method to handle list companies and return mode and view
    @GetMapping("/companies")
    public String listCompanies(Model model) {
        model.addAttribute("companies", companyService.getAllCompanies());
        return "companies";
    }

    @GetMapping("/companies/new")
    public String createCompanyForm(Model model) {

        // create company object to hold company form data
        Company company = new Company();
        model.addAttribute("company", company);
        return "add_company";

    }

    @PostMapping("/companies")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);
        return "redirect:/admin-page/companies";
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

        // get company from database by id
        Company existingCompany = companyService.getCompanyById(id);
        existingCompany.setId(id);
        existingCompany.setFirstName(company.getFirstName());
        existingCompany.setLastName(company.getLastName());
        existingCompany.setEmail(company.getEmail());
        existingCompany.setProducts(company.getProducts());

        // save updated company object
        companyService.updateCompany(existingCompany);
        return "redirect:/admin-page/companies";
    }

    // handler method to handle delete stcompanyudent request

    @GetMapping("/companies/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return "redirect:/admin-page/companies";
    }

}

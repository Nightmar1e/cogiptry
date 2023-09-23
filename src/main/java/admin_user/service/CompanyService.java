package admin_user.service;

import java.util.List;

import admin_user.model.Company;

public interface CompanyService {
    List<Company> getAllCompanies();

    Company saveCompany(Company company);

    Company getCompanyById(Long id);

    Company updateCompany(Company company);

    void deleteCompanyById(Long id);
}

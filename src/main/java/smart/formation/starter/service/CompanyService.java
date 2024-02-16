package smart.formation.starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smart.formation.starter.dao.CompanyRepository;
import smart.formation.starter.entity.Company;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company createCompany(Company company){
        return companyRepository.save(company);
    } 
}
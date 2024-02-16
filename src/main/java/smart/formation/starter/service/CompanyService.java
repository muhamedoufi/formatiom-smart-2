package smart.formation.starter.service;

import java.util.Optional;

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

    public Company updateCompany(Company company, Long id){
        Optional<Company> optionalComapny = companyRepository.findById(id);
        if(optionalComapny.isPresent()){
            var newCompany = optionalComapny.get();
            newCompany.setName(company.getName());
            newCompany.setPhone(company.getPhone());
            newCompany.setMail(company.getMail());

            return companyRepository.save(newCompany);
        }

        return null;

    } 
}
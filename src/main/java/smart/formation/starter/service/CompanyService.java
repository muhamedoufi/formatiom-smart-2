package smart.formation.starter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import smart.formation.starter.dao.CompanyRepository;
import smart.formation.starter.entity.Company;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public ResponseEntity<Object> createCompany(Company company){
        // return companyRepository.save(company);
        try {
            return ResponseEntity.ok().body(companyRepository.save(company));
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();

        }
    } 

    public ResponseEntity<Object> updateCompany(Company company, Long id){
        Optional<Company> optionalComapny = companyRepository.findById(id);
        if(optionalComapny.isPresent()){
            var newCompany = optionalComapny.get();
            newCompany.setName(company.getName());
            newCompany.setPhone(company.getPhone());
            newCompany.setMail(company.getMail());

            return ResponseEntity.ok().body(companyRepository.save(newCompany));
        }
        else{
            return ResponseEntity.notFound().build();

        }


    } 


    public ResponseEntity<Object> getCompanies(){
        var companies = companyRepository.findAll();

        return ResponseEntity.ok().body(companies);
    }

}
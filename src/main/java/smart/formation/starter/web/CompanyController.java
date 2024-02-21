package smart.formation.starter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smart.formation.starter.entity.Company;
import smart.formation.starter.service.CompanyService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService service;
    
    @PostMapping("/create")
    public ResponseEntity<Object> createCompany(@RequestBody Company company){
            return service.createCompany(company);

            // return ResponseEntity.ok().build();

            // return ResponseEntity.internalServerError().build();
        

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCompany(@RequestBody Company company, @PathVariable Long id){
        try {

            service.updateCompany(company, id);

            return ResponseEntity.ok().build();
        } catch (Exception e) {

            return ResponseEntity.internalServerError().build();
        }

    }


    @GetMapping
    public ResponseEntity<Object> getCompanies(){
        var companies = service.getCompanies();
        return ResponseEntity.ok().body(companies);
    }
}

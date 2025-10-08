package com.embarkx.firstjobapp.company;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
        return new ResponseEntity<>(companyService.getAllCompany() , HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,
                                                @RequestBody Company company){
        companyService.updateCompany(company , id);
        return new ResponseEntity<>("Job Updated Successfully" , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Added Successfully" , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean isDeleted = companyService.deleteCompanyById(id);
        if(isDeleted){
            return new ResponseEntity<>("Successfully Deleted" , HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Failed Detetion" , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long id){
        Company company = companyService.getCompanyById(id);
        if(company != null){
            return new ResponseEntity<>(company , HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}



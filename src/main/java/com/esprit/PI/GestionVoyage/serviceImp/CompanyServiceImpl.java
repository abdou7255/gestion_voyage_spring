package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Company;
import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.repository.CompanyRepository;
import com.esprit.PI.GestionVoyage.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Object create(Company entity) {
        return companyRepository.save(entity);
    }

    @Override
    public Object update(Long id, Company entity) {
        try {

            entity.setIdCompany(id);
            return companyRepository.save(entity);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        companyRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Page<Company> getAll(Pageable pageable) {
        Page<Company> zonePage = companyRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());

    }

    @Override
    public Company findCompanyByEmail(String email) {
        Company company = companyRepository.findCompanyByEmail(email);
        return company;
    }

    @Override
    public Company findCompanyByEmailAndPassword(String email, String password) {

        Company company = companyRepository.findCompanyByEmailAndPassword(email,password);
        return company;
    }
}

package com.code.service.impl;


import com.code.model.entity.Company;
import com.code.repository.CompanyRepository;
import com.code.service.AdminCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service

public class AdminCompanyServiceImpl implements AdminCompanyService {
    private final CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Page<Company> paginate(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }
    @Transactional(readOnly = true)
    @Override
    public Company findById(Integer id) {
        return companyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Company not found"));
    }

    @Transactional
    @Override
    public Company create(Company company) {
        company.setCreatedAt(LocalDateTime.now());
        return companyRepository.save(company);
    }
    @Transactional
    @Override
    public Company update(Integer id, Company updatedCompany) {
        Company companyFromDb = findById(id);
        companyFromDb.setCompanyName(updatedCompany.getCompanyName());
        companyFromDb.setDescription(updatedCompany.getDescription());
        companyFromDb.setEmail(updatedCompany.getEmail());
        companyFromDb.setPhone(updatedCompany.getPhone());
        companyFromDb.setUpdatedAt(LocalDateTime.now());
        return companyRepository.save(companyFromDb);
    }
    @Transactional
    @Override
    public void delete(Integer id) {
        Company company = findById(id);
        companyRepository.delete(company);
    }
}

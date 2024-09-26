package com.code.service;

import com.code.model.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminCompanyService {
    List<Company> getAll();
    Page<Company> paginate(Pageable pageable);
    Company findById(Integer id);
    Company create(Company company);
    Company update(Integer id, Company updatedCompany);
    void delete(Integer id);
}

package com.code.service.impl;

import com.code.model.entity.Category;
import com.code.model.entity.Company;
import com.code.model.entity.Job;
import com.code.repository.CategoryRepository;
import com.code.repository.CompanyRepository;
import com.code.repository.JobRepository;
import com.code.service.AdminJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service

public class AdminJobServiceImpl implements AdminJobService {
    private final JobRepository jobRepository;
    private final CategoryRepository categoryRepository;
    private final CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Page<Job> paginate(Pageable pageable) {
         return jobRepository.findAll(pageable);
    }
    @Transactional
    @Override
    public Job findById(Integer id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
    }

    @Override
    public Job create(Job job) {
        Category category = categoryRepository.findById(job.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + job.getCategory().getId()));
        Company company = companyRepository.findById(job.getCompany().getId())
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + job.getCompany().getId()));

        job.setCompany(company);
        job.setCategory(category);
        job.setCreatedAt(LocalDateTime.now());

        return jobRepository.save(job);
    }

    @Override
    public Job update(Integer id, Job updatedJob) {
        Job jobFromDb = findById(id);

        Category category = categoryRepository.findById(updatedJob.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + updatedJob.getCategory().getId()));
        Company company = companyRepository.findById(updatedJob.getCompany().getId())
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + updatedJob.getCompany().getId()));

        jobFromDb.setTitle(updatedJob.getTitle());
        jobFromDb.setDescription(updatedJob.getDescription());
        jobFromDb.setLocation(updatedJob.getLocation());
        jobFromDb.setJobType(updatedJob.getJobType());
        jobFromDb.setCategory(category);
        jobFromDb.setCompany(company);
        jobFromDb.setCreatedAt(LocalDateTime.now());

        return jobRepository.save(jobFromDb);
    }

    @Override
    public void delete(Integer id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
        jobRepository.delete(job);
    }
}

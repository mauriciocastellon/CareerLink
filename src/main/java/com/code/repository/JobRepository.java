package com.code.repository;

import com.code.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository  extends JpaRepository<Job, Integer> {

}

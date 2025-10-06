package com.embarkx.firstjobapp.Job.JobServiceImpl;

import com.embarkx.firstjobapp.Job.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}

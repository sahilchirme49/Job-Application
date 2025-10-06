package com.embarkx.firstjobapp.Job;

import java.util.List;


public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(long id);
    boolean deleteJobById(Long id);
    boolean updateJob(Long id, Job updatedJob);
}

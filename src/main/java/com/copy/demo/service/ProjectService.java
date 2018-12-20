package com.copy.demo.service;

import com.copy.demo.repository.FactorRepository;
import com.copy.demo.repository.MethodRepository;
import com.copy.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private FactorRepository factorRepository;

    @Autowired
    private MethodRepository methodRepository;
}

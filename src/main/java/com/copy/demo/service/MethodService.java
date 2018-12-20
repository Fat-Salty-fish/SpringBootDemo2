package com.copy.demo.service;

import com.copy.demo.repository.MethodRepository;
import com.copy.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MethodService {

    @Autowired
    private MethodRepository methodRepository;

    @Autowired
    private ProjectRepository projectRepository;
}

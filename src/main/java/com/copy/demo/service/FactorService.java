package com.copy.demo.service;

import com.copy.demo.entity.AnalyzeFactor;
import com.copy.demo.repository.FactorRepository;
import com.copy.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FactorService {

    @Autowired
    private FactorRepository factorRepository;

    @Autowired
    private ProjectRepository projectRepository;

    //增加一条因子
    public AnalyzeFactor save(AnalyzeFactor factor)
    {
        return null;
    }

    //查询因子


}

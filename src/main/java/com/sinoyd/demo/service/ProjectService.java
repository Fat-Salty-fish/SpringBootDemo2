package com.sinoyd.demo.service;

import com.sinoyd.demo.entity.AnalyzeFactor;
import com.sinoyd.demo.entity.AnalyzeMethod;
import com.sinoyd.demo.entity.AnalyzeProject;
import com.sinoyd.demo.repository.FactorRepository;
import com.sinoyd.demo.repository.MethodRepository;
import com.sinoyd.demo.repository.ProjectRepository;
import com.sinoyd.frame.base.repository.CommonRepository;
import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private FactorRepository factorRepository;

    @Autowired
    private MethodRepository methodRepository;

    @Autowired
    private CommonRepository commonRepository;

    //保存一条分析项目  如果对应的因子factor和方法method不存在 则需要添加
    public AnalyzeProject save(AnalyzeProject project)
    {
        Integer factorId = project.getFactorId();
        Integer methodId = project.getMethodId();
        if(factorRepository.findOne(factorId)==null)
        {
//            AnalyzeFactor factor = new AnalyzeFactor();
//            factorId = factorRepository.save(factor).getId();
//            project.setFactorId(factorId);
        }
        else if(methodRepository.findOne(methodId)==null)
        {
            AnalyzeMethod method = new AnalyzeMethod();
            methodId = methodRepository.save(method).getId();
            project.setMethodId(methodId);
        }
        return projectRepository.save(project);
    }

    //查询一条分析项目
    public AnalyzeProject getOne(Integer id)
    {
        return projectRepository.findOne(id);
    }

    //分页查询多条分析项目
    public void getByPage(PageBean pageBean, BaseCriteria analyzeProjectCriteria)
    {
        pageBean.setEntityName("AnalyzeProject a");
        pageBean.setSelect("select a");
        commonRepository.findByPage(pageBean,analyzeProjectCriteria);
    }

    //更新一条分析项目
    @Transactional
    public AnalyzeProject update(AnalyzeProject project)
    {
        return commonRepository.merge(project);
    }

    //删除分析项目
    @Transactional
    public Integer delete(Collection<Integer> ids)
    {
        return projectRepository.deleteAllByIdIn(ids);
    }

}

package com.sinoyd.demo.service;

import com.sinoyd.demo.entity.AnalyzeMethod;

import com.sinoyd.demo.entity.AnalyzeProject;
import com.sinoyd.demo.repository.MethodRepository;
import com.sinoyd.demo.repository.ProjectRepository;
import com.sinoyd.frame.base.repository.CommonRepository;
import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class MethodService {

    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private MethodRepository methodRepository;

    @Autowired
    private ProjectRepository projectRepository;

    //增加一条方法
    public AnalyzeMethod save(AnalyzeMethod method)
    {
        return methodRepository.save(method);
    }

    //获取一条方法
    public AnalyzeMethod getOne(Integer id)
    {
        return methodRepository.findOne(id);
    }


    //分页查询多条方法
    public void getByPage(PageBean pageBean, BaseCriteria analyzeMethodCriteria)
    {
        pageBean.setEntityName("AnalyzeMethod a");
        pageBean.setSelect("select a");
        commonRepository.findByPage(pageBean,analyzeMethodCriteria);
    }

    //更新一条方法
    @Transactional
    public AnalyzeMethod update(AnalyzeMethod method)
    {
        return commonRepository.merge(method);
    }

    //安全删除
    @Transactional
    public Integer safelyDelete(Collection<Integer> ids )
    {
        List<AnalyzeProject> analyzeProjects = projectRepository.findByFactorIdIn(ids);

        if (analyzeProjects.size() > 0) {
            throw new NullPointerException("因子已配置相关项目！！！");
        }

        return methodRepository.fakeDelete(ids);
    }
}

package com.sinoyd.demo.service;

import com.sinoyd.demo.entity.AnalyzeFactor;
import com.sinoyd.demo.entity.AnalyzeProject;
import com.sinoyd.demo.repository.FactorRepository;
import com.sinoyd.demo.repository.ProjectRepository;
import com.sinoyd.frame.base.repository.CommonRepository;
import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class FactorService {

    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private FactorRepository factorRepository;

    @Autowired
    private ProjectRepository projectRepository;

    //增加一条因子
    public AnalyzeFactor save(AnalyzeFactor factor)
    {
        return factorRepository.save(factor);
    }

    //通过一个id查询一条因子
    public AnalyzeFactor getOne(Integer id)
    {
        return factorRepository.findOne(id);
    }

    public AnalyzeFactor getOneByName(String name )
    {
        return factorRepository.findByFactorName(name);
    }

    //分页查询多条因子
    public void getByPage(PageBean pageBean, BaseCriteria analyzeFactorCriteria)
    {
        pageBean.setEntityName("AnalyzeFactor a");
        pageBean.setSelect("select a");
        commonRepository.findByPage(pageBean,analyzeFactorCriteria);
    }

    @Transactional//更新因子信息              更新因子需要开启事务
    public AnalyzeFactor update(AnalyzeFactor factor)
    {
        return commonRepository.merge(factor);
    }

    @Transactional//安全删除                  删除因子需要开启事务
    public Integer safelyDelete(Collection<Integer> ids )
    {
        List<AnalyzeProject> analyzeProjects = projectRepository.findByFactorIdIn(ids);

        if (analyzeProjects.size() > 0) {
            throw new NullPointerException("因子已配置相关项目！！！");
        }

        return factorRepository.fakeDelete(ids);
    }
}

package com.copy.demo.service;

import com.copy.demo.entity.AnalyzeFactor;
import com.copy.demo.repository.FactorRepository;
import com.copy.demo.repository.ProjectRepository;
import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

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

    //通过一个id查询一条因子
    public AnalyzeFactor getOne(Integer id)
    {
        return  null;
    }

    //分页查询多条因子
    public Set<AnalyzeFactor> getByPage(PageBean pageBean, BaseCriteria analyzeItemCriteria)
    {
        return null;
    }

    //更新因子信息
    public Integer update(AnalyzeFactor factor)
    {
        return null;
    }

    //删除因子信息
    public Integer delete(Integer id )
    {
        return null;
    }


}

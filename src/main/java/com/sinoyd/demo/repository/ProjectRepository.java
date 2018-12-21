package com.sinoyd.demo.repository;


import com.sinoyd.demo.entity.AnalyzeProject;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ProjectRepository extends CrudRepository<AnalyzeProject,Integer> {

    List<AnalyzeProject> findByFactorIdIn(Collection<Integer> factorIds);

    List<AnalyzeProject> findByMethodId(Integer methodId);

    Integer deleteAllByIdIn(Collection<Integer> ids);


}

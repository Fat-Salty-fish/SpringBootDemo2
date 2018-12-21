package com.sinoyd.demo.repository;


import com.sinoyd.demo.entity.AnalyzeMethod;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface MethodRepository extends CrudRepository<AnalyzeMethod,Integer> {

    @Modifying
    @Query("update AnalyzeMethod a set a.isDeleted = 1 where a.id in :ids")
    Integer fakeDelete(@Param("id") Collection<Integer> ids);
}

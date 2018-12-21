package com.sinoyd.demo.repository;

import com.sinoyd.demo.entity.AnalyzeFactor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface FactorRepository extends CrudRepository<AnalyzeFactor,Integer> {

    @Modifying
    @Query("update AnalyzeFactor a set a.isDeleted = 1 where a.id in :ids")
    Integer fakeDelete(@Param("ids") Collection<Integer> ids);

    AnalyzeFactor findByFactorName(String name);
}

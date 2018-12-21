package com.sinoyd.demo.controller;


import com.sinoyd.demo.criteria.AnalyzeFactorCriteria;
import com.sinoyd.demo.entity.AnalyzeFactor;
import com.sinoyd.demo.service.FactorService;
import com.sinoyd.frame.base.controller.BaseController;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/factor")
public class FactorController extends BaseController {

    @Autowired
    private FactorService factorService;

    @GetMapping("/{id}")
    public Object getOne(@PathVariable("id") Integer id)
    {
        return factorService.getOne(id);
    }

//    @GetMapping("")
//    public Object getOne(@RequestParam("factorName") String name)
//    {
//        return factorService.getOneByName(name);
//    }



    @GetMapping("")
    public Object findByPage(AnalyzeFactorCriteria criteria)
    {
        PageBean pageBean = super.getPageBean();
        factorService.getByPage(pageBean,criteria);
        return super.setJsonPaginationMap(pageBean);
    }

    @PostMapping("")
    public Object create(@RequestBody AnalyzeFactor factor)
    {
        return factorService.save(factor);
    }

    @PutMapping("")
    public Object update(@RequestBody AnalyzeFactor factor)
    {
        return factorService.update(factor);
    }

    @DeleteMapping("")
    public Object delete(@RequestBody  Collection<Integer> ids)
    {
        return factorService.safelyDelete(ids);
    }

}

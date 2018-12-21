package com.sinoyd.demo.controller;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.sinoyd.demo.criteria.AnalyzeMethodCriteria;
import com.sinoyd.demo.entity.AnalyzeMethod;
import com.sinoyd.demo.service.MethodService;
import com.sinoyd.frame.base.controller.BaseController;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/method")
public class MethodController extends BaseController {

    @Autowired
    private MethodService methodService;

    @GetMapping("/{id}")
    public Object getOne(@PathVariable("id") Integer id)
    {
        return methodService.getOne(id);
    }

    @GetMapping("")
    public Object getByPage(AnalyzeMethodCriteria criteria)
    {
        PageBean pageBean = super.getPageBean();
        methodService.getByPage(pageBean,criteria);
        return super.setJsonPaginationMap(pageBean);
    }

    @PostMapping("")
    public Object create(@RequestBody  AnalyzeMethod method)
    {
        return methodService.save(method);
    }

    @PutMapping("")
    public Object update(@RequestBody AnalyzeMethod method)
    {
        return methodService.update(method);
    }

    @DeleteMapping("")
    public Object delete(@RequestBody Collection<Integer> ids)
    {
        return methodService.safelyDelete(ids);
    }
}

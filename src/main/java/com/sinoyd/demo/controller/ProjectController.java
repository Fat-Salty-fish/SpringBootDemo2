package com.sinoyd.demo.controller;



import com.sinoyd.demo.criteria.AnalyzeProjectCriteria;
import com.sinoyd.demo.entity.AnalyzeProject;
import com.sinoyd.demo.service.ProjectService;
import com.sinoyd.frame.base.controller.BaseController;
import com.sinoyd.frame.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;



@RestController
@RequestMapping("/project")
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Integer id)
    {
        return projectService.getOne(id);
    }

    @GetMapping("")
    public Object findByPage(AnalyzeProjectCriteria criteria)
    {
        PageBean pageBean = super.getPageBean();
        projectService.getByPage(pageBean,criteria);
        return super.setJsonPaginationMap(pageBean);
    }

    @PostMapping("")
    public Object create(@RequestBody AnalyzeProject project)
    {
        return projectService.save(project);
    }

    @PutMapping("")
    public Object update(@RequestBody AnalyzeProject project)
    {
        return projectService.update(project);
    }

    @DeleteMapping("")
    public Object delete(@RequestBody Collection<Integer> ids)
    {
        return projectService.delete(ids);
    }


}

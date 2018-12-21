package com.sinoyd.demo.entity;


import com.sinoyd.frame.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "table_method")
@Setter
@Getter
public class AnalyzeMethod implements BaseEntity
{
    @Id
    @GeneratedValue
    private Integer id;   //方法id

    private String methodName;  //方法名字

    private String methodCode; //方法编号

    private String standardName; //标准名

    private Boolean isDeleted = false ; //标注是否删除

    @Column(length = 4000)
    private String remark ;     //方法有关备注
}

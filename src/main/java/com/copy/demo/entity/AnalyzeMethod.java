package com.copy.demo.entity;


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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;   //方法id

    @Column
    private String methodName;  //方法名字

    @Column
    private String methodCode; //方法编号

    @Column
    private String standardName; //标准名

    @Column
    private Boolean isDeleted = false ; //标注是否删除

    @Column(length = 4000)
    private String remark ;     //方法有关备注
}

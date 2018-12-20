package com.copy.demo.entity;


import com.sinoyd.frame.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "table_analyze")
public class AnalyzeProject implements BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; //项目id 主键

    @Column
    private Integer factorId ;  //项目有关因子id 外键

    @Column
    private Integer methodId;   //项目所用方法id 外键

    @Column
    private String itemCode ;   //项目编码

    @Column
    private String itemName;    //项目名称

    @Column(length = 4000)
    private String remark;      //项目备注
}

package com.copy.demo.entity;


import com.sinoyd.frame.base.entity.BaseEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "table_factor") //因子表
@Setter
@Getter
public class AnalyzeFactor implements BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; //因子id

    @Column
    private String factorName ; //因子名

    @Column
    private String factorCode ; //因子编号

    @Column
    private Boolean isDeleted = false ;  //用于判断是否已经被删除 即删除时作假删除 仅修改此值即可

}

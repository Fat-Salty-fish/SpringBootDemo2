package com.sinoyd.demo.criteria;

import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.StringUtils;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AnalyzeFactorCriteria extends BaseCriteria {

    private String factorName ; //因子名

    private String factorCode;  //因子编号

    @Override
    public String getCondition() {
        values.clear(); //先清除整个hashmap BaseCriteria类里定义了values Criteria意为标准 这里应该为存放多个因子的集合
        StringBuilder condition = new StringBuilder();

        if(StringUtils.isNotNullAndEmpty(this.factorName))
        {
            condition.append("and factorName = :factorName");
            values.put("factorName","%" + this.factorName + "%");
        }
        if(StringUtils.isNotNullAndEmpty(this.factorCode))
        {
            condition.append("and factorCode = :factorCode");
            values.put("factorCode","%" + this.factorCode + "%");
        }
        condition.append(" and isDeleted = 0");

        return condition.toString();
    }
}

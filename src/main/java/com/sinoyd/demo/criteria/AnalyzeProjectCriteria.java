package com.sinoyd.demo.criteria;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.StringUtils;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AnalyzeProjectCriteria extends BaseCriteria {

    private String itemName;
    private String itemCode;
    @Override
    public String getCondition() {
        values.clear();     //先清空hashmap 保证values为空
        StringBuilder condition = new StringBuilder();
        if(StringUtils.isNotNullAndEmpty(itemName))
        {
            condition.append(" and itemName = :itemName");
            values.put("itemName","%"+this.itemName+"%");
        }
        if(StringUtils.isNotNullAndEmpty(itemCode))
        {
            condition.append(" and itemCode = :itemCode");
            values.put("itemCode", "%" + this.itemCode + "%");
        }
        return condition.toString();
    }
}

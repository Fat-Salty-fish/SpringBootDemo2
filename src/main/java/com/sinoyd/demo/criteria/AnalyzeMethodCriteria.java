package com.sinoyd.demo.criteria;

import com.sinoyd.frame.base.util.BaseCriteria;
import com.sinoyd.frame.base.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnalyzeMethodCriteria extends BaseCriteria {
    private String methodName;
    private String methodCode;

    @Override
    public String getCondition() {
        values.clear();         //先清除hashmap 保证集合内为空
        StringBuilder condition = new StringBuilder();

        if(StringUtils.isNotNullAndEmpty(methodName))
        {
            condition.append(" and methodName = :methodName");
            values.put("methodName","%" + this.methodName + "%");
        }

        if(StringUtils.isNotNullAndEmpty(methodCode))
        {
            condition.append(" and methodCode = :methodCode");
            values.put("methodCode", "%" + this.methodCode + "%");
        }
        condition.append(" and isDeleted = 0");
        return condition.toString();
    }
}

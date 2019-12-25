package com.example.sentinelcoreexample;

import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/23 下午9:22
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

public class JsonFlowRuleListConverter implements Converter<String, List<FlowRule>> {
    @Override
    public List<FlowRule> convert(String source) {
        return JSON.parseObject(source, new TypeReference<List<FlowRule>>() {});
    }
}

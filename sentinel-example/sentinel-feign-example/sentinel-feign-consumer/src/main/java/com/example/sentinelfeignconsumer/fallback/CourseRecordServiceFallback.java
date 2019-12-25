package com.example.sentinelfeignconsumer.fallback;

import com.example.sentinelfeignconsumer.service.CourseRecordService;
import org.springframework.stereotype.Component;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/25 14:11
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */
@Component
public class CourseRecordServiceFallback implements CourseRecordService {

    @Override
    public String test(String aa) {
        return "fail";
    }

    @Override
    public String test2(String aa) {
        return "fail2";
    }
}

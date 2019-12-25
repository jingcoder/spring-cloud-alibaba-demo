package com.example.sentinelfeignconsumer.service;

import com.example.sentinelfeignconsumer.fallback.CourseRecordServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/25 14:07
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */
@FeignClient(name = "web-backend", fallback = CourseRecordServiceFallback.class)
public interface CourseRecordService {

    @PostMapping("/jty/course_record/test")
    String test(String aa);

    @PostMapping("/course_record/test")
    String test2(String aa);

}

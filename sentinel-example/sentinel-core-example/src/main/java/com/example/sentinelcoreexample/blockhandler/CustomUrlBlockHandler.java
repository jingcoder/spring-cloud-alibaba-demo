package com.example.sentinelcoreexample.blockhandler;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author xu.xiaojing
 * @Date 2019/11/24 上午12:55
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

public class CustomUrlBlockHandler implements UrlBlockHandler {

    @Override
    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {

    }
}

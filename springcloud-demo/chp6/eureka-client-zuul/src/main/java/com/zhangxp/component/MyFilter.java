package com.zhangxp.component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

// 实现一个自定义的过滤器
@Component
public class MyFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    // 过滤器类型，有4种: pre, post, routing和error
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    // 过滤器执行顺序，越小越先执行。
    @Override
    public int filterOrder() {
        return 0;
    }

    // 是否执行过滤器的run方法。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 具体的执行过滤逻辑
    /*
    * 在本例中，检查请求的参数中是否传了token这个参数，如果没有传，则请求不被路由到具体的服务实例，直接返回响应
    * 状态码为401
    * */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accesToken = request.getParameter("token");
        if (accesToken == null) {
            log.warn("toke is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e) {
                return null;
            }
        }
        log.info("ok");
        return null;
    }
}

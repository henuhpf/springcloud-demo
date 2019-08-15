package com.hmoro.zuul.filter;

import com.netflix.zuul.IZuulFilter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class LoginFilter extends ZuulFilter {

    // 过滤器类型 : pre route post error
    @Override
    public String filterType() {
        return "pre";
    }
    // 执行顺序，返回值越小,优先级越高,可以为负数
    @Override
    public int filterOrder() {
        return 10;
    }
    // 是否执行该过滤器 true: 执行run()
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 初始化 context 上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        // 获取 request对象
        HttpServletRequest request = context.getRequest();
        // 获取对象
        String token = request.getParameter("token");
        if(StringUtils.isBlank(token)){
            // 拦截, 不转发请求
            context.setSendZuulResponse(false);
            //设置status， 401-身份未认证 HttpStatus.SC_UNAUTHORIZED || HttpStatus.UNAUTHORIZED
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            //设置data
            context.setResponseBody(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        }
        // 返回值为 null,代表该过滤器无动作
        return null;
    }
}

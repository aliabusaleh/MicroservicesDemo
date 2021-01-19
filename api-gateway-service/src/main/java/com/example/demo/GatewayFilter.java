package com.example.demo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class GatewayFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(GatewayFilter.class);


    @Override
    public String filterType() {
        return "pre";
        //return "pre";
        //return "post";
        //return "error";

    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request =
                RequestContext.getCurrentContext().getRequest();
        LOG.info(request.getQueryString());
        LOG.info("request -> {} request Uri -> {}",request,request.getRequestURI());

        return null;
    }
}

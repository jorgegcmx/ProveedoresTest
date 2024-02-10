package com.backSwagger.gapsi.Config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Slf4j
@Generated
@Component
public class SimpleCORSFilter implements Filter {

    public SimpleCORSFilter() {
        log.info("SimpleCORSFilter init");
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Referrer-Policy", "no-referrer");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Authorization, token");

        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        // Sin funcionalidad específica, pero debe implementarse por la interfaz.
    }

    @Override
    public void destroy() {
        //Sin funcionalidad específica, pero debe implementarse por la interfaz.
    }
}
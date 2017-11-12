package ru.info.tech.filters;

import ru.info.tech.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sulaymon on 22.10.2017.
 */
@WebFilter(urlPatterns =  { "/purchasePolicies", "/userAccount"})
public class GuideFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user != null){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }else
            httpServletResponse.sendRedirect("/home");
    }

    @Override
    public void destroy() {

    }
}

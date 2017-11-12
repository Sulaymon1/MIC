package ru.info.tech.filters;

import org.springframework.context.ApplicationContext;
import ru.info.tech.dao.InsuranceDao;
import ru.info.tech.models.InsurancePolicy;
import ru.info.tech.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sulaymon on 11.11.2017.
 */
@WebFilter({"/registerInsurance", "/viewPolicy"})
public class RegisterInsFilter implements Filter {
    private InsuranceDao insuranceDao;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ApplicationContext context = (ApplicationContext) filterConfig.getServletContext().getAttribute("context");
        insuranceDao = context.getBean(InsuranceDao.class);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user != null){
            InsurancePolicy insurancePolicy = insuranceDao.find(user.getId());
            if (insurancePolicy != null) {
                httpServletRequest.setAttribute("insurancePolicy", insurancePolicy);
                httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/getPolicies/get_insurance_for_one.jsp").forward(httpServletRequest, httpServletResponse);
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }else httpServletResponse.sendRedirect("/register");
    }

    @Override
    public void destroy() {

    }
}

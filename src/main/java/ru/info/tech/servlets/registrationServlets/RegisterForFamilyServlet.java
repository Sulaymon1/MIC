package ru.info.tech.servlets.registrationServlets;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ru.info.tech.dao.InsuranceFamilyDao;
import ru.info.tech.models.User;
import ru.info.tech.models.UsersInsurancePolicy;
import ru.info.tech.servlets.LoginServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by Sulaymon on 23.10.2017.
 */
@WebServlet("/purchasePolicies")
public class RegisterForFamilyServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(RegisterForFamilyServlet.class);
    private InsuranceFamilyDao familyDao;
    private User user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("context");
        familyDao = context.getBean(InsuranceFamilyDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/register/register_for_family.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("From first group field (name): "+req.getParameter("name1"));
        log.info("From second group field (name): "+req.getParameter("name2"));
        user = (User) req.getSession().getAttribute("user");
        int i = 0;
        while (req.getParameter("name" + ++i) != null) {
            UsersInsurancePolicy model = UsersInsurancePolicy.builder()
                    .id(user.getId())
                    .name(req.getParameter("name" + i))
                    .passport_series(req.getParameter("passport_series" + i))
                    .age(Integer.parseInt(req.getParameter("age" + i)))
                    .price(Long.valueOf(req.getParameter("expiration_year" + i))*100L)
                    .expiration_date(LocalDate.now().plusYears(Long.parseLong(req.getParameter("expiration_year"+i))))
                    .build();
            log.info("got policy: "+model.toString());
            familyDao.save(model);
        }
        resp.sendRedirect("/payment");
        //req.getRequestDispatcher("").forward(req, resp);
    }
}

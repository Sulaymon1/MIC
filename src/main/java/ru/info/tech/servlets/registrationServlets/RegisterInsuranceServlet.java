package ru.info.tech.servlets.registrationServlets;

import org.springframework.context.ApplicationContext;
import ru.info.tech.dao.InsuranceDao;
import ru.info.tech.dao.InsuranceDaoImpl;
import ru.info.tech.models.InsurancePolicy;
import ru.info.tech.models.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


/**
 * Created by Sulaymon on 21.10.2017.
 */
@WebServlet("/registerInsurance")
public class RegisterInsuranceServlet extends HttpServlet {

    private User user;
    private InsuranceDao insuranceDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("context");
        insuranceDao = context.getBean(InsuranceDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = (User) req.getSession().getAttribute("user");
        req.getRequestDispatcher("/WEB-INF/jsp/register/register_insurance_for_one.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = (User) req.getSession().getAttribute("user");
        InsurancePolicy policy = InsurancePolicy.builder()
                .id(user.getId())
                .passport_series(req.getParameter("passport_series"))
                .price(Long.valueOf(req.getParameter("expiration_year"))*100L)
                .expiration_date(LocalDate.now().plusYears(Long.parseLong(req.getParameter("expiration_year"))))
                .build();
        insuranceDao.save(policy);

       /* LocalDate date = LocalDate.parse(string);
        System.out.println(date); // 2010-01-02*/
        req.getSession().setAttribute("insurancePolicy", policy);
        req.getRequestDispatcher("/WEB-INF/jsp/getPolicies/get_insurance_for_one.jsp").forward(req,resp);
    }
}

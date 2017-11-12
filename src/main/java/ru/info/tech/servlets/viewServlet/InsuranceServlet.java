package ru.info.tech.servlets.viewServlet;

import org.springframework.context.ApplicationContext;
import ru.info.tech.dao.InsuranceDao;
import ru.info.tech.models.InsurancePolicy;
import ru.info.tech.models.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sulaymon on 22.10.2017.
 */
@WebServlet("/viewPolicy")
public class InsuranceServlet extends HttpServlet {
    private InsuranceDao insuranceDao;
    private User user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("context");
        insuranceDao = context.getBean(InsuranceDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = (User) req.getSession().getAttribute("user");
        InsurancePolicy policy = insuranceDao.find(user.getId());
        req.getSession().setAttribute("policy", policy);
        req.getRequestDispatcher("/WEB-INF/jsp/getPolicies/get_insurance_for_one.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

package ru.info.tech.servlets;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ru.info.tech.dao.InsuranceDao;
import ru.info.tech.dao.InsuranceDaoImpl;
import ru.info.tech.dao.UsersDao;
import ru.info.tech.models.InsurancePolicy;
import ru.info.tech.models.User;
import ru.info.tech.servlets.security.PasswordToHashConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sulaymon on 20.10.2017.
 */
@WebServlet({"/login", "/myaccount"})
public class LoginServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(LoginServlet.class);
    private UsersDao usersDao;
    private PasswordToHashConverter toHashMD5;
    private InsuranceDao insuranceDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("context");
        insuranceDao = context.getBean(InsuranceDao.class);
        usersDao = context.getBean(UsersDao.class);
        toHashMD5 = new PasswordToHashConverter();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/user/login_page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = usersDao.findByUsernameAndPassword(req.getParameter("username"), "");
        log.info("got from LoginServlet(doPost): "+ user);
        if (user != null){
            if (user.getHashPassword().equals(toHashMD5.hashMD5(req.getParameter("password")))) {
                InsurancePolicy insurancePolicy = insuranceDao.find(user.getId());
                if (insurancePolicy!=null)
                    req.getSession().setAttribute("insurancePolicy", insurancePolicy);
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/home");
            }else {
                req.setAttribute("errorMessage", "password is incorrect!");
                req.getRequestDispatcher("/WEB-INF/jsp/user/login_page.jsp").forward(req, resp);
            }
            //req.getRequestDispatcher("/WEB-INF/jsp/userAccount.jsp").forward(req, resp);
        }else {
            req.setAttribute("errorMessage", "username or password is incorrect!");
            req.getRequestDispatcher("/WEB-INF/jsp/user/login_page.jsp").forward(req, resp);
        }

    }
}

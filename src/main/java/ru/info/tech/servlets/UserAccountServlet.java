package ru.info.tech.servlets;

import org.springframework.context.ApplicationContext;
import ru.info.tech.dao.UsersDao;
import ru.info.tech.models.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sulaymon on 05.11.2017.
 */
@WebServlet("/userAccount")
public class UserAccountServlet extends HttpServlet {
    private UsersDao usersDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("context");
        usersDao = context.getBean(UsersDao.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/user/userAccount.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

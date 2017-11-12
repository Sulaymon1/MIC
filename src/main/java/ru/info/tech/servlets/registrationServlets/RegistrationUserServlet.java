package ru.info.tech.servlets.registrationServlets;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ru.info.tech.dao.UserTempDao;
import ru.info.tech.mail.MailSender;
import ru.info.tech.models.User;
import ru.info.tech.servlets.security.PasswordToHashConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sulaymon on 15.10.2017.
 */
@WebServlet({"/register","/reg"})
public class RegistrationUserServlet extends HttpServlet {
    private Logger log = Logger.getLogger(RegistrationUserServlet.class);
    private UserTempDao userTempDao;
    private MailSender mailSender;
    private PasswordToHashConverter toHash;

    private boolean validate(User user){
        Pattern pattern = Pattern.compile("^[a-zA-Z.+]{3,15}$");
        Matcher name = pattern.matcher(user.getName());
        Matcher surname = pattern.matcher(user.getSurname());
        Matcher lastname = pattern.matcher(user.getLastname());
        pattern = Pattern.compile("^[0-9+]{1,2}");
        Matcher age = pattern.matcher(String.valueOf(user.getAge()));
        pattern =Pattern.compile("^[0-9+]{9,12}");
        Matcher phone = pattern.matcher(user.getTel());
        pattern = Pattern.compile("^[0-9+]{9,12}");
        Matcher address = pattern.matcher(user.getAddress());
        return (name.matches() && surname.matches()
                && lastname.matches() && age.matches() && phone.matches()
                && address.matches());
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("context");
        userTempDao = context.getBean(UserTempDao.class);
        mailSender = new MailSender();
        toHash = new PasswordToHashConverter();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/WEB-INF/jsp/register/userRegister.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info(toHash.hashMD5("1234"));
        log.info(toHash.hashMD5(req.getParameter("password")));
        String birthday = req.getParameter("day")+"."+req.getParameter("month")+"."+req.getParameter("year");
        User user = User.builder()
                .name(req.getParameter("name"))
                .surname(req.getParameter("surname"))
                .lastname(req.getParameter("lastname"))
                .age(birthday)
                .tel(req.getParameter("telefon"))
                .address(req.getParameter("address"))
                .email(req.getParameter("email"))
                .username(req.getParameter("username"))
                .hashPassword(toHash.hashMD5(req.getParameter("password")))
                .build();

        log.info(toHash.hashMD5(req.getParameter("username")));
        String hashMD5 = toHash.hashMD5(req.getParameter("username"));
        userTempDao.save(user, hashMD5);
        mailSender.sendMail(user.getEmail(), "http://localhost:8080/confirm?control="+hashMD5);
        req.getRequestDispatcher("/WEB-INF/jsp/confirmation.jsp").forward(req, resp);

    }


}

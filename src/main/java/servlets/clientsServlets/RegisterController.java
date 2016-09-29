package servlets.clientsServlets;

import model.Client;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import service.ClientServ;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    private ClientServ clientServ;

    @Override
    public void init() throws ServletException {

        ApplicationContext applicationContext =
                (ApplicationContext) getServletContext().getAttribute("spring-context");
        clientServ = applicationContext.getBean(ClientServ.class);
        super.init();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        String driverLicenseNumber = req.getParameter("driverLicenseNumber");
        String pass = req.getParameter("pass");
        String passRepeated = req.getParameter("passRepeated");

        PrintWriter printWriter = resp.getWriter();

        if (!pass.equals(passRepeated)) {
            RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");

            printWriter.println("<font color=red>Passwords you entered in Password field and Re-Enter Password field" +
                    " are not equals!!! Please try again.</font>");
            rd.include(req, resp);

        } else {
            Client client = clientServ.register(firstName, secondName,
                    phoneNumber, email, driverLicenseNumber, pass);
            req.setAttribute("client", client);
            LOGGER.info("successful registration" + client.toString());

            req.getRequestDispatcher("/WEB-INF/pages/clientMenu.jsp").
                    forward(req, resp);

            printWriter.flush();

        }
    }
}

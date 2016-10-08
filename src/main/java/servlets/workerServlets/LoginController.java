package servlets.workerServlets;

import exeption.NoWorkerFoundException;
import model.Worker;
import model.WorkerTypes;
import org.springframework.context.ApplicationContext;
import service.ClientServImpl;
import service.WorkerServ;
import util.GetEnumFromString;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/loginForWorker"})
public class LoginController extends HttpServlet {
    private static final org.apache.log4j.Logger LOGGER =
            org.apache.log4j.Logger.getLogger(LoginController.class);
    private WorkerServ workerServ;

    public void init() throws ServletException {
        ApplicationContext applicationContext = (ApplicationContext) getServletContext().getAttribute("spring-context");
        workerServ = applicationContext.getBean(WorkerServ.class);
        LOGGER.info("worker service created info login controller servlet");

        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        LOGGER.info(login.toString()+" from do post() login controller");
        String pass = req.getParameter("pass");
        LOGGER.info(pass.toString()+" from do post() login controller");
        PrintWriter printWriter = resp.getWriter();

        String accessToken = workerServ.login(login, pass);
        LOGGER.info(accessToken.toString()+" accessToken info from do post() login controller");
        Worker worker = workerServ.getWorker(accessToken);
        LOGGER.info("worker login controller: " + worker.toString() + " in system!");

        resp.addCookie(new Cookie("accessToken", accessToken));
        req.setAttribute("worker", worker);

        if(worker.getWorkerTypes()==WorkerTypes.ADMINISTRATOR){
            req.getRequestDispatcher("/WEB-INF/pages/administratorMenu.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("/WEB-INF/pages/workerMenu.jsp").forward(req,resp);
        }
        printWriter.flush();


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/WEB-INF/pages/workerMenu.jsp").forward(req,resp);


    }
}

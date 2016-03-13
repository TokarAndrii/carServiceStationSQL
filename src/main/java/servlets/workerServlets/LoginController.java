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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/loginForWorker"})
public class LoginController extends HttpServlet {
    private static final org.apache.log4j.Logger LOGGER =
            org.apache.log4j.Logger.getLogger(ClientServImpl.class);
    private WorkerServ workerServ;

    public void init() throws ServletException {
        ApplicationContext applicationContext = (ApplicationContext) getServletContext().getAttribute("spring-context");
        WorkerServ workerServ = applicationContext.getBean(WorkerServ.class);

        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        PrintWriter printWriter = resp.getWriter();
      /*  try {*/
            String accessToken = workerServ.login(login, pass);
            Worker worker = workerServ.getWorker(accessToken);
            LOGGER.info("worker login controller: " +worker.toString()+" in system!");
        req.getRequestDispatcher("index.html").forward(req,resp);
        printWriter.flush();


/*
        }catch (NoWorkerFoundException e){
            LOGGER.info("no use found");
        };*/


    }
}

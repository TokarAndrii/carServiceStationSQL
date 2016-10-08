package servlets.workerServlets;

import model.Worker;
import org.springframework.context.ApplicationContext;
import service.WorkerServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/workerSheduler"})
public class WorkerSheduler extends HttpServlet {
    private static final org.apache.log4j.Logger LOGGER =
            org.apache.log4j.Logger.getLogger(WorkerSheduler.class);

    private WorkerServ workerServ;
    private LoginController loginController;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Worker worker = (Worker) getServletContext().getAttribute("worker");


        System.out.println(worker.toString() + " worker data from dopost() WorkerSheduler");

        String firstName = worker.getFirstName();
        req.setAttribute("firstName",firstName);
        System.out.println(firstName + "firstName of worker data from dopost() WorkerSheduler");

        PrintWriter printWriter = resp.getWriter();


        printWriter.write(firstName);

        printWriter.flush();
        printWriter.close();

        req.getRequestDispatcher("workerSheduler.jsp").forward(req,resp);







    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




    }

    @Override
    public void init() throws ServletException {
        ApplicationContext applicationContext = (ApplicationContext) getServletContext().getAttribute("spring-context");
        super.init();

        workerServ = applicationContext.getBean(WorkerServ.class);
    }
}

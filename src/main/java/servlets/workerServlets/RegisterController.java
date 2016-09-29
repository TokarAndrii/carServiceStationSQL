package servlets.workerServlets;

import model.Admin;
import model.Worker;
import model.WorkerTypes;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import service.WorkServImpl;
import service.WorkerServ;
import util.GetEnumFromString;

import javax.persistence.Enumerated;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/registerWorker"})
public class RegisterController extends HttpServlet {
    private WorkerServ workerServ;
    private static final Logger LOGGER = Logger.getLogger(RegisterController.class);

    @Override
    public void init() throws ServletException {
        ApplicationContext applicationContext =
                (ApplicationContext) getServletContext().getAttribute("spring-context");
        workerServ = applicationContext.getBean(WorkerServ.class);
        Admin admin = applicationContext.getBean(Admin.class);
        workerServ.register(admin.getFirstName(), admin.getSecondName(),
                admin.getSalary(), admin.getWorkerTypes(), admin.getLogin(),
                admin.getPassword());


        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.info("doPost method starting....");
        String firstName = req.getParameter("firstName");
        LOGGER.info(firstName.toString() + " from doPost!!!");
        String secondName = req.getParameter("secondName");
        LOGGER.info(secondName.toString() + " from doPost!!!");
        String salaryString = req.getParameter("salary");
        long salary = Long.parseLong(salaryString);
        LOGGER.info(salary + " from doPost!!!");


        String workerTypesString = req.getParameter("workerTyps");
        LOGGER.info(workerTypesString+ " from doPost!!!");
        WorkerTypes workerTypes = GetEnumFromString.getEnumFromString(WorkerTypes.class, workerTypesString);
        LOGGER.info(workerTypes.toString() + " from doPost!!!");

        String login = req.getParameter("login");
        LOGGER.info(login.toString()+ " from doPost!!!");
        String pass = req.getParameter("pass");
        LOGGER.info(pass.toString()+ " from doPost!!!");


        PrintWriter printWriter = resp.getWriter();
        Worker worker = workerServ.register(firstName, secondName, salary, workerTypes, login, pass);
        LOGGER.info(worker.toString()+ " doPost created worker!!!!!");
        LOGGER.info(worker + worker.toString());
        req.getRequestDispatcher("/WEB-INF/pages/workerMenu.jsp").
                forward(req, resp);


        printWriter.flush();

    }
}

package servlets.workerServlets;

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
public class RegisterController extends HttpServlet{
    private WorkerServ workerServ;
    private static final Logger LOGGER = Logger.getLogger(RegisterController.class);
    
    @Override
    public void init() throws ServletException {
        ApplicationContext applicationContext = 
                (ApplicationContext) getServletContext().getAttribute("spring-context");
        workerServ=applicationContext.getBean(WorkerServ.class);
        
        
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String salaryString = req.getParameter("salary");
        long salary = Long.parseLong(salaryString);
        String workerTypesString = req.getParameter("workerTyps");
        WorkerTypes workerTypes = GetEnumFromString.getEnumFromString(WorkerTypes.class, workerTypesString);
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");


        PrintWriter printWriter = resp.getWriter();
        Worker worker = workerServ.register(firstName,secondName,salary,workerTypes,login,pass);
        LOGGER.info(worker+worker.toString());
req.getRequestDispatcher("/WEB-INF/pages/clientMenu.jsp").
                forward(req,resp);


        printWriter.flush();

    }
}

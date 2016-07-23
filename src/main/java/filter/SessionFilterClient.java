package filter;

import model.Admin;
import model.Client;
import model.Worker;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import service.ClientServImpl;
import service.WorkServImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionFilterClient implements Filter {
    private static final Logger LOGGER = Logger.getLogger(SessionFilterClient.class);
    private ClientServImpl clientServ;
    private WorkServImpl workServ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ApplicationContext applicationContext =
                (ApplicationContext) filterConfig.getServletContext().getAttribute("spring-context");

        clientServ = applicationContext.getBean(ClientServImpl.class);
        workServ = applicationContext.getBean(WorkServImpl.class);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("accessToken") && cookie.equals("acessToken")) {
                String value = cookie.getValue();
                if (clientServ.getClient(value) != null) {
                    Client client = clientServ.getClient(value);

                    request.setAttribute("accessToken", value);


                }
                if (workServ.getWorker(value) != null) {
                    Worker worker = workServ.getWorker(value);
                    request.setAttribute("accessToken", value);
                } else {
                    LOGGER.info("Authentification failled");
                }
            }

        }

    filterChain.doFilter(request,response);
}

    @Override
    public void destroy() {

    }
}

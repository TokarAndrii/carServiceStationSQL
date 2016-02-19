package filter;


import model.Worker;
import org.springframework.context.ApplicationContext;
import service.WorkServImpl;
import sun.rmi.transport.proxy.HttpReceiveSocket;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class SessionFilterWorker implements Filter {
    private static final org.apache.log4j.Logger LOGGER =
            org.apache.log4j.Logger.getLogger(SessionFilterClient.class);
    private WorkServImpl workServ;

    public void init(FilterConfig filterConfig) throws ServletException {
        ApplicationContext applicationContext = (
                ApplicationContext) filterConfig.getServletContext().getAttribute("spring-context");
        workServ=applicationContext.getBean(WorkServImpl.class);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("accessToken")) ;
            {
                String value = cookie.getValue();
                Worker worker = workServ.getWorker(value);
                request.setAttribute("workerSessionToken", value);
                if (worker==null){
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
;

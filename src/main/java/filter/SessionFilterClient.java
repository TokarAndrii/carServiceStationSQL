package filter;

import model.Client;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import service.ClientServImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionFilterClient implements Filter {
    private static final Logger LOGGER = Logger.getLogger(SessionFilterClient.class);
    private ClientServImpl clientServ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ApplicationContext applicationContext =
                (ApplicationContext) filterConfig.getServletContext().getAttribute("spring-context");

        clientServ = applicationContext.getBean(ClientServImpl.class);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("accessToken")) {
                String value = cookie.getValue();
                Client client = clientServ.getClient(value);

                request.setAttribute("clientSessionToken", value);

                if (client == null) {
                    LOGGER.info("Authentification failled");
                   /* resp.sendRedirect("auth-error.html");*/
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

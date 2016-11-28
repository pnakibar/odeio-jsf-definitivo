package beerzeit.utils.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by pedro on 28/11/16.
 */
@WebFilter(filterName = "loginfilter", urlPatterns = { "*.xhtml" })
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest reqt = (HttpServletRequest) req;
        HttpServletResponse resp = (HttpServletResponse) res;
        HttpSession ses = reqt.getSession(false);
        String reqURI = ((HttpServletRequest) req).getRequestURI();
        if (
                reqURI.indexOf("/login.xhtml") >= 0
                || (ses != null && ses.getAttribute("userid") != null)
                || reqURI.contains("javax.faces.resource")
        ) {
            filterChain.doFilter(req, res);
        } else {
            resp.sendRedirect("/login.xhtml");
        }

    }

    @Override
    public void destroy() {}
}

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter", urlPatterns = {"/addServlet/*","/doneServlet/*","/logoutServlet/*"})
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        Object login = request.getSession().getAttribute("login");
        if(login != null && login.toString().equals("ok")){
            chain.doFilter(req, resp);
        }else{
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
    }
    public void init(FilterConfig config) throws ServletException {
    }
}

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addServlet", urlPatterns = "/addServlet")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        PrintWriter out = response.getWriter();

        if(a == null || b == null){
            out.println("参数错误");
        }else{
            try {
                int num1 = Integer.parseInt(a);
                int num2 = Integer.parseInt(b);
                RequestDispatcher rd = request.getRequestDispatcher("/doneServlet");
                rd.forward(request, response);
            }catch (NumberFormatException e){
                out.println("参数错误");
            }
        }

    }
}

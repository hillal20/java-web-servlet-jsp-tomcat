package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AddValuesServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
       int n1 = Integer.parseInt(req.getParameter("n1"));
        int n2 = Integer.parseInt(req.getParameter("n2"));
        int result = n1 + n2;


//        PrintWriter printWriter = res.getWriter();
//        printWriter.println("result ==> "+ result);


       // req.setAttribute("result", result);
        // when we talk from a servlet to another we use dispatchers
       // RequestDispatcher rd = req.getRequestDispatcher("multiply"); // this is the url where the request will go
       //rd.forward(req,res); // we are sending the same res and req as well



        // we use sendRedirect instead, and we send the result as a url query
       // res.sendRedirect("multiply?result="+result);

        // we can use sessions to send  result
        HttpSession session  = req.getSession();
        session.setAttribute("result",result);

        // we can use the cookies to send result
        Cookie cookie = new Cookie("result",result+"");
        res.addCookie(cookie);
        res.sendRedirect("multiply");


    }

}

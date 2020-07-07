package servlets;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;


public class MultiplyServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

          // the result is coming from the request dispatcher
//        int result =  (int)req.getAttribute("result");
//        result = result * 10;

          // the result is coming from the params since we are redirecting
//        int result =  Integer.parseInt(req.getParameter("result"));
//       result = result * 10;

        // the  result is coming from the request session
//        HttpSession session = req.getSession();
//        int result = (int)session.getAttribute("result");
//        result = result * 10;


        // the result is coming from the cookie
        int result = 0 ;
        Cookie cookies[] = req.getCookies();
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("result")){
                result = Integer.parseInt(cookie.getValue());
                System.out.println("result ==>  "+ Integer.parseInt(cookie.getValue()));
            }
        }
        result = result * 10;

        PrintWriter printWriter = res.getWriter();
        printWriter.println("result  ====> " + result);
    }

}

package servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletContextClass extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException  {


          // shared by all the servlets
         ServletContext sc =  getServletContext();
          String name = sc.getInitParameter("name");


          // it is servlet specific
        ServletConfig sConfig = getServletConfig();
        String mySecret = sConfig.getInitParameter("mySecret");

        PrintWriter printWriter = res.getWriter();
        printWriter.println("==> context is here ==> : " + name + mySecret);

    }
}

package main.java.com.bigode.utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(value = "/api/dono/v1/")
public class BigodeServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public BigodeServlet(){
        super();
    }

    public void init() throws ServletException {
        //tests DB connection
        JDBCConnection instance = JDBCConnection.getJdbcInstance();
        Connection conn = instance.connect();
        if(conn != null) {
            getServletContext().setAttribute("DB_Success", "True");
        }
        else throw new ServletException("DB Connection error");

        instance.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        out.print("<html><body>");
        out.print("<h3>Hello Servlet</h3>");
        out.print("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
    }
}
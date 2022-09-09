package com.project.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletTest", urlPatterns = "/test")
// @WebServlet 어노테이션을 통해
// localhost/8181/test 를 치게되면, doGet() 메서드를 통해 페이지를 보여준다.
// .jsp로 굳이 파일을 안열어도 된다.
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<p>Web Servlet 어노테이션 활용방법</p>");
    }
}

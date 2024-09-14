package routes;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

class Student {
    private String name;
    private String phone;
    private String city;

    public String getName() {
        return this.name;
    }
    public String getPhone() {
        return this.phone;
    }
    public String getCity() {
        return this.city;
    }
}

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(403);
        PrintWriter out = response.getWriter();
        out.println("<html><h1>hi from /add route</h1></html>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        Student student = new Gson().fromJson(reader, Student.class);
        System.out.println(student.getName() + " " + student.getPhone() + " " + student.getCity());

        response.setContentType("text/html");
        response.setStatus(200);
        PrintWriter out = response.getWriter();
        out.println("<html><h1>hi from /add post route</h1></html>");
    }
}

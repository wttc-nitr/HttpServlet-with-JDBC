package routes;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studentmgmt.StudentDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

class Id {
    private int id;
    public int getId() {
        return this.id;
    }
}

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doDelete (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Id id = new Gson().fromJson(reader, Id.class);
        boolean result = StudentDAO.deleteStudent(id.getId());
        resp.setContentType("text/html");
        if (result) {
            resp.setStatus(200);
            resp.getWriter().println("deleted successfully");
        }
        else {
            resp.setStatus(404);
            resp.getWriter().println("not deleted");
        }
    }
}

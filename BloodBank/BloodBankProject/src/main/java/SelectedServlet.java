import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/donorlist1")

public class SelectedServlet extends HttpServlet {
    SelectedDAO SelectedDao;

    public void init() throws ServletException {
        String jdbcURL = "jdbc:mysql://db4free.net/sathydb";
        String jdbcUsername = "sathym";
        String jdbcPassword = "99sathy.";
        SelectedDao = new SelectedDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Donor> donordata = new ArrayList<Donor>();
        try {
            donordata = SelectedDao.listSelected();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String result = gson.toJson(donordata);
        resp.getWriter().print(result);
    }
}
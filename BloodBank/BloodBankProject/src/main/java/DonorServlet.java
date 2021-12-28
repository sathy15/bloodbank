import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/donorlist")
public class DonorServlet extends HttpServlet {
    DonorDAO donorDao;

    public void init() throws ServletException {
        String jdbcURL = "jdbc:mysql://db4free.net/sathydb";
        String jdbcUsername = "sathym";
        String jdbcPassword = "99sathy.";
        donorDao = new DonorDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Donor> donordata = new ArrayList<Donor>();
        try {
            donordata = donorDao.listAllDonors();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String result = gson.toJson(donordata);
        resp.getWriter().print(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestData = req.getReader().lines().collect(Collectors.joining());

        Donor newuser = new Gson().fromJson(requestData, Donor.class);

        try {
            donorDao.insertDonor(newuser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // read the data and store in collection
        String deleteData = req.getReader().lines().collect(Collectors.joining());
        // json obj is converted to java obj
        Donor deletedonor = new Gson().fromJson(deleteData, Donor.class);
        // System.out.println("requestData Length->" + deleteData.length());
        // System.out.println("requestData->" + deleteData);
        try {
            donorDao.deleteDonor(deletedonor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPut called");
        String requestData = req.getReader().lines().collect(Collectors.joining());
        Donor updateDonor = new Gson().fromJson(requestData, Donor.class);
        System.out.println("requestData Length->" + requestData.length());
        System.out.println("requestData->" + requestData);
        System.out.println(updateDonor.getDonor_id() + " " + updateDonor.getDonor_id());

        try {
            donorDao.updateDonor(updateDonor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public static boolean checkUser(String email,String pass,String role) 
    // {
    //     boolean st =false;
    //     try {
    //         //loading drivers for mysql
    //         Class.forName("com.mysql.jdbc.Driver");
    //         //creating connection with the database
    //         Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/gayathrirdb","gayathrir","Adgjmptw0@");
    //         PreparedStatement ps = con.prepareStatement("select * from register where email=? and pass=? and role=?");
    //         ps.setString(1, email);
    //         ps.setString(2, pass);
    //         ps.setString(3, role);
    //         ResultSet rs =ps.executeQuery();
    //         st = rs.next();
    //     }
    //     catch(Exception e) {
    //         e.printStackTrace();
    //     }
    //     return st;                 
    // }
}

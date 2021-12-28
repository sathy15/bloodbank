import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DonorDAO {
    String jdbcURL;
    String jdbcUserName;
    String JdbcPassword;
    Connection jdbcConnection;

    // constructor for DonarConn for connecting the db
    public DonorDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUserName = jdbcUserName;
        this.JdbcPassword = jdbcPassword;
    }

    // this method is used to establish the connection to db
    void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUserName, JdbcPassword);
        }
    }

    // this method is used to establish the disconnection to db
    void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    // method used to get all the data from the db
    public List<Donor> listAllDonors() throws SQLException {
        List<Donor> donorList = new ArrayList<Donor>();
        String sql = "SELECT * FROM DONOR;";
        connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
        while (resultset.next()) {
            int donor_id = resultset.getInt("donor_id");
            String donor_name = resultset.getString("donor_name");
            String date = resultset.getString("date");
            String dob = resultset.getString("dob");
            String gender = resultset.getString("gender");
            String blood_group = resultset.getString("blood_group");
            String contact_number = resultset.getString("contact_number");
            String address = resultset.getString("address");
            String p_word = resultset.getString("p_word");
            String confirm_password = resultset.getString("confirm_password");

            Donor donorobj = new Donor();

            donorobj.setDonor_id(donor_id);
            donorobj.setDonor_name(donor_name);
            donorobj.setDate(date);
            donorobj.setDob(dob);
            donorobj.setGender(gender);
            donorobj.setBlood_group(blood_group);
            donorobj.setContact_number(contact_number);
            donorobj.setAddress(address);
            donorobj.setP_word(p_word);
            donorobj.setConfirm_password(confirm_password);
            donorList.add(donorobj);

        }
        resultset.close();
        statement.close();
        disconnect();
        return donorList;
    }

    public boolean insertDonor(Donor insertdonor) throws Exception {
        String sql = "INSERT INTO DONOR values(?,?,?,?,?,?,?,?,?,?)";
        connect();
        PreparedStatement prepstat = jdbcConnection.prepareStatement(sql);
        prepstat.setInt(1, insertdonor.getDonor_id());
        prepstat.setString(2, insertdonor.getDonor_name());
        prepstat.setString(3, insertdonor.getDate());
        prepstat.setString(4, insertdonor.getDob());
        prepstat.setString(5, insertdonor.getGender());
        prepstat.setString(6, insertdonor.getBlood_group());
        prepstat.setString(7, insertdonor.getContact_number());
        prepstat.setString(8, insertdonor.getAddress());
        prepstat.setString(9, insertdonor.getP_word());
        prepstat.setString(10, insertdonor.getConfirm_password());
        boolean rowUpdated = prepstat.executeUpdate() > 0;
        prepstat.close();
        disconnect();
        return rowUpdated;
    }

    public boolean deleteDonor(Donor deletedonor) throws Exception {
        String sql = "DELETE FROM DONOR where donor_id = ?";
        connect();
        PreparedStatement statement2 = jdbcConnection.prepareStatement(sql);
        statement2.setLong(1, deletedonor.getDonor_id());
        boolean rowDeleted = statement2.executeUpdate() > 0;
        statement2.close();
        disconnect();
        return rowDeleted;     
    }
      
    public boolean updateDonor(Donor updatedonor) throws SQLException {
        String sql = "UPDATE DONOR SET  donor_id= ?";
        sql += " WHERE donor_id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setLong(1, updatedonor.getDonor_id());
        statement.setInt(2, updatedonor.getDonor_id());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }

    public static boolean checkUser(String contact_number, String password) {
        return false;
    }


}
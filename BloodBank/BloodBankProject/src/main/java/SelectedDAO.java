import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectedDAO {
    String jdbcURL;
    String jdbcUserName;
    String JdbcPassword;
    Connection jdbcConnection;

    // constructor for DonarConn for connecting the db
    public SelectedDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
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

    public List<Donor> listSelected() throws SQLException {
        List<Donor> donorList = new ArrayList<Donor>();
        String sql = "SELECT * FROM DONOR where blood_group='A+';";
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
}
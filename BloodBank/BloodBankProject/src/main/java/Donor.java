public class Donor {

    private int donor_id;
    private String donor_name;
    private String date;
    private String dob;
    private String gender;
    private String blood_group;
    private String contact_number;
    private String address;
    private String p_word;
    private String confirm_password;

    public Donor(int donor_id, String donor_name, String date, String dob, String gender, String blood_group,
            String contact_number,
            String address, String p_word, String confirm_password) {

        this.donor_id = donor_id;
        this.donor_name = donor_name;
        this.date = date;
        this.dob = dob;
        this.gender = gender;
        this.blood_group = blood_group;
        this.contact_number = contact_number;
        this.address = address;
        this.p_word = p_word;
        this.confirm_password = confirm_password;
    }

    public Donor() {

    }

    public int getDonor_id() {
        return donor_id;
    }

    public void setDonor_id(int donor_id) {
        this.donor_id = donor_id;
    }

    public String getDonor_name() {
        return donor_name;
    }

    public void setDonor_name(String donor_name) {
        this.donor_name = donor_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getP_word() {
        return p_word;
    }

    public void setP_word(String p_word) {
        this.p_word = p_word;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
}
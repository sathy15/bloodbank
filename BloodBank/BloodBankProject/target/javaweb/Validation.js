function validationLogIn() {
    var Uname = document.getElementById("Uname").value;
    var Pass = document.getElementById("Pass").value;
    if (Uname == "") {
        alert("Username is empty");
        return false;
    }
    if (Pass == "") {
        alert("Password is empty");
        return false;
    }
}

function userValidation(){

    var donar_name = document.getElementById("donar_name").value;
    var date = document.getElementById("date").value;
    var contact_number = document.getElementById("contact_number").value;
    if (donar_name == "") {
        alert("DonarNmae is empty");
        return false;
    }
    if (date == "") {
        alert("Select the date ");
        return false;
    }
    if (contact_number == "") {
        alert("Phone no is empty");
        return false;
    }
    else {
        alert("Successfully Registered");
    }
}

function ValidationSignIn(){

    var donor_id = document.getElementById("donor_id").value;
    var donar_name = document.getElementById("donar_name").value;
    var date = document.getElementById("date").value;
    var dob = document.getElementById("dob").value;
    var gender = document.getElementById("gender").value;
    var blood_group = document.getElementById("blood_group").value;
    var contact_number = document.getElementById("contact_number").value;
    var address = document.getElementById("address").value;
    var password = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm_password").value;

    if (donor_id == "") {
        alert("DonarId is empty");
        return false;
    }
    if (donar_name == "") {
        alert("Donarname is empty");
        return false;
    }
    if (date == "") {
        alert("Select the date ");
        return false;
    }
    if (dob == "") {
        alert("select the dob");
        return false;
    }
    if (gender == "") {
        alert("select the gender");
        return false;
    }
    if (blood_group == "") {
        alert("Select the blood_group ");
        return false;
    }
    if (contact_number == "") {
        alert("Ph No is empty");
        return false;
    }
    if (address == "") {
        alert("address is empty");
        return false;
    }
    if (password == "") {
        alert("password is empty");
        return false;
    }
    if (confirm_password == "") {
        alert("confirm password is empty");
        return false;
    }
    if (password != confirm_password) {
        alert("password is empty");
        return false;
    }
    else {
        alert("Successfully Registered");
    }
}


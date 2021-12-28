function getalldonarlist() {
    alert("Showing your data......!");

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            _displayItems(JSON.parse(xhttp.responseText));
            console.log(xhttp.responseText);
        }
    };
    xhttp.open("GET", "http://localhost:9090/donorlist", true);
    xhttp.send();
}

function getBlood() {
    alert("Showing your data....!");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            _displayItems(JSON.parse(xhttp.responseText));
            console.log(xhttp.responseText);
        }
    };
    xhttp.open("GET", "http://localhost:9090/donorlist1", true);
    xhttp.send();
}


function _displayItems(data) {
    const tBody = document.getElementById("result");
    tBody.innerHTML = "";
    const button = document.createElement("button");
    data.forEach((item) => {

        let editButton = button.cloneNode(false);
        editButton.innerText = "Edit";
        editButton.setAttribute("onclick", `editItem(${item.donar_id})`);

        let deleteButton = button.cloneNode(false);
        deleteButton.innerText = "Delete";
        deleteButton.setAttribute("onclick", `deleteItem(${item.donor_id})`);

        let tr = tBody.insertRow();

        let td1 = tr.insertCell(0);
        let don_id = document.createTextNode(item.donor_id);
        td1.appendChild(don_id);

        let td2 = tr.insertCell(1);
        let don_name = document.createTextNode(item.donor_name);
        td2.appendChild(don_name);

        let td3 = tr.insertCell(2);
        let date = document.createTextNode(item.date);
        td3.appendChild(date);

        let td4 = tr.insertCell(3);
        let don_dob = document.createTextNode(item.dob);
        td4.appendChild(don_dob);

        let td5 = tr.insertCell(4);
        let don_gender = document.createTextNode(item.gender);
        td5.appendChild(don_gender);

        let td6 = tr.insertCell(5);
        let don_bloodgroup = document.createTextNode(item.blood_group);
        td6.appendChild(don_bloodgroup);

        let td7 = tr.insertCell(6);
        let don_contno = document.createTextNode(item.contact_number);
        td7.appendChild(don_contno);

        let td8 = tr.insertCell(7);
        let don_addr = document.createTextNode(item.address);
        td8.appendChild(don_addr);

        let td9 = tr.insertCell(8);
        let don_pwd = document.createTextNode(item.p_word);
        td9.appendChild(don_pwd);

        let td10 = tr.insertCell(9);
        let don_conpwd = document.createTextNode(item.confirm_password);
        td10.appendChild(don_conpwd);

        let td11 = tr.insertCell(10);
        td11.appendChild(editButton);

        let td12 = tr.insertCell(11);
        td12.appendChild(deleteButton);
    });
    result = data;
}


function Adding() {
    alert("Registered Successfully");

    const newdonars = {
        donor_id: document.getElementById("donor_id").value,
        donor_name: document.getElementById("donor_name").value,
        date: document.getElementById("date").value,
        dob: document.getElementById("dob").value,
        gender: document.getElementById("gender").value,
        blood_group: document.getElementById("blood_group").value,
        contact_number: document.getElementById("contact_number").value,
        address: document.getElementById("address").value,
        p_word: document.getElementById("password").value,
        confirm_password: document.getElementById("confirm_password").value
    };

    console.log(newdonars);
    //creating xttp var
    var xhttp = new XMLHttpRequest();
    //calling post method
    xhttp.open("POST", "http://localhost:9090/donorlist", true);
    //definding the type of data is transfered
    xhttp.setRequestHeader("Content-type", "application/json");
    //  getuserdetails();
    xhttp.send(JSON.stringify(newdonars));
}

function deleteItem(id) {
    console.log(id)
    const item = {
        donor_id: id
    };
    console.log(item);
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "/donorlist", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(item));
    getalldonarlist();
}; 
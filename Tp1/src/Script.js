function appendActions(row, id) {

    const td1 = document.createElement("td");
    const viewImage = document.createElement("img");
    viewImage.width = 20;
    viewImage.src = "./images/view.png";
    viewImage.alt = "View";
    viewImage.onclick = () => viewPerson(id);
    td1.appendChild(viewImage);

    const td2 = document.createElement("td");
    const editImage = document.createElement("img");
    editImage.width = 20;
    editImage.src = "./images/edit.png";
    editImage.alt = "Edit";
    editImage.onclick = () => openEditDialog(id);
    td2.appendChild(editImage);

    const td3 = document.createElement("td");
    const deleteImage = document.createElement("img");
    deleteImage.width = 20;
    deleteImage.src = "./images/delete.jpg";
    deleteImage.alt = "Delete";
    deleteImage.onclick = () => deletePerson(id);
    td3.appendChild(deleteImage);

    row.appendChild(td1);
    row.appendChild(td2);
    row.appendChild(td3);
}

function createPersonRow(person) {
    const row = document.createElement("tr");
    const name = document.createElement("td");
    name.innerText = person.firstname;
    const lastName = document.createElement("td");
    lastName.innerText = person.lastname;
    const mail = document.createElement("td");
    mail.innerText = person.mail;
    const phone = document.createElement("td");
    phone.innerText = person.phone;

    row.appendChild(name);
    row.appendChild(lastName);
    row.appendChild(mail);
    row.appendChild(phone);
    return row;
}

const getPersons = () => {
    document.addEventListener("DOMContentLoaded", (() => {
        const request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if (request.readyState === XMLHttpRequest.DONE) {
            document.getElementById("persons-table").setAttribute("style", undefined);
            const persons = JSON.parse(request.responseText).payload.items;
            const table = document.getElementById("person-information-table");
            console.log(table)
            for (let i = 0; i < persons.length; i++) {
                const row = createPersonRow(persons[i]);
                appendActions(row, persons[i].id);
                console.log(row)
                table.appendChild(row)
            }
        }
    };
    request.open('GET', "http://dpoi2012api.appspot.com/api/1.0/list?credential=nfox", true);
    request.send(null);
}));
};

const persons = getPersons();

const createPerson = (e) => {
    e.preventDefault();
    const firstname = document.getElementById("name").value;
    const lastname = document.getElementById("lastname").value;
    const mail = document.getElementById("mail").value;
    const phone = document.getElementById("phone").value;
    const birthday = document.getElementById("birthday").value;
    const civilStatus = document.querySelector('input[name="civil-status"]:checked').value;
    const province = document.getElementById("prov").value;
    const street = document.getElementById("street").value;
    const zipCode = document.getElementById("zipcode").value;


    const request = new XMLHttpRequest();
    request.open('POST', `http://dpoi2012api.appspot.com/api/1.0/create?credential=nfox&firstname=${firstname}&lastname=${lastname}&mail=${mail}&phone=${phone}&birthday=${birthday}&civilStatus=${civilStatus}&province=${province}&street=${street}&zipCode=${zipCode}`, true);
    request.onload = () => {
        const response = JSON.parse(request.responseText);
        if(response.status.code === 5){
            const id = response.payload.id;
            let table = document.getElementById("person-information-table");
            const row = createPersonRow({firstname, lastname, mail, phone});
            appendActions(row, id);
            table.appendChild(row);
            alert("Persona Creada!");
        }
    };
    request.send(null);
};

const viewPerson = (id) => {
    const request = new XMLHttpRequest();
    request.open('POST', `http://dpoi2012api.appspot.com/api/1.0/view?credential=nfox&id=${id}`, true);
    request.onload = () => {
        const response = JSON.parse(request.responseText);
        if(response.status.code === 1){
            _openViewDialog();

            const person = response.payload;
            document.getElementById("view-name").value = person.firstname;
            document.getElementById("view-lastname").value = person.lastname;
            document.getElementById("view-mail").value = person.mail;
            document.getElementById("view-phone").value = person.phone;
            document.getElementById("view-birthday").value = person.birthday;
            switch (person.civilStatus) {
                case "married":
                    document.getElementById("view-married").checked = true;
                    break;
                case "single":
                    document.getElementById("view-single").checked = true;
                    break;
                case "other":
                    document.getElementById("view-other").checked = true;
                    break;
            }
            document.getElementById("view-street").value = person.street;
            document.getElementById("view-prov").value = person.province;
            document.getElementById("view-zipcode").value = person.zipCode;

        }
    };
    request.send(null);
};

const openEditDialog = (id) => {
    const request = new XMLHttpRequest();
    request.open('POST', `http://dpoi2012api.appspot.com/api/1.0/view?credential=nfox&id=${id}`, true);
    request.onload = () => {
        const response = JSON.parse(request.responseText);
        if(response.status.code === 1){
            _openEditDialog();
            const person = response.payload;
            document.getElementById("edit-name").value = person.firstname;
            document.getElementById("edit-lastname").value = person.lastname;
            document.getElementById("edit-mail").value = person.mail;
            document.getElementById("edit-phone").value = person.phone;
            document.getElementById("edit-birthday").value = person.birthday;
            switch (person.civilStatus) {
                case "married":
                    document.getElementById("edit-married").checked = true;
                    break;
                case "single":
                    document.getElementById("edit-single").checked = true;
                    break;
                case "other":
                    document.getElementById("edit-other").checked = true;
                    break;
            }
            document.getElementById("edit-street").value = person.street;
            document.getElementById("edit-prov").value = person.province;
            document.getElementById("edit-zipcode").value = person.zipCode;
        }
    };
    request.send(null);
};

const _openViewDialog = () => {
    document.getElementById("view-person-dialog").open = true;
};

const _openEditDialog = () => {
    document.getElementById("edit-person-dialog").open = true;
};

const editPerson = (e) => {
    e.preventDefault();
    const firstname = document.getElementById("edit-name").value;
    const lastname = document.getElementById("edit-lastname").value;
    const mail = document.getElementById("edit-mail").value;
    const phone = document.getElementById("edit-phone").value;
    const birthday = document.getElementById("edit-birthday").value;
    const civilStatus = document.querySelector('input[name="civil-status"]:checked').value;
    const province = document.getElementById("edit-prov").value;
    const street = document.getElementById("edit-street").value;
    const zipCode = document.getElementById("edit-zipcode").value;


    const request = new XMLHttpRequest();
    request.open('POST', `http://dpoi2012api.appspot.com/api/1.0/update?credential=nfox&id=${id}&firstname=${firstname}&lastname=${lastname}&mail=${mail}&phone=${phone}&birthday=${birthday}&civilStatus=${civilStatus}&province=${province}&street=${street}&zipCode=${zipCode}`, true);
    request.onload = () => {
        const response = JSON.parse(request.responseText);
        if(response.status.code === 6){
            alert("Persona modifcada!");
            window['edit-person-dialog'].close()
        }
    };
    request.send(null);
};

const deletePerson = (id) => {
    const request = new XMLHttpRequest();
    request.open('POST', `http://dpoi2012api.appspot.com/api/1.0/delete?credential=nfox&id=${id}`, true);
    request.onload = () => {
        const response = JSON.parse(request.responseText);
        if(response.status.code === 6){
            alert("Persona Eliminada!")
            window.location.reload();
        }
    };
    request.send(null);
};

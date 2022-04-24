sendData = () => {

    let result = document.querySelector('.result');
    let firstname = document.querySelector('#firstname');
    let lastname = document.querySelector('#lastname');
    let address = document.querySelector('#address');
    let courses = document.querySelector('#courses');
    let points = document.querySelector('#points');
    let classname = document.querySelector('#classname');

    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8900/students";

    xhr.open("POST", url,true);

    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200){
            result.innerHTML = this.responseText;
        }
    };

    let data =JSON.stringify({
        "studentFirstName": firstname.value,
        "studentLastName": lastname.value,
        "studentAddress": address.value,
        "coursesAccomplished": courses.value,
        "className": classname.value,
        "studentPoints": points.value
    });
    xhr.send(data);
}
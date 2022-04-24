const fetchButton = document.getElementById("updatebutton");
const tableBody = document.getElementById("tablebody");

const aSyncFunction = async () => {
    console.log("Inside async");

    const response = await fetch(
        '/students'
    );
    console.log("response", response);

    const data = await response.json();
    console.log("Data", data);

    tableBody.textContent = "";

    data.forEach((valueData, index) => {
        const row = document.createElement("tr");

        const studentArray = [
            index+1,
            valueData.studentId,
            valueData.studentFirstName,
            valueData.studentLastName,
            valueData.studentAddress,
            valueData.coursesAccomplished,
            valueData.studentPoints,
            valueData.className
        ]

        console.log("StudentArray", studentArray);

        for (const value of studentArray) {
            const cell = document.createElement("td");
            const celltext = document.createTextNode((value));
            cell.appendChild(celltext);
            row.appendChild(cell);
            tableBody.appendChild(row);
        }
    });
}

const aFunc = async (value) => {
    console.log("Inside async");
    const response = await fetch ('/students/'+ value);
    console.log("Response:", response);
    const data = await response.json();
    console.log("Data:",data);

    console.log(data.studentFirstName);
    console.log(data.studentLastName);

    document.getElementById('firstname').value = data.studentFirstName;
    document.getElementById('lastname').value = data.studentLastName;
    document.getElementById('address').value = data.studentAddress;
    document.getElementById('courses').value = data.coursesAccomplished;
    document.getElementById('points').value = data.studentPoints;
    document.getElementById('classname').value = data.className;
};

fetchStudent = () => {
    let updateStudent = document.querySelector('#updateStudent')
    let value = Number(updateStudent.value);
    console.log("UpdateStudent", value);
    aFunc(value);

};

saveData = ()  =>{
    let result = document.querySelector('.result');
    let id = document.querySelector('#updateStudent');
    id = Number(id.value);
    let firstname = document.querySelector('#firstname');
    let lastname = document.querySelector('#lastname');
    let address = document.querySelector('#address');
    let courses = document.querySelector('#courses');
    let points = document.querySelector('#points');
    let classname = document.querySelector('#classname');

    let xhr = new XMLHttpRequest();
    let url = "/students/" + id;

    xhr.open('PUT',url,true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200){
            result.innerHTML = this.responseText;
        }};

    let data = JSON.stringify({
        "studentFirstName": firstname.value,
        "studentLastName": lastname.value,
        "studentAddress": address.value,
        "coursesAccomplished": courses.value,
        "className": classname.value,
        "studentPoints": points.value
    })
    xhr.send(data);
};


fetchButton.addEventListener('click', () => {
    console.log("Pressed button");
    aSyncFunction();
});






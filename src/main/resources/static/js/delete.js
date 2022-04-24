const fetchButton = document.getElementById("deletebutton");
const tableBody = document.getElementById("tablebody");

const aSyncFunction = async () => {
    console.log("Inside async");

    const response = await fetch(
        'http://localhost:8900/students'
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

deleteStudent = () => {
    let result = document.querySelector('.result');
    let deleteStudent = document.querySelector('#deleteStudent');
    let value = Number(deleteStudent.value);
    console.log("StudentID", value);
    let xhr = new XMLHttpRequest();
    let url = 'http://localhost:8900/students/' + value;
    console.log("Url:", url);
    xhr.open("DELETE", url, true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200){
            result.innerHTML = this.responseText;
        }
    };
    xhr.send();

}

fetchButton.addEventListener('click', () => {
    console.log("Pressed button");
    aSyncFunction();
});


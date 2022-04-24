const listButton = document.getElementById('studentbutton');
const tableBody = document.getElementById("tablebody");

const aSyncFunction = async (students) => {
    console.log("Inside async");

    const response = await fetch(
        'http://localhost:8900/students'
    );
    console.log("response", response);

    const data = await response.json();
    console.log("Data", data);

    tableBody.textContent = "";

    data.slice(0,students).forEach((valueData, index) => {
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

listButton.addEventListener('click', () => {
    console.log("Pressed button");
    const studentValue = studentform.amount.value;
    aSyncFunction(studentValue);
});
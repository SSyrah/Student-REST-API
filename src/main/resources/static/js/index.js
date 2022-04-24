let time = setInterval(timeFunction, 1000);

function timeFunction() {
    let today = new Date();
    let date = today.getFullYear()+'/'+(today.getMonth()+1)+'/'+today.getDate();
    let time = today.getHours()+":"+today.getMinutes()+":"+today.getSeconds();
    let fulltime = date+' '+time;
    // console.log(fulltime);
    document.getElementById("CurrentDate").innerHTML = "Today is: "+ fulltime;
}

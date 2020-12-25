let student_form = document.getElementById('view_students_form');
window.onload = fetch_domains;



student_form.addEventListener('submit', async (e) => {
    // console.log(document.getElementById('domains').value);
    e.preventDefault();
    e.stopPropagation();
    if (student_form.checkValidity() === true) {
        // let response = await fetch('api/domains/studentDetails', {
        //     method: 'POST',
        //     headers: {
        //         'Content-Type': 'application/json;charset=utf-8'
        //     },
        //     body: JSON.stringify({
        //         domain_id: document.getElementById('domains').value
        //     })
        // }).then(
        //     response => {
        //         // if(response['status'] === 203){
        //         //     document.getElementById("login-success").style.display = "none";
        //         //     document.getElementById("login-alert").style.display = "block";
        //         //
        //         // }else{
        //         //     document.getElementById("login-alert").style.display = "none";
        //         //     document.getElementById("login-success").style.display = "block";
        //         //
        //         // }
        //         let students = await response.json();
        //
        //     }
        // );
        let response = await fetch('api/domains/studentsDetails', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                domain_id: document.getElementById('domains').value
            })
        });
        if (response.ok) { // if HTTP-status is 200-299
                           // get the response body (the method explained below)
            let data = await response.json();
            // console.log(json.length);
            $('#tbody').html("");
            $.each(data, function (index, item) {
                let eachrow = "<tr>"
                    + "<th scope='row'>" + item.student_id + "</th>"
                    + "<td>" + item.first_name + "</td>"
                    + "<td>" + item.last_name + "</td>"
                    + "<td>" + item.email + "</td>"
                    + "</tr>";
                $('#tbody').append(eachrow);
            });
        } else {
            alert("HTTP-Error: " + response.status);
        }
    }else{
        student_form.classList.add('was-validated');
    }
    // console.log(pname);
});








async function fetch_domains(){
    let response = await fetch("api/domains/get");
    let domains = await response.json(); // read response body and parse as JSON
    // console.log(domains[0]);
    // console.log(domains[0]["program"]);
    let domains_option = document.getElementById('domains');
    domains_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<domains.length ; i++){
        domains_option.innerHTML += '<option value="'+domains[i]["domain_id"]+'">'+domains[i]["program"]+'</option>';
    }
}
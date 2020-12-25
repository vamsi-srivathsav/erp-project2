let student_form = document.getElementById('view_students_form');




student_form.addEventListener('submit', async (e) => {
    // console.log(document.getElementById('domains').value);
    e.preventDefault();
    e.stopPropagation();
    if (student_form.checkValidity() === true) {
        let response = await fetch("api/grades/getAllGrades");
        // console.log(domains[0]);
        // console.log(domains[0]["program"]);
        if (response.ok) { // if HTTP-status is 200-299
            // get the response body (the method explained below)
            let data = await response.json();
            // console.log(json.length);
            $('#tbody').html("");
            $.each(data, function (index, item) {
                let eachrow = "<tr>"
                    + "<th scope='row'>" + item.grade_id + "</th>"
                    + "<td>" + item.letter_grade + "</td>"
                    + "<td>" + item.grade_points + "</td>"
                    + "<td>" + item.comment + "</td>"
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




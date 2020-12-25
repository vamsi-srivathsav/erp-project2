let student_form = document.getElementById('add-grade');


student_form.addEventListener('submit', async (e) => {
    console.log(document.getElementById('gletter').value);
    e.preventDefault();
    e.stopPropagation();
    if (student_form.checkValidity() === true) {
        let response = await fetch('api/grades/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                letter_grade: document.getElementById('gletter').value,
                grade_points: document.getElementById('gpoints').value,
                comment: document.getElementById('gcomment').value,
            })
        }).then(
            response => {
                console.log(response['status']);
                if(response['status'] === 203){
                    alert("Grade Details added successfully !!!");
                    location.reload();
                }else{
                    document.getElementById("login-alert").style.display = "none";
                    document.getElementById("login-success").style.display = "block";

                }
            }
        );
    }else{
        student_form.classList.add('was-validated');
    }
    // console.log(pname);
});

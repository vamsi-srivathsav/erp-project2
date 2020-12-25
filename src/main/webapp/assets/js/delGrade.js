let student_form = document.getElementById('del_grade_form');
window.onload = fetch_grades;


student_form.addEventListener('submit', async (e) => {
    // console.log(document.getElementById('newProgram').value);
    e.preventDefault();
    e.stopPropagation();
    if (student_form.checkValidity() === true) {
        let response = await fetch('api/grades/delete', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                grade_id: document.getElementById('grades').value,
            })
        }).then(
            response => {
                if(response['status'] === 200){
                    alert("Grade has been deleted successfully !!!");
                    location.reload();
                }else{
                    alert("Please enter valid grade details !!!");
                    // location.reload();
                }
            }
        );
    }else{
        student_form.classList.add('was-validated');
    }
    // console.log(pname);
});




async function fetch_grades(){
    let response = await fetch("api/grades/getAllGrades");
    let grades = await response.json(); // read response body and parse as JSON
    // console.log(domains[0]);
    // console.log(domains[0]["program"]);
    let grades_option = document.getElementById('grades');
    grades_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<grades.length ; i++){
        let gLetter = grades[i]["letter_grade"];
        // let curCapacity = domains[i]["capacity"];
        // let curBatch = domains[i]["batch"];
        // let curOption = curProgram + " [ BATCH: " + curBatch + "] " + " [ CAPACITY" + curCapacity +"] ";
        // alert("dfd");
        grades_option.innerHTML += '<option value="'+grades[i]["grade_id"]+'">'+gLetter+'</option>';
    }
}
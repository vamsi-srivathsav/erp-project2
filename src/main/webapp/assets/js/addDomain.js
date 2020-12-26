let student_form = document.getElementById('add-domain');


student_form.addEventListener('submit', async (e) => {
    console.log(document.getElementById('pname').value);
    e.preventDefault();
    e.stopPropagation();
    if (student_form.checkValidity() === true) {
        let response = await fetch('api/domains/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                program: document.getElementById('pname').value,
                batch: document.getElementById('batch').value,
                capacity: document.getElementById('capacity').value,
                qualification: document.getElementById('qual').value,

            })
        }).then(
            response => {
                if(response['status'] === 200){
                    alert("Domain Details added successfully !!!");
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

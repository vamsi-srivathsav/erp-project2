let student_form = document.getElementById('mod_domain_form');
window.onload = fetch_domains;


student_form.addEventListener('submit', async (e) => {
    // console.log(document.getElementById('newProgram').value);
    e.preventDefault();
    e.stopPropagation();
    if (student_form.checkValidity() === true) {
        let response = await fetch('api/domains/modify', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                domain_id: document.getElementById('domains').value,
                program: document.getElementById('newProgram').value,
                batch: document.getElementById('newBatch').value,
                capacity: document.getElementById('newBatchCapacity').value,
                qualification: document.getElementById('newQualification').value,

            })
        }).then(
            response => {
                // console.log(response);
                if(response['status'] === 200){
                    alert("Domain Details updated successfully !!!");
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




async function fetch_domains(){
    let response = await fetch("api/domains/get");
    let domains = await response.json(); // read response body and parse as JSON
    // console.log(domains[0]);
    // console.log(domains[0]["program"]);
    let domains_option = document.getElementById('domains');
    domains_option.innerHTML = '<option value=""> Choose...</option>';

    for(let i = 0 ; i<domains.length ; i++){
        let curProgram = domains[i]["program"];
        let curCapacity = domains[i]["capacity"];
        let curBatch = domains[i]["batch"];
        let curOption = curProgram + " [ BATCH: " + curBatch + "] " + " [ CAPACITY" + curCapacity +"] ";
        // alert("dfd");
        domains_option.innerHTML += '<option value="'+domains[i]["domain_id"]+'">'+curOption+'</option>';
    }
}
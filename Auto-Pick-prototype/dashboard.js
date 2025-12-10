
function menuBtn(contentDiv){
    const mainContentDiv = document.querySelector('.main-content');
    const childMainDivs = mainContentDiv.querySelectorAll(':scope > div');
    console.log(childMainDivs);
    const currentDiv = document.getElementById(contentDiv);
    childMainDivs.forEach(element => {
        element.style.display = 'none'
    });
    if (contentDiv === 'add-new-car'){
        document.getElementById('add-vehicle-form').reset();
        saveFormBtn = document.getElementById('save-form-btn');
        saveFormBtn.textContent = "Add New Vehicle";
        formHeading = document.getElementById('form-heading');
        formHeading.textContent = "Add Vehicle";
    }
    currentDiv.style.display = 'block'
}





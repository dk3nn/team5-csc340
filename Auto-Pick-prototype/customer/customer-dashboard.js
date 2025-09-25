function menuBtn(contentDiv){
    const mainContentDiv = document.querySelector('#content');
    const childMainDivs = mainContentDiv.querySelectorAll(':scope > div');
    const currentDiv = document.getElementById(contentDiv);
    childMainDivs.forEach(element => {
        element.style.display = 'none'
    });
    currentDiv.style.display = 'block'
}
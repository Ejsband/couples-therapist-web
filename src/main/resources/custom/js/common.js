// ---------------------------------------------------------------------------------------------------------------------  Copyright

document.querySelector('.footer-wrapper-copyright').innerHTML = '&#169; ' + new Date().getFullYear() + ' - Все права защищены';

// ---------------------------------------------------------------------------------------------------------------------  Show/Hide Functions

function showElement(className, cssDisplayProperty, cssAnimationProperty) {
    let name = document.querySelector(className);
    name.style.display = cssDisplayProperty;
    name.style.animation = cssAnimationProperty;
}

function hideElement(className, cssAnimationProperty, cssDisplayProperty, timeoutInMillis) {
    let name = document.querySelector(className);
    name.style.animation = cssAnimationProperty;
    setTimeout(() => { name.style.display = cssDisplayProperty;}, timeoutInMillis);
}
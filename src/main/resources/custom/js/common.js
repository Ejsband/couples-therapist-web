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

// ---------------------------------------------------------------------------------------------------------------------  Restrict Input Symbols Amount

function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
        limitField.value = limitField.value.substring(0, limitNum);
    }
}

// ---------------------------------------------------------------------------------------------------------------------  Restrict e-+ Symbols in Input

document.querySelector('.popUpThree-form-phone-container-right-input').addEventListener("keypress", function (evt) {
    if (evt.which !== 8 && evt.which !== 0 && evt.which < 48 || evt.which > 57)
    {
        evt.preventDefault();
    }
});

document.querySelector('.popUpThree-form-email-container-right-input').addEventListener("keypress", function (email) {
    return String(email)
        .toLowerCase()
        .match(
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        );
});

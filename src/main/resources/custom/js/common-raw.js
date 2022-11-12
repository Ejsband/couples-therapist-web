document.querySelector('.footer-wrapper-copyright').innerHTML = '&#169; ' + new Date().getFullYear() + ' - Все права защищены';

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

function clearFormFields() {
    document.getElementById('formName').value = '';
    document.getElementById('formPhone').value = '';
    document.getElementById('formEmail').value = '';
    document.getElementById('formText').value = '';
    document.getElementById('result').value = '';
    document.querySelector('.popUpThree-form-name-container-left').style.color = 'var(--textColorOne)';
    document.querySelector('.popUpThree-form-phone-container-left').style.color = 'var(--textColorOne)';
    document.querySelector('.popUpThree-form-email-container-left').style.color = 'var(--textColorOne)';
    document.querySelector('.popUpThree-form-protection-input').style.border = 'solid 1px var(--textColorOne)';
}

function limitText(limitField, limitNumber) {
    if (limitField.value.length > limitNumber) {
        limitField.value = limitField.value.substring(0, limitNumber);
    }
}

document.getElementById('formName').addEventListener('check', () => {
    return /[A-Za-zА-Яа-яЁё\s]/i
})

function checkCaptcha() {
    let result = document.getElementById('result').value;
    let number = document.getElementById('number').value;

    if (result === number) {
        return true;
    } else {
        document.querySelector('.popUpThree-form-protection-input').style.border = 'solid 1px var(--textColorThree)';
        return  false;
    }
}

function sendForm() {

    if (checkCaptcha() === false) {

    } else {
        document.getElementById("value").value = "correct";

        let nameInput = document.querySelector('.popUpThree-form-name-container-right-input');
        let nameText = document.querySelector('.popUpThree-form-name-container-left');
        let phoneInput = document.querySelector('.popUpThree-form-phone-container-right-input');
        let phoneText = document.querySelector('.popUpThree-form-phone-container-left');
        let emailInput = document.querySelector('.popUpThree-form-email-container-right-input');
        let emailText = document.querySelector('.popUpThree-form-email-container-left');

        let nameFlag = false;
        let phoneFlag = false;
        let emailFlag = false;

        if (nameInput.value === '') {
            nameText.style.color = 'var(--textColorThree)';
        } else {
            nameText.style.color = 'var(--textColorOne)';
            nameFlag = true;
        }

        if (phoneInput.value === '' || phoneInput.value.length < 7) {
            phoneText.style.color = 'var(--textColorThree)';
        } else {
            phoneText.style.color = 'var(--textColorOne)';
            phoneFlag = true;
        }

        if (emailInput.value === '' || !emailInput.value.toLowerCase().match(
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})|(([a-zA-Z\-\d]+\.)+[a-zA-Z]{2,}))$/
        )) {
            emailText.style.color = 'var(--textColorThree)';
        } else {
            emailText.style.color = 'var(--textColorOne)';
            emailFlag = true;
        }

        if (nameFlag === true && phoneFlag === true && emailFlag === true) {
            let request = fetch('/appeal', {method: 'POST', body: new FormData(document.querySelector('.popUpThree-form-form'))});
            hideElement('.popUpThree', 'closePopUp 0.4s ease', 'none', 380);
            clearFormFields();
        }
    }
}

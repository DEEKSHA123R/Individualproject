
function store() {
    debugger;
    var usernameEmail = document.getElementById('email');
    var Pass = document.getElementById('pass'); 
    localStorage.setItem('email', usernameEmail.value);
    localStorage.setItem('password', Pass.value);
    var displayStatus = document.getElementById("Error-Message");
     displayStatus.style.display = 'none'; 
     var displayStatus = document.getElementById("Message");
     displayStatus.style.display = 'block';
     setTimeout(NavigateMethod,0);
    
}
function NavigateMethod()
{
    window.location.href="student.html";  
}
function validateInfo() {
    debugger;
    var password = document.getElementById('pass');
    var ConfirmPassword = document.getElementById('con');
    if(password.value == ConfirmPassword.value) {
        store();
    }else {
        var displayStatus = document.getElementById("Error-Message");
       displayStatus.style.display = 'block'; 
    }
}

function validateCredential() {    
    var storedEmail = localStorage.getItem('email');
    var storedPw = localStorage.getItem('password');

  
    var userName = document.getElementById('e-mail');
    var userPw = document.getElementById('pass-id');

   
    if(userName.value == storedEmail && userPw.value == storedPw) {
        var displayStatus = document.getElementById("ErrorMessage");
        displayStatus.style.display = 'none'; 
        var displayStatus = document.getElementById("LoginMessage");
        displayStatus.style.display = 'block';
        setTimeout(NavigateCartMethod,0);

    }else {
        var displayStatus = document.getElementById("ErrorMessage");
        displayStatus.style.display = 'block';
    }
}
function NavigateCartMethod()
{
    window.location.href = "cart2.html"; 
}
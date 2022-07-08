function validate(){
    var storedEmail = localStorage.getItem('email');
     var storedPw = localStorage.getItem('password');
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    if(username.value == storedEmail && password.value == storedPw) {
        var displayStatus = document.getElementById("ErrorMessage");
            displayStatus.style.display = 'none'; 
            var displayStatus = document.getElementById("LoginMessage");
            displayStatus.style.display = 'block';
            setTimeout(NavigateCartMethod,3500);
    
        }else {
            var displayStatus = document.getElementById("ErrorMessage");
            displayStatus.style.display = 'block';
        }
    }
    function NavigateCartMethod()
    {
        window.location.href = "book.html"; 
    }
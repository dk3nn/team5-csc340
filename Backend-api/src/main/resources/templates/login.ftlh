<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/home.css">
    <link rel="stylesheet" href="/login.css">
    <title>Auto-Pick Login</title>
    <style>
        #login-outer-container{
    background-color: #fff;
    width: 100%;
    height: 85%;
    overflow: auto;
    display: flex;
    justify-content: center;
}

#login-container{
    display: flex;
    flex-direction: column;
    gap: 15px;
    width: 50%;
    align-items: center;
    justify-content: space-between;
    padding: 25px;
    margin: 25px 0;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

#login-container button{
    width: 50%;
}

#login-container label input{
   height: 35px;
   padding: 10px;
    font-size: 16px;
    width: 100%;
    border: 1px solid #ccc;
    border-radius: 5px;
}
    </style>
</head>
<body>
    <div id="home-body">
        <div id="navbar">
            <h2 id="name" style="color: #ffffff;">Auto-Pick</h2>
            <div id="navbar-links">
                <a href="/">Home</a>
                <a href="#">About</a>
                <a href="#">Contact</a>
            </div>
        </div>
        <div id="heading">
            <h1 style="text-align: center;">Welcome to Auto-Pick</h1>
            <p style="text-align: center;">Your new car is just a click away</p>
        </div>
        <div id="login-outer-container">
            <div id="login-container">
                <h1>Customer Log In</h1>
                    <form action="customer/login" method="post">
                    <label for="customerUsername" class="form-label">Username</label>
                    <input type="text" class="form-control" id="customerUsername" name="username" required>

                    <label for="customerPassword" class="form-label">Password</label>
                    <input type="password" class="form-control" id="customerPassword" name="password" required>

                  <button type="submit" class="btn btn-primary">Login</button>
               <a href="/customer/signup">Need an account? Sign Up</a>
               <button type="button" onclick="window.location.href='/dealerSignin'">Dealer Log In</button>
            </div>
        </div>

        <div id="footer">
            <p>Copyright 2025</p>
        </div>
    </div>
</body>
</html>

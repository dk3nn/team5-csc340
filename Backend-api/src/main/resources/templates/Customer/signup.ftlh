<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/home.css">
    <link rel="stylesheet" href="/signup.css">
    <title>Auto-Pick Sign Up</title>
    <style>
        #signup-outer-container{
            background-color: #fff;
            width: 100%;
            height: 85%;
            overflow: auto;
            display: flex;
            justify-content: center;
        }

        #signup-container{
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

        #signup-container button{
            width: 50%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        #signup-container button:hover{
            background-color: #0056b3;
        }

        .form-control{
            height: 35px;
            padding: 10px;
            font-size: 16px;
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        .form-label{
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        #signup-container form{
            width: 100%;
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        #signup-container form div{
            width: 100%;
        }

        #signup-container a{
            color: #007bff;
            text-decoration: none;
        }

        #signup-container a:hover{
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div id="home-body">
        <div id="navbar">
            <h2 id="name" style="color: #fff;">Auto-Pick</h2>
            <div id="navbar-links">
                <a href="/">Home</a>
                <a href="#">About</a>
                <a href="#">Contact</a>
            </div>
            <div id="btn-container">
            </div>
        </div>
        <div id="heading">
            <h1 style="text-align: center;">Welcome to Auto-Pick</h1>
            <p style="text-align: center;">Your first step in finding a new car</p>
        </div>
        <div id="signup-outer-container">
            <div id="signup-container">
                <h1>Customer Sign up</h1>
                
                <form action="/customer/signup" method="post">
                    <div>
                        <label for="name" class="form-label">Full Name</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>

                    <div>
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="username" required>
                    </div>

                    <div>
                       <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" required>
                    </div>

                    <div>
                        <label for="phone" class="form-label">Phone Number</label>
                        <input type="tel" class="form-control" id="phone" name="phone" required>
                    </div>

                    <div>
                        <label for="address" class="form-label">Address</label>
                        <input type="text" class="form-control" id="address" name="address" required>
                    </div>

                    <div>
                        <label for="city" class="form-label">City</label>
                        <input type="text" class="form-control" id="city" name="city" required>
                    </div>

                    <div>
                        <label for="state" class="form-label">State</label>
                        <input type="text" class="form-control" id="state" name="state" required>
                    </div>
                     
                    <div>
                        <label for="password" class="form-label">Create Password</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                     
                    <div>
                        <label for="confirmPassword" class="form-label">Re-enter Password</label>
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Sign Up</button>
                </form>
                
                <div>
                    <a href="/login">Already have an account? Log in</a>
                </div>
                <button type="button" onclick="window.location.href='/dealerSignup'">Dealer Sign Up</button>
            </div>
        </div>

        <div id="footer">
            <p>Copyright 2025</p>
        </div>
    </div>
</body>
</html>
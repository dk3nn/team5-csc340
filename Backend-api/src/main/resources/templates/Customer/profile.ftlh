<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Auto-Pick Sign Up</title>
    <style>
        #signup-outer-container {
            background-color: #fff;
            width: 100%;
            height: 85%;
            overflow: auto;
            display: flex;
            justify-content: center;
        }

        #signup-container {
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

        #signup-container button {
            width: 50%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        #signup-container button:hover {
            background-color: #0056b3;
        }

        .form-control {
            height: 35px;
            padding: 10px;
            font-size: 16px;
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        .form-label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        #signup-container form {
            width: 100%;
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        #signup-container form div {
            width: 100%;
        }

        #signup-container a {
            color: #007bff;
            text-decoration: none;
        }

        #signup-container a:hover {
            text-decoration: underline;
        }

        .delete-profile-btn {
            position: absolute;
            top: 20px;
            right: 20px;
            background-color: #dc3545;
            color: white;
            padding: 8px 16px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
            transition: background-color 0.3s;
        }


        .delete-profile-btn:hover {
            background-color: #c82333;
            text-decoration: none;
            color: white;
        }
    </style>
</head>

<body>
    <div id="home-body">
        <div id="navbar">
            <h2 id="name" style="color: #fff;">Auto-Pick</h2>
            <!--<a href="/customer/delete/${customer.cId!}" class="delete-profile-btn"
                onclick="return confirm('Are you sure you want to permanently delete your profile? This action cannot be undone.');">
                Delete Profile
            </a>
            -->
        </div>
        <div id="btn-container">
        </div>
    </div>
    <div id="signup-outer-container">
        <div id="signup-container">
            <h1>Edit Profile</h1>

            <P>Change any information below</P>

            <form action="/customer/profile" method="post">

                <div>
                    <label for="username" class="form-label">Current Username*</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>

                <div>
                    <label for="curretnPassword" class="form-label">Current Password*</label>
                    <input type="password" class="form-control" id="currentPassword" name="currentPassword" required>
                </div>

                <div>
                    <label for="name" class="form-label">Full Name</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>

                <div>
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email">
                </div>

                <div>
                    <label for="phone" class="form-label">Phone Number</label>
                    <input type="tel" class="form-control" id="phone" name="phone">
                </div>

                <div>
                    <label for="address" class="form-label">Address</label>
                    <input type="text" class="form-control" id="address" name="address">
                </div>

                <div>
                    <label for="city" class="form-label">City</label>
                    <input type="text" class="form-control" id="city" name="city">
                </div>

                <div>
                    <label for="state" class="form-label">State</label>
                    <input type="text" class="form-control" id="state" name="state">
                </div>

                <div>
                    <label for="newUsername" class="form-label">New Username</label>
                    <input type="text" class="form-control" id="newUsername" name="newUsername">
                </div>

                <div>
                    <label for="newPassword" class="form-label">New Password</label>
                    <input type="password" class="form-control" id="newPassword" name="newPassword">
                </div>

                <p>*Required</p>

                <button type="submit" class="btn btn-primary">Save changes</button>
            </form>

            <div>
                <a href="/customer/dashboard">Back to dashboard</a>
            </div>
        </div>
    </div>

    <div id="footer">
        <p>Copyright 2025</p>
    </div>
    </div>
</body>

</html>
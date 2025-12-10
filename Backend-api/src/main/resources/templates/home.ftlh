<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="dashboard.css">
    <link rel="stylesheet" href="home.css">
    <script src="samplecardata.js"></script>
    <title>Auto-Pick Home</title>
    <style>
    * {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}


body {
  font-family: Arial, sans-serif;
  display: flex;
  min-height: 100vh;
  background-color: #f4f4f4;
}

button {
  background-color: #2ecc71;
  color: white;
  font-size: 16px;
  padding: 10px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #27ae60;
}

#home-body{
    background-color: #2c3e50;
    width: 100vw;
    height: 100vh;
}

#navbar{
    display: flex;
    flex-direction: row;
    align-content: center;
    align-items: center;
    justify-content: space-between;
    gap: 10px;
}

#navbar h2{
    background-color: inherit;
    margin: 0;
}

#navbar-links{
    display: flex;
    gap: 15px;
    margin-left: 5px;
}

#navbar-links a{
    text-decoration: none;
    list-style: none;
    color: #f4f4f4;
    border-bottom: #14243f;
}
#navbar-links a:hover{
    border-bottom: #fff;
}
#heading{
    display: flex;
    flex-direction: column;
    gap: 10px;
    background-image: url("header_background.jpg");
    background-position: center;
    height: auto;
    max-height: 250px;
    color: #f4f4f4;
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    padding: 10px 0;
}
#search{
    display: flex;
    flex-direction: row;
    justify-content: center;
    gap: 5px;
}

#search input{
    width: 55vw;
}

#outer-container{
    background-color: #fff;
    width: 100%;
    overflow: auto;
}

#footer{
    background-color: #14243f;
    height: 5vh;
    max-height: 55px;
    text-align: center;
    color: #fff;
}
    </style>

</head>

<body>
    <div id="home-body">
        <div id="navbar">
            <h2 id="name">Auto-Pick</h2>
            <div id="navbar-links">
                <a href="/">Home</a>
                <a href="#">About</a>
                <a href="#">Contact</a>
            </div>
            <div id="btn-container">
                <a href="/customer/signup" class="nav-btn">Sign Up</a>
                <a href="/login" class="nav-btn">LogIn</a>
            </div>
        </div>
        <div id="heading">
            <h1 style="text-align: center;">Welcome to Auto-Pick</h1>
            <p style="text-align: center;">Step to finding a new car</p>
            <div id="search">
                <input type="text" placeholder="Enter text here">
                <button id="search">Search</button>
            </div>
        </div>
        <div id="outer-container">
            <div id="car-listings">

            </div>
        </div>

        <div id="footer">
            <p>Copyright 2025</p>
        </div>
    </div>

    <script>
    
    container = document.getElementById('car-listings')
    carInventory.cars.forEach(car => { 
            const card = document.createElement('div');
            card.className = 'car-card';

            const img = document.createElement('img');
            img.src = car.image;
            img.alt = name

            const cardTextArea = document.createElement('div')
            cardTextArea.className = "card-text-area"

            const cardHeading = document.createElement('h3');
            cardHeading.textContent = car.make + " " + car.model + " " + car.trim +" " + car.year;

            const carMilage = document.createElement('p');
            carMilage.innerHTML = "<strong>Milage: </strong>" + car.mileage;

            const carEngineType = document.createElement('p');
            carEngineType.innerHTML = "<strong>Engine Type: </strong>" + car.engineType

            const btnContainer = document.createElement('div')
            btnContainer.className = 'card-btn-container'


            const detailButton = document.createElement('button');
            detailButton.textContent = "View Details";
            detailButton.type ="button";

            btnContainer.append(detailButton);

            container.appendChild(card);
            card.appendChild(img);
            card.appendChild(cardTextArea);
            cardTextArea.appendChild(cardHeading);
            cardTextArea.appendChild(carMilage);
            cardTextArea.appendChild(carEngineType);
            card.appendChild(btnContainer);
             
        });
  </script>
</body>
</html>
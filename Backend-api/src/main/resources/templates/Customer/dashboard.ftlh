<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Auto Dealership Seller Dashboard</title>
  <link rel="stylesheet" href="../dashboard.css">
  <link rel="stylesheet" href="../home.css">
  <script src="../dashboard.js"></script>
  <script src="../samplecardata.js"></script>
  <style>
    body {
      display: flex;
      flex-direction: row;
    }

    .sidebar {
      width: 20vw;
      min-width: 150px;
      background-color: #4c6c8c;
      color: white;
      padding: 20px;
    }

    .sidebar h2 {
      text-align: center;
      margin-bottom: 30px;
    }

    .sidebar ul {
      list-style-type: none;
      padding: 0;
    }

    .sidebar ul li {
      margin: 20px 0;
    }

    .menu-btn {
      text-decoration: none;
      color: white;
      font-size: 18px;
      display: block;
      padding: 10px;
      width: 100%;
      background-color: inherit;
      transition: background-color 0.3s ease;
    }

    .sidebar ul li button:hover {
      background-color: #34495e;
    }

    .main-content {
      flex-grow: 1;
      height: 100vh;
      width: 80vw;
      overflow: auto;
      scroll-behavior: smooth;
      padding: 30px;
      padding-top: 5px;
    }

    .header h1,
    h2 {
      text-align: center;
      margin-bottom: 20px;
      background-color: #030f1b;
      color: #fff;
      border-radius: 5px;
    }


    h2 {
      font-size: 24px;
      margin-bottom: 10px;
    }

    p {
      font-size: 18px;
      color: #7f8c8d;
    }

    form {
      display: grid;
      gap: 15px;
      max-width: 600px;
      margin: 0 auto;
    }

    label {
      font-size: 16px;
    }

    input,
    textarea {
      padding: 10px;
      font-size: 16px;
      width: 100%;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    textarea {
      resize: vertical;
    }

    #inventory,
    #finance,
    #add-new-car {
      display: none;
    }


    .dashboard-cards {
      display: flex;
      gap: 20px;
      justify-content: space-around;
      flex-wrap: wrap;
      margin-top: 20px;
    }

    .card {
      background-color: #ffffff;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      padding: 20px;
      text-align: center;
      width: 200px;
      transition: transform 0.3s ease;
      flex: 1;
      max-width: 250px;
      min-width: 180px;
    }


    .card:hover {
      transform: translateY(-10px);
    }

    .card h3 {
      font-size: 20px;
      color: #2c3e50;
      margin-bottom: 10px;
    }

    .card p {
      font-size: 24px;
      font-weight: bold;
      color: #16a085;
    }

    #inventory-ribbon {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      padding: 20px;
    }

    #inventory-ribbon label {
      font-size: 16px;
      font-weight: 600;
      margin-bottom: 8px;
      display: flex;
      flex-direction: row;
      align-items: center;
    }

    #inventory-ribbon input {
      padding: 8px 12px;
      font-size: 16px;
      border: 1px solid #ccc;
      border-radius: 4px;
      width: 150px;
    }

    #inventory-ribbon datalist {
      width: 200px;
    }


    #car-listings {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
      gap: 20px;
      padding: 20px;
    }

    .car-card {
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      overflow: hidden;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      transition: transform 0.3s ease-in-out;
      padding: 15px;
    }

    .car-card:hover {
      transform: translateY(-5px);
    }

    .car-card button {
      margin-top: 5px;
      width: auto;
    }

    .card-btn-container {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
    }

    .sell-btn {
      background-color: #a01616;
    }

    .sell-btn:hover {
      background-color: #bc1313;
    }

    .car-card img {
      width: 100%;
      height: auto;
      border-radius: 8px;
    }

    .car-card h3 {
      font-size: 1.25rem;
      margin-top: 10px;
      color: #333;
    }

    .car-card p {
      font-size: 1rem;
      color: #666;
      margin-top: 8px;
    }

    #payment-table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 10px;
      padding: 15px 0;
    }

    #payment-table thead {
      background-color: #2c3e50;
      color: #fff;
    }

    #payment-table td {
      padding: 5px 0;
    }

    #payment-table tr:nth-child(even) {
      background-color: #787676;
    }

    #payment-table tr {
      padding: 0 5px;
    }

    #car-listings-saved {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
    gap: 20px;
    padding: 20px;
}

/* Ensure car cards in saved section look the same as browse */
#saved .car-card {
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    transition: transform 0.3s ease-in-out;
    padding: 15px;
    border: 1px solid #e0e0e0;
}

#saved .car-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
}

#saved .card-body {
    padding: 15px;
}

#saved .card-title {
    font-size: 1.25rem;
    margin-top: 0;
    margin-bottom: 10px;
    color: #333;
    font-weight: 600;
}

#saved .card-text {
    font-size: 1rem;
    color: #666;
    margin-bottom: 8px;
    line-height: 1.4;
}

#saved .btn-primary {
    background-color: #007bff;
    color: white;
    padding: 8px 16px;
    text-decoration: none;
    border-radius: 4px;
    display: inline-block;
    margin-top: 10px;
    transition: background-color 0.3s;
}

#saved .btn-primary:hover {
    background-color: #0056b3;
}

  </style>
</head>

<body>

  <div class="sidebar">
    <ul>
      <li><button onclick="menuBtn('dashboard')" class="menu-btn">Dashboard</button></li>
      <li><button onclick="menuBtn('browse')" class="menu-btn">Browse</button></li>
      <li><button onclick="menuBtn('saved')" class="menu-btn">Saved Vehicles</button></li>
      <li><a href="/customer/logout" class="menu-btn"
          style="display: block; text-decoration: none; color: white;">Logout</a>
    </ul>
  </div>

  <div class="main-content">
    <div id="content">

      <div id="dashboard">
        <div class="header">
          <h1 style="margin-top: 0px;">Auto-Pick Customer Dashboard</h1>
          <p>Welcome, ${customer.name!}</p>
        </div>
        <div class="dashboard-cards">
          <div class="card">
            <h3>Your Profile</h3>
            <p>${customer.username!}</p>
            <a href="/customer/profile">Edit Profile</a>
          </div>
          <div class="card">
            <h3>Available Vehicles</h3>
            <button onclick="menuBtn('browse')">Browse Now</button>
          </div>
          <div class="card">
            <h3>Auto-Pick Purchases</h3>
            <p>0</p>
          </div>
        </div>
      </div>

      <div id="browse">
        <h2>Browse Vehicles</h2>
        <div id="browse-ribbon">
          <label>Search
            <input id="search" type="text" name="inventory-search">
          </label>
          <label>Sort
            <input list="sort-values">
          </label>
          <datalist id="sort-values">
            <option value="New to Old"></option>
            <option value="Old to new"></option>
            <option value="High to low Price"></option>
            <option value="Low to High Price"></option>
          </datalist>
          <label for="filter-values">Filter
            <input list="filter-values">
          </label>
          <datalist id="filter-values">
            <option value="On Hold"></option>
            <option value="Available"></option>
            <option value="All"></option>
          </datalist>
        </div>
        <div id="car-listings">
          <#if vehicles??>
            <#list vehicles as vehicle>
              <div class="car-card">
                <div class="card-body">
                  <h5 class="card-title">${vehicle.name!}</h5>
                  <p class="card-text">${vehicle.make!} ${vehicle.model!}</p>
                  <p class="card-text">${vehicle.year!}</p>
                  <p class="card-text"><strong>Price: $${vehicle.price!}</strong></p>
                  <a href="/customer/vehicles/${vehicle.id}" class="btn-link">View Details</a>
                </div>
              </div>
            </#list>
            <#else>
              <p>No vehicles available</p>
          </#if>
        </div>
      </div>

      <div id="saved">
        <h2>Your Saved Vehicles</h2>
        <div id="car-listings-saved">
          <#if savedVehicles??>
            <#list savedVehicles as savedVehicles>
              <div class="car-card">
                <div class="card-body">
                  <h5 class="card-title">${vehicle.name!}</h5>
                  <p class="card-text">${vehicle.make!} ${vehicle.model!}</p>
                  <p class="card-text">${vehicle.year!}</p>
                  <p class="card-text"><strong>Price: $${vehicle.price!}</strong></p>
                  <a href="/customer/vehicles/${vehicle.id}" class="btn-link">View Details</a>
                </div>
              </div>
            </#list>
          </#if>
        </div>
      </div>

    </div>
  </div>

  <script>
    function menuBtn(contentDiv) {
      const mainContentDiv = document.querySelector('#content');
      const childMainDivs = mainContentDiv.querySelectorAll(':scope > div');
      const currentDiv = document.getElementById(contentDiv);
      childMainDivs.forEach(element => {
        element.style.display = 'none'
      });
      currentDiv.style.display = 'block'
    }


    document.addEventListener('DOMContentLoaded', function () {
      menuBtn('dashboard');
    });
  </script>

</body>

</html>
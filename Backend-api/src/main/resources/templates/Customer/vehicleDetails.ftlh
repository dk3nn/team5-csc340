<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${vehicle.year!} ${vehicle.make!} ${vehicle.model!} - Auto-Pick</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }

        .vehicle-details-container {
            max-width: 1200px;
            margin: 2rem auto;
            padding: 0 1rem;
        }

        .back-button {
            margin-bottom: 1rem;
        }

        .back-button a {
            color: #007bff;
            text-decoration: none;
            font-size: 1.1rem;
        }

        .back-button a:hover {
            text-decoration: underline;
        }

        .vehicle-header {
            background: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 2rem;
        }

        .vehicle-title {
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
            margin-bottom: 1.5rem;
        }

        .vehicle-title h1 {
            margin: 0;
            color: #2c3e50;
            font-size: 2.5rem;
        }

        .vehicle-price {
            font-size: 2rem;
            color: #e74c3c;
            font-weight: bold;
        }

        .vehicle-image {
            width: 100%;
            max-height: 500px;
            object-fit: cover;
            border-radius: 8px;
            margin-bottom: 2rem;
        }

        .vehicle-specs {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 2rem;
            margin-bottom: 2rem;
        }

        .specs-card {
            background: white;
            padding: 1.5rem;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .specs-card h3 {
            color: #2c3e50;
            border-bottom: 2px solid #3498db;
            padding-bottom: 0.5rem;
            margin-top: 0;
        }

        .spec-grid {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 1rem;
        }

        .spec-item {
            display: flex;
            flex-direction: column;
        }

        .spec-label {
            font-weight: bold;
            color: #7f8c8d;
            font-size: 0.9rem;
            margin-bottom: 0.25rem;
        }

        .spec-value {
            color: #2c3e50;
            font-size: 1.1rem;
        }

        .description-section {
            background: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 2rem;
        }

        .description-section h2 {
            color: #2c3e50;
            border-bottom: 2px solid #3498db;
            padding-bottom: 0.5rem;
            margin-top: 0;
        }

        .description-content {
            line-height: 1.6;
            color: #34495e;
            font-size: 1.1rem;
        }

        .no-description {
            color: #7f8c8d;
            font-style: italic;
        }

        .action-buttons {
            display: flex;
            gap: 1rem;
            margin-top: 2rem;
        }

        .btn {
            padding: 0.75rem 1.5rem;
            border: none;
            border-radius: 5px;
            font-size: 1.1rem;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            text-align: center;
        }

        .btn-primary {
            background-color: #3498db;
            color: white;
        }

        .btn-primary:hover {
            background-color: #2980b9;
        }

        .btn-secondary {
            background-color: #95a5a6;
            color: white;
        }

        .btn-secondary:hover {
            background-color: #7f8c8d;
        }

        .btn-success {
            background-color: #27ae60;
            color: white;
        }

        .btn-success:hover {
            background-color: #229954;
        }

        @media (max-width: 768px) {
            .vehicle-title {
                flex-direction: column;
                gap: 1rem;
            }

            .spec-grid {
                grid-template-columns: 1fr;
            }

            .action-buttons {
                flex-direction: column;
            }
        }
    </style>
</head>

<body>
    <div class="vehicle-details-container">

        <div class="vehicle-header">
            <div class="vehicle-title">
                <h1>${vehicle.year!} ${vehicle.make!} ${vehicle.model!}</h1>
                <div class="vehicle-price">$${vehicle.price!}</div>
            </div>

            <#if vehicle.imageUrl?? && vehicle.imageUrl !="">
                <img src="${vehicle.imageUrl}" alt="${vehicle.year!} ${vehicle.make!} ${vehicle.model!}"
                    class="vehicle-image">
                <#else>
                    <div
                        style="background: #ecf0f1; height: 300px; display: flex; align-items: center; justify-content: center; border-radius: 8px; margin-bottom: 2rem;">
                        <p style="color: #7f8c8d; font-size: 1.2rem;">No Image Available</p>
                    </div>
            </#if>

            <div class="vehicle-specs">

                <div class="specs-card">
                    <h3>Vehicle Information</h3>
                    <div class="spec-grid">
                        <div class="spec-item">
                            <h class="spec-label">VIN</h>
                            <h class="spec-value">${vehicle.vin!}</h>
                        </div>
                        <div class="spec-item">
                            <h class="spec-label">Year</h>
                            <h class="spec-value">${vehicle.year!}</h>
                        </div>
                        <div class="spec-item">
                            <h class="spec-label">Make</h>
                            <h class="spec-value">${vehicle.make!}</h>
                        </div>
                        <div class="spec-item">
                            <h class="spec-label">Model</h>
                            <h class="spec-value">${vehicle.model!}</h>
                        </div>
                        <div class="spec-item">
                            <h class="spec-label">Color</h>
                            <h class="spec-value">${vehicle.color!}</h>
                        </div>
                        <div class="spec-item">
                            <h class="spec-label">Mileage</h>
                            <h class="spec-value">${vehicle.mileage!} miles</h>
                        </div>
                    </div>
                </div>

                <div class="specs-card">
                    <h3>Mechanical Specifications</h3>
                    <div class="spec-grid">
                        <div class="spec-item">
                            <h class="spec-label">Transmission</h>
                            <h class="spec-value">${vehicle.transmission!}</h>
                        </div>
                        <div class="spec-item">
                            <h class="spec-label">Fuel Type</h>
                            <h class="spec-value">${vehicle.fuelType!}</h>
                        </div>
                        <div class="spec-item">
                            <h class="spec-label">Engine Size</h>
                            <h class="spec-value">${vehicle.engineSize!}</h>
                        </div>
                        <div class="spec-item">
                            <h class="spec-label">Drive Type</h>
                            <h class="spec-value">${vehicle.driveType!}</h>
                        </div>
                    </div>
                </div>

                <div class="specs-card">
                    <h3>Body & Dimensions</h3>
                    <div class="spec-grid">
                        <div class="spec-item">
                            <h class="spec-label">Body Type</h>
                            <h class="spec-value">${vehicle.bodyType!}</h>
                        </div>
                        <div class="spec-item">
                            <h class="spec-label">Number of Doors</h>
                            <h class="spec-value">${vehicle.numberOfDoors!}</h>
                        </div>
                    </div>
                </div>
                <div class="specs-card">
                    <h3>Pricing</h3>
                    <div class="spec-grid">
                        <div class="spec-item">
                            <h class="spec-label">List Price</h>
                            <h class="spec-value"
                                style="color: #e74c3c; font-weight: bold;">$${vehicle.price!}</h>
                        </div>
                    </div>
                </div>
            </div>

            <div class="description-section">
                <h2>Vehicle Description</h2>
                <div class="description-content">
                    <#if vehicle.description?? && vehicle.description !="">
                        ${vehicle.description!}
                        <#else>
                            <p class="no-description">No description available for this vehicle.</p>
                    </#if>
                </div>
            </div>

            <div class="action-buttons">
                <a href="/customer/vehicles" class="btn btn-secondary">Back to Vehicles</a>
                <a href="/customer/dashboard" class="btn btn-primary">Back to Dashboard</a>
                <button class="btn btn-success">Save Vehicle</button>
                <button class="btn btn-primary">Contact Dealer</button>
            </div>
        </div>
    </div>
</body>

</html>
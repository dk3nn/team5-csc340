carInventory ={
        "cars": [
            {
            "id": "CAR1001",
            "make": "Toyota",
            "model": "Camry",
            "year": 2020,
            "mileage": 34500,
            "engineType": "2.5L I4",
            "fuelType": "Gasoline",
            "transmission": "Automatic",
            "carType": "Sedan",
            "trim": "XSE",
            "drivetrain": "FWD",
            "color": {
                "exterior": "Silver",
                "interior": "Black"
            },
            "vin": "4T1B11HK3LU100001",
            "price": 22500,
            "features": [
                "Leather Seats",
                "Bluetooth",
                "Backup Camera",
                "Apple CarPlay",
                "Adaptive Cruise Control"
            ],
            "image": "data:image/jpeg;base64,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",
            "location": "Los Angeles, CA",
            "dateAdded": "2025-09-20",
            "availability": "In Stock",
            "previousOwners": 1,
            "accidentHistory": "None",
            "serviceHistory": "Full Service History",
            "warranty": {
                "type": "Dealer Warranty",
                "duration": "6 months / 6,000 miles"
            }
            },
            {
            "id": "CAR1002",
            "make": "Honda",
            "model": "Civic",
            "year": 2018,
            "mileage": 58500,
            "engineType": "1.5L Turbo I4",
            "fuelType": "Gasoline",
            "transmission": "Manual",
            "carType": "Coupe",
            "trim": "Sport Touring",
            "drivetrain": "FWD",
            "color": {
                "exterior": "Blue",
                "interior": "Gray"
            },
            "vin": "2HGFC3A59JH100002",
            "price": 16900,
            "features": [
                "Navigation",
                "Heated Seats",
                "Sunroof",
                "Bluetooth",
                "Lane Departure Warning"
            ],
            "image": "https://th.bing.com/th/id/OIP.Pekhm5HosglON-1swp8n-QAAAA?w=248&h=180&c=7&r=0&o=7&dpr=1.5&pid=1.7&rm=3",
            "location": "Houston, TX",
            "dateAdded": "2025-09-15",
            "availability": "Pending Sale",
            "previousOwners": 2,
            "accidentHistory": "Minor cosmetic damage repaired",
            "serviceHistory": "Regular maintenance",
            "warranty": {
                "type": "None",
                "duration": null
            }
            },
            {
            "id": "CAR1003",
            "make": "Ford",
            "model": "F-150",
            "year": 2019,
            "mileage": 74000,
            "engineType": "3.5L V6 EcoBoost",
            "fuelType": "Gasoline",
            "transmission": "Automatic",
            "carType": "Truck",
            "trim": "Lariat",
            "drivetrain": "4WD",
            "color": {
                "exterior": "White",
                "interior": "Black"
            },
            "vin": "1FTFW1E40KKD100003",
            "price": 31900,
            "features": [
                "Tow Package",
                "Remote Start",
                "Blind Spot Monitoring",
                "Heated Seats",
                "Navigation"
            ],
            "image": "https://th.bing.com/th/id/OIP.EYAnIcbJDCS3qsfjul9lZAHaEy?w=295&h=191&c=7&r=0&o=7&dpr=1.5&pid=1.7&rm=3",
            "location": "Phoenix, AZ",
            "dateAdded": "2025-09-10",
            "availability": "In Stock",
            "previousOwners": 1,
            "accidentHistory": "None",
            "serviceHistory": "Dealer Serviced",
            "warranty": {
                "type": "Extended Warranty Available",
                "duration": "Optional"
            }
            },
            {
            "id": "CAR1004",
            "make": "Tesla",
            "model": "Model 3",
            "year": 2021,
            "mileage": 22000,
            "engineType": "Electric",
            "fuelType": "Electric",
            "transmission": "Automatic",
            "carType": "Sedan",
            "trim": "Long Range AWD",
            "drivetrain": "AWD",
            "color": {
                "exterior": "Red",
                "interior": "White"
            },
            "vin": "5YJ3E1EB5MF100004",
            "price": 38900,
            "features": [
                "Autopilot",
                "Glass Roof",
                "Heated Steering Wheel",
                "Over-the-Air Updates",
                "Premium Sound"
            ],
            "image": "https://th.bing.com/th/id/OIP.T-20wMjk5nViAu8lLlU-DgHaFJ?w=247&h=180&c=7&r=0&o=7&dpr=1.5&pid=1.7&rm=3",
            "location": "San Francisco, CA",
            "dateAdded": "2025-09-12",
            "availability": "In Stock",
            "previousOwners": 1,
            "accidentHistory": "None",
            "serviceHistory": "Tesla Certified",
            "warranty": {
                "type": "Manufacturer Warranty",
                "duration": "4 years / 50,000 miles"
            }
            },
            {
            "id": "CAR1005",
            "make": "Chevrolet",
            "model": "Equinox",
            "year": 2022,
            "mileage": 13500,
            "engineType": "1.5L Turbo I4",
            "fuelType": "Gasoline",
            "transmission": "Automatic",
            "carType": "SUV",
            "trim": "LT",
            "drivetrain": "AWD",
            "color": {
                "exterior": "Gray",
                "interior": "Black"
            },
            "vin": "2GNAXUEV0N6100005",
            "price": 23900,
            "features": [
                "Remote Start",
                "Rear Cross Traffic Alert",
                "Apple CarPlay",
                "Backup Camera"
            ],
            "image": "https://th.bing.com/th/id/OIP.XG08cszou1C26R99CgVEqgHaFj?w=227&h=180&c=7&r=0&o=7&dpr=1.5&pid=1.7&rm=3",
            "location": "Denver, CO",
            "dateAdded": "2025-08-28",
            "availability": "In Stock",
            "previousOwners": 1,
            "accidentHistory": "None",
            "serviceHistory": "Certified Pre-Owned",
            "warranty": {
                "type": "CPO Warranty",
                "duration": "12 months / 12,000 miles"
            }
            },
            {
            "id": "CAR1006",
            "make": "BMW",
            "model": "X5",
            "year": 2017,
            "mileage": 80500,
            "engineType": "3.0L I6 Turbo",
            "fuelType": "Gasoline",
            "transmission": "Automatic",
            "carType": "SUV",
            "trim": "xDrive40i",
            "drivetrain": "AWD",
            "color": {
                "exterior": "Black",
                "interior": "Brown"
            },
            "vin": "5UXKR0C58H0X100006",
            "price": 28900,
            "features": [
                "Panoramic Sunroof",
                "Heads-Up Display",
                "Navigation",
                "Heated Front and Rear Seats"
            ],
            "image": "https://th.bing.com/th/id/OIP.yjLx4HjQyuT5QkZWfCdGBQHaE8?w=251&h=180&c=7&r=0&o=7&dpr=1.5&pid=1.7&rm=3",
            "location": "Chicago, IL",
            "dateAdded": "2025-09-01",
            "availability": "In Stock",
            "previousOwners": 2,
            "accidentHistory": "No structural damage",
            "serviceHistory": "Maintained at BMW dealership",
            "warranty": {
                "type": "None",
                "duration": null
            }
            },
            {
            "id": "CAR1007",
            "make": "Hyundai",
            "model": "Elantra",
            "year": 2021,
            "mileage": 31000,
            "engineType": "2.0L I4",
            "fuelType": "Gasoline",
            "transmission": "CVT",
            "carType": "Sedan",
            "trim": "SEL",
            "drivetrain": "FWD",
            "color": {
                "exterior": "White",
                "interior": "Black"
            },
            "vin": "5NPLM4AG7MH100007",
            "price": 17900,
            "features": [
                "Lane Keep Assist",
                "Android Auto",
                "Blind Spot Monitoring",
                "Heated Mirrors"
            ],
            "image": "https://th.bing.com/th/id/OIP.EQIQw2393PsXCYsKUpkR4AHaEK?w=304&h=180&c=7&r=0&o=7&dpr=1.5&pid=1.7&rm=3",
            "location": "Atlanta, GA",
            "dateAdded": "2025-09-05",
            "availability": "In Stock",
            "previousOwners": 1,
            "accidentHistory": "None",
            "serviceHistory": "Clean",
            "warranty": {
                "type": "None",
                "duration": null
            }
        }
    ]
}
     


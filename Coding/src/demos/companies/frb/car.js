let theCar = {
    maker: 'Ford',
    mileage: 0
}

function drive(car, miles) {
    car.mileage += miles;
    return car;
}

let car1 = drive(theCar, 100);
let car2 = drive(theCar, 50);
let car3 = drive(car1, 25);
let car4 = drive(car2, 25);

// All below statements should pring 200
console.log(theCar)
console.log(car1)
console.log(car2)
console.log(car3)
console.log(car4)
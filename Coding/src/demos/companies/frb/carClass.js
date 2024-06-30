class Car {
    constructor(maker, miles) {
        this.maker = maker;
        this.mileage = miles;
    }
}

function drive(car, miles) {
    car.mileage += miles;
    return car;
}

let car1 = new Car('GM', 100);
let car2 = drive(car1, 50);
let car3 = drive(car1, 25);
let car4 = drive(car2, 25);

let car5 = new Car('Ford', 10);
let car6 = drive(car5, 70);

// All below statements should pring 200
console.log(car1)
console.log(car2)
console.log(car3)
console.log(car4)
console.log(car5)
console.log(car6)

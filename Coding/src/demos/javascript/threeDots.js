// Spread operator
let students = ['David', 'Jack', 'Jeff'];
let names = [...students];
console.log(names);

let user = { name: "Jeff", age: 55 };
let copiedUser = { ...user };
console.log(copiedUser); // same as user

// Rest
const multiplyArgs = (multiplier, ...otherArgs) => {
    return otherArgs.map((n) => {
        return n * multiplier;
    });
};
let multipiedArray = multiplyArgs(6, 5, 7, 9);
console.log(multipiedArray); // [30,42,54]

function sum(...args) {
  let sum = 0;
  for (let arg of args) sum += arg;
  return sum;
}
let x = sum(4, 9, 16, 25, 29, 100, 66, 77);
console.log(x);
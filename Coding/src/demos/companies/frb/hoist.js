var num1 = 100;

function print() {
    console.log(num1);      // print undefined, local variable takes priority and it is hoisted and initialized with undefined
    num2 = 60;              // Ok, because of hoisting
    console.log(num2);      // print 60
    var num1 = 50;
    var num2;
    console.log(num4);      // error, variable with let/const is hpisted but not initialized. ReferenceError: Cannot access 'num4' before initialization
    let num4 = 5;
    console.log(num3);      // Error: ReferenceError: num3 is not defined, which is different from above for num4
}

print();
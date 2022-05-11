import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
   num1: number=5;
   num2: number=4;
   result: number=0;
  
  calculate(op: string){
	
	this.opChange(op);
  }
  onchange1(text: string) {
	return this.num1=Number(text);
  }
  onchange2(text: string) {
	return this.num2=Number(text);
  }
  opChange(op: string) {
	switch (op) {
		case "+":
			this.result = this.num1+this.num2;
			this.enableInput2();
			break;
		case "-":
			this.result = this.num1-this.num2;
			this.enableInput2();
			break;
		case "*":
			this.result = this.num1*this.num2;
			this.enableInput2();
			break;
		case "/":
			this.result = this.num1/this.num2;
			this.enableInput2();
			break;
		case "**2":
			this.result = this.num1*this.num1;
			this.disableInput2();
			break;
		case "**":
			this.result = this.num1**this.num2;
			this.enableInput2();
			break;
		case "sqrt":
			this.result = Math.sqrt(this.num1);
			this.disableInput2();
			break;
	}
	
	return this.result;

  }
  private disableInput2(){
	(<HTMLInputElement>document.getElementById("input2")).disabled=true;
  }
  private enableInput2(){
	(<HTMLInputElement>document.getElementById("input2")).disabled=false;
  }
}

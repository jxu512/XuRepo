import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpXhrBackend } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Component({
  selector: 'app-foodcourt',
  templateUrl: './foodcourt.component.html',
  styleUrls: ['./foodcourt.component.css']
})
@Injectable({
  providedIn: 'root'
})
export class FoodcourtComponent implements OnInit {

  response: string="";
  constructor(private httpInjected: HttpClient) { }

  ngOnInit(): void {
  }

  // AJax call with XMLHttpRequest
  getFoodCourt() {
	const xmlHttp = new XMLHttpRequest();
	xmlHttp.onload = function() {
		(<HTMLInputElement>document.getElementById("court")).value=this.responseText;
	}
	
	xmlHttp.open("GET","https://jsonmock.hackerrank.com/api/food_outlets?city=Seattle&page=1");
	xmlHttp.send();

  }
  // Angular http
  getFoodCourtHttp() {
	
	const httpClient = new HttpClient(new HttpXhrBackend({ 
    	build: () => new XMLHttpRequest() 
		}));
    httpClient.get("https://jsonmock.hackerrank.com/api/food_outlets?city=Seattle&page=3")
    	.subscribe((responseBody) => {
		(<HTMLInputElement>document.getElementById("court")).value=JSON.stringify(responseBody);
    });

  }

  // Angular http via Injection
  getFoodCourtHttpInject() {
	
    this.httpInjected.get("https://jsonmock.hackerrank.com/api/food_outlets?city=Seattle&page=2")
    	.subscribe((responseBody) => {
		(<HTMLInputElement>document.getElementById("court")).value=JSON.stringify(responseBody);
    });
  }
  // Local rest api
  sayHello() {
	
	const xmlHttp = new XMLHttpRequest();
	xmlHttp.onload = function() {
		(<HTMLInputElement>document.getElementById("court")).value=this.responseText;
	}
	
	xmlHttp.open("GET","http://xulinux:8080/spring-boot-demo/hello?name=Jeff");
	xmlHttp.send();
  }

}

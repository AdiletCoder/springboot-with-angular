import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HelloWorldBean, WelcomeDataService } from '../service/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  message = 'Some Welcome Message'
  welcomeMessageFromService:string
  name = ''
  

  constructor(
    private route:ActivatedRoute,
    private service:WelcomeDataService) { 
      this.welcomeMessageFromService='' 
    }

  ngOnInit(): void {
   // console.log(this.message)
    this.route.snapshot.params['name']
    this.name = this.route.snapshot.params['name']
    // console.log(this.route.snapshot.params['name'])
  }

  getWelcomeMessage(){
    //console.log(this.service.executeHelloWorldBeanService());
    this.service.executeHelloWorldBeanService().subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
      );

     // console.log('last line of getWelcomeMessage')
  }

  getWelcomeMessageWithParameter(){
    //console.log(this.service.executeHelloWorldBeanService());
    this.service.executeHelloWorldServiceWithPathVariable(this.name).subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
      );

     // console.log('last line of getWelcomeMessage')
  }

  handleSuccessfulResponse(response: HelloWorldBean){
    this.welcomeMessageFromService = response.message
    // console.log(response);
    // console.log(response.message);
  }

  handleErrorResponse(error:HttpErrorResponse){
    //console.log(error)
    //console.log(error.error.message)
    this.welcomeMessageFromService = error.error.message
  }
}

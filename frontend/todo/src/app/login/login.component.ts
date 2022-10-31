import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BasicAuthenticationService } from '../service/basic-authentication.service';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'adik'
  password = ''
  errorMessage = 'invalid credentials'
  invalidLogin = false

  constructor(private router:Router, 
    private hardcodedAuthenticationService: HardcodedAuthenticationService,
    private basicAuthenticationService: BasicAuthenticationService){}

  ngOnInit(): void {
  }

  handleLogin(){
    // console.log(this.username)
     if(this.hardcodedAuthenticationService.authenticate(this.username, this.password)){
      this.router.navigate(['welcome', this.username])
      this.invalidLogin = false
    } else {
      this.invalidLogin = true
    }
  }

  handleBasicAuthLogin(){

     this.basicAuthenticationService.executeAuthenticationService(this.username, this.password)
     .subscribe(
      data => {
        console.log(data)
        this.router.navigate(['welcome', this.username])
      this.invalidLogin = false
      },
      error =>{
        console.log(error)
        this.invalidLogin = true
      }
     ) 
  }

  handleJWTAuthLogin(){

    this.basicAuthenticationService.executeJWTAuthenticationService(this.username, this.password)
    .subscribe(
     data => {
       console.log(data)
       this.router.navigate(['welcome', this.username])
     this.invalidLogin = false
     },
     error =>{
       console.log(error)
       this.invalidLogin = true
     }
    ) 
 }
}

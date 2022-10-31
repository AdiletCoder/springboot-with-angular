import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
  invalidLogin = false

  constructor(private router:Router, public hardcodedAuthenticationService:HardcodedAuthenticationService){}


  ngOnInit(): void {
    this.hardcodedAuthenticationService.logout()
  }

}

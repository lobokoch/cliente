/**********************************************************************************************
Code generated with MKL Plug-in version: 6.0.2
Code generated at time stamp: 2019-06-29T10:11:35.889
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { MessageHandlerService } from 'src/app/core/message-handler.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private auth: AuthService,
    private messageHandler: MessageHandlerService,
    private router: Router
    ) { }

  ngOnInit() {
  }

  login(username: string, password: string) {
    this.auth.login(username, password)
    .then(() => {
      const tenant = this.auth.tenant;
      if (tenant) {
        this.router.navigate(['/mainmenu']);
      } else {
        this.router.navigate(['/confignewaccount']);
      }
    })
    .catch (error => {
      this.messageHandler.showError(error);
    });
  }

}

/**********************************************************************************************
Code generated with MKL Plug-in version: 6.0.2
Code generated at time stamp: 2019-06-29T10:11:35.889
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-kerubin-menu',
  templateUrl: './kerubin-menu.component.html',
  styleUrls: ['./kerubin-menu.component.css']
})
export class KerubinMenuComponent implements OnInit {

  items: MenuItem[];


  constructor() { }

  ngOnInit() {
    this.loadMenu();
  }

  loadMenu() {
    this.items = [

      {
      	label: 'Cadastros',
      	icon: 'pi pi-pw',
      	items: [
      		
      		{
      			label: 'Cliente',
      			icon: 'pi pi-fw ',
      			items: [
      				{ label: 'Cliente', icon: 'pi pi-fw', routerLink: '/cliente' }
      			]
      		}
      		
      	]
      }


    ];
  }

}

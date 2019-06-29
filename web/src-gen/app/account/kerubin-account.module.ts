/**********************************************************************************************
Code generated with MKL Plug-in version: 6.0.2
Code generated at time stamp: 2019-06-29T10:11:35.889
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

// Angular
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

// PrimeMG
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';		

// Kerubin
import { NewAccountComponent } from './newaccount/newaccount.component';
import { ConfirmAccountComponent } from './confirmaccount/confirmaccount.component';
import { ConfigNewAccountComponent } from './confignewaccount/confignewaccount.component';

@NgModule({

  imports: [
    CommonModule,
    FormsModule,
    InputTextModule,
    ButtonModule,
    DropdownModule
  ],

  declarations: [
    ConfigNewAccountComponent,
    ConfirmAccountComponent,
    NewAccountComponent
  ],

  exports: [
    ConfigNewAccountComponent,
    ConfirmAccountComponent,
    NewAccountComponent
  ]

})

export class KerubinAccountModule {  }


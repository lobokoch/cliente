/**********************************************************************************************
Code generated with MKL Plug-in version: 6.0.2
Code generated at time stamp: 2019-06-29T10:11:35.889
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

import { MenuModule } from 'primeng/menu';
import { KerubinMenuComponent } from './kerubin-menu.component';
import { PanelMenuModule } from 'primeng/panelmenu';
import { NgModule } from '@angular/core';

@NgModule({

  imports: [
    PanelMenuModule,
    MenuModule
  ],

  declarations: [
    KerubinMenuComponent
  ],

  exports: [
    KerubinMenuComponent,
    PanelMenuModule,
    MenuModule
  ]

})

export class KerubinMenuModule {  }


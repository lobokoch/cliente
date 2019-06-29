/**********************************************************************************************
Code generated with MKL Plug-in version: 6.0.2
Code generated at time stamp: 2019-06-29T10:11:35.889
Copyright: Kerubin - logokoch@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/

import { NgZone, Directive, AfterContentInit, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appFocus]'
})
export class FocusDirective implements AfterContentInit {

  constructor(
    private el: ElementRef,
    private zone: NgZone,
    private renderer: Renderer2) {}

  ngAfterContentInit(): void {
    this.zone.runOutsideAngular(() => setTimeout(() => {
            this.renderer.selectRootElement(this.el.nativeElement).focus();
        }, 0));
  }

}

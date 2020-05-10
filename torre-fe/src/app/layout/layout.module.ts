import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';

@NgModule({
    declarations: [
    ],
    imports: [
      CommonModule,
      RouterModule
    ],
    providers: [],
    exports: [
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
  })
  export class LayoutModule { }

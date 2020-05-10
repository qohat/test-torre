import {CommonModule} from '@angular/common';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule, MatCardModule, MatIconModule, MatInputModule, MatToolbarModule} from '@angular/material';
import {HomeComponent} from './home.component';
import {HomeRoutingModule} from './home-rounting.module';
import {ProfileCardComponent} from '../../shared/components/profile-card/profile-card.component';

@NgModule({
  declarations: [
    HomeComponent,
    ProfileCardComponent,
  ],
    imports: [
        CommonModule,
        HomeRoutingModule,
        ReactiveFormsModule,
        MatButtonModule,
        MatInputModule,
        MatToolbarModule,
        MatCardModule,
        MatIconModule,
    ],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class HomeModule { }

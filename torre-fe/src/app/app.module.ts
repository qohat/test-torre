import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {MatCardModule, MatIconModule, MatListModule, MatMenuModule, MatSidenavModule, MatToolbarModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {WebHttpInterceptor} from './core/interceptor/web-http-interceptor';
import {LayoutModule} from './layout/layout.module';
import {LayoutComponent} from './layout/layout/layout.component';
import {NotFoundComponent} from './pages/not-found/not-found.component';
import {SpinnerComponent} from './shared/components/spinner/spinner.component';
import {NgxSpinnerModule} from 'ngx-spinner';
import {HomeModule} from './pages/home/home.module';
import {PeopleModule} from './pages/people/people.module';
import { SkillCardComponent } from './shared/components/skill-card/skill-card.component';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    NotFoundComponent,
    SpinnerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LayoutModule,
    HttpClientModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatIconModule,
    MatMenuModule,
    MatListModule,
    NgxSpinnerModule,
    HomeModule,
    PeopleModule,
    MatCardModule,
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: WebHttpInterceptor, multi: true}],
  bootstrap: [AppComponent],
})
export class AppModule { }

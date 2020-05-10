import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NotFoundComponent} from './pages/not-found/not-found.component';
import {LayoutComponent} from './layout/layout/layout.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home',
  },
  {
    path: 'home',
    component: LayoutComponent,
    loadChildren: './pages/home/home.module#HomeModule',
    //canActivate: [AuthGuard],
  },
  {
    path: 'people',
    component: LayoutComponent,
    loadChildren: './pages/people/people.module#PeopleModule',
    //canActivate: [AuthGuard],
  },
  {
    path: '**',
    component: NotFoundComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { scrollPositionRestoration: 'enabled' })],
  exports: [RouterModule],
})
export class AppRoutingModule { }

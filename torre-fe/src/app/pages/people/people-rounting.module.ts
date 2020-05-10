import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {InterestedSkillsComponent} from './interested-skills/interested-skills.component';
import {OpportunitiesComponent} from './opportunities/opportunities.component';
import {MainResolver} from './resolver/main-resolver';
import {OpportunityResolver} from './resolver/opportunity-resolver';

const routes: Routes = [
  {
    path: 'interested-skills/:profileName',
    component: InterestedSkillsComponent,
    resolve: { insterests: MainResolver },
  },
  {
    path: 'me/:profileName',
    component: OpportunitiesComponent,
    resolve: { goals: OpportunityResolver },
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PeopleRoutingModule { }

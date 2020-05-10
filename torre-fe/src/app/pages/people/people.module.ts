import {CommonModule} from '@angular/common';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {
  MatButtonModule,
  MatCardModule,
  MatDatepickerModule,
  MatIconModule,
  MatInputModule,
  MatNativeDateModule,
  MatSelectModule
} from '@angular/material';
import {PeopleRoutingModule} from './people-rounting.module';
import {OpportunitiesComponent} from './opportunities/opportunities.component';
import {InterestedSkillsComponent} from './interested-skills/interested-skills.component';
import {SkillCardComponent} from '../../shared/components/skill-card/skill-card.component';

@NgModule({
  declarations: [
    InterestedSkillsComponent,
    OpportunitiesComponent,
    SkillCardComponent
  ],
  imports: [
    CommonModule,
    PeopleRoutingModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatIconModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCardModule
  ],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class PeopleModule { }

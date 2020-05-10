import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Goal} from '../dto/goal';
import {Interests} from '../dto/interests';
import {GoalService} from '../http/goal.service';

@Component({
  selector: 'ct-opportunities',
  templateUrl: './opportunities.component.html',
  styleUrls: ['./opportunities.component.scss'],
})
export class OpportunitiesComponent implements OnInit {

  public goals: Goal[] = [];

  constructor(private readonly activatedRoute: ActivatedRoute) { }

  public ngOnInit() {
    this.goals = this.activatedRoute.snapshot.data.goals as Goal[];
  }

}

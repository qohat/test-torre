import {Component, Input, OnInit} from '@angular/core';
import {Goal} from '../../../pages/people/dto/goal';

@Component({
  selector: 'ct-skill-card',
  templateUrl: './skill-card.component.html',
  styleUrls: ['./skill-card.component.scss'],
})
export class SkillCardComponent implements OnInit {

  @Input()
  public goal: Goal;

  constructor() { }

  public ngOnInit() {
  }

}

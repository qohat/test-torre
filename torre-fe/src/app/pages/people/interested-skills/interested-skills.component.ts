import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {ListItem} from '../../../core/dto/list-item';
import {ListService} from '../../../core/service/list.service';
import {Interests} from '../dto/interests';
import {Goal} from '../dto/goal';
import {GoalService} from '../http/goal.service';

@Component({
  selector: 'ct-interested-skills',
  templateUrl: './interested-skills.component.html',
  styleUrls: ['./interested-skills.component.scss'],
})
export class InterestedSkillsComponent implements OnInit {

  public fg: FormGroup;
  public interests: Interests[] = [];
  public levels: ListItem[] = [];
  public profileName: string = this.activatedRoute.snapshot.paramMap.get('profileName');

  constructor(
    private readonly fb: FormBuilder,
    private readonly activatedRoute: ActivatedRoute,
    private readonly listService: ListService,
    private readonly goalService: GoalService,
    private readonly router: Router
  ) { }

  public ngOnInit() {
    this.listService.getList('LEVELS')
      .subscribe((list: ListItem[]) => {
        this.levels = list;
      });
    this.interests = this.activatedRoute.snapshot.data.insterests as Interests[];
    this.initForm();
  }

  public initForm() {
    this.fg = this.fb.group({});
    const formObject = {};
    this.interests.forEach((q) => {
      formObject['' + q.id] = ['', Validators.required];
      formObject['' + q.id + 'Date'] = ['', Validators.required];
    });
    this.fg = this.fb.group(formObject);
  }

  public save() {
    const goals: Goal[] = []
    this.interests.map(
      (int) => goals.push(new Goal(
        this.profileName,
        int.id,
        int.name,
        this.fg.get('' + int.id).value,
        this.fg.get('' + int.id + 'Date').value,
        Math.random() * (100 - 80) + 80,
      ))
    );

    this.goalService.saveAll(goals)
      .subscribe(_ => {
        this.router.navigateByUrl('/people/me/' + this.profileName);
      });
  }

}

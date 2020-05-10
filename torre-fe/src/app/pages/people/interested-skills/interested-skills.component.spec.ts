import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {InterestedSkillsComponent} from './interested-skills.component';

describe('IntertedSkillsComponent', () => {
  let component: InterestedSkillsComponent;
  let fixture: ComponentFixture<InterestedSkillsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InterestedSkillsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InterestedSkillsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

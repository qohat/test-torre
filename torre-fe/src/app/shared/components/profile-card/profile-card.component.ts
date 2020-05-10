import {Component, Input, OnInit} from '@angular/core';
import {ProfileData} from './interface/profile-data';
import {LocalStorageService} from '../../../core/service/local-storage.service';

@Component({
  selector: 'ct-profile-card',
  templateUrl: './profile-card.component.html',
  styleUrls: ['./profile-card.component.scss'],
})
export class ProfileCardComponent implements OnInit {

  @Input()
  public profile: ProfileData;

  constructor(public readonly ls: LocalStorageService) { }

  public ngOnInit() {
  }

}

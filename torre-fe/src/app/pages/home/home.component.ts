import {Component, OnInit} from '@angular/core';
import {ProfileData} from '../../shared/components/profile-card/interface/profile-data';

@Component({
  selector: 'ct-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {

  public profiles: ProfileData[];

  constructor() { }

  public ngOnInit() {
    this.profiles = [
      new ProfileData(
        'qohatpretelpolo',
        'https://starrgate.s3.amazonaws.com:443/users/5320188b246ea7bfed5c972ed8e5ee2be29074d9/profile_XvKAyJ8.jpg',
        'Qohat Pretel Polo',
        'Software Engineer Developer',
      ),
      new ProfileData(
        'manolo',
        'https://starrgate.s3.amazonaws.com:443/users/97875998db0346c35fc3fd815df4802e99157dae/profile_h5u4pFr.jpg',
        'Manolo',
        'Founding member and Tech Lead of Torre',
      ),
      new ProfileData(
        'johnlloydefc',
        'https://starrgate.s3.amazonaws.com:443/users/1f33f322a3003fba7b2e42619a1c812dc2c5d3a8/profile_zjofuxC.jpg',
        'John',
        'Digital Marketing Strategist',
      ),
    ];
  }

}

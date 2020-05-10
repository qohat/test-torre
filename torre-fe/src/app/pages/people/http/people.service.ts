import {Injectable} from '@angular/core';
import {ApiService} from '../../../core/service/api.service';

@Injectable({
  providedIn: 'root',
})
export class PeopleService {

  public endPoint = '/people';

  constructor(private readonly api: ApiService) { }

  public getPeople(profileName: string) {
    return this.api.get(`${this.endPoint}/${profileName}`);
  }

  public getOpportunities(profileName: string) {
    return this.api.get(`${this.endPoint}/opportunities/2W11EaWq/${profileName}`);
  }
}

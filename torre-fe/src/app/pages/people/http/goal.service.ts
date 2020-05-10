import {Injectable} from '@angular/core';
import {ApiService} from '../../../core/service/api.service';
import {Goal} from '../dto/goal';

@Injectable({
  providedIn: 'root',
})
export class GoalService {

  public endPoint = '/goals';

  constructor(private readonly api: ApiService) { }

  public saveAll(goals: Goal[]) {
    return this.api.post(`${this.endPoint}/all`, goals);
  }

  public findByPerson(personId) {
    return this.api.get(`${this.endPoint}/${personId}`);
  }

}

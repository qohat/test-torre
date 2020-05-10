import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {GoalService} from '../http/goal.service';

@Injectable({
  providedIn: 'root',
})
  export class OpportunityResolver implements Resolve<any> {

  constructor(
    private readonly gs: GoalService,
  ) {}

  public resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> {
    const key = route.paramMap.get('profileName');
    return this.gs.findByPerson(key);
  }

}

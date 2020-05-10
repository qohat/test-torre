import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {PeopleService} from '../http/people.service';

@Injectable({
  providedIn: 'root',
})
export class MainResolver implements Resolve<any> {

  constructor(
    private readonly ps: PeopleService,
  ) {}

  public resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> {
    const key = route.paramMap.get('profileName');
    return this.ps.getPeople(key);
  }

}

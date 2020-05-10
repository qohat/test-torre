import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {ListItem} from '../dto/list-item';

@Injectable({
  providedIn: 'root',
})
export class ListService {

  public endPoint = '/lists';

  constructor(private readonly api: ApiService) { }

  public getList(keyId: string): Observable<ListItem[]> {
    return this.api.get(`${this.endPoint}/${keyId}`);
  }

  public getListByKeyAndValue(keyId: string, text: string): Observable<ListItem[]> {
    return this.api.get(`${this.endPoint}/${keyId}/${text}`);
  }
}

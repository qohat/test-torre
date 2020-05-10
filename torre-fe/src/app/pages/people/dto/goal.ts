import {ListItem} from '../../../core/dto/list-item';

export class Goal {
  constructor(
    public peopleId: string,
    public interestId: string,
    public interestName: string,
    public level: ListItem,
    public expirationDate: Date,
    public score: number,
    public id?: number,
  ) {
  }
}

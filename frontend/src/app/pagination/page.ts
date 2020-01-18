import {Sort} from './sort';
import {Pageable} from './pageable';

export class Page<T> {
  content: Array<T>;
  pageable: Pageable;
  totalPages: number;
  last: boolean;
  totalElements: number;
  sort: Sort;
  number: number;
  size: number;
  numberOfElements: number;
  first: boolean;
  empty: boolean;

  public constructor() {
    this.pageable = new Pageable();
  }
}

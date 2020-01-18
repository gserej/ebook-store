import {Injectable} from '@angular/core';
import {Pageable} from './pageable';
import {Page} from './page';

@Injectable({
  providedIn: 'root'
})
export class CustomPaginationService {

  constructor() {
  }

  public getNextPage(page: Page<any>): Pageable {
    if (!page.last) {
      page.pageable.pageNumber = page.pageable.pageNumber + 1;
    }
    return page.pageable;
  }

  public getPreviousPage(page: Page<any>): Pageable {
    if (!page.first) {
      page.pageable.pageNumber = page.pageable.pageNumber - 1;
    }
    return page.pageable;
  }
}

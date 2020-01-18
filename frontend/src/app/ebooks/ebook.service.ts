import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Ebook} from './ebook';
import {Page} from '../pagination/page';
import {Pageable} from "../pagination/pageable";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class EbookService {

  private baseEbookUrl = 'http://localhost:8080/api/v1/ebooks';

  constructor(private http: HttpClient) {
  }


  getEbooks(pageable: Pageable): Observable<Page<Ebook>> {
    const url = this.baseEbookUrl
      + '?page=' + pageable.pageNumber
      + '&size=' + pageable.pageSize
      + '&sort=id';
    return this.http.get<Page<Ebook>>(url, httpOptions);
  }

  getEbooksByCategory(shortName: string, pageable: Pageable): Observable<Page<Ebook>> {
    const url = this.baseEbookUrl
      + '?page=' + pageable.pageNumber
      + '&size=' + pageable.pageSize
      + '&sort=id';
    return this.http.get<Page<Ebook>>(url, {
      params: {
        categoryShortName: shortName
      },
    });
  }

  getEbookById(id: number): Observable<any> {
    return this.http.get(this.baseEbookUrl + '/' + id);
  }

  getEbookByShortName(shortName: string): Observable<any> {
    return this.http.get(this.baseEbookUrl + '/name/' + shortName);
  }

  createEbook(ebook: Ebook): Observable<any> {
    return this.http.post(this.baseEbookUrl, ebook);
  }

  updateEbook(ebook: Ebook): Observable<any> {
    return this.http.put(this.baseEbookUrl + '/' + ebook.id, ebook);
  }

  deleteEbook(id: number): Observable<any> {
    return this.http.delete(this.baseEbookUrl + '/' + id);
  }
}

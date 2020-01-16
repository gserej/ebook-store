import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

import {HttpClient} from '@angular/common/http';
import {Category} from '../categories/category';
import {Ebook} from './ebook';


@Injectable({
  providedIn: 'root'
})
export class EbookService {

  private baseUrl = 'http://localhost:8080/api/v1/ebooks';

  constructor(private http: HttpClient) {
  }

  getEbooks(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getEbooksByCategory(id: Category): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getEbookById(id: number): Observable<any> {
    return this.http.get(this.baseUrl + '/' + id);
  }

  createEbook(ebook: Ebook): Observable<any> {
    return this.http.post(this.baseUrl, ebook);
  }

  updateEbook(ebook: Ebook): Observable<any> {
    return this.http.put(this.baseUrl + '/' + ebook.id, ebook);
  }

  deleteEbook(id: number): Observable<any> {
    return this.http.delete(this.baseUrl + '/' + id);
  }
}

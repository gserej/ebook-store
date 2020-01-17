import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

import {HttpClient} from '@angular/common/http';
import {Ebook} from './ebook';


@Injectable({
  providedIn: 'root'
})
export class EbookService {

  private baseEbookUrl = 'http://localhost:8080/api/v1/ebooks';

  constructor(private http: HttpClient) {
  }

  getAllEbooks(): Observable<any> {
    return this.http.get(this.baseEbookUrl);
  }

  getEbooksByCategory(shortName: string): Observable<any> {
    return this.http.get(this.baseEbookUrl, {
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

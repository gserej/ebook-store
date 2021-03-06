import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Ebook} from '../ebooks/ebook';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private baseUrl = 'http://localhost:8080/api/v1/categories';

  constructor(private http: HttpClient) {
  }

  getCategories(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getCategoryById(id: number): Observable<any> {
    return this.http.get(this.baseUrl + '/' + id);
  }

  getCategoryByShortName(shortName: string): Observable<any> {
    return this.http.get(this.baseUrl + '/name/' + shortName);
  }

  createCategory(ebook: Ebook): Observable<any> {
    return this.http.post(this.baseUrl, ebook);
  }

  updateCategory(ebook: Ebook): Observable<any> {
    return this.http.put<any>(this.baseUrl + '/' + ebook.id, ebook);
  }

  deleteCategory(id: number): Observable<any> {
    return this.http.delete(this.baseUrl + '/' + id);
  }
}

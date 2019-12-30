import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Ebook} from '../model/ebook';
import {ApiResponse} from '../model/api.response';

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

  createCategory(ebook: Ebook): Observable<any> {
    return this.http.post(this.baseUrl, ebook);
  }

  updateCategory(ebook: Ebook): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.baseUrl + '/' + ebook.id, ebook);
  }

  deleteCategory(id: number): Observable<any> {
    return this.http.delete(this.baseUrl + '/' + id);
  }
}

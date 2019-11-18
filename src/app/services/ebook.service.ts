import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {Ebook} from '../ebook';
import {EBOOKS} from '../mock-ebooks';

@Injectable({
  providedIn: 'root'
})
export class EbookService {

  constructor() { }

  getEbooks(): Observable<Ebook[]> {
    const ebooks: Ebook[] = EBOOKS;
    return of(ebooks);
  }
  getEbook(key: string): Observable<Ebook> {
    const ebooks: Ebook[] = EBOOKS.filter(a => a.key === key);
    return of(ebooks[0]);
  }
}

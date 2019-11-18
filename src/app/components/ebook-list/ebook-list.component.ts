import { Component, OnInit } from '@angular/core';
import {Ebook} from '../../ebook';
import {EbookService} from '../../services/ebook.service';


@Component({
  selector: 'app-ebook-list',
  templateUrl: './ebook-list.component.html',
  styleUrls: ['./ebook-list.component.css']
})
export class EbookListComponent implements OnInit {
  ebooks: Ebook[] = [];

  constructor(private ebookService: EbookService) { }

  ngOnInit() {
    this.getEbooks();
    console.log(this.ebooks);
  }

  getEbooks(): void {
    this.ebookService.getEbooks().subscribe(ebooks => (this.ebooks = ebooks));
  }
}

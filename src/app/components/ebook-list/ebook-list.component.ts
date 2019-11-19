import {Component, OnInit} from '@angular/core';
import {Ebook} from '../../model/ebook';
import {EbookService} from '../../services/ebook.service';


@Component({
  selector: 'app-ebook-list',
  templateUrl: './ebook-list.component.html',
  styleUrls: ['./ebook-list.component.css']
})
export class EbookListComponent implements OnInit {
  ebooks: Array<Ebook>;

  constructor(private ebookService: EbookService) {
  }

  ngOnInit() {
    this.getEbooks();
  }

  getEbooks(): void {
    this.ebookService.getEbooks()
      .subscribe(data => {
        this.ebooks = data;
      });

  }

  deleteEbook(id: number) {
    this.ebookService.deleteEbook(id)
      .subscribe(
        () => {
          this.getEbooks();
        },
        error => console.log(error));
    this.getEbooks();
  }
}

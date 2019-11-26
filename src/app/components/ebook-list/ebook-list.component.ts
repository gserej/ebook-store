import {Component, OnInit} from '@angular/core';
import {Ebook} from '../../model/ebook';
import {EbookService} from '../../services/ebook.service';
import {AuthService} from '../../services/auth.service';


@Component({
  selector: 'app-ebook-list',
  templateUrl: './ebook-list.component.html',
  styleUrls: ['./ebook-list.component.css']
})
export class EbookListComponent implements OnInit {
  ebooks: Array<Ebook>;
  loggedAsAdmin = false;

  page = 1;

  constructor(private ebookService: EbookService,
              private authService: AuthService) {
  }

  ngOnInit() {
    this.getEbooks();
    this.loggedAsAdmin = this.authService.isUserLoggedIn();
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

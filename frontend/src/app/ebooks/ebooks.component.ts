import {Component, OnInit} from '@angular/core';
import {Ebook} from './ebook';
import {EbookService} from './ebook.service';
import {AuthService} from '../services/auth.service';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-ebooks',
  templateUrl: './ebooks.component.html',
  styleUrls: ['./ebooks.component.css']
})
export class EbooksComponent implements OnInit {
  ebooks: Array<Ebook>;
  loggedAsAdmin = false;

  page = 1;

  constructor(private ebookService: EbookService,
              private authService: AuthService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const categoryName = params.id;
      if (categoryName == null) {
        this.getAllEbooks();
      } else {
        this.ebookService.getEbooksByCategory(categoryName).subscribe(ebooks => {
          this.ebooks = ebooks;
        });
      }
    });
    this.loggedAsAdmin = this.authService.isUserLoggedIn();
  }

  getAllEbooks(): void {
    this.ebookService.getAllEbooks()
      .subscribe(data => {
        this.ebooks = data;
      });
  }

  deleteEbook(id: number) {
    this.ebookService.deleteEbook(id)
      .subscribe(
        () => {
          this.ngOnInit();
        },
        error => console.log(error));
    this.ngOnInit();
  }
}

import {Component, OnInit} from '@angular/core';
import {Ebook} from './ebook';
import {EbookService} from './ebook.service';
import {AuthService} from '../services/auth.service';
import {ActivatedRoute} from '@angular/router';
import {Category} from '../categories/category';
import {CategoryService} from '../categories/category.service';
import {Page} from '../pagination/page';
import {CustomPaginationService} from '../pagination/custom-pagination.service';


@Component({
  selector: 'app-ebooks',
  templateUrl: './ebooks.component.html',
  styleUrls: ['./ebooks.component.css']
})
export class EbooksComponent implements OnInit {
  loggedAsAdmin = false;
  category: Category;

  page: Page<Ebook> = new Page();

  constructor(private ebookService: EbookService,
              private categoryService: CategoryService,
              private authService: AuthService,
              private route: ActivatedRoute,
              private paginationService: CustomPaginationService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const categoryName = params.id;
      if (categoryName == null) {
        this.getEbooks();
      } else {
        this.categoryService.getCategoryByShortName(categoryName).subscribe(category => {
          this.category = category;
        });
        this.ebookService.getEbooksByCategory(categoryName, this.page.pageable).subscribe(page => {
          this.page = page;
        });
      }
    });
    this.loggedAsAdmin = this.authService.isUserLoggedIn();
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

  public getNextPage(): void {
    this.page.pageable = this.paginationService.getNextPage(this.page);
    this.getEbooks();
  }

  public getPreviousPage(): void {
    this.page.pageable = this.paginationService.getPreviousPage(this.page);
    this.getEbooks();
  }

  private getEbooks(): void {
    this.ebookService.getEbooks(this.page.pageable)
      .subscribe(page => this.page = page);
  }
}

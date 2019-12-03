import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../../services/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categories: Array<Category>;

  constructor(
    private categoryService: CategoryService) {
  }

  ngOnInit() {
    this.getCategories();
  }

  getCategories(): void {
    this.categoryService.getCategories()
      .subscribe(data => {
        this.categories = data;
      });
  }

}

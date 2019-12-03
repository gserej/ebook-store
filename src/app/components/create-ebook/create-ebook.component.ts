import {Component, OnInit} from '@angular/core';
import {Ebook} from '../../model/ebook';
import {EbookService} from '../../services/ebook.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-create-ebook',
  templateUrl: './create-ebook.component.html',
  styleUrls: ['./create-ebook.component.css']
})
export class CreateEbookComponent implements OnInit {

  ebook: Ebook = new Ebook();

  addForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private ebookService: EbookService) {
  }


  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
      title: ['', Validators.required],
      key: ['', Validators.required],
      date: ['', Validators.required],
      description: ['', Validators.required],
      imageUrl: ['', Validators.required],
      author: ['', Validators.required],
      publicationYear: ['', Validators.required],
      pages: ['', Validators.required],
      language: ['', Validators.required],
      format: ['', Validators.required],
      isbn: ['', Validators.required],
    });

  }

  onSubmit() {
    this.ebookService.createEbook(this.addForm.value)
      .subscribe(() => {
        this.router.navigate(['ebooks']);
      });
  }


}

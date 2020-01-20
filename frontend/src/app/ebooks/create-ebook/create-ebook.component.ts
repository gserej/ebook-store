import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Ebook} from '../ebook';
import {EbookService} from '../ebook.service';

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
      shortName: ['', Validators.required],
      dateAdded: ['', Validators.required],
      description: ['', Validators.required],
      imageUrl: ['', Validators.required],
      author: ['', Validators.required],
      publicationYear: ['', Validators.required],
      pages: ['', Validators.required],
      language: ['', Validators.required],
      ebookFormat: ['', Validators.required],
      isbn: ['', Validators.required],
    });

  }

  onSubmit() {
    this.ebookService.createEbook(this.addForm.value)
      .subscribe(() => {
        this.router.navigate(['']);
      });
  }


}

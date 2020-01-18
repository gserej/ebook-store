import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {first} from 'rxjs/operators';
import {Ebook} from '../ebook';
import {EbookService} from '../ebook.service';

@Component({
  selector: 'app-edit-ebook',
  templateUrl: './edit-ebook.component.html',
  styleUrls: ['./edit-ebook.component.css']
})
export class EditEbookComponent implements OnInit {

  ebook: Ebook;
  editForm: FormGroup;
  ebookId: number;

  constructor(private route: ActivatedRoute, private formBuilder: FormBuilder,
              private router: Router, private ebookService: EbookService) {
  }

  ngOnInit() {

    this.ebookId = this.route.snapshot.params.id;

    this.editForm = this.formBuilder.group({
      id: [],
      title: ['', Validators.required],
      dateAdded: [],
      description: ['', Validators.required],
      imageUrl: ['', Validators.required],
      author: ['', Validators.required],
      publicationYear: ['', Validators.required],
      pages: ['', Validators.required],
      language: ['', Validators.required],
      format: ['', Validators.required],
      isbn: ['', Validators.required],
      categories: [],
    });

    this.ebookService.getEbookById(this.ebookId)
      .subscribe(data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.ebookService.updateEbook(this.editForm.value)
      .pipe(first())
      .subscribe(() => {
        this.router.navigate(['ebooks']);
      });
  }
}

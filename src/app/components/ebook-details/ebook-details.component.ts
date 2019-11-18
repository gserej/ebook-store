import {Component, OnInit} from '@angular/core';
import {Ebook} from '../../ebook';
import {ActivatedRoute, Router} from '@angular/router';
import {EbookService} from '../../services/ebook.service';
import {Meta} from '@angular/platform-browser';


@Component({
  selector: 'app-ebook-details',
  templateUrl: './ebook-details.component.html',
  styleUrls: ['./ebook-details.component.css']
})
export class EbookDetailsComponent implements OnInit {

  ebook: Ebook = new Ebook();

  constructor(private route: ActivatedRoute,
              private ebookService: EbookService,
              private router: Router,
              private meta: Meta) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const key = params.key;
      this.ebookService.getEbook(key).subscribe(ebook => {
        if (ebook === undefined) {
          this.router.navigateByUrl('404');
          return;
        }
        this.ebook = ebook;
        this.meta.addTags([
          {name: 'description', content: this.ebook.description},
          {property: 'og:type', content: 'website'},
          {property: 'og:image', content: this.ebook.imageUrl},
          {property: 'og:description', content: this.ebook.description},
        ]);
      });
    });
  }

}

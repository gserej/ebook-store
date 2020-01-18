import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatButtonModule,
  MatCardModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatListModule,
  MatSidenavModule,
  MatToolbarModule
} from '@angular/material';
import {FlexLayoutModule} from '@angular/flex-layout';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {HttpinterceptorService} from './services/httpinterceptor.service';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FooterComponent} from './shared/footer/footer.component';
import {AboutComponent} from './shared/about/about.component';
import {NavBarComponent} from './shared/nav-bar/nav-bar.component';
import {EbookDetailsComponent} from './ebooks/ebook-details/ebook-details.component';
import {NotFoundComponent} from './shared/not-found/not-found.component';
import {LoginComponent} from './shared/login/login.component';
import {CreateEbookComponent} from './ebooks/create-ebook/create-ebook.component';
import {EditEbookComponent} from './ebooks/edit-ebook/edit-ebook.component';
import {SearchBoxComponent} from './shared/search-box/search-box.component';
import {EbooksComponent} from './ebooks/ebooks.component';
import {CategoriesComponent} from './categories/categories.component';
import {CustomPaginationComponent} from './pagination/custom-pagination/custom-pagination.component';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    AboutComponent,
    EbookDetailsComponent,
    EbooksComponent,
    NotFoundComponent,
    CreateEbookComponent,
    EditEbookComponent,
    LoginComponent,
    CategoriesComponent,
    SearchBoxComponent,
    CustomPaginationComponent,
  ],
  imports: [
    NgbModule,
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatGridListModule,
    FlexLayoutModule,
    MatSidenavModule,
    MatListModule,
    FormsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpinterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}

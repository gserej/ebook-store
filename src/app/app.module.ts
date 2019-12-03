import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {NavBarComponent} from './components/nav-bar/nav-bar.component';
import {FooterComponent} from './components/footer/footer.component';
import {AboutComponent} from './components/about/about.component';
import {EbookDetailsComponent} from './components/ebook-details/ebook-details.component';
import {EbookListComponent} from './components/ebook-list/ebook-list.component';
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
import {NotFoundComponent} from './components/not-found/not-found.component';
import {CreateEbookComponent} from './components/create-ebook/create-ebook.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {EditEbookComponent} from './components/edit-ebook/edit-ebook.component';
import {LoginComponent} from './components/login/login.component';
import {HttpinterceptorService} from './services/httpinterceptor.service';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {CategoryListComponent} from './components/category-list/category-list.component';
import {SearchBoxComponent} from './components/search-box/search-box.component';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    AboutComponent,
    EbookDetailsComponent,
    EbookListComponent,
    NotFoundComponent,
    CreateEbookComponent,
    EditEbookComponent,
    LoginComponent,
    CategoryListComponent,
    SearchBoxComponent,
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

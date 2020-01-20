import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AboutComponent} from './shared/about/about.component';
import {LoginComponent} from './shared/login/login.component';
import {NotFoundComponent} from './shared/not-found/not-found.component';
import {EditEbookComponent} from './ebooks/edit-ebook/edit-ebook.component';
import {CreateEbookComponent} from './ebooks/create-ebook/create-ebook.component';
import {EbooksComponent} from './ebooks/ebooks.component';
import {EbookDetailsComponent} from './ebooks/ebook-details/ebook-details.component';


const routes: Routes = [
  {path: '', component: EbooksComponent},
  {path: 'category/:id', component: EbooksComponent},
  {path: 'about', component: AboutComponent},
  {path: 'login', component: LoginComponent},
  {path: 'ebooks/create', component: CreateEbookComponent},
  {path: 'ebooks/:id', component: EbookDetailsComponent},
  {path: 'ebooks/update/:id', component: EditEbookComponent},
  {path: '404', component: NotFoundComponent},
  {path: '**', component: NotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EbookListComponent} from './components/ebook-list/ebook-list.component';
import {AboutComponent} from './components/about/about.component';
import {EbookDetailsComponent} from './components/ebook-details/ebook-details.component';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {CreateEbookComponent} from './components/create-ebook/create-ebook.component';
import {EditEbookComponent} from './components/edit-ebook/edit-ebook.component';
import {LoginComponent} from './components/login/login.component';


const routes: Routes = [
  {path: 'ebooks', component: EbookListComponent},
  {path: 'about', component: AboutComponent},
  {path: 'ebooks/create', component: CreateEbookComponent},
  {path: 'login', component: LoginComponent},
  {path: '404', component: NotFoundComponent},
  {path: '', component: EbookListComponent},
  {path: 'ebooks/:id', component: EbookDetailsComponent},
  {path: 'ebooks/update/:id', component: EditEbookComponent},
  {path: '**', component: NotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

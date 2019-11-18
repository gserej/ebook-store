import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EbookListComponent} from './components/ebook-list/ebook-list.component';
import {AboutComponent} from './components/about/about.component';
import {EbookDetailsComponent} from './components/ebook-details/ebook-details.component';
import {NotFoundComponent} from './components/not-found/not-found.component';


const routes: Routes = [
  { path: 'ebooks', component: EbookListComponent},
  { path: 'about', component: AboutComponent},
  { path: '404', component: NotFoundComponent},
  { path: '', component: EbookListComponent},
  { path: ':key', component: EbookDetailsComponent},
  { path: '**', component: NotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

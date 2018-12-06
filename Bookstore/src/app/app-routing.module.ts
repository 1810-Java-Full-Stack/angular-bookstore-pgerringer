import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent} from 'src/app/components/main/main.component';
import { BookComponent } from 'src/app/components/book/book.component';
import { AuthorComponent } from 'src/app/components/author/author.component';

const routes: Routes = [
  { path: '', redirectTo: 'main', pathMatch: 'full' },
  { path: 'main', component: MainComponent},
  { path: 'book/:book', component: BookComponent},
  { path: 'author/:author', component: AuthorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

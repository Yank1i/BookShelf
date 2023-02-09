import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorCreateComponent } from './author-create/author-create.component';
import { AuthorDetailComponent } from './author-detail/author-detail.component';
import { AuthorListComponent } from './author-list/author-list.component';
import { AuthorUpdateComponent } from './author-update/author-update.component';
import { BookCreateComponent } from './book-create/book-create.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookUpdateComponent } from './book-update/book-update.component';


const routes: Routes = [
  {path:"", component:BookListComponent, pathMatch:'full'},
  {path:"books", component:BookListComponent},
  {path:"authors", component:AuthorListComponent},
  {path:"author-detail/:id", component:AuthorDetailComponent},
  {path:"author-update/:id", component:AuthorUpdateComponent},
  {path:"author-create", component:AuthorCreateComponent},
  {path:"book-detail/:id", component:BookDetailComponent},
  {path:"book-update/:id", component:BookUpdateComponent},
  {path:"book-create", component:BookCreateComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

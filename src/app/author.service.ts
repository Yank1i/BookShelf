import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Author } from './author';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private httpClient: HttpClient) {

  }

  getAllAuthors(): Observable<Object> {

    return this.httpClient.get('http://localhost:8080/api/authors/');

  }

  getAuthorById(id:number):Observable<any>{
    return this.httpClient.get('http://localhost:8080/api/authors/'+id);
  }

  createAuthor(auth:Author):Observable<Object>{
    return this.httpClient.post('http://localhost:8080/api/authors/', auth);

  }

  updateAuhtor(upd:Author):Observable<Object>{
    return this.httpClient.post('http://localhost:8080/api/authors/'+upd.id, upd);
  }

  deleteAuthor(id:number):Observable<Object>{
    return this.httpClient.delete('http://localhost:8080/api/authors/'+id);
  }




}

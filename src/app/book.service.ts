import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from './book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private httpClient:HttpClient) { }

  getAllBooks():Observable<Object>{
    return this.httpClient.get('http://localhost:8080/api/books/');

  }

  getBookById(id:number):Observable<Object>{
    return this.httpClient.get('http://localhost:8080/api/books/'+id);
  }

  createBook(book:Book):Observable<Object>{
    return this.httpClient.post('http://localhost:8080/api/books/', book);
  }

  updateBook(upd:Book):Observable<Object>{
    return this.httpClient.post('http://localhost:8080/api/books/'+upd.id, upd);
  }

  deleteBook(id:number):Observable<Object>{
    return this.httpClient.delete('http://localhost:8080/api/books/'+id);
  }

}

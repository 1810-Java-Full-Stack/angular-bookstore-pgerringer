import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Config } from 'src/app/models/Config';
import { Book } from '../models/Book';
import { Author } from '../models/Author';

@Injectable({
  providedIn: 'root'
})
export class MainService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };

  constructor(private http: HttpClient) { }

  public getBookList(): Observable<Book[]> {
    return this.http.get<Book[]>(Config.base_url + '/books');
  }

  public getBookByID(id: string): Observable<Book> {
    return this.http.get<Book>(Config.base_url + '/books/' + id);
  }

  public updateBook(book: Book): Observable<Book> {
    return this.http.put<Book>(Config.base_url + '/books/' + book.id, book, this.httpOptions);
  }

  public getAuthorByID(id: string): Observable<Author> {
    return this.http.get<Author>(Config.base_url + '/authors/' + id);
  }

  public updateAuthor(author: Author): Observable<Author> {
    return this.http.put<Author>(Config.base_url + '/authors/' + author.id, author, this.httpOptions);
  }
}

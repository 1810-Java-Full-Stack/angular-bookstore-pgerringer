import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Config } from 'src/app/models/Config';
import { Book } from '../models/Book';
import { Author } from "../models/Author";

@Injectable({
  providedIn: 'root'
})
export class MainService {
  
  constructor(private http: HttpClient) { }

  public getBookList() {
    return this.http.get<Book[]>(Config.base_url + '/books');
  }

  public getBookByID(id: string) {
    return this.http.get<Book>(Config.base_url + '/books/' + id);
  }

  public getAuthorByName(name: string) {
    return this.http.get<Author>(Config.base_url + '/authors/' + name);
  }
}

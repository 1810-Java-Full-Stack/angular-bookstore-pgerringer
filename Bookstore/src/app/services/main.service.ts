import { Injectable } from '@angular/core';
import { Book } from '../models/Book';
import { Author } from "../models/Author";

@Injectable({
  providedIn: 'root'
})
export class MainService {
  private ROWLINGS="J.K. Rowlings";
  private FRANK="Frank Herbert";
  private BETTY="Betty G Berney";
  private KING="Steven King";

  public books = [
    new Book(1, 'Sorcers Stone', this.ROWLINGS, 'alsdjfoiaf'),
    new Book(13, 'Dune', this.FRANK, 'alsdjfoiaf'),
    new Book(15, 'Life According to Og the Frog', this.BETTY, 'alsdjfoiaf'),
    new Book(20, 'IT', this.KING, 'alsdjfoiaf')
  ];

  public authors = [
    new Author(1, this.ROWLINGS, "I like string beans."),
    new Author(2, this.FRANK, "The sleeper has awaken."),
    new Author(3, this.BETTY, "I wrote something about a frog."), 
    new Author(4, this.KING, "I'm scared of the dark.")
  ]

  constructor() { }

  public getBookList() {
      return this.books;
  }

  public getBookByName(name: string) : Book {
    return this.books.find((b) => b.name === name);
  }

  public getAuthorByName(name: string) : Author {
    return this.authors.find((A) => A.name === name);
  }
}

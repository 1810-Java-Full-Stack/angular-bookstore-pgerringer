import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MainService } from 'src/app/services/main.service';
import { Book } from 'src/app/models/Book';
import { Author } from 'src/app/models/Author';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  public book: Book;
  public author: Author;
  public id: string;

  constructor(
    public route: ActivatedRoute,
    public service: MainService
    ) { }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('book');
    this.service.getBookByID(this.id).subscribe(
      (b) =>  {
        this.book = b;
        this.service.getAuthorByID(this.book.author_id).subscribe(
          (a) =>  { this.author = a; }
        );
      }
    );
  }

  update() {
    this.service.updateBook(this.book).subscribe(
      (b) =>  {
        this.book = b;
      }
    );
  }

}

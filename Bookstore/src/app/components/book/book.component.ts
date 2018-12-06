import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MainService } from 'src/app/services/main.service';
import { Book } from 'src/app/models/Book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  public book: Book;
  
  constructor( 
    public route: ActivatedRoute,
    public service: MainService
    ) { }

  ngOnInit() {
    this.book = this.service.getBookByName(this.route.snapshot.paramMap.get("book"));
  }

}

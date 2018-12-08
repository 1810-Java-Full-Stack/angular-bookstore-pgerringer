import { Component, OnInit } from '@angular/core';
import { MainService } from 'src/app/services/main.service';
import { Book } from 'src/app/models/Book';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  public bookList: Book[];

  constructor( 
    public service: MainService
    ) { }

  ngOnInit() {
    this.service.getBookList().subscribe(
      (book) =>  { 
        this.bookList = book; 
      }
    );
  }

}

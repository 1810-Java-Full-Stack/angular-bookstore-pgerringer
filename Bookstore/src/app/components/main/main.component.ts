import { Component, OnInit } from '@angular/core';
import { MainService } from 'src/app/services/main.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  public bookList=this.service.getBookList();

  constructor( 
    public service: MainService
    ) { }

  ngOnInit() {
  }

}

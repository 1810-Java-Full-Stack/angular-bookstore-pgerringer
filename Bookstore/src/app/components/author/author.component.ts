import { Component, OnInit } from '@angular/core';
import { MainService } from 'src/app/services/main.service';
import { ActivatedRoute } from '@angular/router';
import { Author } from 'src/app/models/Author';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
  public author: Author;

  constructor(
    public service: MainService, 
    public route: ActivatedRoute ) { }

  ngOnInit() {
    this.author = this.service.getAuthorByName(this.route.snapshot.paramMap.get("author"));
  }

}

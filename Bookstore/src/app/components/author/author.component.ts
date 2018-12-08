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
  public id: string;

  constructor(
    public service: MainService,
    public route: ActivatedRoute ) { }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('author');
    this.service.getAuthorByID(this.id).subscribe(
      (a) =>  {
        this.author = a;
      }
    );
  }

  update() {
    this.service.updateAuthor(this.author).subscribe(
      (a) =>  {
        this.author = a;
      }
    );
  }
}

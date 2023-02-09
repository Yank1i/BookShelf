import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject } from 'rxjs';
import { Author } from '../author';
import { AuthorService } from '../author.service';
import { DataTableDirective } from 'angular-datatables';

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.css']
})
export class AuthorListComponent implements OnInit {
    @ViewChild(DataTableDirective, { static: false })
    dtElement!: DataTableDirective;




  list: Array<Author> = new Array<Author>;
  dtTrigger: Subject<any> = new Subject();

  dtOptions: any = {
    columns: [
      { data: 'Id' },
      { data: 'Name' },
      { data: 'Surname' },
      { data: 'Genre' },
      { data: 'Born Date' },
      { data: 'Death Date' },
      {
        title: 'Action',
        render: function (data: any, type: any, full: any) {
          return 'View';
        }
      },
    ]
  }



  constructor(private service: AuthorService, private actRoute: ActivatedRoute, private router: Router) {

  }
  ngOnInit(): void {
    this.loadList();
  }


  loadList() {
    this.service.getAllAuthors().subscribe((data) => {

      console.log("Get all auhtors request");

      let responseList = (data as Array<Author>);

      this.list.splice(0, this.list.length);

      responseList.forEach((a) => {

        this.list.push({

          id: a.id,
          name: a.name,
          surname: a.surname,
          born_date: new Date(a.born_date),
          death_date: new Date(a.death_date),
          country: a.country,
          genre: a.genre,
          description: a.description,
          comment:a.comment,
          alive:a.alive
        })

      });
this.dtTrigger.next(this.list);

    });
  }

  detailAuthor(id: number) {
    this.router.navigateByUrl("/author-detail/" + id);
  }


  updateAuthor(id: number) {
    this.router.navigateByUrl("/author-update/" + id);
  }

  deleteAuthor(id: number) {
    if (confirm("Do you want to delete this auhtor?")) {
      this.service.deleteAuthor(id).subscribe({
        next: (data) => {
          console.log("Data:", data);
          this.loadList();
        },
        error: (err) => {
          console.log("Error: ", err);
        }
      })
    }
  }

}

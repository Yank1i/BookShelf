import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from '../author';
import { AuthorService } from '../author.service';

@Component({
  selector: 'app-author-update',
  templateUrl: './author-update.component.html',
  styleUrls: ['./author-update.component.css']
})
export class AuthorUpdateComponent implements OnInit{

  autor!:Author;
  id!:number;
  fg!:FormGroup;
  
  constructor(private service:AuthorService, private actRoute:ActivatedRoute, private router:Router, private fb:FormBuilder){}

  ngOnInit(): void {
    this.id=Number (this.router.url.split('/').pop());

    this.getAuthorById(this.id);

 this.service.getAuthorById(this.id).subscribe((data)=>{
  
  let a=(data as Author);

  this.autor={
    id:a.id,
    name:a.name,
    surname:a.surname,
    born_date:new Date(a.born_date),
    death_date:new Date(a.death_date),
    genre:a.genre,
    description:a.description,
    country:a.country,
    comment:a.comment,
    alive:a.alive
  }

})



    this.fg=this.fb.group({
      id:0,
      name:'',
      surname:'',
      born_date:new Date,
      death_date:new Date,
      genre:'',
      description:'',
      country:''
    })
  }

  getAuthorById(id:number){
  
    this.service.getAuthorById(id).subscribe((data)=>{
      this.autor=data;
    })
  }

  
updateAuthor(){
this.service.updateAuhtor(this.fg.value).subscribe({
  next:(data)=>{
    console.log("Updated data: ", data);
    this.router.navigateByUrl("/authors");
  },
  error:(err)=>{
    console.log("Error: ", err);
  }
})

}



}

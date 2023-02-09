import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Author } from '../author';
import { AuthorService } from '../author.service';

@Component({
  selector: 'app-author-create',
  templateUrl: './author-create.component.html',
  styleUrls: ['./author-create.component.css']
})
export class AuthorCreateComponent implements OnInit {

constructor(private service:AuthorService, private actRoute:ActivatedRoute, private router:Router, private fb:FormBuilder){

}

ngOnInit(): void {

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
fg!:FormGroup;

/*
a:Author={
  id:0,
  name:'',
  surname:'',
  born_date:new Date,
  death_date:new Date,
  genre:'',
  description:'',
  country:''
}

*/

createAuthor(){
  this.service.createAuthor(this.fg.value).subscribe({
    next:(data)=>{
      this.router.navigateByUrl("/authors");
    },
    error:(err)=>{
      console.log("Error", err);
    }
  })

}



}

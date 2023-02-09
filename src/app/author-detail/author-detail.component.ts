import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from '../author';
import { AuthorService } from '../author.service';

@Component({
  selector: 'app-author-detail',
  templateUrl: './author-detail.component.html',
  styleUrls: ['./author-detail.component.css']
})
export class AuthorDetailComponent implements OnInit{

  a!:Author;
  id!:number;
  constructor(private service:AuthorService, private actRoute:ActivatedRoute, private router:Router){

  }

  ngOnInit(): void {

    console.log("Recieved author detail request");
    this.id=Number(this.router.url.split('/').pop());

    this.service.getAuthorById(this.id).subscribe({
      next:(data)=>{
        this.a=data;
      },
      error:(err)=>{
        console.log("Something went wrong : ", err);
        
      }
    })
    

    
  }








}

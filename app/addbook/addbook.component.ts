import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.css']
})
export class AddbookComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  home(){

    this.router.navigate(['/home']);
  }
  addbook(){
    alert('dont click dude u r on the same page');
    this.router.navigate(['/addbook']);
  }
}

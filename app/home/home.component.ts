import { Component, OnInit } from '@angular/core';
import { routing} from '../app.route';
import { Router} from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router : Router ) { }

  ngOnInit() {
  }


  btnclick(){

    console.log('clicked');
    this.router.navigate(['/addbook']);
  }
}

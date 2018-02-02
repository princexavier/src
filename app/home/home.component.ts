import { Component, OnInit } from '@angular/core';
import { routing} from '../app.route';
import { Router} from '@angular/router';
import { viewservice } from '../../services/viewbook.service';
import { Book } from '../../services/bookpojo';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  recievedBook:Book [] = [];
  constructor(private router : Router, private view : viewservice ) { }

  ngOnInit() {

    // this.viewbook();
  }


  btnclick(){

    console.log('clicked');
    this.router.navigate(['/addbook']);
  }

  viewbook(){

    this.recievedBook = this.view.loadbook();
  }
}

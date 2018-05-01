import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  first:any={};
  se:any={};
 itms:any=[];
 av:any;
 nc:any;
 temp:any;
 fi:any=0;
 si:any=0;
 vas:any;
 model:any={};
  constructor() { }

  ngOnInit() {
  }
  f(e){
    this.fi = 0;
    debugger;
    for(this.itms in this.first){
      this.temp = this.first[this.itms];
      this.fi = this.fi+this.temp;
    }
    this.model.firstYear = this.fi;
    console.log(this.model);

  }
  s(e){
    this.si = 0;
    debugger;
    for(this.itms in this.se){
      this.temp = this.se[this.itms];
      this.si = this.si+this.temp;
    }
    this.model.secondYear = this.si;
    console.log(this.model);

  }

  
}

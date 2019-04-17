import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ApiService } from '../services/api.service';
import { HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Room } from '../room';

@Component({
  selector: 'app-addroom',
  templateUrl: './addroom.component.html',
  styleUrls: ['./addroom.component.css']
})
export class AddRoomComponent implements OnInit {

  constructor(
    private apiService: ApiService,
     private router: Router) { }

  ngOnInit() {
  }

room = new Room();
  addRoom(){
      this.apiService
        .addRoom(this.room)
        .subscribe(()=> this.goBack());
  }
   goBack(){
    this.router.navigate(['/home']);
  }
}

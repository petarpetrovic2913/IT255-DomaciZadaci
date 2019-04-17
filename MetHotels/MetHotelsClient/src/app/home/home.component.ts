import { Component, OnInit } from "@angular/core";
import { ApiService } from "../services/api.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"]
})
export class HomeComponent implements OnInit {
  constructor(private _apiService: ApiService, private router: Router) {}
  rooms: any;
  filteredRooms: any;

  _listFilter: string;
  get listFilter(): string {
    return this._listFilter;
  }
  set listFilter(value: string) {
    this._listFilter = value;
    this.filteredRooms = this.listFilter
      ? this.performFilter(this.listFilter)
      : this.rooms;
  }

  ngOnInit() {
    this.getRooms();
  }
  public loggedIn = localStorage.getItem("token") ? true : false;

  performFilter(filterBy: string): any[] {
    filterBy = filterBy.toLocaleLowerCase();
    return this.rooms.filter(
      (room: any) => room.hotelName.toLocaleLowerCase().indexOf(filterBy) !== -1
    );
  }

  getRooms() {
    this._apiService.getRooms().subscribe(rooms => {
      this.rooms = rooms;
      this.filteredRooms = this.rooms;
    });
  }

  deleteRoom(id) {
    this._apiService.deleteRoom(id).subscribe(() => {
      this.getRooms();
    });
  }
}

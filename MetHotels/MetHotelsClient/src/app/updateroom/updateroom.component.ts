import { Component, OnInit } from "@angular/core";
import { ApiService } from "../services/api.service";
import { FormGroup, FormControl } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: "app-updateroom",
  templateUrl: "./updateroom.component.html",
  styleUrls: ["./updateroom.component.css"]
})
export class UpdateroomComponent implements OnInit {
  public roomForm = new FormGroup({
    hotelName: new FormControl(),
    hasTV: new FormControl(),
    beds: new FormControl(),
    price: new FormControl()
  });

  constructor(
    private _apiService: ApiService,
    private route: ActivatedRoute,
    private _router: Router
  ) {}
  id: any;
  room: any;
  defaultHotelName: "";
  defaultHasTv: "";
  defaultBeds: "";
  defaultPrice: "";
  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get("id");
    this.getRoom(this.id);
  }

  getRoom(id) {
    this._apiService.getRoom(id).subscribe(room => {
      this.room = room;
      console.log(room);
      this.defaultHotelName = room.hotelName;
      this.defaultHasTv = room.hasTV;
      this.defaultBeds = room.beds;
      this.defaultPrice = room.price;
    });
  }

  public updateRoom() {
    const updatedRoom = {
      hotelName: this.roomForm.value.hotelName,
      hasTV: this.roomForm.value.hasTV,
      beds: this.roomForm.value.beds,
      price: this.roomForm.value.price
    };

    this._apiService.updateRoom(updatedRoom, this.id).subscribe((data: any) => {
      this._router.navigateByUrl("/home");
    });
  }
}

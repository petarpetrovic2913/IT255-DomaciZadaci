import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.css"]
})
export class NavbarComponent implements OnInit {
  constructor(private _router: Router) {}

  ngOnInit() {}

  public loggedIn = localStorage.getItem("token") ? true : false;

  public logOut() {
    this.loggedIn = false;
    localStorage.removeItem("token");
    this._router.navigate(["./home"]);
    location.reload();
  }
}

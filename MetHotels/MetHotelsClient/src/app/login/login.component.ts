import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl } from "@angular/forms";
import { ApiService } from "../services/api.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  public loginForm = new FormGroup({
    username: new FormControl(),
    password: new FormControl()
  });

  constructor(private _apiService: ApiService, private _router: Router) {}

  ngOnInit() {
    if (localStorage.getItem("token")) {
      this._router.navigateByUrl("/home");
    }
  }

  public login() {
    const loginRequest = {
      username: this.loginForm.value.username,
      password: this.loginForm.value.password
    };

    this._apiService.loginUser(loginRequest).subscribe((response: any) => {
      localStorage.setItem("token", JSON.parse(response._body).token);
      this._router.navigate(["./home"]);
      location.reload();
    });
  }
}

import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl } from "@angular/forms";
import { ApiService } from "../services/api.service";
import { Router } from "@angular/router";
@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"]
})
export class RegisterComponent implements OnInit {
  public registerForm = new FormGroup({
    name: new FormControl(),
    email: new FormControl(),
    phone: new FormControl(),
    username: new FormControl(),
    password: new FormControl()
  });

  constructor(private _apiService: ApiService, private _router: Router) {}

  ngOnInit() {
    if (localStorage.getItem("token")) {
      this._router.navigateByUrl("/home");
    }
  }

  public register() {
    const registeredUser = {
      name: this.registerForm.value.name,
      email: this.registerForm.value.email,
      phone: this.registerForm.value.phone,
      username: this.registerForm.value.username,
      password: this.registerForm.value.password
    };

    this._apiService.registerUser(registeredUser).subscribe((data: any) => {
      this._router.navigateByUrl("/home");
    });
  }
}

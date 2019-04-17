import { Injectable } from "@angular/core";
import { Http, Headers } from "@angular/http";
import { map } from "rxjs/operators";

@Injectable({
  providedIn: "root"
})
export class ApiService {
  public static serverEndpoint = "http://localhost:8080";
  rooms = [];
  checkMe: any;
  public generateHeaders() {
    const headers = new Headers();
    headers.append("Content-Type", "application/json");
    if (localStorage.getItem("token")) {
      headers.append("Authorization", localStorage.getItem("token"));
    }
    return headers;
  }

  constructor(private _http: Http) {}

  getRooms() {
    return this._http.get("http://localhost:8080/rooms/all").pipe(
      map(res => {
        this.checkMe = res;

        if (this.checkMe._body !== "0") {
          return res.json();
        }
      })
    );
  }

  public post(url, data) {
    return this._http.post(ApiService.serverEndpoint + url, data, {
      headers: this.generateHeaders()
    });
  }

  registerUser(registeredUser) {
    return this._http.post(
      "http://localhost:8080/users/register/",
      registeredUser
    );
  }

  loginUser(loginRequest) {
    return this._http.post("http://localhost:8080/users/login/", loginRequest, {
      headers: this.generateHeaders()
    });
  }

  deleteRoom(id) {
    return this._http.delete("http://localhost:8080/rooms/delete/" + id);
  }

  addRoom(info) {
    return this._http.post("http://localhost:8080/rooms/add/", info);
  }

  updateRoom(room, id) {
    return this._http.put("http://localhost:8080/rooms/edit/" + id, room);
  }

  getRoom(id) {
    return this._http.get("http://localhost:8080/rooms/" + id).pipe(
      map(res => {
        this.checkMe = res;

        if (this.checkMe._body !== "0") {
          return res.json();
        }
      })
    );
  }
}

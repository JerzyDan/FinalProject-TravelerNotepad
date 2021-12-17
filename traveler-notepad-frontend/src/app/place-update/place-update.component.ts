import { PlaceRequest } from './../models/place-request.model';
import { PlacesService } from './../places.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-place-update',
  templateUrl: './place-update.component.html',
  styleUrls: ['./place-update.component.css']
})
export class PlaceUpdateComponent implements OnInit {

  place!: PlaceRequest;
  submitted = false;
  placeId: number;
  placeName: string;
  placeCity: string;
  placeDays: number;
  placeStatus: string;
  placeDescription:string;
  placeCountryId: number;

  constructor(private placeService: PlacesService, private router: Router) {
    this.placeId = 0;
    this.placeName = "";
    this.placeCity = "";
    this.placeDays = 0;
    this.placeStatus = "";
    this.placeDescription = "";
    this.placeCountryId = 0;
   }

  ngOnInit(): void {
  }

  update() {
    this.place = new PlaceRequest(this.placeId, this.placeName, this.placeCity, this.placeDays, this.placeStatus, this.placeDescription, this.placeCountryId);
    console.log("current data", this.place);
    this.placeService
    .updatePlace(this.placeId, this.place).subscribe(data => {
      console.log(data);
      this.goToList();
    },
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.update();
  }

  goToList() {
    this.router.navigate(['/places']);
  }

}
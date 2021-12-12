import { Router } from '@angular/router';
import { PlacesService } from './../places.service';
import { PlaceRequest } from './../models/place-request.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-place-add',
  templateUrl: './place-add.component.html',
  styleUrls: ['./place-add.component.css']
})
export class PlaceAddComponent implements OnInit {

  place!: PlaceRequest;
  submitted = false;
  placeName: string;
  placeCity: string;
  placeDays: number;
  placeStatus: string;
  placeDescription:string;
  placeCountryId: number;

  constructor(private placeService: PlacesService, private router: Router) {
      this.placeName = "";
      this.placeCity = "";
      this.placeDays = 0;
      this.placeStatus = "";
      this.placeDescription = "";
      this.placeCountryId = 0;
   }

  ngOnInit(): void {
  }

  save() {
    this.place = new PlaceRequest(20,this.placeName, this.placeCity, this.placeDays, this.placeStatus, this.placeDescription, this.placeCountryId);
    console.log("current data", this.place);
    this.placeService
    .postPlace(this.place).subscribe(data => {
      console.log(data);
      this.goToList();
    },
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  goToList() {
    this.router.navigate(['/places']);
  }

}
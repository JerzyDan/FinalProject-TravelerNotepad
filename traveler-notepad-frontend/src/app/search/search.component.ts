import { Router } from '@angular/router';
import { SearchService } from './../search.service';
import { Place } from './../models/places.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  place!: Place;
  placeList: Place[];
  submitted = false;
  placeName: string;
  placeCity: string;
  placeStatus: string;
  placeDays: number;
  placeCountryId: number;

  constructor(private searchService: SearchService, private router: Router) {
    this.placeName = "";
    this.placeCity = "";
    this.placeStatus = "";
    this.placeList = [];
    this.placeDays = 0;
    this.placeCountryId = 0;
   }

  ngOnInit(): void {
  }

  searchByName() {
    this.searchService.getPlaceByName(this.placeName).subscribe(data => {
      this.place = data;
      console.log(data);
    },
    error => console.log(error));
  }

  searchByCity() {
    this.searchService.getPlacesByCity(this.placeCity).subscribe(data => {
      console.log(data);
      this.placeList = data;
    },
    error => console.log(error));
  }

  searchByStatus() {
    this.searchService.getPlacesByStatus(this.placeStatus).subscribe(data => {
      console.log(data);
      this.placeList = data;
    },
    error => console.log(error));
  }

  searchByDays() {
    this.searchService.getPlacesByDays(this.placeDays).subscribe(data => {
      console.log(data);
      this.placeList = data;
    },
    error => console.log(error));
  }

  searchByCountryId() {
    this.searchService.getPlacesByCountryId(this.placeCountryId).subscribe(data => {
      console.log(data);
      this.placeList = data;
    },
    error => console.log(error));
  }

  onSubmitName() {
    this.submitted = true;
    this.searchByName();
  }

  onSubmitCity() {
    this.submitted = true;
    this.searchByCity();
  }

  onSubmitStatus() {
    this.submitted = true;
    this.searchByStatus();
  }

  onSubmitDays() {
    this.submitted = true;
    this.searchByDays();
  }

  onSubmitCountryId() {
    this.submitted = true;
    this.searchByCountryId();
  }

}

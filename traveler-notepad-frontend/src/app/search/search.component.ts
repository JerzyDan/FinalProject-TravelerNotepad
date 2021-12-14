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

  constructor(private searchService: SearchService, private router: Router) {
    this.placeName = "";
    this.placeCity = "";
    this.placeList = [];
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

  onSubmit() {
    this.submitted = true;
    this.searchByName();
  }

  onSubmit2() {
    this.submitted = true;
    this.searchByCity();
  }

}

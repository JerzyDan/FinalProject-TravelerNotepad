import { Place } from './../models/places.model';
import { PlacesService } from './../places.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-places',
  templateUrl: './places.component.html',
  styleUrls: ['./places.component.css']
})
export class PlacesComponent implements OnInit {

  placesList: Place[];

  constructor(
    private placesService: PlacesService,
    private router: Router
  ) {
    this.placesList = [];
   }

  ngOnInit(): void {
    this.placesService.getPlaces().subscribe(
      result => {
        this.placesList = result;
      }
    );
  }

}
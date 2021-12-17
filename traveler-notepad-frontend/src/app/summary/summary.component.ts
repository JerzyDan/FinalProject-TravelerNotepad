import { Router } from '@angular/router';
import { ReportService } from './../report.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {

  status: string;
  visitedPlaces: number;
  visitedCountries: number;
  favoritePlaces: number;
  favoriteCountries: number;
  nextTripPlaces: number;
  nextTripDays: number;
  dontLikePlaces: number;
  dontLikeCountries: number;

  constructor(private reportService: ReportService, private router: Router) {
    this.status = "";
    this.visitedPlaces = 0;
    this.visitedCountries = 0;
    this.favoritePlaces = 0;
    this.favoriteCountries = 0;
    this.nextTripPlaces = 0;
    this.nextTripDays = 0;
    this.dontLikePlaces = 0;
    this.dontLikeCountries = 0;
   }

  ngOnInit(): void {

    this.reportService.countPlacesByStatus("VISITED").subscribe(
      result => {
        console.log("Visited places: ",result);
        this.visitedPlaces = result;
      }
    )

    this.reportService.countCountriesByStatus("VISITED").subscribe(
      result => {
        console.log("Visited countries: ",result);
        this.visitedCountries = result;
      }
    )

    this.reportService.countPlacesByStatus("FAVORITE").subscribe(
      result => {
        console.log("Favorite places: ",result);
        this.favoritePlaces = result;
      }
    )

    this.reportService.countCountriesByStatus("FAVORITE").subscribe(
      result => {
        console.log("Favorite countries: ",result);
        this.favoriteCountries = result;
      }
    )

    this.reportService.countPlacesByStatus("NEXT_TRIP").subscribe(
      result => {
        console.log("Next trip places: ",result);
        this.nextTripPlaces = result;
      }
    )

    this.reportService.countDaysByStatus("NEXT_TRIP").subscribe(
      result => {
        console.log("Next trip countries: ",result);
        this.nextTripDays = result;
      }
    )

    this.reportService.countPlacesByStatus("NEVER_AGAIN").subscribe(
      result => {
        console.log("Never again places: ",result);
        this.dontLikePlaces = result;
      }
    )

    this.reportService.countCountriesByStatus("NEVER_AGAIN").subscribe(
      result => {
        console.log("Never again countries: ",result);
        this.dontLikeCountries = result;
      }
    )
   
  }

}
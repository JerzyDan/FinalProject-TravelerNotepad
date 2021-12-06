import { Router } from '@angular/router';
import { Country } from './../models/countries.model';
import { Component, OnInit } from '@angular/core';
import { CountriesService } from '../countries.service';

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.css']
})
export class CountriesComponent implements OnInit {

  countriesList: Country[];

  constructor(
    private countriesService:CountriesService,
    private router: Router
    ) {
    this.countriesList = [];
   }

  ngOnInit(): void {
    this.countriesService.getCountries().subscribe(
      result => {
        this.countriesList = result;
      }
    );
  }

  addCountry(): void {
    this.router.navigate(['country/add'])
  }

}

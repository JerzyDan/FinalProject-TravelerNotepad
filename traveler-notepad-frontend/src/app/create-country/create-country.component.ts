import { CountryRequest } from './../models/country-request.model';
import { Component, OnInit } from '@angular/core';
import { CountriesService } from '../countries.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-country',
  templateUrl: './create-country.component.html',
  styleUrls: ['./create-country.component.css']
})
export class CreateCountryComponent implements OnInit {

  country!: CountryRequest
  submitted = false;
  countryName: string;
  countryLanguage: string;
  countryClimate: string;
  countryArea: string;

  constructor(private countriesService: CountriesService,
    private router: Router) {
      this.countryName = "";
      this.countryLanguage = "";
      this.countryClimate = "";
      this.countryArea = "";
     }

  ngOnInit(): void {
  }

  newCountry(): void {
    this.submitted = false;
    this.country = new CountryRequest(20, this.countryName, this.countryLanguage, this.countryClimate, this.countryArea);
  }

  save() {
    this.country = new CountryRequest(20, this.countryName, this.countryLanguage, this.countryClimate, this.countryArea);
    console.log("current data", this.country);
    this.countriesService
    .postCountry(this.country).subscribe(data => {
      console.log(data)
      this.goToList();
    },
    error => console.log(error));
  }
  
  onSubmit() {
    this.submitted = true;
    this.save();
  }

  goToList() {
    this.router.navigate(['/country']);
  }

}
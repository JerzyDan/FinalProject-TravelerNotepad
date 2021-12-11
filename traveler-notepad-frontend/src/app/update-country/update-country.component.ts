import { CountryRequest } from './../models/country-request.model';
import { Router } from '@angular/router';
import { CountriesService } from './../countries.service';
//import { Country } from './../models/countries.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-update-country',
  templateUrl: './update-country.component.html',
  styleUrls: ['./update-country.component.css']
})
export class UpdateCountryComponent implements OnInit {

  country!: CountryRequest;
  submitted = false;
  countryId: number;
  countryName: string;
  countryLanguage: string;
  countryClimate: string;
  countryArea: string;

  constructor(private countriesService: CountriesService,
    private router: Router) {

      this.countryId = 0;
      this.countryName = "";
      this.countryLanguage = "";
      this.countryClimate = "";
      this.countryArea = "";      
     }

  ngOnInit(): void {
  }

  update() {
    this.country = new CountryRequest(this.countryId, this.countryName, this.countryLanguage, this.countryClimate, this.countryArea);
    console.log("current data", this.country);
    this.countriesService
    .updateCountry(this.countryId, this.country).subscribe(data => {
      console.log(data)
      this.goToList();
    },
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.update();
  }

  goToList() {
    this.router.navigate(['/country']);
  }

}

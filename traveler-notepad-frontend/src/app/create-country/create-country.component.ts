import { Country } from './../country';
import { Component, OnInit } from '@angular/core';
import { CountriesService } from '../countries.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-country',
  templateUrl: './create-country.component.html',
  styleUrls: ['./create-country.component.css']
})
export class CreateCountryComponent implements OnInit {

  country: Country = new Country();
  submitted = false;

  constructor(private countriesService: CountriesService,
    private router: Router) { }

  ngOnInit(): void {
  }

  newCountry(): void {
    this.submitted = false;
    this.country = new Country();
  }

  save() {
    this.countriesService
    .postCountry(this.country).subscribe(data => {
      console.log(data)
      this.country = new Country();
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

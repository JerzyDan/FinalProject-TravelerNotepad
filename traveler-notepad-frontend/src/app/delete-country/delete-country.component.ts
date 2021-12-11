import { Router } from '@angular/router';
import { CountriesService } from './../countries.service';
import { Country } from './../models/countries.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-delete-country',
  templateUrl: './delete-country.component.html',
  styleUrls: ['./delete-country.component.css']
})
export class DeleteCountryComponent implements OnInit {

  country!: Country;
  submitted = false;
  countryId: number;

  constructor(private countriesService: CountriesService,
    private router: Router) {
      this.countryId = 0;
     }

  ngOnInit(): void {
  }

  delete(): void {
    this.countriesService.deleteCountry(this.countryId).subscribe(data => {
      console.log(data)
      this.goToList();
    },
    error => console.log(error));    
  }

  onSubmit() {
    this.submitted = true;
    this.delete();
  }

  goToList() {
    this.router.navigate(['/country']);
  }

}

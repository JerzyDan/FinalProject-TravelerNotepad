import { CountriesService } from './../countries.service';
import { Country } from './../models/countries.model';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-country-detail',
  templateUrl: './country-detail.component.html',
  styleUrls: ['./country-detail.component.css']
})
export class CountryDetailComponent implements OnInit {

  country: Country;

  constructor(
    private countryService: CountriesService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.country = {
      id: 1,
      name: "Valinor",
      officialLanguage: "Valarin, Quenya",
      climate: "subtropical",
      area: "unknown"
    }
   }

  ngOnInit(): void {
     
    const countryId: number = this.activatedRoute.snapshot.params['countryId'];
    console.log("This is country Id - ",countryId);

    this.countryService.getCountryById(countryId).subscribe(
      result => {
        this.country = result;
      }
    )
  }

  sendToHome(): void {
    this.router.navigate(['/country']);
  }

}

import { Country } from './../models/countries.model';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-country-item',
  templateUrl: './country-item.component.html',
  styleUrls: ['./country-item.component.css']
})
export class CountryItemComponent implements OnInit {

  @Input()
  country!: Country;

  constructor() { }

  ngOnInit(): void {
  }

}

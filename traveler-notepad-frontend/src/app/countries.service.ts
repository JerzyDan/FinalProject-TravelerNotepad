import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Country } from './models/countries.model';

@Injectable({
  providedIn: 'root'
})
export class CountriesService {

  private readonly baseUrl = 'http://localhost:8100/api/v1/country';

  constructor(private http:HttpClient) { }

  getCountries() : Observable<Country[]> {
    return this.http.get<Country[]>(this.baseUrl);
  }

  getCountryById(id: number) : Observable<Country> {
    return this.http.get<Country>(`${this.baseUrl}/${id}`);
  }

  postCountry(country: Object) : Observable<Object> {
    console.log("test payload", country);
    return this.http.post(`${this.baseUrl}/add`, country);
  }

  updateCountry(id: number, value: any) : Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteCountry(id: number) : Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

}

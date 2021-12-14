import { Place } from './models/places.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private readonly baseUrl = 'http://localhost:8300/api/v1/search';

  constructor(private http: HttpClient) { }

  getPlaceByName(name: string) : Observable<Place> {
    return this.http.get<Place>(`${this.baseUrl}/${name}`);
  }

  getPlacesByCity(city: string) : Observable<Place[]> {
    return this.http.get<Place[]>(`${this.baseUrl}/c/${city}`);
  }

  getPlacesByStatus(status: string) : Observable<Place[]> {
    return this.http.get<Place[]>(`${this.baseUrl}/s/${status}`);
  }

  getPlacesByDays(days: number) : Observable<Place[]> {
    return this.http.get<Place[]>(`${this.baseUrl}/d/${days}`);
  }

  getPlacesByCountryId(countryId: number) : Observable<Place[]> {
    return this.http.get<Place[]>(`${this.baseUrl}/ca/${countryId}`)
  }
}

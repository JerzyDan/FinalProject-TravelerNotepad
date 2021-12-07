import { Place } from './models/places.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlacesService {

  private readonly baseUrl = 'http://localhost:8000/api/v1/places';

  constructor(private http: HttpClient) { }

  getPlaces() : Observable<Place[]> {
    return this.http.get<Place[]>(this.baseUrl);
  }

  getPlaceById(id: number) : Observable<Place> {
    return this.http.get<Place>(`${this.baseUrl}/${id}`);
  }

  postPlace(place: Object) : Observable<Object> {
    return this.http.post(`${this.baseUrl}/add`, place);
  }

  updatePlace(id: number, value: any) : Observable<any> {
    return this.http.put(`${this.baseUrl}/{id}`, value);
  }

  deletePlace(id: number) : Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}

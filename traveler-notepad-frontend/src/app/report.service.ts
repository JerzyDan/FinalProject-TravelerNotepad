import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  private readonly baseUrl = 'http://localhost:8400/api/v1/report';

  constructor(private http: HttpClient) { }

  countPlacesByStatus(status: string): Observable<number> {
    return this.http.get<number>(`${this.baseUrl}/${status}`);
  }

  countCountriesByStatus(status: string) {
    return this.http.get<number>(`${this.baseUrl}/c/${status}`);
  }

  countDaysByStatus(status: string) {
    return this.http.get<number>(`${this.baseUrl}/d/${status}`);
  }

}
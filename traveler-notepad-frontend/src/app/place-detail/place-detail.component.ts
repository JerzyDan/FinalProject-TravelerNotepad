import { PlacesService } from './../places.service';
import { Place } from './../models/places.model';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-place-detail',
  templateUrl: './place-detail.component.html',
  styleUrls: ['./place-detail.component.css']
})
export class PlaceDetailComponent implements OnInit {

  place: Place;

  constructor(
    private placeService: PlacesService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.place = new Place(1, "Pelori", "Tixion", 30, 1, "Mountains of Aman", 1);
   }

  ngOnInit(): void {

    const placeId: number = this.activatedRoute.snapshot.params['placeId'];
    console.log("This is place id - ",placeId);

    this.placeService.getPlaceById(placeId).subscribe(
      result => {
        this.place = result;
      }
    )
  }

  sendToHome(): void {
    this.router.navigate(['/places']);
  }

}

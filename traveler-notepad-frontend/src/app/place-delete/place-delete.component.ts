import { Router } from '@angular/router';
import { PlacesService } from './../places.service';
import { Place } from './../models/places.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-place-delete',
  templateUrl: './place-delete.component.html',
  styleUrls: ['./place-delete.component.css']
})
export class PlaceDeleteComponent implements OnInit {

  place!: Place;
  submitted = false;
  placeId: number;

  constructor(private placeService: PlacesService, private router: Router) {
    this.placeId = 0;
  }

  ngOnInit(): void {
  }

  delete(): void {
    this.placeService.deletePlace(this.placeId).subscribe(data => {
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
    this.router.navigate(['/places']);
  }

}

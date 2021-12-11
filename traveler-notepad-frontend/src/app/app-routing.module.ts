import { PlaceDetailComponent } from './place-detail/place-detail.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SummaryComponent } from './summary/summary.component';
import { SearchComponent } from './search/search.component';
import { PlacesComponent } from './places/places.component';
import { CountriesComponent } from './countries/countries.component';
import { HomeComponent } from './home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "countries",
    component: CountriesComponent
  },
  {
    path: "places",
    component: PlacesComponent
  },
  {
    path: "places/:placeId",
    component: PlaceDetailComponent
  },
  {
    path: "search",
    component: SearchComponent
  },
  {
    path: "summary",
    component: SummaryComponent
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

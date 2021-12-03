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
    path: "search",
    component: SearchComponent
  },
  {
    path: "summary",
    component: SummaryComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
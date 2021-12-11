import { UpdateCountryComponent } from './update-country/update-country.component';
import { DeleteCountryComponent } from './delete-country/delete-country.component';
import { CreateCountryComponent } from './create-country/create-country.component';
import { CountryDetailComponent } from './country-detail/country-detail.component';
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
    path: '',
    component: HomeComponent
  },
  {
    path: 'country',
    component: CountriesComponent
  },
  {
    path: 'country/:countryId',
    component: CountryDetailComponent
  },
  {
    path: 'countryadd',
    component: CreateCountryComponent
  },
  {
    path: 'countrydelete',
    component: DeleteCountryComponent
  },
  {
    path: 'coutryupdate',
    component: UpdateCountryComponent
  },
  {
    path: 'places',
    component: PlacesComponent
  },
  {
    path: 'search',
    component: SearchComponent
  },
  {
    path: 'summary',
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

import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { CountriesComponent } from './countries/countries.component';
import { PlacesComponent } from './places/places.component';
import { SearchComponent } from './search/search.component';
import { SummaryComponent } from './summary/summary.component';
import { FooterComponent } from './footer/footer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CountryItemComponent } from './country-item/country-item.component';
import { CountryDetailComponent } from './country-detail/country-detail.component';
import { CreateCountryComponent } from './create-country/create-country.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    CountriesComponent,
    PlacesComponent,
    SearchComponent,
    SummaryComponent,
    FooterComponent,
    PageNotFoundComponent,
    CountryItemComponent,
    CountryDetailComponent,
    CreateCountryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

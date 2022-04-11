import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { SearchResults } from '../models/search-results';

@Injectable({
  providedIn: 'root'
})
export class IndicatorSearchService {

  constructor(private http: HttpClient) { }

  getPovertyIndicators(countryCode: string, page = 1, perPage = 10): Observable<SearchResults> {
    return this.http.get<SearchResults>(`${environment.serviceUrl}${countryCode}?page=${page}&per_page=${perPage}`);
  }
}

import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { IndicatorSearchService } from './indicator-search.service';

class HttpClientMock {

}

describe('IndicatorSearchService', () => {
  let service: IndicatorSearchService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        { provide: HttpClient, useClass: HttpClientMock }
      ]
    });
    service = TestBed.inject(IndicatorSearchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

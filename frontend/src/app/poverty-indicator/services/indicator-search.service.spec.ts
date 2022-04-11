import { TestBed } from '@angular/core/testing';

import { IndicatorSearchService } from './indicator-search.service';

describe('IndicatorSearchService', () => {
  let service: IndicatorSearchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IndicatorSearchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

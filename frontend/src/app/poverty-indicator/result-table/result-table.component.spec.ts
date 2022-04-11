import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { PovertyIndicatorModule } from '../poverty-indicator.module';

import { ResultTableComponent } from './result-table.component';

describe('ResultTableComponent', () => {
  let component: ResultTableComponent;
  let fixture: ComponentFixture<ResultTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        PovertyIndicatorModule,
        NoopAnimationsModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { Component, ViewChild } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PovertyIndicator } from './poverty-indicator/models/poverty-indicator-2';
import { ResultTableComponent } from './poverty-indicator/result-table/result-table.component';
import { IndicatorSearchService } from './poverty-indicator/services/indicator-search.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';

  countryCode: string;
  tableData: PovertyIndicator[] = [];
  isLoading = false;

  @ViewChild(ResultTableComponent) resultTable: ResultTableComponent;

  constructor(private indicatorSearchService: IndicatorSearchService, private snackBar: MatSnackBar) { }

  executeSearch(search: string) {
    this.countryCode = search;
    this.updateTable();
  }

  updateTable(page = 1, perPage = 10) {
    this.isLoading = true;
    this.indicatorSearchService.getPovertyIndicators(this.countryCode, page, perPage)
      .subscribe(data => {
        this.tableData = data.povertyIndicatorList;
        this.isLoading = false;
      }, _ => {
        this.snackBar.open("Verify the code and try again.", 'Close', {
          duration: 2000,
        });
        this.isLoading = false;
      });
  }
}

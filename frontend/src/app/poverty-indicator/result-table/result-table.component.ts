import { Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { PovertyIndicator } from '../models/poverty-indicator-2';

@Component({
  selector: 'app-result-table',
  templateUrl: './result-table.component.html',
  styleUrls: ['./result-table.component.scss']
})
export class ResultTableComponent implements OnInit, OnChanges {
  @Input() tableData: PovertyIndicator[] = ELEMENT_DATA;

  displayedColumns: string[] = ['countryiso3code', 'date', 'value', 'unit', 'obs_status', 'decimal'];
  dataSource = new MatTableDataSource<PovertyIndicator>(this.tableData);

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.dataSource = new MatTableDataSource<PovertyIndicator>(changes.tableData.currentValue);
  }
}

const ELEMENT_DATA: PovertyIndicator[] = [
  {
    "countryiso3code": "BRA",
    "date": "2020",
    "value": 1.7,
    "unit": "",
    "obs_status": "",
    "decimal": 1
  },
];

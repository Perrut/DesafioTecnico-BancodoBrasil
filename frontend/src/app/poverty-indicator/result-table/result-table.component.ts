import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { PovertyIndicator } from '../models/poverty-indicator';

@Component({
  selector: 'app-result-table',
  templateUrl: './result-table.component.html',
  styleUrls: ['./result-table.component.scss']
})
export class ResultTableComponent implements OnInit, OnChanges {
  @Input() tableData: PovertyIndicator[] = [];
  @Input() totalRows = 0;

  @Output() page = new EventEmitter<PageEvent>();

  displayedColumns: string[] = ['countryiso3code', 'date', 'value', 'unit', 'obs_status', 'decimal'];
  dataSource = new MatTableDataSource<PovertyIndicator>(this.tableData);

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.paginator.length = this.totalRows;
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.dataSource = new MatTableDataSource<PovertyIndicator>(changes.tableData.currentValue);
    this.paginator.length = this.totalRows;
  }

  onPage(page: PageEvent) {
    this.page.emit(page);
  }
}

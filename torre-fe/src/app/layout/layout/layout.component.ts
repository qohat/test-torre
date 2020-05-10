import {Component, OnInit} from '@angular/core';
import {LocalStorageService} from '../../core/service/local-storage.service';

@Component({
  selector: 'ct-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss']
})
export class LayoutComponent implements OnInit {

  constructor(public readonly ls: LocalStorageService) { }

  ngOnInit(): void {
  }

}

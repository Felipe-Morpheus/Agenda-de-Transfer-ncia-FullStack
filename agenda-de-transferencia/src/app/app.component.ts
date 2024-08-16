import { Component, OnInit } from '@angular/core';
import { TransferenciaService } from './transferencia.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  transferencias: any[] = [];

  constructor(private transferenciaService: TransferenciaService) { }

  ngOnInit(): void {
    this.transferenciaService.getTransferencias().subscribe(data => {
      this.transferencias = data;
    });
  }
}

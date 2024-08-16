import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';  // Importa o HttpClientModule para comunicação com o backend

import { AppComponent } from './app.component';
import { TransferenciaService } from './transferencia.service';  // Serviço para lidar com transferências

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule  // Adiciona HttpClientModule aos imports
  ],
  providers: [TransferenciaService],  // Adiciona o serviço ao providers
  bootstrap: [AppComponent]
})
export class AppModule { }

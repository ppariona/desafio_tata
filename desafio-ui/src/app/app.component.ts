import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public showGeneralProgres = false;
  monto = 10;
  monedaOrigen = 'soles';
  monedaDestino = 'dolares';

  montoRespuesta ='';
  montoTipoCambio ='';
  monedaOrigenRespuesta='';
  monedaDestinoRespuesta='';

  developer='';
  public tableData: Array<any>;

  idEdit='';
  tipoCambioEdit='';

  constructor(private http: HttpClient) {
    this.tableData = [];
  }

  ngOnInit() {
    this.listar();
  }

  cambioMoneda(path: string, request: any): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/cambio`, request);
  }

  listarCambio(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/listar`);
  }

  editarCambio(request: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8080/editar/${request.id}`, request);
  }

  listar() {
      this.listarCambio().pipe(finalize(() => this.showGeneralProgres = false))
        .subscribe((response) => {
          this.tableData = response;
        }, (error: Error) => {
          console.log(error.message);
          }
        );
  }

  consultar() {
    if(this.monto && this.monedaOrigen && this.monedaDestino){
      const request = {
        monto: this.monto,
        monedaOrigen: this.monedaOrigen,
        monedaDestino: this.monedaDestino
      }
      console.log(request)
      this.cambioMoneda('afiliacion', request).pipe(finalize(() => this.showGeneralProgres = false))
        .subscribe((response) => {
          console.log(response)
          this.montoRespuesta = response.monto;
          this.montoTipoCambio = response.montoTipoCambio;
          this.monedaOrigenRespuesta = response.monedaOrigen;
          this.monedaDestinoRespuesta = response.monedaDestino;
          this.developer = response.developer;
        }, (error: Error) => {
          console.log(error.message);
          }
        );
    }
  }

  editar(elemento: any) {
    console.log(elemento)
    this.idEdit=elemento.id;
    this.tipoCambioEdit=elemento.tipoCambio;
  }

  guardar(){
    const request = {
      id: this.idEdit,
      tipoCambio: this.tipoCambioEdit
    }

    this.editarCambio(request).pipe(finalize(() => this.showGeneralProgres = false))
    .subscribe((response) => {
      console.log(response)
      this.idEdit='';
      this.tipoCambioEdit='';
      this.listar();
    }, (error: Error) => {
      console.log(error.message);
      }
    );
  }
}

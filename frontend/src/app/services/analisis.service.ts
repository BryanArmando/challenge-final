import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Exams } from '../models/Exams';
import baserUrl from './helper';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnalisisService {

  constructor(private httpClient:HttpClient) { }

  obtenerhistorial(id:string): Observable<Exams>{
    return this.httpClient.get<Exams>(`${baserUrl}/private/historial/${id}`);
  }

  public historial(){
    return this.httpClient.get(`http://localhost:8081/api/private/analisis/all`)
  }

  public realizarAnalisis(datitos:any){
    return this.httpClient.post(`http://localhost:8081/api/public/analisis`, datitos);
  }
}

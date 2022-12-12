import { Component, OnInit } from '@angular/core';
import { AnalisisService } from 'src/app/services/analisis.service';
import  Swal  from 'sweetalert2';

@Component({
  selector: 'app-view-table',
  templateUrl: './view-table.component.html',
  styleUrls: ['./view-table.component.css']
})
export class ViewTableComponent implements OnInit {

  resultados:any=[

  ]

  constructor(private analisisService:AnalisisService) { }

  ngOnInit(): void {
    this.analisisService.historial().subscribe(
      (dato:any) => {
        this.resultados = dato;
        console.log(this.resultados);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !!','No se ha podido cargar los resultados','error');
      }
    )
  }

}

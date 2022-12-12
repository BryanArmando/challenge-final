import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AnalisisService } from 'src/app/services/analisis.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 
  public analisis = {
    "azucar": '',
    "grasa": '',
    "oxigeno": '',
    "riesgo": ''
  }

  constructor(private analisisService: AnalisisService, private snack:MatSnackBar) { }

  ngOnInit(): void {
  }
  formSubmit(){
    console.log(this.analisis);
    
    this.analisisService.realizarAnalisis(this.analisis).subscribe(
      (data:any) => {
        console.log(data);
        console.log(data.riesgo)
        Swal.fire(data.riesgo,'Riesgo de contraer una enfermedad','success');
      },(error:any) => {
        console.log(error);
        this.snack.open('Verifique que los datos unicamente sean números del 1 al 100','Aceptar',{
          duration : 5000
        });
      }
    )
  }

  

}

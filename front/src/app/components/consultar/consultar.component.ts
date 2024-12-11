import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ConsultarService } from '../../service/consultar.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-consultar',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './consultar.component.html',
  styleUrl: './consultar.component.css',
})
export class ConsultarComponent {
  formConsultar!: FormGroup;

  constructor(private fb: FormBuilder, private consultarService: ConsultarService, 
    private router: Router) {
    this.inicializarForm()
  }

  inicializarForm() {
    this.formConsultar = this.fb.group({
      tipoDocumento: ['', [Validators.required]],
      numeroDocumento: ['', [Validators.required]],
    });
  }

  consultar(){    
    if (this.formConsultar.valid) {
      this.consultarService.consultarUsuario(this.formConsultar.value).subscribe({
        next: (data) =>{
          if (data) {
            this.consultarService.setData(data)
            this.router.navigate(['../resumen'])
          }
        }
      })
    }else{
      return Object.values(this.formConsultar.controls).forEach(control =>{
        control.markAllAsTouched()
      })
    }
  }
}

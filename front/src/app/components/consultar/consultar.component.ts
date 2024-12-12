import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ConsultarService } from '../../service/consultar.service';
import { Router } from '@angular/router';
import { Usuario } from '../../model/usuario';

@Component({
  selector: 'app-consultar',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './consultar.component.html',
  styleUrl: './consultar.component.css',
})
export class ConsultarComponent {
  formConsultar!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private consultarService: ConsultarService,
    private router: Router
  ) {
    this.inicializarForm();
  }

  inicializarForm() {
    this.formConsultar = this.fb.group({
      tipoIdentificacion: ['', [Validators.required]],
      numeroIdentificacion: ['', [Validators.required]],
    });
  }

  consultar() {
    if (this.formConsultar.valid) {
      let usuario: Usuario = this.formConsultar.value;
      this.consultarService.consultarUsuario(usuario).subscribe({
        next: (data) => {
          console.log("usuario", data);
          
          if (data) {
            this.consultarService.setData(data);
            this.router.navigateByUrl('/dashboard/resumen');
          }
        },
      });
    } else {
      return Object.values(this.formConsultar.controls).forEach((control) => {
        control.markAllAsTouched();
      });
    }
  }
}

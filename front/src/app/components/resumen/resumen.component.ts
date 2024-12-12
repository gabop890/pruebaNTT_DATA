import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../model/usuario';
import { ConsultarService } from '../../service/consultar.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-resumen',
  imports: [ReactiveFormsModule],
  templateUrl: './resumen.component.html',
  styleUrl: './resumen.component.css',
})
export class ResumenComponent {
  usuario!: any;

  formResumen!: FormGroup;

  constructor(
    private consultarService: ConsultarService,
    private fb: FormBuilder
  ) {
    this.usuario = consultarService.getData();
    this.inicializarForm();
    this.formResumen.patchValue(this.usuario)
  }

  inicializarForm() {
    this.formResumen = this.fb.group({
      tipoIdentificacion: ['', [Validators.required]],
      numeroIdentificacion: ['', [Validators.required]],
      primerNombre: [''],
      segundoNombre: [''],
      primerApellido: [''],
      segundoApellido: [''],
      telefono: [''],
      direccion: [''],
      ciudadResidencia: [''],
    });
  }
}

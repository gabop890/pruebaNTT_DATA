import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../model/usuario';
import { ActivatedRoute, Router } from '@angular/router';
import { ConsultarService } from '../../service/consultar.service';

@Component({
  selector: 'app-resumen',
  imports: [],
  templateUrl: './resumen.component.html',
  styleUrl: './resumen.component.css'
})
export class ResumenComponent{

  usuario!: Usuario;

  constructor(private consultarService: ConsultarService){
this.usuario = consultarService.getData()
  }

}

import { Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ConsultarComponent } from './components/consultar/consultar.component';
import { ResumenComponent } from './components/resumen/resumen.component';

export const routes: Routes = [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  {
    path: 'dashboard',
    component: DashboardComponent, title: "Prueba NTT DATA",
    children: [
      { path: 'consultar', component: ConsultarComponent },
      { path: 'resumen', component: ResumenComponent },
    ],
  },
];

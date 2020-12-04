import { Component, OnInit } from '@angular/core';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/company', title: 'Listar Empresas',  icon:'work', class: '' },
    { path: '/create-company', title: 'Nova Empresa',  icon:'border_color', class: '' },
    { path: '/pessoa', title: 'Listar Pessoas',  icon:'attach_money', class: '' },
    { path: '/create-pessoa', title: 'Nova Pessoa',  icon:'monetization_on', class: '' },
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  };
}

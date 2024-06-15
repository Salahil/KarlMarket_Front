import { EcommerceService } from './ecommerce/services/EcommerceService';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [EcommerceService]
})
export class AppComponent {
  title = 'frontend';
}

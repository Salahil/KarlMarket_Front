import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Product } from '../models/product.module';
import { ProductOrder } from '../models/product-order.module';
import { ProductOrders } from '../models/product-orders.module';

@Injectable()
export class EcommerceService {
    private productsUrl = "/api/products";
    private ordersUrl = "/api/orders";

    private productOrder!: ProductOrder; // Indicando ao TypeScript que esta propriedade será inicializada mais tarde
    private orders: ProductOrders = new ProductOrders();

    private productOrderSubject = new Subject<ProductOrder>();
    private ordersSubject = new Subject<ProductOrders>();
    private totalSubject = new Subject<number>();

    private total: number = 0;

    ProductOrderChanged = this.productOrderSubject.asObservable();
    OrdersChanged = this.ordersSubject.asObservable();
    TotalChanged = this.totalSubject.asObservable();

    constructor(private http: HttpClient) {}

    getAllProducts(): Observable<Product[]> {
        return this.http.get<Product[]>(this.productsUrl);
    }

    saveOrder(order: ProductOrders): Observable<any> {
        return this.http.post(this.ordersUrl, order);
    }

    set SelectedProductOrder(value: ProductOrder) {
        this.productOrder = value;
        this.productOrderSubject.next(value); // Passando 'value' para o Subject
    }

    get SelectedProductOrder() {
        return this.productOrder;
    }

    set ProductOrders(value: ProductOrders) {
        this.orders = value;
        this.ordersSubject.next(value); // Passando 'value' para o Subject
    }

    get ProductOrders() {
        return this.orders;
    }

    get Total() {
        return this.total;
    }

    set Total(value: number) {
        this.total = value;
        this.totalSubject.next(value); // Passando 'value' para o Subject
    }
}

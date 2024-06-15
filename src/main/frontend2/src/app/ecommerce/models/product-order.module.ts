import { Product } from "./product.module";

export class ProductOrder {
    product: Product;
    quantity: number;

    constructor(product: Product, quantity: number) {
        this.product = product;
        this.quantity = quantity;
    }
}

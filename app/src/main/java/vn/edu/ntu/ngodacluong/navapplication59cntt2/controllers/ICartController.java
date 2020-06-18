package vn.edu.ntu.ngodacluong.navapplication59cntt2.controllers;

import java.util.List;

import vn.edu.ntu.ngodacluong.navapplication59cntt2.models.Product;

public interface ICartController {
    public boolean addProduct(Product product);
    public List<Product> getProduct();
    public void clearCart();
}

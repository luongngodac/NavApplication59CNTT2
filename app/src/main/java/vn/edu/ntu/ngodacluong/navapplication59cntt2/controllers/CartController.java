package vn.edu.ntu.ngodacluong.navapplication59cntt2.controllers;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.ngodacluong.navapplication59cntt2.models.Product;

public class CartController extends Application implements ICartController{
    List<Product> productList = new ArrayList<>();
    @Override
    public boolean addProduct(Product product) {
        if (!productList.contains(product)){
            productList.add(product);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getProduct() {
        return productList;
    }

    @Override
    public void clearCart() {
        productList.clear();

    }
}

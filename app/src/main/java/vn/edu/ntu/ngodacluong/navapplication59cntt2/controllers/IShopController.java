package vn.edu.ntu.ngodacluong.navapplication59cntt2.controllers;

import java.util.List;

import vn.edu.ntu.ngodacluong.navapplication59cntt2.models.Product;

interface IShopController {
    public List<Product> getAllProduct();
    public void addProduct(Product product);
}

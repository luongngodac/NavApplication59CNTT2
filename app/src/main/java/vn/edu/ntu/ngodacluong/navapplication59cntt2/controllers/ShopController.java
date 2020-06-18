package vn.edu.ntu.ngodacluong.navapplication59cntt2.controllers;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.ngodacluong.navapplication59cntt2.models.Product;

public class ShopController implements IShopController{
    private static ShopController instance;
    List<Product> productList;

    private ShopController(){
        productList = new ArrayList<>();
        productList.add(new Product("Chuối Đà Lạt - Nha Trang", 25000, "Chuối không hạt"));
        productList.add(new Product("Xoài Cam Ranh", 22000, "Xoài hạt lép"));
        productList.add(new Product("Đậu phộng Quảng Nam", 30000, "Đậu phộng hạt bự"));
        productList.add(new Product("Dưa hấu Phú Quốc", 11000, "Không hạt"));
        productList.add(new Product("Nho Ninh Thuận", 56000, "Nho không có hột "));
        productList.add(new Product("Rau muống ", 67000, "Rau muống sông "));
        productList.add(new Product("Bơ Kon Tum", 87000, "Ăn thì ngon thôi rồi"));
    }

    public static ShopController getInstance(){
        if (instance == null){
            instance = new ShopController();
        }
        return  instance;
    }

    @Override
    public List<Product> getAllProduct() {
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        productList.add(product);

    }
}

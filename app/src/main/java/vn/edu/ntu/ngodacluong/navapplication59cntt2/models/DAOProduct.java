package vn.edu.ntu.ngodacluong.navapplication59cntt2.models;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.ArrayList;

@Dao//Data access object.
public interface DAOProduct {
    @Insert
    public void insertProduct(Product...products);//insertProduct: ghi chu gi cung duoc
    //Product...products cai Product co the la 1 , 2, 3 , nhieu product khi truyen vao .
    //neu nhieu thi  chi can dua vao mot cai mang
    @Update
    public void updateProduct(Product...products);
    //update trong bang product.
    @Delete
    public void deleteProduct(Product...products);
    //delete ra khoi bang product.

    @Query("SELECT * FROM Product")
    List<Product> getListProduct();
    @Query("SELECT * FROM Product WHERE id = :id")// sau dau : chinh la bien phia duoi.
    public Product getProductById(long id);


}

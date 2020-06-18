package vn.edu.ntu.ngodacluong.navapplication59cntt2.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "Product")
public class Product {

    @PrimaryKey(autoGenerate = true) //khi deploy ung dung roi thi phai go ung dung ra moi duoc.

    int id;
    @NonNull
    String name;
    @NonNull
    int price;
    String desc;

    public Product(String name, int price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }
}

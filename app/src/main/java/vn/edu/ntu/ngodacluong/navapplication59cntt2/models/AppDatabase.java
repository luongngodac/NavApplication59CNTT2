package vn.edu.ntu.ngodacluong.navapplication59cntt2.models;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = (Product.class), version=1)//version la do minh chon, ten gi cung duoc
public abstract class AppDatabase extends RoomDatabase {
    public abstract DAOProduct getProductDAO();
}

package vn.edu.ntu.ngodacluong.navapplication59cntt2.demo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import vn.edu.ntu.ngodacluong.navapplication59cntt2.R;
import vn.edu.ntu.ngodacluong.navapplication59cntt2.controllers.ShopController;
import vn.edu.ntu.ngodacluong.navapplication59cntt2.models.Product;

public class AddingProductFragment extends Fragment {
    EditText edtName, edtPrice, edtDesc;
    Button btnAdd;
    NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("THÊM MẶT HÀNG");

        //Inflate the layout for thí fragement.
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);
        edtName = view.findViewById(R.id.edtName);
        edtPrice = view.findViewById(R.id.edtPrice);
        edtDesc = view.findViewById(R.id.edtDesc);
        btnAdd = view.findViewById(R.id.btnAdd);

        return  view;
    }


    public void onViewCreated(View view, Bundle saveInstanceSate){
        super.onViewCreated(view, saveInstanceSate);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String price = edtPrice.getText().toString();
                String desc = edtDesc.getText().toString();

                if(name.length() > 0 && price.length() > 0 && desc.length() > 0){
                    ShopController.getInstance().addProduct(new Product(name,new Integer(price), desc));
                    Toast.makeText(getActivity(), "Thêm sản phẩm thành công!", Toast.LENGTH_SHORT).show();
                    edtName.setText("");
                    edtPrice.setText("");
                    edtDesc.setText("");
                }
                else {
                    Toast.makeText(getActivity(), "Chưa nhập đủ thông tin sản phẩm", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        navController = NavHostFragment.findNavController(this);
        ((MainActivity) getActivity()).navController = navController;
    }
}

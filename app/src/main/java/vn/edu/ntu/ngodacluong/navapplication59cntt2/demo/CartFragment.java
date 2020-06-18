package vn.edu.ntu.ngodacluong.navapplication59cntt2.demo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.List;

import vn.edu.ntu.ngodacluong.navapplication59cntt2.R;
import vn.edu.ntu.ngodacluong.navapplication59cntt2.controllers.CartController;
import vn.edu.ntu.ngodacluong.navapplication59cntt2.models.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {
  Button btnBuyCart, btnDeleteCart;
  TextView txtCartInfo;
  CartController cartController;
  NavController navController;

  public CartFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    getActivity().setTitle("GIỎ HÀNG");

    // Inflate the layout for this fragment
    View view =  inflater.inflate(R.layout.fragment_cart, container, false);
    btnBuyCart = view.findViewById(R.id.btnBuyCart);
    btnDeleteCart = view.findViewById(R.id.btnDeleteCart);
    txtCartInfo = view.findViewById(R.id.txtCartInfo);

    cartController = (CartController) getActivity().getApplication();

    List<Product> products = cartController.getProduct();
    if (products.size() > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      for (Product product : products) {
        stringBuilder.append(product.getName());
        stringBuilder.append(": ");
        stringBuilder.append(product.getPrice());
        stringBuilder.append("đ\n");
      }
      txtCartInfo.setText(stringBuilder.toString());
    } else {
      txtCartInfo.setText("Không có mặt hàng trong giỏ");
    }

    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    btnBuyCart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        List<Product> products = cartController.getProduct();
        if (products.size() > 0) {
          StringBuilder stringBuilder = new StringBuilder();
          int sumPrice = 0;
          for (Product product : products) {
            stringBuilder.append(product.getName());
            stringBuilder.append(": ");
            stringBuilder.append(product.getPrice());
            stringBuilder.append("đ\n");
            sumPrice += product.getPrice();
          }
          stringBuilder.append("Thành tiền: ");
          stringBuilder.append(sumPrice);
          stringBuilder.append("đ");

          Bundle bundle = new Bundle();
          bundle.putString("info", stringBuilder.toString());

          cartController.clearCart();
          txtCartInfo.setText("Không có mặt hàng trong giỏ");

          NavHostFragment.findNavController(CartFragment.this)
                  .navigate(R.id.action_cartFragment_to_confirmFragment, bundle);
        } else {
          Toast.makeText(getActivity(), "Không có mặt hàng trong giỏ, không thể đặt hàng", Toast.LENGTH_SHORT).show();
        }
      }
    });

    btnDeleteCart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        cartController.clearCart();
        txtCartInfo.setText("Không có mặt hàng trong giỏ");
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

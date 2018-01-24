package com.example.a.sabjimall.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.sabjimall.ClickListener;
import com.example.a.sabjimall.R;
import com.example.a.sabjimall.models.Fruit;
import com.example.a.sabjimall.models.Fruits;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by A on 26/12/2017.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ProductHolder> {

private List<Fruit> results;
private Context context;
        ClickListener listener;

// private List<String> friendList;
private List<Fruits> searchList;


public class ProductHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView imgProduct,cartPlus,cartMinus;
    TextView txtDriverName, txtProductQnt,txtProductPrice,addQnt,p_code;



    private WeakReference<ClickListener> listenerWeakReference;

    public ProductHolder(View view, ClickListener listener) {
        super(view);
        imgProduct = (ImageView)view.findViewById(R.id.list_image);

        txtDriverName = (TextView)view.findViewById(R.id.from_name);
        txtProductQnt = (TextView)view.findViewById(R.id.plist_weight_text);
        txtProductPrice = (TextView)view.findViewById(R.id.plist_price_text);
        p_code=(TextView)view.findViewById(R.id.prod_code);

        addQnt=(TextView)view.findViewById(R.id.cart_product_quantity_tv);

        cartPlus=(ImageView)view.findViewById(R.id.cart_plus_img);
        cartMinus=(ImageView)view.findViewById(R.id.cart_minus_img);

        listenerWeakReference = new WeakReference<>(listener);

        cartPlus.setOnClickListener(this);
        cartMinus.setOnClickListener(this);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == cartPlus.getId()) {
            Integer qnt = Integer.valueOf(addQnt.getText().toString().trim());
            Integer aa = qnt + 1;
            addQnt.setText(aa.toString());

            Integer price=Integer.valueOf(txtProductPrice.getText().toString().trim());
            Integer total=price*aa;

            String prod_cade=p_code.getText().toString();

            Snackbar snackbar= Snackbar.make(v, "Rs."+total.toString(), Snackbar.LENGTH_LONG)
                    .setAction("Check Out", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

            //snackbar.setActionTextColor(Color.RED);

            // Changing action button text color
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);
            snackbar.setDuration(50000);
            snackbar.show();

            notifyDataSetChanged();
        }
        else if (v.getId() == cartMinus.getId()) {
            Integer qnt= Integer.valueOf(addQnt.getText().toString().trim());
            Integer aa=qnt-1;
            if(aa>=0)
                addQnt.setText(aa.toString());
            notifyDataSetChanged();
        } else {
            //Row pressed
            FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            final FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.addToBackStack("ShowDetailsFragment");
            /*    transaction.setCustomAnimations(R.anim.slide_in_side, R.anim.slide_out_side,
                        R.anim.slide_in_side, R.anim.slide_out_side);
                transaction.replace(R.id.main_view,
                        ViewFragment.newInstance(cartList.get(getAdapterPosition())),
                        "ShowDetailsFragment").commit();
*/
        }

        listenerWeakReference.get().onPositionClicked(getAdapterPosition());
    }
}







    public CartAdapter(Context context, List<Fruit> results, ClickListener clickListener) {
        this.results = results;
        this.context = context;
        this.listener=clickListener;
    }


    @Override
    public CartAdapter.ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vegetables_list, parent, false);
        CartAdapter.ProductHolder holder=new CartAdapter.ProductHolder(view,listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProductHolder holder, int position) {
        Fruit jobData = results.get(position);

        holder.txtDriverName.setText(jobData.getPname());
        holder.txtProductQnt.setText(jobData.getPqnt());
        holder.txtProductPrice.setText(jobData.getPrice());
        holder.addQnt.setText(jobData.getAddqnt());

      //  holder.p_code.setText(jobData.getProductCode());
      //  Picasso.with(context).load("http://admin.kiransveg.com/ProductImage/"+jobData.getProductImage()).into(holder.imgProduct);
        //  Glide.with(context).load(jobData.getProductImage()).into(holder.imgProduct);

    }



    @Override
    public int getItemCount() {
        return results.size();
    }


}


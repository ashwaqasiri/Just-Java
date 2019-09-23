package com.example.ashwaq.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import android.content.Intent;

public class Justjava extends AppCompatActivity {

    int quantity = 2;

    //boolean checked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_justjava);
    }

    public void increment(View view) {
        //  int numberinc=2;
        if (quantity <= 100) {
            quantity = quantity + 1;
            displayQuantity(quantity);
        } else {
            Toast.makeText(getApplication(), "sorry can not be more than 100 of cups", Toast.LENGTH_SHORT).show();
        }
    }

    public void decrement(View view) {
        // int numberdec = 2;
        if (quantity >=1) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        } else {
            Toast.makeText(getApplication(), "sorry can not be negative", Toast.LENGTH_SHORT).show();
        }
    }

   /* public void onCheckboxClicked(View view){
      checked =true;
    }*/

    public void submitOrder(View view) {
        // display(quantity);
        //  int price= calcPrice();
        CheckBox check=(CheckBox)findViewById(R.id.Cream);
        boolean hasckecked=check.isChecked();
        CheckBox  choco=(CheckBox)findViewById(R.id.Choco);
        boolean hasckecked2=choco.isChecked();
        EditText name=(EditText)findViewById(R.id.NAME);
        String value=name.getText().toString();
        int p = calcPrice(hasckecked,hasckecked2);
        createOrderSummary( p,hasckecked,hasckecked2,value);


    }

    private int calcPrice(boolean hascream,boolean haschoco) {
        int pricebase=5;
        if (hascream){
            pricebase=pricebase+1;
        }
        if (haschoco){
            pricebase=pricebase+2;
        }
            int finalprice= quantity*pricebase;
        return finalprice;



    }

    private void createOrderSummary(int price,boolean ch,boolean chocolate,String N) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "cs@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java");
        intent.putExtra(Intent.EXTRA_TEXT, " name: " +N +"\n Add whipped cream= "+ch+"\n Add Chocolate= "+chocolate+ "\n quantity= " + quantity + "\n Total= " + price + "\n Thank you...\n");

        startActivity(Intent.createChooser(intent, "Send Email"));}
        // int p = calcPrice();
//        String summary = " name: "+N +"\n Add whipped cream= "+ch+"\n Add Chocolate= "+chocolate+ "\n quantity= " + quantity + "\n Total= " + price + "\n Thank you...";
//        return summary;
        //Toast toast = Toast.makeText("name=Ashwaq" + "/n quantity= " + quantity + "Total= " + p + "Thank you...");


    private void displaymessage(String message) {
        TextView ordersummarytextview = (TextView) findViewById(R.id.order_summary_text_view);
        ordersummarytextview.setText(message);
    }

    private void displayQuantity(int num) {
        TextView Howmany = (TextView) findViewById(R.id.howmany);
        Howmany.setText("" + num);
    }

}
  /*  <ImageView
        android:id="@+id/Coffee"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:scaleType="centerCrop"
        android:src="@drawable/night"
        android:visibility="visible" android:contentDescription="@string/todo" />

        --------------------------------
         <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:visibility="visible"
        android:layout_marginLeft="10dp"
        android:layout_marginStart="10dp">


        */




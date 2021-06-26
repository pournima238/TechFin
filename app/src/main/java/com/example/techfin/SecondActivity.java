package com.example.techfin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.techfin.Fragments.FifthFragment;
import com.example.techfin.Fragments.FirstFragment;
import com.example.techfin.Fragments.FourthFragment;
import com.example.techfin.Fragments.SecondFragment;
import com.example.techfin.Fragments.ThirdFragment;

public class SecondActivity extends AppCompatActivity {
    //String url="https://api.spoonacular.com/food/menuItems/";
//    private TextView textView;
//    private TextView textView2;
    private Button firstBtn, secBtn, thirBtn, fourBtn, fivBtn;
    LinearLayout linearLayoutF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        firstBtn=findViewById(R.id.firstBtn);
        secBtn=findViewById(R.id.secBtn);
        thirBtn=findViewById(R.id.thirBtn);
        fourBtn=findViewById(R.id.fourBtn);
        fivBtn=findViewById(R.id.fivBtn);


        linearLayoutF=findViewById(R.id.linearLayoutF);
//        textView=findViewById(R.id.textView);
//        textView2=findViewById(R.id.textView2);
        //getRetrofitObject();
      firstBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              FirstFragment firstFragment=new FirstFragment();
              FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
              transaction.replace(R.id.linearLayoutF, firstFragment);
              transaction.commit();
          }
      });
      secBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              SecondFragment secondFragment=new SecondFragment() ;
              FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
              transaction.replace(R.id.linearLayoutF,secondFragment);
              transaction.commit();
          }
      });
      thirBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              ThirdFragment thirdFragment=new ThirdFragment() ;
              FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
              transaction.replace(R.id.linearLayoutF,thirdFragment);
              transaction.commit();

          }
      });
      fourBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              FourthFragment fourthFragment= new FourthFragment();
              FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
              transaction.replace(R.id.linearLayoutF, fourthFragment);
              transaction.commit();
          }
      });
      fivBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              FifthFragment fifthFragment=new FifthFragment();
              FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
              transaction.replace(R.id.linearLayoutF, fifthFragment);
              transaction.commit();

          }
      });



    }
//    public void getRetrofitObject(){
//        Retrofit retrofit= new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        RetrofitObjectAPI service=retrofit.create(RetrofitObjectAPI.class);
//        Call<model> call= service.getJsonObjectData();
//        call.enqueue(new Callback<model>() {
//            @Override
//            public void onResponse(Call<model> call, Response<model> response) {
//                //textView.setText(response.body().getTitle());
//                textView.setText(response.body().getNutrition().getNutrients().get(0).getName());
//                textView2.setText(response.body().getNutrition().getNutrients().get(1).getName());
//
//            }
//
//            @Override
//            public void onFailure(Call<model> call, Throwable t) {
//                Toast.makeText(SecondActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
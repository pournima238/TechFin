package com.example.techfin.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.techfin.R;
import com.example.techfin.RetrofitObjectAPI;
import com.example.techfin.model;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SecondFragment extends Fragment {





    public SecondFragment() {
        // Required empty public constructor
    }
    //TextView textView11, textView12;
    private TextView textView41, textView42, textView43, textView44, textView45, recipeName4;
    private TextView textView41Amount,textView42Amount,textView43Amount,textView44Amount,textView45Amount;
    PieChart pieChart2;
    String url="https://api.spoonacular.com/food/menuItems/";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_second,container,false);
        //textView11=view.findViewById(R.id.textView11);
        //textView12=view.findViewById(R.id.textView12);
        textView41=view.findViewById(R.id.textView41);
        textView42=view.findViewById(R.id.textView42);
        textView43=view.findViewById(R.id.textView43);
        textView44=view.findViewById(R.id.textView44);
        textView45=view.findViewById(R.id.textView45);
        recipeName4=view.findViewById(R.id.recipeName4);
        textView41Amount=view.findViewById(R.id.textView41Amount);
        textView42Amount=view.findViewById(R.id.textView42Amount);
        textView43Amount=view.findViewById(R.id.textView43Amount);
        textView44Amount=view.findViewById(R.id.textView44Amount);
        textView45Amount=view.findViewById(R.id.textView45Amount);
        pieChart2=view.findViewById(R.id.pieChart2);

        getRetrofitObject();
        return view;
    }
    public void getRetrofitObject() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);
        Call<model> call = service.getJsonObjectDataType1();
        call.enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                //textView.setText(response.body().getTitle());
               // textView11.setText(response.body().getNutrition().getNutrients().get(0).getName());
                //textView12.setText(response.body().getNutrition().getNutrients().get(1).getName());
                float a1= Float.parseFloat(response.body().getNutrition().getNutrients().get(0).getAmount());
                float a2= Float.parseFloat(response.body().getNutrition().getNutrients().get(1).getAmount());
                float a3= Float.parseFloat(response.body().getNutrition().getNutrients().get(2).getAmount());
                float a4= Float.parseFloat(response.body().getNutrition().getNutrients().get(3).getAmount());
                float a5= Float.parseFloat(response.body().getNutrition().getNutrients().get(4).getAmount());

                recipeName4.setText(response.body().getTitle());
                textView41.setText(response.body().getNutrition().getNutrients().get(0).getName());
                textView42.setText(response.body().getNutrition().getNutrients().get(1).getName());
                textView43.setText(response.body().getNutrition().getNutrients().get(2).getName());
                textView44.setText(response.body().getNutrition().getNutrients().get(3).getName());
                textView45.setText(response.body().getNutrition().getNutrients().get(4).getName());
                textView41Amount.setText(response.body().getNutrition().getNutrients().get(0).getAmount());
                textView42Amount.setText(response.body().getNutrition().getNutrients().get(1).getAmount());
                textView43Amount.setText(response.body().getNutrition().getNutrients().get(2).getAmount());
                textView44Amount.setText(response.body().getNutrition().getNutrients().get(3).getAmount());
                textView45Amount.setText(response.body().getNutrition().getNutrients().get(4).getAmount());

                pieChart2.addPieSlice(new PieModel("A",a1, getResources().getColor(R.color.yellow)));
                pieChart2.addPieSlice(new PieModel("B",a2, getResources().getColor(R.color.blue_pie)));
                pieChart2.addPieSlice(new PieModel("C",a3, getResources().getColor(R.color.green_pie)));
                pieChart2.addPieSlice(new PieModel("D",a4, getResources().getColor(R.color.red_pie)));
                pieChart2.addPieSlice(new PieModel("D",a5, getResources().getColor(R.color.pink)));

                pieChart2.startAnimation();

            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {
                //Toast.makeText(FirstFragment.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

        }
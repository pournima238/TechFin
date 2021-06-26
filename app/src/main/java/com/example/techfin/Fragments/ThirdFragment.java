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


public class ThirdFragment extends Fragment {



    public ThirdFragment() {
        // Required empty public constructor
    }
    private TextView textView31, textView32, textView33, textView34, textView35, recipeName3;
    private TextView textView31Amount,textView32Amount,textView33Amount,textView34Amount,textView35Amount;
    PieChart pieChart3;
    String url="https://api.spoonacular.com/food/menuItems/";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_third,container,false);
        textView31=view.findViewById(R.id.textView31);
        textView32=view.findViewById(R.id.textView32);
        textView33=view.findViewById(R.id.textView33);
        textView34=view.findViewById(R.id.textView34);
        textView35=view.findViewById(R.id.textView35);
        recipeName3=view.findViewById(R.id.recipeName3);
        textView31Amount=view.findViewById(R.id.textView31Amount);
        textView32Amount=view.findViewById(R.id.textView32Amount);
        textView33Amount=view.findViewById(R.id.textView33Amount);
        textView34Amount=view.findViewById(R.id.textView34Amount);
        textView35Amount=view.findViewById(R.id.textView35Amount);
        pieChart3=view.findViewById(R.id.pieChart3);
        getRetrofitObject();
        return view;
    }
    public void getRetrofitObject() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);
        Call<model> call = service.getJsonObjectDataType2();
        call.enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                //textView.setText(response.body().getTitle());
                float b1= Float.parseFloat(response.body().getNutrition().getNutrients().get(0).getAmount());
                float b2= Float.parseFloat(response.body().getNutrition().getNutrients().get(1).getAmount());
                float b3= Float.parseFloat(response.body().getNutrition().getNutrients().get(2).getAmount());
                float b4= Float.parseFloat(response.body().getNutrition().getNutrients().get(3).getAmount());
                float b5= Float.parseFloat(response.body().getNutrition().getNutrients().get(4).getAmount());

                recipeName3.setText(response.body().getTitle());
                textView31.setText(response.body().getNutrition().getNutrients().get(0).getName());
                textView32.setText(response.body().getNutrition().getNutrients().get(1).getName());
                textView33.setText(response.body().getNutrition().getNutrients().get(2).getName());
                textView34.setText(response.body().getNutrition().getNutrients().get(3).getName());
                textView35.setText(response.body().getNutrition().getNutrients().get(4).getName());
                textView31Amount.setText(response.body().getNutrition().getNutrients().get(0).getAmount());
                textView32Amount.setText(response.body().getNutrition().getNutrients().get(1).getAmount());
                textView33Amount.setText(response.body().getNutrition().getNutrients().get(2).getAmount());
                textView34Amount.setText(response.body().getNutrition().getNutrients().get(3).getAmount());
                textView35Amount.setText(response.body().getNutrition().getNutrients().get(4).getAmount());

                pieChart3.addPieSlice(new PieModel("A",b1, getResources().getColor(R.color.yellow)));
                pieChart3.addPieSlice(new PieModel("B",b2, getResources().getColor(R.color.blue_pie)));
                pieChart3.addPieSlice(new PieModel("C",b3, getResources().getColor(R.color.green_pie)));
                pieChart3.addPieSlice(new PieModel("D",b4, getResources().getColor(R.color.red_pie)));
                pieChart3.addPieSlice(new PieModel("E",b5, getResources().getColor(R.color.pink)));

                pieChart3.startAnimation();

            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {
                //Toast.makeText(FirstFragment.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
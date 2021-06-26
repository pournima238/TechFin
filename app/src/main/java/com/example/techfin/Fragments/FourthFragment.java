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


public class FourthFragment extends Fragment {


    public FourthFragment() {
        // Required empty public constructor
    }
 //TextView tp;
 private TextView textView51, textView52, textView53, textView54, textView55, recipeName5;
    private TextView textView51Amount,textView52Amount,textView53Amount,textView54Amount,textView55Amount;
    PieChart pieChart4;
    String url="https://api.spoonacular.com/food/menuItems/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fourth, container, false);
        //tp=view.findViewById(R.id.tp);
        textView51=view.findViewById(R.id.textView51);
        textView52=view.findViewById(R.id.textView52);
        textView53=view.findViewById(R.id.textView53);
        textView54=view.findViewById(R.id.textView54);
        textView55=view.findViewById(R.id.textView55);
        recipeName5=view.findViewById(R.id.recipeName5);
        textView51Amount=view.findViewById(R.id.textView51Amount);
        textView52Amount=view.findViewById(R.id.textView52Amount);
        textView53Amount=view.findViewById(R.id.textView53Amount);
        textView54Amount=view.findViewById(R.id.textView54Amount);
        textView55Amount=view.findViewById(R.id.textView55Amount);
        pieChart4=view.findViewById(R.id.pieChart4);

        getRetrofitObject();
        return view;

    }
    public void getRetrofitObject() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);
        Call<model> call = service.getJsonObjectDataType3();
        call.enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                //textView.setText(response.body().getTitle());
                // textView11.setText(response.body().getNutrition().getNutrients().get(0).getName());
                //textView12.setText(response.body().getNutrition().getNutrients().get(1).getName());
                float c1= Float.parseFloat(response.body().getNutrition().getNutrients().get(0).getAmount());
                float c2= Float.parseFloat(response.body().getNutrition().getNutrients().get(1).getAmount());
                float c3= Float.parseFloat(response.body().getNutrition().getNutrients().get(2).getAmount());
                float c4= Float.parseFloat(response.body().getNutrition().getNutrients().get(3).getAmount());
                float c5= Float.parseFloat(response.body().getNutrition().getNutrients().get(4).getAmount());

                recipeName5.setText(response.body().getTitle());
                textView51.setText(response.body().getNutrition().getNutrients().get(0).getName());
                textView52.setText(response.body().getNutrition().getNutrients().get(1).getName());
                textView53.setText(response.body().getNutrition().getNutrients().get(2).getName());
                textView54.setText(response.body().getNutrition().getNutrients().get(3).getName());
                textView55.setText(response.body().getNutrition().getNutrients().get(4).getName());
                textView51Amount.setText(response.body().getNutrition().getNutrients().get(0).getAmount());
                textView52Amount.setText(response.body().getNutrition().getNutrients().get(1).getAmount());
                textView53Amount.setText(response.body().getNutrition().getNutrients().get(2).getAmount());
                textView54Amount.setText(response.body().getNutrition().getNutrients().get(3).getAmount());
                textView55Amount.setText(response.body().getNutrition().getNutrients().get(4).getAmount());

                pieChart4.addPieSlice(new PieModel("A",c1, getResources().getColor(R.color.yellow)));
                pieChart4.addPieSlice(new PieModel("B",c2, getResources().getColor(R.color.blue_pie)));
                pieChart4.addPieSlice(new PieModel("C",c3, getResources().getColor(R.color.green_pie)));
                pieChart4.addPieSlice(new PieModel("D",c4, getResources().getColor(R.color.red_pie)));
                pieChart4.addPieSlice(new PieModel("E",c5, getResources().getColor(R.color.pink)));

                pieChart4.startAnimation();

            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {
                //Toast.makeText(FirstFragment.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
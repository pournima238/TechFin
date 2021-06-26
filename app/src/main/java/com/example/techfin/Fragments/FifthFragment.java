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


public class FifthFragment extends Fragment {


    public FifthFragment() {
        // Required empty public constructor
    }
    private TextView textView71, textView72, textView73, textView74, textView75, recipeName7;
    private TextView textView71Amount,textView72Amount,textView73Amount,textView74Amount,textView75Amount;
    PieChart pieChart5;
    String url="https://api.spoonacular.com/food/menuItems/";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fifth, container, false);
        textView71=view.findViewById(R.id.textView71);
        textView72=view.findViewById(R.id.textView72);
        textView73=view.findViewById(R.id.textView73);
        textView74=view.findViewById(R.id.textView74);
        textView75=view.findViewById(R.id.textView75);
        recipeName7=view.findViewById(R.id.recipeName7);
        textView71Amount=view.findViewById(R.id.textView71Amount);
        textView72Amount=view.findViewById(R.id.textView72Amount);
        textView73Amount=view.findViewById(R.id.textView73Amount);
        textView74Amount=view.findViewById(R.id.textView74Amount);
        textView75Amount=view.findViewById(R.id.textView75Amount);
        pieChart5=view.findViewById(R.id.pieChart5);

        getRetrofitObject();
        return view;
    }
    public void getRetrofitObject() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);
        Call<model> call = service.getJsonObjectDataType4();
        call.enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                //textView.setText(response.body().getTitle());
                // textView11.setText(response.body().getNutrition().getNutrients().get(0).getName());
                //textView12.setText(response.body().getNutrition().getNutrients().get(1).getName());
                float d1= Float.parseFloat(response.body().getNutrition().getNutrients().get(0).getAmount());
                float d2= Float.parseFloat(response.body().getNutrition().getNutrients().get(1).getAmount());
                float d3= Float.parseFloat(response.body().getNutrition().getNutrients().get(2).getAmount());
                float d4= Float.parseFloat(response.body().getNutrition().getNutrients().get(3).getAmount());
                float d5= Float.parseFloat(response.body().getNutrition().getNutrients().get(4).getAmount());

                recipeName7.setText(response.body().getTitle());
                textView71.setText(response.body().getNutrition().getNutrients().get(0).getName());
                textView72.setText(response.body().getNutrition().getNutrients().get(1).getName());
                textView73.setText(response.body().getNutrition().getNutrients().get(2).getName());
                textView74.setText(response.body().getNutrition().getNutrients().get(3).getName());
                textView75.setText(response.body().getNutrition().getNutrients().get(4).getName());
                textView71Amount.setText(response.body().getNutrition().getNutrients().get(0).getAmount());
                textView72Amount.setText(response.body().getNutrition().getNutrients().get(1).getAmount());
                textView73Amount.setText(response.body().getNutrition().getNutrients().get(2).getAmount());
                textView74Amount.setText(response.body().getNutrition().getNutrients().get(3).getAmount());
                textView75Amount.setText(response.body().getNutrition().getNutrients().get(4).getAmount());

                pieChart5.addPieSlice(new PieModel("A",d1, getResources().getColor(R.color.yellow)));
                pieChart5.addPieSlice(new PieModel("B",d2, getResources().getColor(R.color.blue_pie)));
                pieChart5.addPieSlice(new PieModel("C",d3, getResources().getColor(R.color.green_pie)));
                pieChart5.addPieSlice(new PieModel("D",d4, getResources().getColor(R.color.red_pie)));
                pieChart5.addPieSlice(new PieModel("D",d5, getResources().getColor(R.color.pink)));

                pieChart5.startAnimation();

            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {
                //Toast.makeText(FirstFragment.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.techfin.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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


public class FirstFragment extends Fragment {



    public FirstFragment() {
        // Required empty public constructor
    }

    private TextView textView;
    private TextView textView2, textView3,textView4,textView5;
    private TextView recipeName;
    private TextView textViewAmount, textView2Amount, textView3Amount,textView4Amount, textView5Amount;
    PieChart pieChart1;
    String url="https://api.spoonacular.com/food/menuItems/";
    View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     view=inflater.inflate(R.layout.fragment_first,container,false);

    textView=view.findViewById(R.id.textView);
      textView2=view.findViewById(R.id.textView2);
      textView3=view.findViewById(R.id.textView3);
      textView4=view.findViewById(R.id.textView4);
      textView5=view.findViewById(R.id.textView5);
      recipeName=view.findViewById(R.id.recipeName);
      textViewAmount=view.findViewById(R.id.textViewAmount);
      textView2Amount=view.findViewById(R.id.textView2Amount);
      textView3Amount=view.findViewById(R.id.textView3Amount);
      textView4Amount=view.findViewById(R.id.textView4Amount);
      textView5Amount=view.findViewById(R.id.textView5Amount);
      pieChart1=view.findViewById(R.id.pieChart1);
        getRetrofitObject();
    return view;
    }

    public void getRetrofitObject(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitObjectAPI service=retrofit.create(RetrofitObjectAPI.class);
        Call<model> call= service.getJsonObjectData();
        call.enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                //textView.setText(response.body().getTitle());
//              int amount=Integer.parseInt(response.body().getNutrition().getNutrients().get(0).getAmount());
//              textViewAmount.setText(amount);
                float f1= Float.parseFloat(response.body().getNutrition().getNutrients().get(0).getAmount());
                float f2= Float.parseFloat(response.body().getNutrition().getNutrients().get(1).getAmount());
                float f3= Float.parseFloat(response.body().getNutrition().getNutrients().get(2).getAmount());
                float f4= Float.parseFloat(response.body().getNutrition().getNutrients().get(3).getAmount());
                float f5= Float.parseFloat(response.body().getNutrition().getNutrients().get(4).getAmount());


                recipeName.setText(response.body().getTitle());
                textView.setText(response.body().getNutrition().getNutrients().get(0).getName());
                textView2.setText(response.body().getNutrition().getNutrients().get(1).getName());
                textView3.setText(response.body().getNutrition().getNutrients().get(2).getName());
                textView4.setText(response.body().getNutrition().getNutrients().get(3).getName());
                textView5.setText(response.body().getNutrition().getNutrients().get(4).getName());
                textViewAmount.setText(response.body().getNutrition().getNutrients().get(0).getAmount());
                textView2Amount.setText(response.body().getNutrition().getNutrients().get(1).getAmount());
                textView3Amount.setText(response.body().getNutrition().getNutrients().get(2).getAmount());
                textView4Amount.setText(response.body().getNutrition().getNutrients().get(3).getAmount());
                textView5Amount.setText(response.body().getNutrition().getNutrients().get(4).getAmount());

                pieChart1.addPieSlice(new PieModel("A",f1, getResources().getColor(R.color.yellow)));
                pieChart1.addPieSlice(new PieModel("B",f2, getResources().getColor(R.color.blue_pie)));
                pieChart1.addPieSlice(new PieModel("C",f3, getResources().getColor(R.color.green_pie)));
                pieChart1.addPieSlice(new PieModel("D",f4, getResources().getColor(R.color.red_pie)));
                pieChart1.addPieSlice(new PieModel("E",f5, getResources().getColor(R.color.pink)));

                pieChart1.startAnimation();



            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {
                //Toast.makeText(FirstFragment.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                //\Toast.makeText(, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
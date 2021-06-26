package com.example.techfin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
private TextView marqueeText;
private RecyclerView recyclerView;
private DataAdapter adapter;
private List<Contact> contactList;
ApiInterface apiInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        marqueeText=findViewById(R.id.marqueeText);
        marqueeText.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        marqueeText.setSelected(true);
        marqueeText.setOnClickListener(v-> startActivity(new Intent(MainActivity.this,SecondActivity.class)));
        recyclerView=findViewById(R.id.recyclerView);
        contactList=new ArrayList<>();
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
       recyclerView.setLayoutManager(layoutManager);
        //DataAdapter adapter=new DataAdapter(this, (ArrayList<Contact>) contactList);
       // recyclerView.setAdapter(adapter);
        loadData();


    }

private void loadData(){
    apiInterface=ApiClient.getClient().create(ApiInterface.class);
    apiInterface.getMovies().enqueue(new Callback<Movie>() {
        @Override
        public void onResponse(Call<Movie> call, Response<Movie> response) {
            if(response.isSuccessful()){
                List<Contact>contactList=response.body().getResults();

                for (int i=0; i<contactList.size();i++){
                    //adapter=new DataAdapter((ArrayList<Contact>contactList));
                    adapter=new DataAdapter( (ArrayList<Contact>) contactList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

            }
        }

        @Override
        public void onFailure(Call<Movie> call, Throwable t) {
            Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });


}
}
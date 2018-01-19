package com.example.android.api.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.android.api.R;
import com.example.android.api.adapters.ItemAdapter;
import com.example.android.api.api.RestApi;
import com.example.android.api.model.BookModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ItemAdapter itemAdapter;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    RestApi api;
    BookModel bookModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        api = new RestApi();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        Call<BookModel> call = api.getPhotos("a");
        call.enqueue(new Callback<BookModel>() {
            @Override
            public void onResponse(Call<BookModel> call, Response<BookModel> response) {
if (response.code() >= 200 && response.code() < 300){
    bookModel = response.body();
    itemAdapter = new ItemAdapter(MainActivity.this, bookModel);
    recyclerView.setAdapter(itemAdapter);


}
            }

            @Override
            public void onFailure(Call<BookModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_LONG).show();

            }
        });



    }

}

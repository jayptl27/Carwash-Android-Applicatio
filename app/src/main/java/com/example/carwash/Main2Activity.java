package com.example.carwash;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {

//    private androidx.appcompat.widget.Toolbar toolbar;

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("Dateandtime");
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Select Vehicle Type");
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Customer,Holder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Customer, Holder>(
                        Customer.class,
                        R.layout.data,
                        Holder.class,
                        databaseReference
                ) {
                    @Override
                    protected void populateViewHolder(Holder holder, Customer customer, int i) {

                        holder.setView(getApplicationContext(), customer.getTime(), customer.getDate(), customer.getRegNo());

                    }
                };

        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.Logout:
//                Toast.makeText(Main2Activity.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(Main2Activity.this, MainActivity.class));
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
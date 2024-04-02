package com.example.tugas6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;
    public static ArrayList<Model> model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.Rview);
        model = new ArrayList<>();
        getData();
        adapter = new Adapter(model, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        model = new ArrayList<>();
        model.add(new Model(1, "Sepatu 1","Sepatu ini xxxxxx", "$750", R.drawable.nike));
        model.add(new Model(2, "Baju 1","Baju ini sangat dingin", "$150", R.drawable.baju1));
        model.add(new Model(3,"Baju 2","Baju yang bagus", "$130", R.drawable.baju2));
        model.add(new Model(4,"Baju 3","Baju ......", "$120", R.drawable.baju3));
        model.add(new Model(5,"Baju 4","Baju asli belanda", "$210", R.drawable.baju4));
        model.add(new Model(6,"Baju 5","Baju dari bahan terbaik", "$200", R.drawable.baju5));
        model.add(new Model(7,"Jacket 1","Jacket dengan bahan yang sangat tebal", "$650", R.drawable.j1));
        model.add(new Model(8,"Jacket 2","Jacket *****", "$560", R.drawable.j2));
        model.add(new Model(9,"Jacket 3","Jacket asli dari bulu harimau", "$1500", R.drawable.j3));
        model.add(new Model(10,"Jacket 4","Jacket asli raja inggris", "$900", R.drawable.j4));
        model.add(new Model(11,"Jacket 5","Jacket anti peluru", "$890", R.drawable.j5));
        model.add(new Model(12,"Sepatu 2","Sepatu bisa dipakai di mana saja", "$1000", R.drawable.gambar1));
        model.add(new Model(13,"Sepatu 3","Sepatu dari kulit singa", "$970", R.drawable.gambar2));
        model.add(new Model(14,"Sepatu 4","Sepatu anti salju", "$780", R.drawable.gambar3));
        model.add(new Model(15,"Sepatu 5","Sepatu anti becek dan tidak bisa kotor", "$3000", R.drawable.gambar5));
    }
}
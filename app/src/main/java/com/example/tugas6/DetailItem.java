package com.example.tugas6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

public class DetailItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);


        // Mendapatkan data dari Intent
        int itemId = getIntent().getIntExtra("itemId", 0);
        Model model = getItemById(itemId);

        // Menampilkan detail item
        TextView Jenis = findViewById(R.id.Jenis);
        TextView Desk = findViewById(R.id.Desk);
        TextView Harga = findViewById(R.id.Harga);
        ImageView GambarItem = findViewById(R.id.GambarItem);
        Button btnShare = findViewById(R.id.Share);

        if (model != null) {
            Jenis.setText(model.getJenisSepatu());
            Desk.setText(model.getDeskSepatu());
            Harga.setText(model.getHargaSepatu());
            GambarItem.setImageResource(model.getGambarSepatu());

            // Mengatur onClickListener untuk tombol share
            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    shareItem(model, GambarItem);
                }
            });
        }
    }

    // Metode untuk mendapatkan item berdasarkan ID
    // Metode untuk mendapatkan item berdasarkan ID
    private Model getItemById(int itemId) {
        if (MainActivity.model != null) {
            for (Model model : MainActivity.model) {
                if (model.getId() == itemId) {
                    return model;
                }
            }
        }
        return null; // Kembalikan null jika tidak menemukan item atau MainActivity.model null
    }


    // Metode untuk berbagi item
    private void shareItem(Model item, ImageView imageView) {
        String shareText = "Nama: " + item.getJenisSepatu() +
                "\nDeskripsi: " + item.getDeskSepatu() +
                "\nHarga: " + item.getHargaSepatu();

        // Simpan gambar ke penyimpanan sementara
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        String imagePath = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Item Image", null);
        Uri imageUri = Uri.parse(imagePath);

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        sendIntent.putExtra(Intent.EXTRA_STREAM, imageUri); // Sisipkan URI gambar
        sendIntent.setType("image/jpeg");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

}
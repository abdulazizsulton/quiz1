package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;

import java.text.DecimalFormat;


public class detailActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        DecimalFormat formatt = new DecimalFormat("#,###.##");

        Intent intent = getIntent();
        String Ucapan = intent.getStringExtra("Ucapan");
        String tipeMember = intent.getStringExtra("tipeMember");
        String kodeBarang = intent.getStringExtra("kodeBarang");
        String namaBarang = intent.getStringExtra("namaBarang");
        double harga = intent.getDoubleExtra("harga", 0);
        double totalHarga = intent.getDoubleExtra("totalHarga", 0);
        double discountHarga = intent.getDoubleExtra("discountHarga", 0);
        double discountMember = intent.getDoubleExtra("discountMember", 0);
        double jumlahBayar = intent.getDoubleExtra("jumlahBayar", 0);


        String totalHargaFormatted = formatt.format(totalHarga);
        String totalBayarFormatted = formatt.format(jumlahBayar);

        TextView tvUcapan = findViewById(R.id.tvUcapan);
        TextView tvTipeMember = findViewById(R.id.tvTipeMeber);
        TextView tvKodeBarang = findViewById(R.id.tvKodeBarang);
        TextView tvNamaBarang = findViewById(R.id.tvNamaBarang);
        TextView tvHarga = findViewById(R.id.tvHarga);
        TextView tvTotalHarga = findViewById(R.id.tvTotalHarga);
        TextView tvDiscountHarga = findViewById(R.id.tvDiscountHarga);
        TextView tvDiscountMember = findViewById(R.id.tvDiscountMember);
        TextView tvJumlahBayar = findViewById(R.id.tvJumlahBayar);

        tvUcapan.setText(" Ucapan " + Ucapan);
        tvTipeMember.setText("Tipe Member " + tipeMember);
        tvKodeBarang.setText("Kode Barang: " + kodeBarang);
        tvNamaBarang.setText("Nama Barang: " + namaBarang);
        tvHarga.setText("Harga: Rp. " + formatt.format(harga));
        tvTotalHarga.setText("Total Harga: Rp. " + formatt.format(totalHarga));
        tvDiscountHarga.setText("Discount Harga: Rp. " + formatt.format(discountHarga));
        tvDiscountMember.setText("Discount Member: Rp. " + formatt.format(discountMember));
        tvJumlahBayar.setText("Jumlah Bayar: Rp. " + formatt.format(jumlahBayar));

        Button btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Pembelian Barang");
                String shareMessage = "Halo, saya telah melakukan pembelian barang " + namaBarang + " seharga " + totalHargaFormatted + ". Total bayar saya adalah " + totalBayarFormatted + ".\nTerima kasih!";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "Bagikan dengan"));
            }
        });

    }
}
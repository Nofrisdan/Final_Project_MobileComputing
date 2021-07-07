package id.mobilecomputing.responsi.aplikasiberita.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import id.mobilecomputing.responsi.R;

public class DetailActivity extends AppCompatActivity {

    String img, judul, deskripsi, tgl, penulis, sumber;
    ImageView tvImg;
    TextView tvJudul, tvDeskripsi, tvTgl, tvPenulis, tvSumber;
    Button btnBagikan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        img = getIntent().getStringExtra("imgNews");
        judul = getIntent().getStringExtra("titleNews");
        deskripsi = getIntent().getStringExtra("contentNews");
        tgl = getIntent().getStringExtra("dateNews");
        penulis = getIntent().getStringExtra("authorNews");

//        SOURCE NEWS
        sumber = getIntent().getStringExtra("sourceNews");

        bindView();

        Glide.with(getApplicationContext())
                .load(img).into(tvImg);
        tvJudul.setText(judul);
        tvDeskripsi.setText(deskripsi);
        tvTgl.setText(tgl);
        tvSumber.setText("Lihat Lebih Lengkap");
        tvPenulis.setText(penulis);

        if(getSupportActionBar() != null)getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnBagikan = (Button) findViewById(R.id.bagikan);
        btnBagikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT,Uri.parse(sumber));
                startActivity(Intent.createChooser(i,"sharing Options"));
                finish();
            }
        });

    }

//    BACA SELENGKAPNYA
    public void sumber (View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(sumber)));
    }
//    ==================
//    BAGIKAN



//    ============

    public void bindView(){
        tvImg = findViewById(R.id.img);
        tvJudul = findViewById(R.id.judul);
        tvDeskripsi = findViewById(R.id.deskripsi);
        tvPenulis = findViewById(R.id.penulis);
        tvTgl = findViewById(R.id.tgl);
        tvSumber = findViewById(R.id.sumber);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);
    }

}

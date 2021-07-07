package id.mobilecomputing.responsi.aplikasiberita.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.mobilecomputing.responsi.DasboardActivity;
import id.mobilecomputing.responsi.R;
import id.mobilecomputing.responsi.aplikasiberita.Kategori.BusinessActivity;
import id.mobilecomputing.responsi.aplikasiberita.Kategori.EnternainmentActivity;
import id.mobilecomputing.responsi.aplikasiberita.Kategori.HealthActivity;
import id.mobilecomputing.responsi.aplikasiberita.Kategori.ScienceActivity;
import id.mobilecomputing.responsi.aplikasiberita.Kategori.SportActivity;
import id.mobilecomputing.responsi.aplikasiberita.Kategori.TechnologyActivity;

public class MainActivity extends AppCompatActivity {

    private CardView business;
    private CardView entertainment;
    private CardView health;
    private CardView science;
    private CardView sport;
    private CardView technology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        business = (CardView) findViewById(R.id.cv_business);
        entertainment = (CardView) findViewById(R.id.cv_entertainment);
        health = (CardView) findViewById(R.id.cv_health);
        science = (CardView) findViewById(R.id.cv_science);
        sport = (CardView) findViewById(R.id.cv_sport);
        technology = (CardView) findViewById(R.id.cv_technology);

        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BusinessActivity.class));
                finish();
            }
        });

        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EnternainmentActivity.class));
                finish();
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HealthActivity.class));
                finish();
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScienceActivity.class));
                finish();
            }
        });

        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SportActivity.class));
                finish();
            }
        });

        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TechnologyActivity.class));
                finish();
            }
        });

        //membuat back button toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(MainActivity.this, DasboardActivity.class);
        startActivity(intent);
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this, DasboardActivity.class);
        startActivity(intent);
    }
}
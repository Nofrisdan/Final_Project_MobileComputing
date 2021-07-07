package id.mobilecomputing.responsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //membuat back button toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(AboutActivity.this, DasboardActivity.class);
        startActivity(back);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(AboutActivity.this, DasboardActivity.class);
        startActivity(intent);
        return true;
    }
}

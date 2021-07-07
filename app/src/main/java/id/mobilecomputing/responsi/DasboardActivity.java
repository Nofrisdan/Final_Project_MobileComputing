package id.mobilecomputing.responsi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import id.mobilecomputing.responsi.aplikasiberita.Activity.MainActivity;
import id.mobilecomputing.responsi.auth.LoginActivity;

public class DasboardActivity extends AppCompatActivity {

    private TextView email;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private CardView logout;
    private CardView about_us;
    private CardView berita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                // user auth state is changed - user is null
                // launch login activity
                startActivity(new Intent(DasboardActivity.this, LoginActivity.class));
                finish();
                }
            }
        };

        logout = (CardView) findViewById(R.id.cv_logout);
        about_us = (CardView) findViewById(R.id.cv_about_us);
        berita = (CardView) findViewById(R.id.cv_berita);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Intent intent = new Intent(DasboardActivity.this, LoginActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DasboardActivity.this, AboutActivity.class));
                finish();
            }
        });

        berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DasboardActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    public void signOut() {
        auth.signOut();
        Intent intent = new Intent(DasboardActivity.this, LoginActivity.class);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

}
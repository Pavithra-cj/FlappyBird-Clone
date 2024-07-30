package lk.itzcorpio.android.games.flappybird.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import lk.itzcorpio.android.games.flappybird.AppHolder;
import lk.itzcorpio.android.games.flappybird.GameActivity;
import lk.itzcorpio.android.games.flappybird.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AppHolder.assign(this.getApplicationContext());
        setListners();
    }

    private void setListners()
    {
        binding.playBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        });

        binding.HowBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, HowToPlayActivity.class);
            startActivity(intent);
        });

        binding.aboutBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        });

        binding.exitBtn.setOnClickListener(v -> {
            finishAffinity();
        });
    }

}
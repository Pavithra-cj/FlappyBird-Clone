package lk.itzcorpio.android.games.flappybird.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import lk.itzcorpio.android.games.flappybird.R;
import lk.itzcorpio.android.games.flappybird.databinding.ActivityGameOverBinding;

public class GameOverActivity extends AppCompatActivity {

    ActivityGameOverBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameOverBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int scoreCount = getIntent().getExtras().getInt("Score", 0);
        SharedPreferences pref = getSharedPreferences("myStoragePreference", 0);
        int scoreBest = pref.getInt("ScoreBest", 0);
        SharedPreferences.Editor edit = pref.edit();
        if (scoreCount > scoreBest) {
            edit.putInt("ScoreBest", scoreBest);
            edit.apply();
        }

        binding.btnRestart.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        binding.scoreDisplay.setText(""+scoreCount);
        binding.bestDisplay.setText(""+scoreBest);

    }
}
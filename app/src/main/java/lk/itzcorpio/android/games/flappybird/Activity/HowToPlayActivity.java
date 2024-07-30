package lk.itzcorpio.android.games.flappybird.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import lk.itzcorpio.android.games.flappybird.R;
import lk.itzcorpio.android.games.flappybird.databinding.ActivityHowToPlayBinding;

public class HowToPlayActivity extends AppCompatActivity {

    ActivityHowToPlayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHowToPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonBack.setOnClickListener(v -> {
            finish();
        });

    }
}
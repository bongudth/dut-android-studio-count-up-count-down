package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        Intent intent = getIntent();
        String value = intent.getStringExtra("value");
        int index = intent.getIntExtra("index", 0);
        binding.numberEdit.setText(value);

        binding.btnOk.setOnClickListener(e -> {
            String newValue = binding.numberEdit.getText().toString().trim();
            intent.putExtra("value", newValue);
            intent.putExtra("index", index);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
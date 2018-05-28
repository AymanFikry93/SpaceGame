package com.ayman.android.spacebattleship.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.ayman.android.spacebattleship.GameActivity;
import com.ayman.android.spacebattleship.R;

public class MainActivity extends AppCompatActivity {

    ImageButton buttonPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferencesManager.init(this);
        ScreenManager.init(this);
        GameMusicManager.init(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        GameMusicManager.releaseResources();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPlay:
                startActivity(new Intent(MainActivity.this, GameActivity.class));
                break;
            case R.id.buttonScore:
                startActivity(new Intent(MainActivity.this, HighScoreActivity.class));
                break;
        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> {

                    GameMusicManager.stopMusic();
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);
                    finish();
                })
                .setNegativeButton("No", (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();

    }

}

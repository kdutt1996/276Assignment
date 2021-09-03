package com.example.kisha.assignment3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);
        this.setTitle("MENU");
        setBackgroundColor(000000);


        //go to setup screen
        setupOptionsButton();
        //go to help Screen
        setupHelpScreen();
    }

    private void setupHelpScreen() {
        Button help = (Button) findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helpIntent = new Intent(MenuScreen.this, HelpScreen.class);
                startActivity(helpIntent);
            }
        });
    }


    private void setupOptionsButton(){
        Button options = (Button) findViewById(R.id.options);
        options.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent optionIntent = new Intent(MenuScreen.this, Options.class);
                startActivity(optionIntent);
            }
        });
    }

    public void setBackgroundColor(int color){
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);

    }



}

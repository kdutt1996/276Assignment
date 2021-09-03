package com.example.kisha.assignment3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        this.setTitle("Options");

        createRowsandCols();
        createMine();
        setupOkButton();

        int savedValue = getNumMinesChosen(this);
        Toast.makeText(this,"saved Value " + savedValue, Toast.LENGTH_SHORT)
                .show();

        int savedRow = getNumRows(this);
        int savedCol = getNumCols(this);


    }

    //populate rows and column  choices
    private void createRowsandCols() {
        RadioGroup group = (RadioGroup) findViewById(R.id.gridValue);

        int [] rows = getResources().getIntArray(R.array.rows);
        int [] cols = getResources().getIntArray(R.array.cols);

        for(int i = 0; i < rows.length; i++){
            final int numRow = rows[i];
            final int numCol = cols[i];

            RadioButton rowxcol = new RadioButton(this);
            rowxcol.setText(numRow + " rows By " + numCol + " columns" );
            rowxcol.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Options.this, "You Picked " + numRow + " By " + numCol, Toast.LENGTH_SHORT)
                            .show();
                    saveCol(numCol);
                    saveRow(numRow);
                }
            });
            group.addView(rowxcol);

            if((numRow == getNumRows(this)) && numCol == getNumCols(this)){
                rowxcol.setChecked(true);
            }

        }

    }
    //Populate mine options
    private void createMine(){
        RadioGroup mine = (RadioGroup) findViewById(R.id.numOfMines);

        int [] mines = getResources().getIntArray(R.array.numMines);

        for(int k = 0; k < mines.length; k++){
            final int num_of_mines = mines[k];

            RadioButton mineButton = new RadioButton(this);
            mineButton.setText("- " + num_of_mines + " mines");

            //toast when option clicked
            mineButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Options.this, "You Picked " + num_of_mines + " mines", Toast.LENGTH_SHORT)
                            .show();
                    saveMine(num_of_mines);
                }
            });
            mine.addView(mineButton);

            //select chosen Button
            if(num_of_mines == getNumMinesChosen(this)){
                mineButton.setChecked(true);
            }
        }
    }
    //save mines
    private void saveMine(int num_of_mines) {
        SharedPreferences choiceMine = this.getSharedPreferences("minechoice",MODE_PRIVATE);
        SharedPreferences.Editor editMine = choiceMine.edit();
        editMine.putInt("choice of mine", num_of_mines);
        editMine.apply();

    }

    static public int getNumMinesChosen(Context context){
        SharedPreferences choiceMine = context.getSharedPreferences("minechoice", MODE_PRIVATE);
        return choiceMine.getInt("choice of mine", 0);

    }
    //save rows
    private void saveRow(int numRow){
        SharedPreferences choiceRow = this.getSharedPreferences("rowchoice", MODE_PRIVATE);
        SharedPreferences.Editor editRow = choiceRow.edit();
        editRow.putInt("choice of row", numRow);
        editRow.apply();
    }

    static public int getNumRows(Context context){
        SharedPreferences choiceRow = context.getSharedPreferences("rowchoice", MODE_PRIVATE);
        return choiceRow.getInt("choice of row", 0);
    }

    //save cols

    private void saveCol(int numCol){
        SharedPreferences choiceRow = this.getSharedPreferences("colchoice", MODE_PRIVATE);
        SharedPreferences.Editor editRow = choiceRow.edit();
        editRow.putInt("choice of col", numCol);
        editRow.apply();
    }

    static public int getNumCols(Context context){
        SharedPreferences choiceRow = context.getSharedPreferences("colchoice", MODE_PRIVATE);
        return choiceRow.getInt("choice of col", 0);
    }

    //Move to menu once button is clicked
    private void setupOkButton(){
        Button ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent okButton = new Intent(Options.this,MenuScreen.class);
                startActivity(okButton);
            }
        });
    }




}


package com.example.ninoo.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int[][] boardValue = new int[3][3];
    ImageButton i1;
    ImageButton i2;
    ImageButton i3;
    ImageButton i4;
    ImageButton i5;
    ImageButton i6;
    ImageButton i7;
    ImageButton i8;
    ImageButton i9;
    Button reset;
    boolean pX=true;
    int count=0;
    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1 = (ImageButton) findViewById(R.id.i1);
        i2 = (ImageButton) findViewById(R.id.i2);
        i3 = (ImageButton) findViewById(R.id.i3);
        i4 = (ImageButton) findViewById(R.id.i4);
        i5 = (ImageButton) findViewById(R.id.i5);
        i6 = (ImageButton) findViewById(R.id.i6);
        i7 = (ImageButton) findViewById(R.id.i7);
        i8 = (ImageButton) findViewById(R.id.i8);
        i9 = (ImageButton) findViewById(R.id.i9);
        reset = (Button) findViewById(R.id.b1);
       info = (TextView) findViewById(R.id.t2);
        i1.setOnClickListener((OnClickListener) this);
        i2.setOnClickListener((OnClickListener) this);
        i3.setOnClickListener((OnClickListener) this);
        i4.setOnClickListener((OnClickListener) this);
        i5.setOnClickListener((OnClickListener) this);
        i6.setOnClickListener((OnClickListener) this);
        i7.setOnClickListener((OnClickListener) this);
        i8.setOnClickListener((OnClickListener) this);
        i9.setOnClickListener((OnClickListener) this);
        reset.setOnClickListener((OnClickListener) this);
        initializeBoard();
    }
@Override
public  void onClick(View view)
{
    boolean resetButton=false;
    switch(view.getId())
    {
        case R.id.i1:
            if(pX)
            {
                
                boardValue[0][0]=1;
            }
            else
                {
                    boardValue[0][0]=0;
            }
            i1.setEnabled(false);
            break;
        case R.id.i2:
            if(pX)
            {
                i2.setImageResource(R.drawable.x);
                boardValue[0][1]=1;
            }
            else
            {i2.setImageResource(R.drawable.o);
                boardValue[0][1]=0;
            }
            i2.setEnabled(false);
            break;
        case R.id.i3:
            if(pX)
            {
                i3.setImageResource(R.drawable.x);
                boardValue[0][2]=1;
            }
            else
            {i3.setImageResource(R.drawable.o);
                boardValue[0][2]=0;
            }
            i3.setEnabled(false);
            break;
        case R.id.i4:
            if(pX)
            {
                i4.setImageResource(R.drawable.x);
                boardValue[1][0]=1;
            }
            else
            {i4.setImageResource(R.drawable.o);
                boardValue[1][0]=0;
            }
            i4.setEnabled(false);

            break;
        case R.id.i5:
            if(pX)
            {
                i5.setImageResource(R.drawable.x);
                boardValue[1][1]=1;
            }
            else
            {i5.setImageResource(R.drawable.o);
                boardValue[1][1]=0;
            }
            i5.setEnabled(false);

            break;
        case R.id.i6:
            if(pX)
            {
                i6.setImageResource(R.drawable.x);
                boardValue[1][2]=1;
            }
            else
            {i6.setImageResource(R.drawable.o);
                boardValue[1][2]=0;
            }
            i6.setEnabled(false);
            break;
        case R.id.i7:
            if(pX)
            {
                i7.setImageResource(R.drawable.x);
                boardValue[2][0]=1;
            }
            else
            {i7.setImageResource(R.drawable.o);
                boardValue[2][0]=0;
            }
            i7.setEnabled(false);
            break;
        case R.id.i8:
            if(pX)
            {
                i8.setImageResource(R.drawable.x);
                boardValue[2][1]=1;
            }
            else
            {i8.setImageResource(R.drawable.o);
                boardValue[2][1]=0;
            }
            i8.setEnabled(false);
            break;
        case R.id.i9:
            if(pX)
            {
                i9.setImageResource(R.drawable.x);
                boardValue[2][2]=1;
            }
            else
            {i9.setImageResource(R.drawable.o);
                boardValue[2][2]=0;
            }
            i9.setEnabled(false);
            break;
        case R.id.b1:
            resetButton=true;
            break;
    }
    if(resetButton)
    {
        resetBoard();
    }
    else {
        count++;
        pX = !pX;
        if (pX) {
            setInfo("Player X's turn ");
        } else {
            setInfo("Player O's turn");
        }
        if (count == 9) {
            setInfo("Draw!!");
        }
        checkWinner();
    }
}
private void checkWinner() {
    for(int i=0; i<3; i++){
        if(boardValue[i][0] == boardValue[i][1] && boardValue[i][0] == boardValue[i][2]){
            if (boardValue[i][0]==1){
                result("Player X winner\n" + (i+1)+" row");
                break;
            }
            else if (boardValue[i][0]==0) {
                result("Player 0 winner\n" + (i+1)+" row");
                break;
            }
        }
    }

    //Vertical --- columns
    for(int i=0; i<3; i++){
        if(boardValue[0][i] == boardValue[1][i] && boardValue[0][i] == boardValue[2][i]){
            if (boardValue[0][i]==1){
                result("Player X winner\n" + (i+1)+" column");
                break;
            }
            else if (boardValue[0][i]==0) {
                result("Player 0 winner\n" + (i+1)+" column");
                break;
            }
        }
    }

    //First diagonal
    if(boardValue[0][0] == boardValue[1][1] && boardValue[0][0] == boardValue[2][2]){
        if (boardValue[0][0]==1){
            result("Player X winner\nFirst Diagonal");
        }
        else if (boardValue[0][0]==0) {
            result("Player 0 winner\nFirst Diagonal");
        }
    }

    //Second diagonal
    if(boardValue[0][2] == boardValue[1][1] && boardValue[0][2] == boardValue[2][0]){
        if (boardValue[0][2]==1){
            result("Player X winner\nSecond Diagonal");
        }
        else if (boardValue[0][2]==0) {
            result("Player 0 winner\nSecond Diagonal");
        }
    }

    }
private void setInfo(String text) {
info.setText(text);
    }
    private void result(String winner){
        setInfo(winner);
        enableAll(false);
    }
private void resetBoard()
{
    i1.setImageResource(R.drawable.bgi);
    i2.setImageResource(R.drawable.bgi);
    i3.setImageResource(R.drawable.bgi);
    i4.setImageResource(R.drawable.bgi);
    i5.setImageResource(R.drawable.bgi);
    i6.setImageResource(R.drawable.bgi);
    i7.setImageResource(R.drawable.bgi);
    i8.setImageResource(R.drawable.bgi);
    i9.setImageResource(R.drawable.bgi);
    initializeBoard();
    count=0;
    pX=true;
    enableAll(true);
}
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardValue[i][j] = -1;
            }
        }
    }
    private void enableAll(boolean val)
            {
                i1.setEnabled(val);
                i2.setEnabled(val);
                i3.setEnabled(val);
                i4.setEnabled(val);
                i5.setEnabled(val);
                i6.setEnabled(val);
                i7.setEnabled(val);
                i8.setEnabled(val);
                i9.setEnabled(val);

            }

        }



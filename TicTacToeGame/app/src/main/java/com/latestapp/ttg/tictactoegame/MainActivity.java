package com.latestapp.ttg.tictactoegame;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_one,btn_two,btn_three,btn_four,btn_five,btn_six,btn_seven,btn_eight,btn_nine;

    Button reset_Game,reset_Session;
    TextView scorePlayer1,scorePlayer2;
    int wonP1,wonP2;

    ArrayList<Integer> player1 = new ArrayList<>();
    ArrayList<Integer> player2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_one = (ImageButton) findViewById(R.id.btn1);
        btn_two = (ImageButton)findViewById(R.id.btn2);
        btn_three = (ImageButton)findViewById(R.id.btn3);
        btn_four = (ImageButton)findViewById(R.id.btn4);
        btn_five = (ImageButton)findViewById(R.id.btn5);
        btn_six = (ImageButton)findViewById(R.id.btn6);
        btn_seven = (ImageButton)findViewById(R.id.btn7);
        btn_eight = (ImageButton)findViewById(R.id.btn8);
        btn_nine = (ImageButton)findViewById(R.id.btn9);

        scorePlayer1 = (TextView)findViewById(R.id.scoreDisplay1);
        scorePlayer2 = (TextView)findViewById(R.id.scoreDisplay2);

        reset_Game = (Button)findViewById(R.id.btn_resetGame);
        reset_Session = (Button) findViewById(R.id.btn_resetSession);

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectButton = 1;
                GamePlay(selectButton,btn_one);
                btn_one.setEnabled(false);
            }
        });
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectButton = 2;
                GamePlay(selectButton,btn_two);
                btn_two.setEnabled(false);
            }
        });
        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectButton = 3;
                GamePlay(selectButton,btn_three);
                btn_three.setEnabled(false);
            }
        });
        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectButton = 4;
                GamePlay(selectButton,btn_four);
                btn_four.setEnabled(false);
            }
        });
        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectButton = 5;
                GamePlay(selectButton,btn_five);
                btn_five.setEnabled(false);
            }
        });
        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectButton = 6;
                GamePlay(selectButton,btn_six);
                btn_six.setEnabled(false);
            }
        });
        btn_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectButton = 7;
                GamePlay(selectButton,btn_seven);
                btn_seven.setEnabled(false);
            }
        });
        btn_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectButton = 8;
                GamePlay(selectButton,btn_eight);
                btn_eight.setEnabled(false);
            }
        });
        btn_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectButton = 9;
                GamePlay(selectButton,btn_nine);
                btn_nine.setEnabled(false);
            }
        });

        reset_Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_one.setImageResource(0);
                btn_two.setImageResource(0);
                btn_three.setImageResource(0);
                btn_four.setImageResource(0);
                btn_five.setImageResource(0);
                btn_six.setImageResource(0);
                btn_seven.setImageResource(0);
                btn_eight.setImageResource(0);
                btn_nine.setImageResource(0);

                player1.clear();
                player2.clear();

                btn_one.setEnabled(true);
                btn_two.setEnabled(true);
                btn_three.setEnabled(true);
                btn_four.setEnabled(true);
                btn_five.setEnabled(true);
                btn_six.setEnabled(true);
                btn_seven.setEnabled(true);
                btn_eight.setEnabled(true);
                btn_nine.setEnabled(true);
            }
        });

        reset_Session.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void Player1(int selectedButton,ImageButton button) {
        button.setImageResource(R.drawable.o);
        player1.add(selectedButton);
        //Toast.makeText(MainActivity.this,String.valueOf(button),Toast.LENGTH_SHORT).show();
    }

    public void Player2(int selectedButton,ImageButton button) {
        button.setImageResource(R.drawable.x);
        player2.add(selectedButton);
        //Toast.makeText(MainActivity.this,String.valueOf(button),Toast.LENGTH_SHORT).show();
    }

    int activePlayer = 1;
    public void GamePlay(int selectedButton,ImageButton button)
    {

        if(activePlayer==1) {
            Player1(selectedButton, button);
            activePlayer = 2;
            checkWinner(player1,player2);
        }
        else if(activePlayer == 2) {
            Player2(selectedButton, button);
            activePlayer = 1;
            checkWinner(player1,player2);
        }
    }

    //To check wheather the Game is won or not

    public void checkWinner(ArrayList<Integer> player1,ArrayList<Integer> player2)
    {
        int winner = -1;
        //Player 1 victory conditions
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)) {
            winner = 1;
        }
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)) {
            winner = 1;
        }
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)) {
            winner = 1;
        }
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)) {
            winner = 1;
        }
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)) {
            winner = 1;
        }
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)) {
            winner = 1;
        }
        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9)) {
            winner = 1;
        }
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7)) {
            winner = 1;
        }

        //Player 2 victory conditions

        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner = 2;
        }
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)) {
            winner = 2;
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)) {
            winner = 2;
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)) {
            winner = 2;
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)) {
            winner = 2;
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)) {
            winner = 2;
        }
        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9)) {
            winner = 2;
        }
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7)) {
            winner = 2;
        }

        if(!(winner == -1)) {
            //we have a winner
            if(winner == 1)
            {
                scorePlayer1.setText(String.valueOf(++wonP1));
                Toast.makeText(MainActivity.this,"Player 1 is win"+wonP1,Toast.LENGTH_SHORT).show();
                btn_one.setEnabled(false);
                btn_two.setEnabled(false);
                btn_three.setEnabled(false);
                btn_four.setEnabled(false);
                btn_five.setEnabled(false);
                btn_six.setEnabled(false);
                btn_seven.setEnabled(false);
                btn_eight.setEnabled(false);
                btn_nine.setEnabled(false);
            }
            else if(winner == 2)
            {
                scorePlayer2.setText(String.valueOf(++wonP2));
                Toast.makeText(MainActivity.this, "Player 2 is win"+wonP2, Toast.LENGTH_SHORT).show();
                btn_one.setEnabled(false);
                btn_two.setEnabled(false);
                btn_three.setEnabled(false);
                btn_four.setEnabled(false);
                btn_five.setEnabled(false);
                btn_six.setEnabled(false);
                btn_seven.setEnabled(false);
                btn_eight.setEnabled(false);
                btn_nine.setEnabled(false);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);

//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.search_bar).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                Toast.makeText(MainActivity.this,"Searching Query on Submit",Toast.LENGTH_LONG).show();
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                Toast.makeText(MainActivity.this,"Searching Query text Change",Toast.LENGTH_LONG).show();
//                return true;
//            }
//        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.home:
                Toast.makeText(MainActivity.this,"You are at Home",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.setting:
                Toast.makeText(MainActivity.this,"Modifying Setting",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                Toast.makeText(MainActivity.this,"App Developed by : Virendra Shakya",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
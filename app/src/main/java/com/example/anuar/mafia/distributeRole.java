package com.example.anuar.mafia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class distributeRole extends Activity {
    private int pivot = 0;
    private int civilNumber = 3;
    private int mafiaNumber = 1;


    private boolean doctorPlay;
    private boolean mistressPlay;
    private boolean commissionerPlay;
    private boolean maniacPlay;


    private TextView roleText;
    private EditText name;
    private EditText password;
    private ImageView roleImage;
    private Button understand;

    private String tmpName;
    private String tmpPassword;
    private ArrayList<String> playerRoleNameArray = new ArrayList<String>();
    private ArrayList<String> playerPasswordArray = new ArrayList<String>();

    public distributeRole() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.distribute);
        Intent intent = getIntent();

        civilNumber = intent.getIntExtra("civilNumber", 0);
        mafiaNumber = intent.getIntExtra("mafiaNumber", 0);

        doctorPlay = intent.getBooleanExtra("doctorPlay", false);
        commissionerPlay = intent.getBooleanExtra("commissionerPlay", false);
        maniacPlay = intent.getBooleanExtra("maniacPlay", false);
        mistressPlay = intent.getBooleanExtra("mistressPlay", false);

        roleText = (TextView) findViewById(R.id.roleText);
        name = (EditText) findViewById(R.id.textName);
        password = (EditText) findViewById(R.id.textPassword);
        roleImage = (ImageView) findViewById(R.id.roleImage);

        understand = (Button) findViewById(R.id.buttonUnderstand);
        understand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (civilNumber + mafiaNumber == 0 && !doctorPlay && !commissionerPlay && !maniacPlay && !mistressPlay) {
                    // new activity for filling table
                    name.setText(" Роли кончились");
                    Intent intent = new Intent(v.getContext(), tableActivity.class);
                    intent.putExtra("playerRoleNameArray", playerRoleNameArray);
                    intent.putExtra("playerPasswordArray", playerPasswordArray);

                    startActivity(intent);
                    finish();
                } else if (name.getText().toString().length() == 0 || password.getText().toString().length() == 0) {
                    Toast.makeText(getBaseContext(), "Имя и пароль заполнять объязательно", Toast.LENGTH_LONG);
                } else {
                    pivot++;
                    if (pivot != 1 && pivot % 2 == 0) {
                        boolean ok = false;
                        tmpName = name.getText().toString();
                        tmpPassword = password.getText().toString();
                        name.setFocusable(false);
                        password.setFocusable(false);
                        while (!ok) {
                            int random = getRandomNumber();
                            switch (random) {
                                case 0:
                                    if (civilNumber > 0) {
                                        roleImage.setImageResource(R.drawable.civil);
                                        roleText.setText("Ты МИРНЫЙ ЖИТЕЛЬ");
                                        civilNumber--;
                                        playerRoleNameArray.add(0 + tmpName);
                                        ok = true;
                                    }
                                    break;
                                case 1:
                                    if (mafiaNumber > 0) {
                                        roleImage.setImageResource(R.drawable.mafia);
                                        roleText.setText("Ты МАФИЯ");
                                        mafiaNumber--;
                                        playerRoleNameArray.add(1 + tmpName);
                                        ok = true;
                                    }
                                    break;
                                case 2:
                                    if (doctorPlay || maniacPlay || mistressPlay || commissionerPlay) {
                                        if (doctorPlay) {
                                            doctorPlay = false;
                                            roleImage.setImageResource(R.drawable.doctor);
                                            roleText.setText("Ты ДОКТОР");
                                            playerRoleNameArray.add(2 + tmpName);
                                            ok = true;

                                        } else if (commissionerPlay) {
                                            commissionerPlay = false;
                                            roleImage.setImageResource(R.drawable.commissioner);
                                            roleText.setText("Ты КОММИССАР");
                                            playerRoleNameArray.add(3 + tmpName);
                                            ok = true;

                                        } else if (mistressPlay) {
                                            mistressPlay = false;
                                            roleImage.setImageResource(R.drawable.mistress);
                                            roleText.setText("Ты ЛЮБОВНИЦА");
                                            playerRoleNameArray.add(4 + tmpName);
                                            ok = true;
                                        } else if (maniacPlay) {
                                            maniacPlay = false;
                                            roleImage.setImageResource(R.drawable.maniac);
                                            roleText.setText("Ты МАНЬЯК");
                                            playerRoleNameArray.add(5 + tmpName);
                                            ok = true;

                                        }
                                    }
                                    break;
                            }
                        }
                        playerPasswordArray.add(tmpPassword);
                        understand.setText("понял");

                    } else {

                        AllFieldCanceling();

                        understand.setText("Дай мне роль!");
                        //Toast.makeText(getBaseContext(),"передай телефон следующему игроку",Toast.LENGTH_LONG);
                    }
                }
            }
        });


    }

    public int getRandomNumber() {
        int random = (int) (Math.random() * 3);
        return random;
    }

    public void AllFieldCanceling() {
        roleText.setText("");
        roleImage.setImageResource(R.drawable.question);
        name.setText("");
        password.setText("");
        name.setFocusableInTouchMode(true);
        password.setFocusableInTouchMode(true);

    }


}

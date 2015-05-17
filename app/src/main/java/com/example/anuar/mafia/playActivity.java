package com.example.anuar.mafia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.TextView;


public class playActivity extends Activity implements NumberPicker.OnValueChangeListener {

    private int civilNumber = 3;
    private int mafiaNumber = 1;

    private boolean doctorPlay;
    private boolean mistressPlay;
    private boolean commissionerPlay;
    private boolean maniacPlay;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        NumberPicker np = (NumberPicker) findViewById(R.id.playerNumber);
        np.setMinValue(4);
        np.setMaxValue(30);
        np.setWrapSelectorWheel(false);
        np.setValue(4);
        np.setOnValueChangedListener(this);



        CheckBox doctorPlayCheckBox = (CheckBox) findViewById (R.id.doctorPlayCheckBox);
        doctorPlayCheckBox.setOnCheckedChangeListener(OnCheckedChangeListener);


        CheckBox CommissionerPlayCheckBox = (CheckBox) findViewById (R.id.CommissionerPlayCheckBox);
        CommissionerPlayCheckBox.setOnCheckedChangeListener(OnCheckedChangeListener);

        CheckBox mistressPlayCheckBox = (CheckBox) findViewById (R.id.mistressPlayCheckBox);
        mistressPlayCheckBox.setOnCheckedChangeListener(OnCheckedChangeListener);

        CheckBox maniacPlayCheckBox = (CheckBox) findViewById (R.id.maniacPlayCheckBox);
        maniacPlayCheckBox.setOnCheckedChangeListener(OnCheckedChangeListener);


        Button play = (Button) findViewById(R.id.buttonPlay);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( v.getContext(), distributeRole.class);
                intent.putExtra("civilNumber", civilNumber);
                intent.putExtra("mafiaNumber", mafiaNumber);
                intent.putExtra("doctorPlay",doctorPlay );
                intent.putExtra("commissionerPlay",commissionerPlay );
                intent.putExtra("mistressPlay",mistressPlay );
                intent.putExtra("maniacPlay",maniacPlay );
                startActivity(intent);
                finish();
            }
        });


    }


    @Override
    public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
        switch (newVal){
            case 5:
                civilNumber = 4;
                mafiaNumber = 1;
                break;
            case 6:
                civilNumber = 4;
                mafiaNumber = 2;
                break;
            case 7:
                civilNumber = 5;
                mafiaNumber = 2;
                break;
            case 8:
                civilNumber = 5;
                mafiaNumber = 3;
                break;
            case 9:
                civilNumber = 6;
                mafiaNumber = 3;
                break;
            case 10:
                civilNumber = 7;
                mafiaNumber = 3;
                break;
            case 11:
                civilNumber = 8;
                mafiaNumber = 3;
                break;
            case 12:
                civilNumber = 9;
                mafiaNumber = 3;
                break;
            case 13:
                civilNumber = 9;
                mafiaNumber = 4;
                break;
        }
        TextView civilNumberText = (TextView) findViewById(R.id.civilNumberText);
        civilNumberText.setText(""+civilNumber);

        TextView mafiaNumberText = (TextView) findViewById(R.id.mafiaNumberText);
        mafiaNumberText.setText(""+mafiaNumber);



    }


    CompoundButton.OnCheckedChangeListener OnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        short otherRole = 0;
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.doctorPlayCheckBox:
                    TextView doctorNumberText = (TextView) findViewById(R.id.doctorNumberText);
                    if (isChecked && !doctorPlay){
                        doctorPlay = true;
                        civilNumber--;
                        otherRole = 1;
                    }else{
                        if (doctorPlay){
                            doctorPlay = false;
                            civilNumber ++;
                        }
                        otherRole = 0;
                    }
                    doctorNumberText.setText(""+otherRole);
                    break;

                case R.id.CommissionerPlayCheckBox:
                    TextView commissionerNumberText = (TextView) findViewById(R.id.commissionerNumberText);
                    if (isChecked && !commissionerPlay){
                        commissionerPlay = true;
                        civilNumber--;
                        otherRole = 1;
                    }else{
                        if (commissionerPlay){
                            commissionerPlay = false;
                            civilNumber ++;
                        }
                        otherRole = 0;

                    }
                    commissionerNumberText.setText(""+otherRole);
                    break;

                case R.id.maniacPlayCheckBox:
                    TextView maniacNumberText = (TextView) findViewById(R.id.maniacNumberText);
                    if (isChecked && !maniacPlay){
                        maniacPlay = true;
                        mafiaNumber--;
                        otherRole = 1;
                    }else{
                        if (maniacPlay){
                            maniacPlay = false;
                            mafiaNumber ++;
                        }
                        otherRole = 0;

                    }
                    maniacNumberText.setText(""+otherRole);
                    break;

                case R.id.mistressPlayCheckBox:

                    TextView mistressNumberText = (TextView) findViewById(R.id.mistressNumberText);
                    if (isChecked && !mistressPlay){
                        mistressPlay = true;
                        otherRole = 1;
                        civilNumber --;
                    }else{
                        if (mistressPlay){
                            mistressPlay = false;
                            civilNumber ++;
                        }
                        otherRole = 0;
                    }
                    mistressNumberText.setText(""+otherRole);
                    break;
            }

            TextView civilNumberText = (TextView) findViewById(R.id.civilNumberText);
            civilNumberText.setText(""+civilNumber);

            TextView mafiaNumberText = (TextView) findViewById(R.id.mafiaNumberText);
            mafiaNumberText.setText(""+mafiaNumber);

        }
    };












}


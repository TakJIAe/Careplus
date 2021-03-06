package com.example.Careplus.Statistics;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Careplus.Main.MainActivity;
import com.example.Careplus.R;

import java.util.Calendar;

public class StatisticsMain_Activity extends AppCompatActivity {
    int nowValue1,nowValue2,nowValue3,nowValue4;
    ProgressBar bar1,bar2,bar3, bar4;
    TextView click1,click2,click3,click4;
    EditText name1,name2,name3,name4;
    String nametext1,nametext2,nametext3,nametext4;
    ImageView rank_iv1,rank_iv2, rank_iv3, rank_iv4;
    private SharedPreferences sf;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_main);

        Intent intent = new Intent(this.getIntent());

        ImageButton Categorybtn2 = (ImageButton) findViewById(R.id.categorybtn2);

        Categorybtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(StatisticsMain_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bar1 =(ProgressBar)findViewById(R.id.rank1_progressBar);
        bar2 =(ProgressBar)findViewById(R.id.rank2_progressBar);
        bar3 =(ProgressBar)findViewById(R.id.rank3_progressBar);
        bar4 =(ProgressBar)findViewById(R.id.rank4_progressBar);


        click1 =(TextView) findViewById(R.id.rank_click1);
        click2 =(TextView)findViewById(R.id.rank_click2);
        click3 =(TextView)findViewById(R.id.rank_click3);
        click4 =(TextView)findViewById(R.id.rank_click4);

        name1 =(EditText) findViewById(R.id.rank_name1);
        name2 =(EditText) findViewById(R.id.rank_name2);
        name3 =(EditText) findViewById(R.id.rank_name3);
        name4 =(EditText) findViewById(R.id.rank_name4);

        rank_iv1 =(ImageView) findViewById(R.id.rank_iv1);
        rank_iv2 =(ImageView) findViewById(R.id.rank_iv2);
        rank_iv3 =(ImageView) findViewById(R.id.rank_iv3);
        rank_iv4 =(ImageView) findViewById(R.id.rank_iv4);

        getData1();
        getData2();
        getData3();
        getData4();

        name1.setText(nametext1);
        name2.setText(nametext2);
        name3.setText(nametext3);
        name4.setText(nametext4);

        rank_iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rank_iv1.setVisibility(View.INVISIBLE); //+?????? ????????????
                click1.setText("???");
            }
        });

        click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnceADay1();
                bar1.setProgress(nowValue1);
                click1.setText(nowValue1+"???");
                saveData1();  //????????? ??????

            }
        });

        rank_iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rank_iv2.setVisibility(View.INVISIBLE); //+?????? ????????????
                click2.setText("???");
            }
        });

        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnceADay2();
                bar2.setProgress(nowValue2);
                click2.setText(nowValue2+"???");
                saveData2(); //????????? ??????
            }
        });

        rank_iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rank_iv3.setVisibility(View.INVISIBLE); //+?????? ????????????
                click3.setText("???");
            }
        });

        click3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnceADay3();
                bar3.setProgress(nowValue3);
                click3.setText(nowValue3+"???");
                saveData3(); //????????? ??????
            }
        });
        rank_iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rank_iv4.setVisibility(View.INVISIBLE);  //+?????? ????????????
                click4.setText("???");
            }
        });
        click4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnceADay4();
                bar4.setProgress(nowValue4);
                click4.setText(nowValue4+"???");
                saveData4(); //????????? ??????
            }
        });

    }

    /*????????? ???, ????????? ????????? ????????? ????????? ???????????? ?????? ??????(DAY OF MONTH), ??????????????? ?????? ????????? ????????? ????????? ??????????????? ?????????*/
    public void OnceADay1(){
        Calendar calendar1 = Calendar.getInstance();  //????????? ?????????
        int currentDay1 = calendar1.get(Calendar.MINUTE);  //?????? ?????? ?????????
        SharedPreferences settings = getSharedPreferences("EAT_1",0);
        int lastDay1 = settings.getInt("day_1",0);

        if(lastDay1!=currentDay1){
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("day_1",currentDay1);
            editor.apply();

            int maxValue = bar1.getMax(); //????????? ?????????
            if (maxValue == nowValue1) { nowValue1 = 0; }  //30?????? ????????? ?????????
            else {
                bar1.setVisibility(View.VISIBLE);
                rank_iv1.setVisibility(View.INVISIBLE);
                nowValue1 += 1;  //?????? ?????? ??? 1??? ??????
            }

            if (nowValue1 == 0) { //????????? ????????? ??? ??????????????? ????????? ??????
                bar1.setVisibility(View.VISIBLE);
                showAlert();
            }
            else bar1.setProgress(nowValue1);
            click1.setText(nowValue1+"???");
            Toast.makeText(this,"1-?????? ?????? ??????!",Toast.LENGTH_SHORT).show();
        }

    }

    /*????????? ???, ????????? ????????? ????????? ????????? ???????????? ?????? ??????*/
    public void OnceADay2(){
        Calendar calendar2 = Calendar.getInstance();
        int currentDay2 = calendar2.get(Calendar.DAY_OF_MONTH);
        SharedPreferences settings = getSharedPreferences("EAT_2",0);
        int lastDay2 = settings.getInt("day_2",0);

        if(lastDay2!=currentDay2){
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("day_2",currentDay2);
            editor.apply();
            int maxValue = bar2.getMax(); //????????? ?????????

            if (maxValue == nowValue2) { nowValue2 = 0; }
            else {
                bar2.setVisibility(View.VISIBLE);
                rank_iv2.setVisibility(View.INVISIBLE);
                nowValue2 += 1;
            }

            if (nowValue2 == 0) {
                bar2.setVisibility(View.VISIBLE);
                showAlert();
            }
            else bar2.setProgress(nowValue2);
            click2.setText(nowValue2+"???");
            Toast.makeText(this,"2-?????? ?????? ??????!",Toast.LENGTH_SHORT).show();
        }
    }

    /*????????? ???, ????????? ????????? ????????? ????????? ???????????? ?????? ??????*/
    public void OnceADay3(){
        Calendar calendar3 = Calendar.getInstance();
        int currentDay3 = calendar3.get(Calendar.DAY_OF_MONTH);
        SharedPreferences settings = getSharedPreferences("EAT_3",0);
        int lastDay3 = settings.getInt("day_3",0);

        if(lastDay3!=currentDay3){
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("day_3",currentDay3);
            editor.apply();

            int maxValue = bar3.getMax(); //????????? ?????????
            if (maxValue == nowValue3) { nowValue3 = 0; }
            else {
                bar3.setVisibility(View.VISIBLE);
                rank_iv3.setVisibility(View.INVISIBLE);
                nowValue3 += 1;
            }

            if (nowValue3 == 0) {
                bar3.setVisibility(View.VISIBLE);
                showAlert();
            }
            else bar3.setProgress(nowValue3);
            click3.setText(nowValue3+"???");
            Toast.makeText(this,"3-?????? ?????? ??????!",Toast.LENGTH_SHORT).show();
        }
    }

    /*????????? ???, ????????? ????????? ????????? ????????? ???????????? ?????? ??????*/
    public void OnceADay4(){
        Calendar calendar4 = Calendar.getInstance();
        int currentDay4 = calendar4.get(Calendar.DAY_OF_MONTH);
        SharedPreferences settings = getSharedPreferences("EAT_4",0);
        int lastDay4 = settings.getInt("day_4",0);

        if(lastDay4!=currentDay4){
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("day_4",currentDay4);
            editor.apply();

            int maxValue = bar4.getMax(); //????????? ?????????

            if (maxValue == nowValue4) { nowValue4 = 0; }
            else {
                bar4.setVisibility(View.VISIBLE);
                rank_iv4.setVisibility(View.INVISIBLE);
                nowValue4 += 1;
            }

            if (nowValue4 == 0) {
                bar4.setVisibility(View.GONE);
                showAlert();
            }
            else bar4.setProgress(nowValue4);
            click4.setText(nowValue4+"???");
            Toast.makeText(this,"4-?????? ?????? ??????!",Toast.LENGTH_SHORT).show();
        }
    }

    /*????????? ??????*/
    public void saveData1() {
        SharedPreferences sharedPreferences = getSharedPreferences("sFile1",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("statistics1", nowValue1);
        editor.putString("nameText1", String.valueOf(name1.getText()));
        Log.e("set???", String.valueOf(nowValue1));
        editor.commit();
    }
    /*????????? ????????????*/
    public void getData1() {
        SharedPreferences sf = getSharedPreferences("sFile1", MODE_PRIVATE);
        nowValue1 = sf.getInt("statistics1", 0);
        nametext1 = sf.getString("nameText1","");
        Log.e("get???", String.valueOf(nowValue1));
    }


    /*????????? ??????*/
    public void saveData2() {
        SharedPreferences sharedPreferences = getSharedPreferences("sFile2",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("statistics2", nowValue2);
        Log.e("set???", String.valueOf(nowValue2));
        editor.putString("nameText2", String.valueOf(name2.getText()));
        editor.commit();
    }
    /*????????? ????????????*/
    public void getData2() {
        SharedPreferences sf = getSharedPreferences("sFile2", MODE_PRIVATE);
        nowValue2 = sf.getInt("statistics2", 0);
        nametext2 = sf.getString("nameText2","");
        Log.e("get???", String.valueOf(nowValue2));
    }


    /*????????? ??????*/
    public void saveData3() {
        SharedPreferences sharedPreferences = getSharedPreferences("sFile3",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("statistics3", nowValue3);
        editor.putString("nameText3", String.valueOf(name3.getText()));
        Log.e("set???", String.valueOf(nowValue3));
        editor.commit();
    }
    /*????????? ????????????*/
    public void getData3() {
        SharedPreferences sf = getSharedPreferences("sFile3", MODE_PRIVATE);
        nowValue3 = sf.getInt("statistics3", 0);
        nametext3 = sf.getString("nameText3","");
        Log.e("get???", String.valueOf(nowValue3));
    }


    /*????????? ??????*/
    public void saveData4() {
        SharedPreferences sharedPreferences = getSharedPreferences("sFile4",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("statistics4", nowValue4);
        editor.putString("nameText4", String.valueOf(name4.getText()));
        Log.e("set???", String.valueOf(nowValue4));
        editor.commit();
    }
    /*????????? ????????????*/
    public void getData4() {
        SharedPreferences sf = getSharedPreferences("sFile4", MODE_PRIVATE);
        nowValue4 = sf.getInt("statistics4", 0);
        nametext4 = sf.getString("nameText4","");
        Log.e("get???", String.valueOf(nowValue4));
    }

    public void showAlert() {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(StatisticsMain_Activity.this);
        // alert??? title??? Messege ??????
        builder.setTitle("???????????????!");
        builder.setMessage("30??? ?????? ?????????????????????!");
        // ?????? ?????? (Ok ????????? Cancle ?????? )
        builder.setPositiveButton("??????",null);
        builder.create().show();

    }


}
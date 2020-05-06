package com.google.distlergrace.guess02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameTotalsActivity extends AppCompatActivity
{

    TextView    textViewTotals;
    Button      buttonReturnHome;

    Integer     totalWows;
    Integer     totalAvgs;
    Integer     totalNovs;
    String      result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_totals);

        textViewTotals      = findViewById(R.id.textViewResults);
        buttonReturnHome    = findViewById(R.id.buttonReturnHome);

        //totalWows   = 0;
        //totalAvgs   = 0;
        //totalNovs   = 0;

        Intent totalsIntent = getIntent();
        Bundle rankExtras  = totalsIntent.getExtras();

        if (rankExtras != null)
        {
            if (rankExtras.containsKey("totalWows"))
            {
                totalWows = rankExtras.getInt("totalWows", 0);
            }
            if (rankExtras.containsKey("totalAvgs"))
            {
                totalAvgs = rankExtras.getInt("totalAvgs", 0);
            }
            if (rankExtras.containsKey("totalNovs"))
            {
                totalNovs = rankExtras.getInt("totalNovs", 0);
            }

            result  = "\nTotal WOWs: " + totalWows.toString() + "\n";
            result += "\nTotal AVGs: " + totalAvgs.toString() + "\n";
            result += "\nTotal NOVs: " + totalNovs.toString() + "\n";
            textViewTotals.setText(result);
        }

        buttonReturnHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}

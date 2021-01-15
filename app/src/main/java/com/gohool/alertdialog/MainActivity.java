package com.gohool.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertDialog;
    private Button buttonDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDialog = (Button) findViewById(R.id.alertButton);
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show the actual alert dialog
                alertDialog = new AlertDialog.Builder(MainActivity.this);
                //set thing up - setup title
                //alertDialog.setTitle(R.string.title);
                alertDialog.setTitle(getResources().getString(R.string.title));
                alertDialog.setIcon(android.R.drawable.star_on);

                //set message
                alertDialog.setMessage(getResources().getString(R.string.message));

                //set cancelable
                alertDialog.setCancelable(false);

                //set positive Button
                alertDialog.setPositiveButton(getResources().getString(R.string.yes),
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Exit our window activity
                        MainActivity.this.finish();
                    }
                });

                //set negative Button
                alertDialog.setNegativeButton(getResources().getString(R.string.no),
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                //Create the actual Dialog
                AlertDialog dialog = alertDialog.create();
                //Show dialog
                dialog.show();
            }
        });

    }
}
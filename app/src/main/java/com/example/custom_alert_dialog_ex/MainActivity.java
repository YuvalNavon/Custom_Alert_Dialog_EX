
/**
 * @author		Yuval Navon <yuvalnavon8@gmail.com>
 * @version	1.0
 * @since		20/12/2021
 * The program has 4 buttons which allow the user to choose a background color from 1 of the RGB Colors,
 * a possible mix of them, reset the background color to white, and to make custom toasts using
 * Buttons and custom AlertDialogs (all in order from the top button to the bottom).
 * It has a general OptionsMenu to go to the credits screen/second activity.
 */

package com.example.custom_alert_dialog_ex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


    public class MainActivity extends AppCompatActivity {
        /**
         * The class makes 3 AlertDialogs used by Buttons which allow the user to choose a
         *  background color from 1 of the RGB Colors, a possible mix of them,
         *  reset the background color to white, and to make custom toasts
         *  using Buttons and custom AlertDialogs (all in order from the top button to the bottom).
         *
         *
         * @param	None
         * @return	None
         */

    AlertDialog.Builder adb1, adb2, adb4;
    AlertDialog ad1, ad2, ad4;
    LinearLayout screen;

    int[] rgb1 = {0, 0, 0};
    int[] rgb2 = {0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);
        String[] colors = {"RED", "GREEN", "BLUE"};

        adb1 = new AlertDialog.Builder(this);
        adb1.setTitle("Change Background Color");
        adb1.setCancelable(false);
        adb1.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                rgb1[which] = 255;
                screen.setBackgroundColor(Color.rgb(rgb1[0], rgb1[1], rgb1[2]));
                rgb1[0] = 0;
                rgb1[1] = 0;
                rgb1[2] = 0;
            }
        });
        adb1.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        ad1 = adb1.create();


        adb2 = new AlertDialog.Builder(this);
        adb2.setTitle("Change Background Color Combo");
        adb2.setCancelable(false);
        adb2.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) rgb2[which] = 255;
                else if (rgb2[which] == 255)
                {
                    rgb2[which] = 0;
                }


            }
        });
        adb2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                screen.setBackgroundColor(Color.rgb(rgb2[0], rgb2[1], rgb2[2]));

            }
        });
        adb2.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        ad2 = adb2.create();


        adb4 = new AlertDialog.Builder(this);
        adb4.setTitle("Toast Maker");
        adb4.setCancelable(false);
        EditText et = new EditText(this);
        et.setHint("Enter Toast");
        adb4.setView(et);
        adb4.setPositiveButton("Make Toast", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                        String str = et.getText().toString();
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                        et.setText("");


            }
        });
        adb4.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                et.setText("");
                dialog.cancel();
            }
        });

        ad4 = adb4.create();





    }

    public void ad1_click (View view)
    /**
     * The function is called when the first button (from top to bottom) is pressed.
     * It shows the first AlertDialog.
     *
     *
     * @param    View view -	required for the function to be recognized as the button's
     *      *              onClick method
     * @return	None
     */
    {
                ad1.show();
    }



    public void ad2_click (View view)
    /**
     * The function is called when the second button (from top to bottom) is pressed.
     * It shows the second AlertDialog.
     *
     *
     * @param    View view -	required for the function to be recognized as the button's
     *      *              onClick method
     * @return	None
     */
    {
        ad2.show();
    }


    public void ad3_click (View view)
    /**
     * The function is called when the third button (from top to bottom) is pressed.
     * It changes the screen's background color to white.
     *
     *
     * @param    View view -	required for the function to be recognized as the button's
     *      *              onClick method
     * @return	None
     */
    {
        screen.setBackgroundColor(Color.WHITE);
    }

    public void ad4_click (View view)
    /**
     * The function is called when the forth button (from top to bottom) is pressed.
     * It shows the third AlertDialog.
     *
     *
     * @param    View view -	required for the function to be recognized as the button's
     *      *              onClick method
     * @return	None
     */
    {
        ad4.show();
    }

    public boolean onCreateOptionsMenu (Menu menu)
    /**
     * The function creates a general Option Menu, which has 2 buttons:
     * 1. Main - takes the user to the main/first activity (if they aren't on it already).
     * 2. Credits - takes the user to the credits screen/second activity (if they aren't on it already).
     *
     *
     * @param    Menu menu -	required for the function to inflate the menu layout into
     *                the Menu object which it creates.
     * @return	true
     */
    {

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    /**
     * The function decides which option the user chose, and acts accordingly.
     * If they chose the Credits option, the function will start the second activity/go to
     * the credits screen.
     * Else, nothing happens.
     *
     *
     * @param    MenuItem item - the option which the user chose.
     * @return	true
     */
    {
        int id = item.getItemId();
        if (id == R.id.Credits)
        {
            Intent si = new Intent(this, Credits.class);
            startActivity(si);
        }
        return true;


    }

}
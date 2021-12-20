
/**
 * @author		Yuval Navon <yuvalnavon8@gmail.com>
 * @version	1.0
 * @since		20/12/2021
 * The program shows the credits for the app, using a TextView.
 * It has a general OptionsMenu to go back to the main activity.
 */

package com.example.custom_alert_dialog_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Credits extends AppCompatActivity {
    /**
     * The class makes creates the activity, nothin' else.
     *
     *
     * @param	None
     * @return	None
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);


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
     * If they chose the Menu option, the function will go back to the first/main activity.
     * Else, nothing happens.
     *
     *
     * @param    MenuItem item - the option which the user chose.
     * @return	true
     */
    {
        int id = item.getItemId();
        if (id == R.id.Main)
        {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        return true;

    }
}
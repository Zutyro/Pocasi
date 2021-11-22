package cz.utb.fai.pocasitureckytomas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    EditText editText;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        editText = findViewById(R.id.second_layout_edittext);
        editText.setText("Vyberte mesto, ve kterem chcete sledovat pocasi.");
        spinner = findViewById(R.id.second_layout_spinner);

    }

    @Override
    public void onResume() {
        super.onResume();

        String SHARED_PREFERENCES_FILE_NAME = "appFileInternal";
        String myStringKeyInternal = "selectedCityKey";
        String myStringKeyInternalDefault = "N/A";
        SharedPreferences sharedPreferences = this.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, MODE_PRIVATE);
        String currentCity = sharedPreferences.getString(myStringKeyInternal, myStringKeyInternalDefault);

        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equals(currentCity)) {
                spinner.setSelection(i);
            }
        }
    }


    public void saveSettingsClick(View v) {
        String SHARED_PREFERENCES_FILE_NAME = "appFileInternal";
        String myStringKeyInternal = "selectedCityKey";
        SharedPreferences sharedPreferences = v.getContext().getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(myStringKeyInternal, spinner.getSelectedItem().toString());
        editor.apply();
    }
}
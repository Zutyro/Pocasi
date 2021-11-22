package cz.utb.fai.pocasitureckytomas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewCity;
    private static final String TAG = "MMMMM";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        textViewCity = findViewById(R.id.activity_main_textview_city);
    }

    @Override
    public void onResume() {
        super.onResume();

        String SHARED_PREFERENCES_FILE_NAME = "appFileInternal";
        String myStringKeyInternal = "selectedCityKey";
        String myStringKeyInternalDefault = "N/A";
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, MODE_PRIVATE);
        textViewCity.setText(sharedPreferences.getString(myStringKeyInternal, myStringKeyInternalDefault));
    }

    public void myButtonClick(View v) {
        Intent intent = new Intent(context, SecondActivity.class);
        startActivity(intent);
    }
}
package hotforms.com.br.realmtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import java.util.Calendar;

import hotforms.com.br.realmtest.services.PersonServices;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(v -> new Thread(() -> {
            PersonServices personServices = new PersonServices(MainActivity.this);
            Log.i(TAG, String.valueOf(Calendar.getInstance().getTime()));
            personServices.populate(100000); //100.000 mil registros inseridos em 3 segundos
            Log.i(TAG, String.valueOf(Calendar.getInstance().getTime()));
        }).start());

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PersonListActivity.class);
            startActivity(intent);
        });
    }
}
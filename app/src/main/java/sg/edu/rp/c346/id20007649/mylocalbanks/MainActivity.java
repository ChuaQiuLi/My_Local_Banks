package sg.edu.rp.c346.id20007649.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDbs;
    Button btnOcbc;
    Button btnUob;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDbs = findViewById(R.id.btnDbs);
        btnOcbc = findViewById(R.id.btnOcbc);
        btnUob = findViewById(R.id.btnUob);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {

            btnDbs.setText("DBS");
            btnOcbc.setText("OCBC");
            btnUob.setText("UOB");


            return true;
        }

        else if (id == R.id.ChineseSelection) {

            btnDbs.setText("星展银行");
            btnOcbc.setText("华侨银行");
            btnUob.setText("大华银行");

            return true;
        }



        return super.onOptionsItemSelected(item);
    }


}
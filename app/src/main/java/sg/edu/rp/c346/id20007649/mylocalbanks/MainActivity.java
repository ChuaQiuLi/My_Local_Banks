package sg.edu.rp.c346.id20007649.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

   TextView btnDbs;
   TextView btnOcbc;
   TextView btnUob;

    String viewSelected = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDbs = findViewById(R.id.btnDbs);
        btnOcbc = findViewById(R.id.btnOcbc);
        btnUob = findViewById(R.id.btnUob);

        registerForContextMenu(btnDbs);
        registerForContextMenu(btnOcbc);
        registerForContextMenu(btnUob);


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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        Log.v("Context", "create context");

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if (v == btnDbs){
            viewSelected = "toptextview";

            Log.v("Context", "top view selected ");
        }

        else if (v == btnOcbc) {
            viewSelected = "middletextview";

            Log.v("Context", "middle view selected ");

        }

        else{
            viewSelected = "bottomtextview";

            Log.v("Context", "bottom view selected ");
        }

    }

    @Override
   public boolean onContextItemSelected(@NonNull MenuItem item) {

       if (viewSelected.equalsIgnoreCase("toptextview") ) {

           if (item.getItemId() == 0  ){

               Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
               startActivity(intent);

               Toast.makeText(MainActivity.this, "Going to DBS webpage", Toast.LENGTH_LONG).show();

               return true;

            }

           else {
               Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18001111111L));
               startActivity(intentCall);

               Toast.makeText(MainActivity.this, "Going phone dialler ", Toast.LENGTH_LONG).show();
           }
      }


       else if (viewSelected.equalsIgnoreCase("middletextview")) {

           if (item.getItemId() == 0 ){

               Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
               startActivity(intent);

               Toast.makeText(MainActivity.this, "Going to OCBC webpage", Toast.LENGTH_LONG).show();

               return true;

           }

           else {

               Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18003633333L));
               startActivity(intentCall);

               Toast.makeText(MainActivity.this, "Going phone dialler ", Toast.LENGTH_LONG).show();
           }

       }

       else {

           if (item.getItemId() == 0 ){

               Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
               startActivity(intent);

               Toast.makeText(MainActivity.this, "Going to UOB webpage", Toast.LENGTH_LONG).show();

               return true;

           }

           else{

               Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18002222121L));
               startActivity(intentCall);

               Toast.makeText(MainActivity.this, "Going phone dialler ", Toast.LENGTH_LONG).show();


           }
       }

        return super.onContextItemSelected(item);

    }
}
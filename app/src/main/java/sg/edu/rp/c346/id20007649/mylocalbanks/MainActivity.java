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

   TextView tvDbs;
   TextView tvOcbc;
   TextView tvUob;

    String viewSelected = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.tvDbs);
        tvOcbc = findViewById(R.id.tvOcbc);
        tvUob = findViewById(R.id.tvUob);

        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);


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

            tvDbs.setText("DBS");
            tvOcbc.setText("OCBC");
            tvUob.setText("UOB");

            return true;
        }

        else if (id == R.id.ChineseSelection) {

            tvDbs.setText("星展银行");
            tvOcbc.setText("华侨银行");
            tvUob.setText("大华银行");

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

        if (v == tvDbs){
            viewSelected = "toptextview";

            Log.v("Context", "top view selected ");
        }

        else if (v == tvOcbc) {
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
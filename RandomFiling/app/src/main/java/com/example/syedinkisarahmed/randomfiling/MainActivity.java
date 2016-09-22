package com.example.syedinkisarahmed.randomfiling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.*;
public class MainActivity extends AppCompatActivity {
public String fileName="newnames"+".dat";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /////////////////////////Create
    public void createFile(View view){
        TextView ed =(TextView) findViewById(R.id.editFirst);
        fileName = ed.getText().toString();

    }
    ////////////////////write
    public void write(View view){
        TextView tx = (TextView) findViewById(R.id.EditFirstRec);
        try {
            FileOutputStream fos = openFileOutput(fileName,MODE_APPEND);
           //DataOutputStream rand = new DataOutputStream(fos );
            int rec = Integer.parseInt(tx.getText().toString());


            fos.write(rec);
            fos.close();
            tx.setText("write");

        }
        catch(Exception ex){
            tx.setText(""+ex);
        }

    }

    /////////////////////////////////////////Read
    public void read (View v){
        TextView tx = (TextView) findViewById(R.id.readText);
       // tx.setText("");
        try {
            FileInputStream fis = openFileInput(fileName);
            int read;
           // rand.seek(0);
            while(true){
                read = fis.read();
                tx.setText(read+"\n");
            }
        }catch (Exception ex){
            //there is nodata
           // tx.setText(""+ex);
        }
    }
    ////////////////////////////////////////TotalSale

    public void totalSale(View v){
        TextView tx = (TextView) findViewById(R.id.tsale);
        int read=0;
        try {
            FileInputStream fis = openFileInput(fileName);

            while(true){
                read += fis.read();

            }
        }catch (Exception ex){
            tx.setText(read+"\n");
        }

    }
}

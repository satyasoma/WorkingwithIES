package com.fa.androiduser.workingwithies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{

    String fileName="Day8";
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=(EditText)findViewById(R.id.edittext1);


        //internal read

                                 //readInternalStorage;

        //internal write

                                 //writeInternalStorage;

        //external read

        //external write

    }

    private String readInternalStorage()
    {
        StringBuffer sb= new StringBuffer(); //the purpose of string buffer is the information we enter will be
                                            //converted to bit by bit and it will be saved.
        int ch;

        //read the file

        try
        {
            FileInputStream fis=openFileInput(fileName);

            //from the FIS reading the file one byte by one byte

            while((ch=fis.read())!=-1) //-1 means end of the file
            {
                sb.append((char)ch);
            }

            fis.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
            return sb.toString();
    }
    private void writeInternalStorage()
    {
        try
        {
            //once we have FOS we can start writing some stuff into it
            FileOutputStream fos=openFileOutput(fileName,MODE_PRIVATE);

            String contentToBeWritten=et.getText().toString();

            fos.write(contentToBeWritten.getBytes());

            fos.close();

            et.setText("");

            System.out.println("File Written");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void Write(View v)
    {
        //internal write

        writeInternalStorage();
    }

    public void Read(View v)
    {
        //internal read
       String whatIRead=readInternalStorage();

        Toast.makeText(getApplicationContext(), whatIRead, Toast.LENGTH_SHORT).show();
    }
}

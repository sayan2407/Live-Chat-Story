package com.example.chatstory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class StoryActivity extends AppCompatActivity {
    int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent i=getIntent();
        Bundle bundle=i.getExtras();
        p=bundle.getInt("position");
       if (p==0)
       {
         showmessage("The Savage Mom","A young boy in a dishearted state texts...");
       }

    }
    public void showmessage(String title,String message)
    {
        AlertDialog.Builder alert=new AlertDialog.Builder(StoryActivity.this);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setCancelable(false);
        alert.setPositiveButton("Read Story", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SavageMom fragment=new SavageMom();
                FragmentManager manager=getSupportFragmentManager();
                manager.beginTransaction().add(R.id.story,fragment).commit();
            }
        });
        alert.create().show();
    }

}

package com.example.chatstory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FunnyActivity extends AppCompatActivity {
    ListView listView;
    String[] title={"The Savage Mom","Sarcastic and Realistic"};
    String[] message={"A young boy in a dishearted state texts...","Sometimes it is okay to leave your c...."};
    int[] i={R.drawable.savage,R.drawable.sarcasm};
    String[] time={"1 year(s) ago | ENGLISH","7 month(s) ago | ENGLISH"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny);
        listView=findViewById(R.id.list_view);

        MyAdapter myAdapter=new MyAdapter(getApplicationContext(),title,message,time,i);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        Bundle bundle=new Bundle();
                        bundle.putInt("position",0);
                        Intent i=new Intent(getApplicationContext(),StoryActivity.class);
                        i.putExtras(bundle);
                        startActivity(i);
                        break;
                    case 1:
                        Toast.makeText(FunnyActivity.this, "Under Development,Click on The Savage Mom", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String title[];
        String message[];
        String time[];
        int img[];
        MyAdapter(Context c,String title[], String message[], String time[],int img[])
        {
            super(c,R.layout.listview_design,R.id.title,title);
            this.context=c;
            this.title=title;
            this.message=message;
            this.time=time;
            this.img=img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row=layoutInflater.inflate(R.layout.listview_design,parent,false);
            ImageView imgs=row.findViewById(R.id.image1);
            TextView name=row.findViewById(R.id.title);
            TextView msg=row.findViewById(R.id.msg);
            TextView t=row.findViewById(R.id.time);

            imgs.setBackgroundResource(img[position]);
            name.setText(title[position]);
            msg.setText(message[position]);
            t.setText(time[position]);
            return row;
        }
    }
}

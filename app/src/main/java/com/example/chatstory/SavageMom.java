package com.example.chatstory;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SavageMom extends Fragment {


    String[] message={"rMom!","sSay it","rMom Mom!","sSpeak up","rMom Mom Mom!","rAre you going to say?","rMom Mom Mom Mom!",
            "sSayan","sWhat is this?","sAre you crazy?","rWhats that?Mom my phone hangs","rIts not an Arithmetic Progression!",
            "rI have something to say!!!","sI was just playing the game that you had started!","rMom please!","soh you dont wanna play?",
            "sThen Speak","rMy Condition is miserable","rToo miserable to walk even","sToo miserable to walk but simply awesome while typing",
            "rMom!!","rIts paining inside","rPlease come over","sI think you messaged the wrong person","sSend it back to your gf","rWhat??",
            "sAsk your gf to come over and heal the pain..","sSince I do not have  wings to fly off from Mumbai","rMom!!","rI had no gf all my life",
            "sYou dont have a gf?","sDude?","sIf you never have had a gf then how do you know what is pain?","rThere is a pain mom!!",
            "rThe pain of not finding a gf!","rBut","rAt this moment my leg aches","sI thought your heart aches","rTommy bit me Mom",
            "soh God!","sHow is my baby!","sis he alive?","rMom!!","rI am texting you because I am alive","sI was asking about Tommy",
            "sIs he alive after consuming poison?","rMommm!!!!","rTell me where is the medicine","sIn your book shelf","rNo Mom! No again",
            "rBooks will kill me","sThere is the first aid box hidden stupid","rI hate you Mom","sI love you too","sTake care"

    };
    ArrayList<String> sender,reciver;
    ListView listView;
    EditText text_msg;
    FloatingActionButton send;
    RelativeLayout savage;
    String msg,msg1="";
    ArrayList<String> s,r;
    MyChat myChat;
    int i=0;
    Boolean internetAvailaible=false;
    Internet detectConnection;
    final int internet=1;
    public SavageMom() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_savage_mom, container, false);
        listView=v.findViewById(R.id.list_view);
        sender=new ArrayList<String>();
        reciver=new ArrayList<String>();
        s=new ArrayList<String>();
        r=new ArrayList<String>();
        text_msg=v.findViewById(R.id.message);
        send=v.findViewById(R.id.send);
        savage=v.findViewById(R.id.touch_here);

        detectConnection=new Internet(getActivity());



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                internetAvailaible=detectConnection.InternetConnecting();
                if (internetAvailaible)
                {
                    String text=text_msg.getText().toString();
                    sender.add(text);
                    reciver.add("");
                    myChat=new MyChat(getActivity(),sender,reciver);
                    listView.setAdapter(myChat);
                    text_msg.setText("");
                }
                else
                {
                    NoInternet noInternet=new NoInternet();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.savage1,noInternet);
                    transaction.commit();

                }


            }
        });

        savage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                internetAvailaible=detectConnection.InternetConnecting();
                if (internetAvailaible)
                {
                    if (i==message.length)
                    {
                        Toast.makeText(getActivity(),"Story End",Toast.LENGTH_SHORT);
                    }else {
                        msg = message[i];

                        if (msg.charAt(0) == 'r') {

                            for (int j = 1; j < msg.length(); j++)
                                msg1 += msg.charAt(j);
                            reciver.add(msg1);
                            sender.add("");
                            msg1="";

                        }
                        if (msg.charAt(0) == 's') {

                            for (int j = 1; j < msg.length(); j++)
                                msg1 += msg.charAt(j);
                            sender.add(msg1);
                            reciver.add("");
                            msg1="";

                        }
                        myChat=new MyChat(getActivity(),sender,reciver);
                        listView.setAdapter(myChat);

                        i++;
                    }
                }
                else {
                    NoInternet noInternet=new NoInternet();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.savage1,noInternet);
                    transaction.commit();

                }






            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                internetAvailaible=detectConnection.InternetConnecting();
                if (internetAvailaible)
                {
                    if (position<=message.length)
                    {
                        if (i==message.length)
                        {
                            Toast.makeText(getActivity(),"Story End",Toast.LENGTH_SHORT);
                        }else {
                            msg = message[i];

                            if (msg.charAt(0) == 'r') {

                                for (int j = 1; j < msg.length(); j++)
                                    msg1 += msg.charAt(j);
                                reciver.add(msg1);
                                sender.add("");
                                msg1="";

                            }
                            if (msg.charAt(0) == 's') {

                                for (int j = 1; j < msg.length(); j++)
                                    msg1 += msg.charAt(j);
                                sender.add(msg1);
                                reciver.add("");
                                msg1="";

                            }
                            myChat=new MyChat(getActivity(),sender,reciver);
                            listView.setAdapter(myChat);

                            i++;
                        }

                    }
                }
                else
                {
                    NoInternet noInternet=new NoInternet();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.savage1,noInternet);
                    transaction.commit();
                }

            }
        });

        return v;
    }


    class MyChat extends ArrayAdapter<String> {
        Context context;
        ArrayList<String> sender, reciver;

        MyChat(Context c, ArrayList<String> sender, ArrayList<String> reciver) {
            super(c, R.layout.list_design, R.id.reciver1, reciver);
            this.context = c;
            this.sender = sender;
            this.reciver = reciver;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.list_design, parent, false);

            TextView name = row.findViewById(R.id.sender1);
            TextView name1 = row.findViewById(R.id.reciver1);
            if (sender.get(position).equals(""))
            {
                name.setVisibility(View.INVISIBLE);
            }
            if (reciver.get(position).equals(""))
            {
                name1.setVisibility(View.INVISIBLE);
            }

            name.setText(sender.get(position));
            name1.setText(reciver.get(position));

            return row;
        }
    }


}

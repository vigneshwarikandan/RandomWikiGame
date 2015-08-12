package com.example.samyukthah.randomwikigame;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Models.RandomPage;
import Models.RemovedWords;


public class MainActivity extends ActionBarActivity {
 int count=1;
    TextView tv0;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;

    TextView tv12;
    TextView tv13;
    TextView tv14;
    TextView tv15;
    TextView tv16;
    TextView ed1;
    TextView ed0;
    TextView ed2;
    TextView ed3;
    TextView tv11;
    TextView tv7;
    TextView tv8;
    TextView tv9;
    TextView tv10;

    Button finishBtn;
    Button replayBtn;
    List<RemovedWords> removedwordsList=new ArrayList<RemovedWords>();
ListView lstwords;
    RemovedWords removedWordHashMap;
     int score=0;
    public TextView createContactTextView(String text){
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextSize(20);
        tv.setWidth(50);
        System.out.println("textview added =" + count);

        count++;
      //  tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.presence_offline, 0);
        return tv;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain2);
      // final RelativeLayout rl=(RelativeLayout)findViewById(R.id.relativelayoutid);
    //   final  TextView webdisplay=(TextView)findViewById(R.id.Webdisplay);
        new AsyncTask<Void,Void,String>() {
            @Override
            protected String doInBackground(Void... params) {
                return RandomPage.jread();
            }

            @Override
            protected void onPostExecute(String result) {
                String[] splited = result.split("\\s+");
                    tv0=(TextView)findViewById(R.id.txtv0);
                    tv0.setText(splited[0]);

                    tv1=(TextView)findViewById(R.id.txtv1);
                    tv1.setText(splited[1]);

                    tv2=(TextView)findViewById(R.id.txtv2);
                    tv2.setText(splited[2]);

                    tv3=(TextView)findViewById(R.id.txtv3);
                    tv3.setText(splited[3]);

                 ed0=(TextView)findViewById(R.id.edv0);
                ed0.setText("___________");
                removedWordHashMap=new RemovedWords("4",splited[4]);

                removedwordsList.add(removedWordHashMap);
                tv4=(TextView)findViewById(R.id.txtv4);
                tv4.setText(splited[5]);
                tv5=(TextView)findViewById(R.id.txtv5);
                tv5.setText(splited[6]);
                tv6=(TextView)findViewById(R.id.txtv6);
                tv6.setText(splited[7]);
                tv7=(TextView)findViewById(R.id.txtv7);
                tv7.setText(splited[8]);
                ed1=(TextView)findViewById(R.id.edv1);
                removedWordHashMap=new RemovedWords("9",splited[9]);
                ed1.setText("__________");
                removedwordsList.add(removedWordHashMap);

               // removedwordsList.add(removedWordHashMap);
                tv8=(TextView)findViewById(R.id.txtv8);
                tv8.setText(splited[10]);
                tv9=(TextView)findViewById(R.id.txtv9);
                tv9.setText(splited[11]);
                tv10=(TextView)findViewById(R.id.txtv10);
                tv10.setText(splited[12]);
                tv11=(TextView)findViewById(R.id.txtv11);
                tv11.setText(splited[13]);
                ed2=(TextView)findViewById(R.id.edv2);
                ed2.setText("__________");
                removedWordHashMap=new RemovedWords("14",splited[14]);
                removedwordsList.add(removedWordHashMap);
                tv12=(TextView)findViewById(R.id.txtv12);
                tv12.setText(splited[15]);
                tv13=(TextView)findViewById(R.id.txtv13);
                tv13.setText(splited[16]);
                tv14=(TextView)findViewById(R.id.txtv14);
                tv14.setText(splited[17]);
                tv15=(TextView)findViewById(R.id.txtv15);
                tv15.setText(splited[18]);

                ed3=(TextView)findViewById(R.id.edv3);


                removedWordHashMap=new RemovedWords("19",splited[19]);
                removedwordsList.add(removedWordHashMap);
                ed3.setText("__________");
            }
        }.execute();
        ed0=(TextView)findViewById(R.id.edv0);
        ed1=(TextView)findViewById(R.id.edv1);
        ed2=(TextView)findViewById(R.id.edv2);
        ed3=(TextView)findViewById(R.id.edv3);
        ed0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(v);
            }
        });
        ed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(v);
            }
        });

        ed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(v);
            }
        });
        ed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(v);
            }
        });
        finishBtn=(Button)findViewById(R.id.btnfinish);
        replayBtn=(Button)findViewById(R.id.btnreplay);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer1=ed0.getText().toString();
                String answer2=ed1.getText().toString();
                String answer3=ed2.getText().toString();
                String reqAnswer1="";
                String reqAnswer2="";
                String reqAnswer3="";
                System.out.println("the size of the list is "+removedwordsList.size());
                for(int i=0;i<removedwordsList.size();i++){
                    RemovedWords rem=removedwordsList.get(i);
                    if(rem.get("wordindex").equals("4")){
                        reqAnswer1=rem.get("word");

                    }else if(rem.get("wordindex").equals("9")){
                        reqAnswer2=rem.get("word");
                    }else if(rem.get("word").equals("13")){
                        reqAnswer3=rem.get("word");
                    }
                    System.out.println("the reqanswer1="+reqAnswer1);
                    System.out.println("the reqanswer2="+reqAnswer2);
                }
                if(answer1.equals(reqAnswer1)){
                    ++score;
                }
                if(answer2.equals(reqAnswer2)){
                    ++score;
                }
                if(answer3.equals(reqAnswer3)){
                    ++score;
                }

                Toast.makeText(MainActivity.this,"Your score is"+score,Toast.LENGTH_LONG).show();
            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void open(View v){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final List<Integer> mSelectedItems = new ArrayList();
        final View selectedView=v;
        LayoutInflater inflater = this.getLayoutInflater();
        final View layoutalertdialogView=inflater.inflate(R.layout.alertdialoglayout, null);
        SimpleAdapter adap=new SimpleAdapter(MainActivity.this,removedwordsList,R.layout.listviewrow,new String[]{"word"},new int[]{R.id.txtw1});
        lstwords=(ListView)layoutalertdialogView.findViewById(R.id.lstlistofwords);
        lstwords.setAdapter(adap);
        alertDialogBuilder.setView(layoutalertdialogView);
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        lstwords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RemovedWords rw=(RemovedWords)parent.getItemAtPosition(position);
                String selword=rw.get("word");
                System.out.println("the selword is="+selword);
                String txtview=getResources().getResourceEntryName(selectedView.getId());
                System.out.println(" the textview is "+txtview);
                if(txtview.equals("edv0")){
                   // ed0.setAllCaps(true);
                    ed0.setPaintFlags(ed0.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                    ed0.setText(selword);
                    alertDialog.hide();
                }else if(txtview.equals("edv1")){
                   // ed1.setAllCaps(true);
                    ed1.setPaintFlags(ed1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                    ed1.setText(selword);
                    alertDialog.hide();
                }else if(txtview.equals("edv2")){
                    // ed1.setAllCaps(true);
                    ed2.setPaintFlags(ed2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                    ed2.setText(selword);
                    alertDialog.hide();
                }else if(txtview.equals("edv3")){
                    // ed1.setAllCaps(true);
                    ed3.setPaintFlags(ed3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                    ed3.setText(selword);
                    alertDialog.hide();
                }
            }
        });
    }

    public void dynamicAdd(String result){
        LinearLayout ll = new LinearLayout(MainActivity.this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        ll.setGravity(Gravity.CENTER);
        String[] splited = result.split("\\s+");
        int textviewcount=0;
        for(int i=0;i<splited.length;i++){
            System.out.println("the splitted string is " + splited[i]);
            if(textviewcount==10){
                EditText ed=createEditText(splited[i]);
                ll.addView(ed);
                textviewcount=0;

            }else{
                TextView tv=createContactTextView(splited[i]);

                textviewcount++;
                ll.addView(tv);
            }

            //    rl.addView(tv);
            // tv.setText(" \n");
        }
        //setContentView(ll);
    }

    public EditText createEditText(String text){
        EditText tv = new EditText(this);
        tv.setText(text);
        tv.setTextSize(20);
        tv.setWidth(50);
        System.out.println("Edit text added =" + count);
        count++;
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.presence_offline, 0);
        return tv;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

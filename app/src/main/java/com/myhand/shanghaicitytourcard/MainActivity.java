package com.myhand.shanghaicitytourcard;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.myhand.POS.DatabaseSHCT;
import com.myhand.devices.DataExchangeService;

public class MainActivity extends AppCompatActivity {
    private String tag=MainActivity.class.getSimpleName();
    public static final int CardQuery=1;
    public static final int SendData=2;
    public static final int DebitQuery=3;
    public static final int Login=4;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //启动数据交换服务
        Intent dataExchangeService=new Intent(MainActivity.this, DataExchangeService.class);
        ComponentName name=startService(dataExchangeService);
        if(name==null){
            Log.d(tag,"Service start failure");
        }else{
            Log.d(tag,"Service start OK,name:"+name.getShortClassName());
        }

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        Button btnLogin=(Button)findViewById(R.id.buttonLogin) ;
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,LoginActivity.class);
                startActivityForResult(intent,Login);
            }
        });

        Button btnCardQuery=(Button)findViewById(R.id.buttonCardQuery);
        btnCardQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,CityCardQueryActivity.class);
                startActivityForResult(intent,CardQuery);
            }
        });

        Button btnSendData=(Button)findViewById(R.id.buttonConnect);
        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,SendDataActivity.class);
                startActivityForResult(intent,SendData);
            }
        });

        Button btnDebitQuery=(Button)findViewById(R.id.buttonDebitQuery) ;
        btnDebitQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,DebitQueryActivity.class);
                startActivityForResult(intent,DebitQuery);
            }
        });

        //测试黑名单卡数据库
        POSApplication application=(POSApplication)getApplication();

        DatabaseSHCT db=application.getAppDatabase();
        db.insertBlkCard("123");
        if(!db.isBlackCard("123"))
        {
            Log.d(tag,"Black Card Find Failure");
        }
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

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}

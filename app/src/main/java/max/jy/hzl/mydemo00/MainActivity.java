package max.jy.hzl.mydemo00;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mPb;
    private int progress=0;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progress+=10;
            mPb.setProgress(progress);
            if(progress==mPb.getMax()){
                startActivity(new Intent(MainActivity.this,Main2Activity.class));

                overridePendingTransition(R.anim.enter_anim,R.anim.exit_anim);
                timer.cancel();
                finish();
            }

        }
    };
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTimer();
    }

    private void initTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        },1000,500);
    }

    private void initView() {
        mPb = (ProgressBar) findViewById(R.id.pb);
    }
}

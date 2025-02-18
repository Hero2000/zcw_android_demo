package top.zcwfeng.jetpack;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import top.zcwfeng.jetpack.bean.User;
import top.zcwfeng.jetpack.databinding.ActivitySecondBinding;

/**
 * Databinding Demo
 */
public class MyDatabindDemoActivity extends AppCompatActivity {

    ActivitySecondBinding activitySecondBinding;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
        user = new User("David");
        activitySecondBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_second);
        activitySecondBinding.tv.setText(user.getName());

        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                user.setName(user.name + "1");
//                activitySecondBinding.setUser(user);
                activitySecondBinding.setVariable(BR.user, user);
                Log.d("zcw:::", Thread.currentThread().getName());
                handler.postDelayed(this, 1000);
            }
        });
    }
}
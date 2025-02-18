package top.zcwfeng.httpprocessor_java_hilt;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import dagger.hilt.android.AndroidEntryPoint;
import top.zcwfeng.httpprocessor_java_hilt.bean.ResponceData;
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    //全局注入
    IHttpProcessor iHttpProcessor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iHttpProcessor = ((MyApplication)getApplication()).getiHttpProcessor();
    }

    public void click(View view) {
        Log.e("zcwfeng", "11111111");

        String url="https://v.juhe.cn/historyWeather/citys";
        HashMap<String,Object> params=new HashMap<>();
        //https://v.juhe.cn/historyWeather/citys?&province_id=2&key=bb52107206585ab074f5e59a8c73875b
        params.put("province_id","2");
        params.put("key","bb52107206585ab074f5e59a8c73875b");
        iHttpProcessor.post(url, params, new HttpCallback<ResponceData>() {
            @Override
            public void onSuccess(ResponceData objResult) {
                Log.e("zcwfeng", "click(View view) ==== onSuccess");
                Toast.makeText(MainActivity.this, objResult.getResultcode(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
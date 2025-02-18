package top.zcwfeng.giflib;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import top.zcwfeng.giflib.gif.GifDrawable;
import top.zcwfeng.giflib.gif.GifFrame;

//import top.zcwfeng.giflib.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {



//    ActivityMainBinding mainBinding;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE}, 666);
        }

        GifDrawable gifDrawable;
        try {

//            File file = new File("a.txt");
//            FileInputStream fileInputStream = new FileInputStream(file);
//            byte[] buffer = new byte[1024];
//            fileInputStream.read(buffer,0,buffer.length);

//            gifDrawable = new GifDrawable(GifFrame.decodeStream(getAssets().open("fire.gif")));
            gifDrawable = new GifDrawable(GifFrame.decodeStream(this,"fire.gif"));
//            gifDrawable = new GifDrawable(GifFrame.decodeStream(null,"/sdcard/timg_2.gif"));
            imageView.setImageDrawable(gifDrawable);
            gifDrawable.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public native String stringFromJNI();

}
package com.example.ibasu.fart2;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer fartSound;


    Button farty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        farty=(Button)findViewById(R.id.fartbutton);
        farty.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                Toast.makeText(MainActivity.this, "raspberry", Toast.LENGTH_SHORT).show();
                if(fartSound.isPlaying()){
                    fartSound.stop();
                }
                try{
                    fartSound.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("R.raw.raspberry1");
                    fartSound.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                    fartSound.prepare();
                    fartSound.start();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



    }
}

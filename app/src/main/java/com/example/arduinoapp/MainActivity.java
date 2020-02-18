package com.example.arduinoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Method;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class MainActivity extends AppCompatActivity {



    private Button button;

    private Switch switchMode;
    private Switch switchState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.getArduino);

        switchState=findViewById(R.id.switchState);
        switchMode=findViewById(R.id.switchMode);

        Gson gson= new GsonBuilder()
                    .setLenient()
                    .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.172:8080/arduino/")
                //.addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

      final  ArduinoService service = retrofit.create(ArduinoService.class);



      //for switching states
        switchState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Call<Arduino> callInfo = service.getState();

                if(switchState.getText().equals("OFF"))
                    switchState.setText("ON");
                else
                    switchState.setText("OFF");

                callInfo.enqueue(new Callback<Arduino>() {
                    @Override
                    public void onResponse(Call<Arduino> call, Response<Arduino> response) {

                        Arduino use = response.body();
                        Toast.makeText(getApplicationContext(),"message: "+use.getMessage()+" state: " +
                                use.getMode(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Arduino> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });
            }


        });

        //for switching mode

        switchMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Call<Arduino> callMode = service.getMode();

                if(switchMode.getText().equals("OFF"))
                    switchMode.setText("ON");
                else
                    switchMode.setText("OFF");

                callMode.enqueue(new Callback<Arduino>() {
                    @Override
                    public void onResponse(Call<Arduino> call, Response<Arduino> response) {

                        Arduino use = response.body();
                        Toast.makeText(getApplicationContext(),"message: "+use.getMessage()+" state: " +
                                use.getMode(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Arduino> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
    }
}

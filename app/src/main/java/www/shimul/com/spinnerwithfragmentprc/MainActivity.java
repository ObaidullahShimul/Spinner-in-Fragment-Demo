package www.shimul.com.spinnerwithfragmentprc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    BlankFragment graphics;// =new BlankFragment();
    AndroidFragment androidFragment;//=new AndroidFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        graphics=new BlankFragment();
        androidFragment=new AndroidFragment();

        spinner=findViewById(R.id.spId);
        String[] title=getResources().getStringArray(R.array.spinner_title);



        ArrayAdapter <String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,R.layout.custom_spinner,title);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        setFragment(graphics);
                        break;

                    case 1:
                        setFragment(androidFragment);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void setFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainFragment,fragment);
        fragmentTransaction.commit();
    }
}

package com.example.omero.donemsonuortalamahesaplama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,spinner9,spinner10;
    Button btnHesapla;
    EditText ders1Edit,ders2Edit,ders3Edit,ders4Edit,ders5Edit,ders6Edit,ders7Edit,ders8Edit,ders9Edit,ders10Edit;
    double ders1_kredi_deger,ders2_kredi_deger,ders3_kredi_deger,ders4_kredi_deger,ders5_kredi_deger,ders6_kredi_deger,ders7_kredi_deger,ders8_kredi_deger,ders9_kredi_deger,ders10_kredi_deger;
    double ders1_derece,ders2_derece,ders3_derece,ders4_derece,ders5_derece,ders6_derece,ders7_derece,ders8_derece,ders9_derece,ders10_derece;
    public double sonuc=0,top_kredi=0,kredi_toplam=0;

    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        doldur();
        ders1Edit=(EditText)findViewById(R.id.ders1_kredi);
        btnHesapla=(Button)findViewById(R.id.btnHesapla);
        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kredi_topla();
                toplanan_kredi();
                hesapla();
                sonuc=hesapla();
                Toast.makeText(MainActivity.this,String.valueOf(sonuc),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("sonuc_al",sonuc);
                startActivity(intent);

            }
        });

    }
    private void doldur(){
        spinner1=(Spinner)findViewById(R.id.ders1);
        adapter=ArrayAdapter.createFromResource(this,R.array.dersDerecesi,R.layout.spinner_row_derece);
        adapter.setDropDownViewResource(R.layout.spinner_row_derece);
        spinner1.setAdapter(adapter);

        spinner2=(Spinner)findViewById(R.id.ders2);
        adapter=ArrayAdapter.createFromResource(this,R.array.dersDerecesi,R.layout.spinner_row_derece);
        adapter.setDropDownViewResource(R.layout.spinner_row_derece);
        spinner2.setAdapter(adapter);

        spinner3=(Spinner)findViewById(R.id.ders3);
        adapter=ArrayAdapter.createFromResource(this,R.array.dersDerecesi,R.layout.spinner_row_derece);
        adapter.setDropDownViewResource(R.layout.spinner_row_derece);
        spinner3.setAdapter(adapter);

        spinner4=(Spinner)findViewById(R.id.ders4);
        adapter=ArrayAdapter.createFromResource(this,R.array.dersDerecesi,R.layout.spinner_row_derece);
        adapter.setDropDownViewResource(R.layout.spinner_row_derece);
        spinner4.setAdapter(adapter);

        spinner5=(Spinner)findViewById(R.id.ders5);
        adapter=ArrayAdapter.createFromResource(this,R.array.dersDerecesi,R.layout.spinner_row_derece);
        adapter.setDropDownViewResource(R.layout.spinner_row_derece);
        spinner5.setAdapter(adapter);

        spinner6=(Spinner)findViewById(R.id.ders6);
        adapter=ArrayAdapter.createFromResource(this,R.array.dersDerecesi,R.layout.spinner_row_derece);
        adapter.setDropDownViewResource(R.layout.spinner_row_derece);
        spinner6.setAdapter(adapter);

        spinner7=(Spinner)findViewById(R.id.ders7);
        adapter=ArrayAdapter.createFromResource(this,R.array.dersDerecesi,R.layout.spinner_row_derece);
        adapter.setDropDownViewResource(R.layout.spinner_row_derece);
        spinner7.setAdapter(adapter);

        spinner8=(Spinner)findViewById(R.id.ders8);
        adapter=ArrayAdapter.createFromResource(this,R.array.dersDerecesi,R.layout.spinner_row_derece);
        adapter.setDropDownViewResource(R.layout.spinner_row_derece);
        spinner8.setAdapter(adapter);

        spinner9=(Spinner)findViewById(R.id.ders9);
        adapter=ArrayAdapter.createFromResource(this,R.array.dersDerecesi,R.layout.spinner_row_derece);
        adapter.setDropDownViewResource(R.layout.spinner_row_derece);
        spinner9.setAdapter(adapter);

        spinner10=(Spinner)findViewById(R.id.ders10);
        adapter=ArrayAdapter.createFromResource(this,R.array.dersDerecesi,R.layout.spinner_row_derece);
        adapter.setDropDownViewResource(R.layout.spinner_row_derece);
        spinner10.setAdapter(adapter);
    }
    private double kredi_topla(){
        ders1Edit=(EditText)findViewById(R.id.ders1_kredi);
        ders2Edit=(EditText)findViewById(R.id.ders2_kredi);
        ders3Edit=(EditText)findViewById(R.id.ders3_kredi);
        ders4Edit=(EditText)findViewById(R.id.ders4_kredi);
        ders5Edit=(EditText)findViewById(R.id.ders5_kredi);
        ders6Edit=(EditText)findViewById(R.id.ders6_kredi);
        ders7Edit=(EditText)findViewById(R.id.ders7_kredi);
        ders8Edit=(EditText)findViewById(R.id.ders8_kredi);
        ders9Edit=(EditText)findViewById(R.id.ders9_kredi);
        ders10Edit=(EditText)findViewById(R.id.ders10_kredi);

        ders1_kredi_deger=kredi_denetle(ders1Edit.getText().toString());
        ders2_kredi_deger=kredi_denetle(ders2Edit.getText().toString());
        ders3_kredi_deger=kredi_denetle(ders3Edit.getText().toString());
        ders4_kredi_deger=kredi_denetle(ders4Edit.getText().toString());
        ders5_kredi_deger=kredi_denetle(ders5Edit.getText().toString());
        ders6_kredi_deger=kredi_denetle(ders6Edit.getText().toString());
        ders7_kredi_deger=kredi_denetle(ders7Edit.getText().toString());
        ders8_kredi_deger=kredi_denetle(ders8Edit.getText().toString());
        ders9_kredi_deger=kredi_denetle(ders9Edit.getText().toString());
        ders10_kredi_deger=kredi_denetle(ders10Edit.getText().toString());

        kredi_toplam=ders1_kredi_deger+ders2_kredi_deger+ders3_kredi_deger+ders4_kredi_deger+ders5_kredi_deger+ders6_kredi_deger+ders7_kredi_deger+ders8_kredi_deger+ders9_kredi_deger+ders10_kredi_deger;

        return kredi_toplam;
    }
    private double kredi_denetle(String txt){
       double kredi=-1;
        if (txt.toString().matches(""))
            kredi=0;
        else
            kredi=Double.parseDouble(txt.toString());
        return kredi;
    }

    private double toplanan_kredi(){

        ders1_derece=spin_denetle(spinner1.getSelectedItem().toString());
        ders2_derece=spin_denetle(spinner2.getSelectedItem().toString());
        ders3_derece=spin_denetle(spinner3.getSelectedItem().toString());
        ders4_derece=spin_denetle(spinner4.getSelectedItem().toString());
        ders5_derece=spin_denetle(spinner5.getSelectedItem().toString());
        ders6_derece=spin_denetle(spinner6.getSelectedItem().toString());
        ders7_derece=spin_denetle(spinner7.getSelectedItem().toString());
        ders8_derece=spin_denetle(spinner8.getSelectedItem().toString());
        ders9_derece=spin_denetle(spinner9.getSelectedItem().toString());
        ders10_derece=spin_denetle(spinner10.getSelectedItem().toString());

        top_kredi=(ders1_kredi_deger*ders1_derece)+(ders2_kredi_deger*ders2_derece)+(ders3_kredi_deger*ders3_derece)+(ders4_kredi_deger*ders4_derece)+(ders5_kredi_deger*ders5_derece)+(ders6_kredi_deger*ders6_derece)+(ders7_kredi_deger*ders7_derece)+(ders8_kredi_deger*ders8_derece)+(ders9_kredi_deger*ders9_derece)+(ders10_kredi_deger*ders10_derece);

        return top_kredi;
    }
    private double spin_denetle(String spinn){
        double x=-1;
        if (spinn.matches("AA"))
           x=4;
        else if(spinn.matches("BA"))
            x=3.5;
        else if(spinn.matches("BB"))
            x=3;
        else if(spinn.matches("CB"))
            x=2.5;
        else if(spinn.matches("CC"))
            x=2;
        else if(spinn.matches("DC"))
            x=1.5;
        else if(spinn.matches("DD"))
            x=1;
        else if(spinn.matches("FD"))
            x=0.5;
        else if(spinn.matches("FF"))
            x=0;

        return x;
    }

    public double hesapla(){

        sonuc=toplanan_kredi()/kredi_topla();

        return sonuc;
    }

}

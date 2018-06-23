package com.example.josuealejandrodiaz.calculadora_final;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText fecha1, hora1;
    private int dia1, mes1, ano1, hor1, minutos1;

    EditText fecha2, hora2;
    TextView respuesta;
    Button boton;
    private int dia2, mes2, ano2, edad, hor2, minutos2;
    private int resulDias, resulMes, resulAnos, resulHoras;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fecha1 = (EditText) findViewById(R.id.fecha1);
        fecha1.setFocusable(false);
        hora1 = (EditText) findViewById(R.id.hora1);
        hora1.setFocusable(false);

        fecha2 = (EditText) findViewById(R.id.fecha2);
        fecha2.setFocusable(false);
        hora2 = (EditText) findViewById(R.id.hora2);
        hora2.setFocusable(false);
        boton = (Button) findViewById(R.id.boton);
        respuesta = (TextView) findViewById(R.id.respuesta);

        fecha1.setOnClickListener(this);
        hora1.setOnClickListener(this);

        ///////////////////////////////////////////////////////////////////////////////////////////
        fecha2.setOnClickListener(this);
        hora2.setOnClickListener(this);
        boton.setOnClickListener(this);


/*  */
    }

    @Override
    public void onClick(View v) {
        if (v == fecha1) {
            final Calendar a = Calendar.getInstance();
            dia1 = a.get(Calendar.DAY_OF_MONTH);
            mes1 = a.get(Calendar.MONTH);
            ano1 = a.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    dia1 = dayOfMonth;
                    mes1 = monthOfYear;
                    ano1 = year;


                    fecha1.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                }
            }
                    , dia1, mes1, ano1);
            datePickerDialog.show();
        }

        if (v==hora1){
            final Calendar c = Calendar.getInstance();
            hor1 = c.get(Calendar.HOUR_OF_DAY);
            minutos1=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hor1 = hourOfDay;
                    minutos1 = minute;

                    hora1.setText(hourOfDay+":"+minute);
                }
            }
                    ,hor1,minutos1,false);
            timePickerDialog.show();
        }

        ////////////////////////////////////////////////////////////////////////////////////////////

        if (v == fecha2) {
            final Calendar b = Calendar.getInstance();
            dia2 = b.get(Calendar.DAY_OF_MONTH);
            mes2 = b.get(Calendar.MONTH);
            ano2 = b.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    dia2 = dayOfMonth;
                    mes2 = monthOfYear;
                    ano2 = year;

                    fecha2.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                }
            }
                    , dia2, mes2, ano2);
            datePickerDialog.show();
        }

            if (v==hora2){
                final Calendar c = Calendar.getInstance();
                hor2 = c.get(Calendar.HOUR_OF_DAY);
                minutos2=c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hor2 = hourOfDay;
                        minutos2 = minute;


                        hora2.setText(hourOfDay+":"+minute);
                    }
                }
                        ,hor2,minutos2,false);
                timePickerDialog.show();
                }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (v.getId() == R.id.boton) {

            int  DAnos,DMeses = 0,DDias = 0;
            DAnos = ano2 - ano1;
            if (mes2 < mes1) {
                DAnos--;
                DMeses = 12-(mes2-mes1);
                if (dia2 < dia1) {
                    DMeses--;
                    DDias = 30 -dia2-dia1;
                }else{
                    DDias = dia2-dia1;
                }

            } else if (mes1 == mes2) {
                DMeses=0;
                if (dia2 < dia1) {
                    DMeses--;
                    DDias = 30 -dia2-dia1;
                }else{
                    DDias = dia2-dia1;
                }
            }else{
                DMeses = mes2-mes1;
                if (dia2 < dia1) {
                    DMeses--;
                    DDias = 30 -dia2-dia1;
                }else{
                    DDias = dia2-dia1;
                }
            }

            Toast.makeText(getBaseContext(),+dia1+"/"+mes1+"/"+ano1,Toast.LENGTH_SHORT).show();
            Toast.makeText(getBaseContext(),+dia2+"/"+mes2+"/"+ano2,Toast.LENGTH_SHORT).show();
            Toast.makeText(getBaseContext(),"Tiiempo Transcurrido es "+DAnos+", "+DMeses+" meses "+" y "+DDias+"dias",Toast.LENGTH_LONG).show();
            respuesta.setText("Tiempo Transcurrido es "+DAnos+" Años "+", "+DMeses+" meses "+" y "+DDias+"dias");

        }





    }


    }




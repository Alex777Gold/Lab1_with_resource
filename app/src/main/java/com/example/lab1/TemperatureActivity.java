package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TemperatureActivity extends AppCompatActivity {
    //teacher

    private BroadcastReceiver tickReceiver;
    private BroadcastReceiver finishReceiver;
/*
    private void startTimer() {
        Intent timerIntent = new Intent(this, DegreesService.class);
        timerIntent.putExtra(DegreesService.TIMER_ACTION, DegreesService.START);
        //imerIntent.putExtra(DegreesService.TIMER_TIME, DegreesService);
        startService(timerIntent);
    }
*/

    private TextView service;
    private TextView textdegrees;
    String numcel, numkel, numfahr = null;

    public double locgic_degree(Spinner datatemp_1, Spinner datatemp_2, double datatemp_3, double kelvin, double fahrenheit, double celsius){
        switch(datatemp_1.getSelectedItem().toString()) {
            case "celsius":
                switch (datatemp_2.getSelectedItem().toString()) {
                    case "celsius":
                        datatemp_3 = datatemp_3;
                        break;
                    case "kelvin":
                        datatemp_3 = datatemp_3+(kelvin-celsius);
                        break;
                    case "fahrenheit":
                        datatemp_3 = (datatemp_3*1.8)+(fahrenheit-1.8);
                        break;
                }
                break;
            case "kelvin":
                switch (datatemp_2.getSelectedItem().toString()) {
                    case "celsius":
                        datatemp_3 = datatemp_3 + (kelvin-1);
                        break;
                    case "kelvin":
                        datatemp_3 = datatemp_3;
                        break;
                    case "fahrenheit":
                        datatemp_3 = (datatemp_3-(kelvin-celsius))*1.8+(fahrenheit-1.8);
                        break;
                }
                break;
            case "fahrenheit":
                switch (datatemp_2.getSelectedItem().toString()) {
                    case "celsius":
                        datatemp_3 = (datatemp_3-(fahrenheit-1.8))*1.8;
                        break;
                    case "kelvin":
                        datatemp_3 = (datatemp_3-(fahrenheit-1.8))*0.555+(kelvin-celsius);
                        break;
                    case "fahrenheit":
                        datatemp_3 = datatemp_3;
                        break;
                }
                break;
        }
        return datatemp_3;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        textdegrees = findViewById(R.id.activity_temperature);
        parseXML();

        Spinner temperaturesp5, temperaturesp6;
        EditText temperatureed3;
        Button temperatureb3;

        final double celsius = Double.parseDouble(numcel);
        final double kelvin = Double.parseDouble(numkel);
        final double fahrenheit = Double.parseDouble(numfahr);

        temperatureed3 = findViewById(R.id.editTextTextPersonName2);
        temperaturesp5 = findViewById(R.id.spinner3);
        temperaturesp6 = findViewById(R.id.spinner4);
        temperatureb3 = findViewById(R.id.button6);

        String[] from = {"celsius", "kelvin", "fahrenheit"};
        ArrayAdapter temperaturead3 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        temperaturesp5.setAdapter(temperaturead3);

        String[] to = {"celsius", "kelvin", "fahrenheit"};
        ArrayAdapter temperaturead4 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        temperaturesp6.setAdapter(temperaturead4);


        temperatureb3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Double temperaturetot2 = null;
                Double temperatureamount2 = Double.parseDouble(temperatureed3.getText().toString());

                Spinner datatempone = temperaturesp5;
                Spinner datatemptwo = temperaturesp6;
                Double datatemptree = temperatureamount2;
                String resulted;

                resulted = String.valueOf(locgic_degree(datatempone, datatemptwo, datatemptree, kelvin, fahrenheit, celsius));
                Toast.makeText(getApplicationContext(), resulted, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = getAssets().open("datadegrees.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            processParsing(parser);

        } catch (XmlPullParserException e) {

        } catch (IOException e) {

        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        ArrayList<Degrees> degrees_s = new ArrayList<Degrees>();
        int eventType = parser.getEventType();
        Degrees currentDegrees = null;

        while(eventType != XmlPullParser.END_DOCUMENT){
            String eltName = null;

            switch(eventType){
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();
                    //switch no work
                    if ("degrees".equals(eltName)) {
                        currentDegrees = new Degrees();
                        degrees_s.add(currentDegrees);
                    } else if (currentDegrees != null){
                        if ("celsius".equals(eltName)) {
                            currentDegrees.celsius = parser.nextText();
                        } else if ("kelvin".equals(eltName)) {
                            currentDegrees.kelvin = parser.nextText();
                        } else if ("fahrenheit".equals(eltName)) {
                            currentDegrees.fahrenheit = parser.nextText();
                        }
                    }
                    break;
            }
            eventType = parser.next();
        }
        printDegrees(degrees_s);
    }

    private void printDegrees(ArrayList<Degrees> degrees_s) {
        StringBuilder builder = new StringBuilder();

        for (Degrees degrees : degrees_s) {
            numcel = degrees.celsius;
            numkel = degrees.kelvin;
            numfahr = degrees.kelvin;

            builder.append("Сelsius: ").append(degrees.celsius).append("\n").
                    append("Kelvin: ").append(degrees.kelvin).append("\n").
                    append("Fahrenheit: ").append(degrees.kelvin).append("\n")
            ;
        }

        textdegrees.setText(builder.toString());
    }
}
package com.example.lab1;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class LengthActivity extends AppCompatActivity {

    private TextView textlength;
    String mnum, cnum, knum ,inum, fnum, minum, ynum = null;
    String nmnum, nknum, ninum, nfnum, nminum, nynum = null;

    public static double sant (double num, double form, double to){
        return num*form * to;
    }

    public double locgic_length(Spinner datatemp_1, Spinner datatemp_2, double length, double amount,
                                double centimeter, double meters, double kilometer, double inch, double foot, double mile, double yard,
                                double nmeters, double nkilometer, double ninch, double nfoot, double nmile, double nyard
    ){
        switch(datatemp_1.getSelectedItem().toString()){
            case "centimeter":
                switch (datatemp_2.getSelectedItem().toString()){
                    case "centimeter":
                        length = sant(centimeter, amount, centimeter);
                        break;
                    case "meter":
                        length = sant(centimeter, amount, meters);
                        break;
                    case "kilometer":
                        length = sant(centimeter, amount, kilometer);
                        break;
                    case "inch":
                        length = sant(centimeter, amount, inch);
                        break;
                    case "mile":
                        length = sant(centimeter, amount, mile);
                        break;
                    case "yard":
                        length = sant(centimeter, amount, yard);
                        break;
                    case "foot":
                        length = sant(centimeter, amount, foot);
                        break;
                }
                break;
            case "meter":
                switch (datatemp_2.getSelectedItem().toString()){
                    case "centimeter":
                        length = sant(nmeters, amount, centimeter);
                        break;
                    case "meter":
                        length = sant(nmeters, amount, meters);
                        break;
                    case "kilometer":
                        length = sant(nmeters, amount, kilometer);
                        break;
                    case "inch":
                        length = sant(nmeters,amount, inch);
                        break;
                    case "mile":
                        length = sant(nmeters, amount, mile);
                        break;
                    case "yard":
                        length = sant(nmeters, amount, yard);
                        break;
                    case "foot":
                        length = sant(nmeters, amount, foot);
                        break;
                }
                break;
            case "kilometer":
                switch (datatemp_2.getSelectedItem().toString()){
                    case "centimeter":
                        length = sant(nkilometer, amount, centimeter);
                        break;
                    case "meter":
                        length = sant(nkilometer, amount, meters);
                        break;
                    case "kilometer":
                        length = sant(nkilometer, amount, kilometer);
                        break;
                    case "inch":
                        length = sant(nkilometer, amount, inch);
                        break;
                    case "mile":
                        length = sant(nkilometer, amount, mile);
                        break;
                    case "yard":
                        length = sant(nkilometer, amount, yard);
                        break;
                    case "foot":
                        length = sant(nkilometer, amount, foot);
                        break;
                }
                break;
            case "inch":
                switch (datatemp_2.getSelectedItem().toString()){
                    case "centimeter":
                        length = sant(ninch, amount, centimeter);
                        break;
                    case "meter":
                        length = sant(ninch, amount, meters);
                        break;
                    case "kilometer":
                        length = sant(ninch, amount, kilometer);
                        break;
                    case "inch":
                        length = sant(ninch, amount, inch);
                        break;
                    case "mile":
                        length = sant(ninch, amount, mile);
                        break;
                    case "yard":
                        length = sant(ninch, amount, yard);
                        break;
                    case "foot":
                        length = sant(ninch, amount, foot);
                        break;
                }
                break;
            case "mile":
                switch (datatemp_2.getSelectedItem().toString()){
                    case "centimeter":
                        length = sant(nmile, amount, centimeter);
                        break;
                    case "meter":
                        length = sant(nmile, amount, meters);
                        break;
                    case "kilometer":
                        length = sant(nmile, amount, kilometer);
                        break;
                    case "inch":
                        length = sant(nmile, amount, inch);
                        break;
                    case "mile":
                        length = sant(nmile, amount, mile);
                        break;
                    case "yard":
                        length = sant(nmile, amount, yard);
                        break;
                    case "foot":
                        length = sant(nmile, amount, foot);
                        break;
                }
                break;
            case "yard":
                switch (datatemp_2.getSelectedItem().toString()){
                    case "centimeter":
                        length = sant(nyard, amount, centimeter);
                        break;
                    case "meter":
                        length = sant(nyard, amount, meters);
                        break;
                    case "kilometer":
                        length = sant(nyard, amount, kilometer);
                        break;
                    case "inch":
                        length = sant(nyard, amount, inch);
                        break;
                    case "mile":
                        length = sant(nyard, amount, mile);
                        break;
                    case "yard":
                        length = sant(nyard, amount, yard);
                        break;
                    case "foot":
                        length = sant(nyard, amount, foot);
                        break;
                }
                break;
            case "foot":
                switch (datatemp_2.getSelectedItem().toString()){
                    case "centimeter":
                        length = sant(nfoot, amount, centimeter);
                        break;
                    case "meter":
                        length = sant(nfoot, amount, meters);
                        break;
                    case "kilometer":
                        length = sant(nfoot, amount, kilometer);
                        break;
                    case "inch":
                        length = sant(nfoot, amount, inch);
                        break;
                    case "mile":
                        length = sant(nfoot, amount, mile);
                        break;
                    case "yard":
                        length = sant(nfoot, amount, yard);
                        break;
                    case "foot":
                        length = sant(nfoot, amount, foot);
                        break;
                }
                break;

        }
        return length;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        textlength = findViewById(R.id.activity_length);
        parseXML();

        Spinner lengthsp1, lengthsp2;
        EditText lengthed1;
        Button lengthb1;

        final double meters = Double.parseDouble(mnum);
        final double centimeter = Double.parseDouble(cnum);
        final double kilometer = Double.parseDouble(knum);
        final double inch = Double.parseDouble(inum);
        final double foot = Double.parseDouble(fnum);
        final double mile = Double.parseDouble(minum);
        final double yard = Double.parseDouble(ynum);

        double nmeters = Double.parseDouble(nmnum);
        double nkilometer = Double.parseDouble(nknum);
        double ninch = Double.parseDouble(ninum);
        double nfoot = Double.parseDouble(nfnum);
        double nmile = Double.parseDouble(nminum);
        double nyard = Double.parseDouble(nynum);

        lengthed1 = findViewById(R.id.editTextTextPersonName);
        lengthsp1 = findViewById(R.id.spinner);
        lengthsp2 = findViewById(R.id.spinner2);
        lengthb1 = findViewById(R.id.button);

        String[] from = {"centimeter", "meter", "kilometer", "inch", "mile", "yard", "foot"};
        ArrayAdapter lengthad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        lengthsp1.setAdapter(lengthad);

        String[] to = {"centimeter", "meter", "kilometer", "inch", "mile", "yard", "foot"};
        ArrayAdapter lengthad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        lengthsp2.setAdapter(lengthad1);

        lengthb1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Double lengthtots = Double.valueOf(0);
                Double lengthamount = Double.parseDouble(lengthed1.getText().toString());

                Spinner datalenone = lengthsp1;
                Spinner datalentwo = lengthsp2;
                Double lengthamounts = lengthamount;
                String resulted;

                resulted = String.valueOf(locgic_length(datalenone, datalentwo, lengthtots, lengthamounts,
                        centimeter, meters, kilometer, inch, foot, mile, yard,
                        nmeters, nkilometer, ninch, nfoot, nmile, nyard));
                Toast.makeText(getApplicationContext(), resulted, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = getAssets().open("datalength.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            processParsing(parser);

        } catch (XmlPullParserException e) {

        } catch (IOException e) {

        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        ArrayList<Length> lengths = new ArrayList<Length>();
        int eventType = parser.getEventType();
        Length currentLength = null;

        while(eventType != XmlPullParser.END_DOCUMENT){
            String eltName = null;

            switch(eventType){
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();
                    //switch no work
                    if ("length".equals(eltName)) {
                        currentLength = new Length();
                        lengths.add(currentLength);
                    } else if (currentLength != null){
                        if ("meter".equals(eltName)) {
                            currentLength.meter = parser.nextText();
                        } else if ("centimeter".equals(eltName)) {
                            currentLength.centimeter = parser.nextText();
                        } else if ("kilometer".equals(eltName)) {
                            currentLength.kilometer = parser.nextText();
                        } else if ("inch".equals(eltName)) {
                            currentLength.inch = parser.nextText();
                        } else if ("foot".equals(eltName)) {
                            currentLength.foot = parser.nextText();
                        } else if ("mile".equals(eltName)) {
                            currentLength.mile = parser.nextText();
                        } else if ("yard".equals(eltName)) {
                            currentLength.yard = parser.nextText();
                        } else if ("nmeter".equals(eltName)) {
                            currentLength.nmeter = parser.nextText();
                        }else if ("nkilometer".equals(eltName)) {
                            currentLength.nkilometer = parser.nextText();
                        } else if ("ninch".equals(eltName)) {
                            currentLength.ninch = parser.nextText();
                        } else if ("nfoot".equals(eltName)) {
                            currentLength.nfoot = parser.nextText();
                        } else if ("nmile".equals(eltName)) {
                            currentLength.nmile = parser.nextText();
                        } else if ("nyard".equals(eltName)) {
                            currentLength.nyard = parser.nextText();
                        }
                    }
                    break;
            }
            eventType = parser.next();
        }
        printLengths(lengths);
    }

    private void printLengths(ArrayList<Length> lengths) {
        StringBuilder builder = new StringBuilder();

        for (Length length : lengths) {
            mnum = length.meter;
            cnum = length.centimeter;
            knum = length.kilometer;
            inum = length.inch;
            fnum = length.foot;
            minum = length.mile;
            ynum = length.yard;
            nmnum = length.nmeter;
            nknum = length.nkilometer;
            ninum = length.ninch;
            nfnum = length.nfoot;
            nminum = length.nmile;
            nynum = length.nyard;

            builder.append("Meters: ").append(length.meter).append("\n").
                    append("Centimeter: ").append(length.centimeter).append("\n").
                    append("Kilometer: ").append(length.kilometer).append("\n").
                    append("Inch: ").append(length.inch).append("\n").
                    append("Foot: ").append(length.foot).append("\n").
                    append("Mile: ").append(length.mile).append("\n").
                    append("Yard: ").append(length.yard).append("\n").
                    append("Dop Meters: ").append(length.nmeter).append("\n").
                    append("Dop Kilometer: ").append(length.nkilometer).append("\n").
                    append("Dop Inch: ").append(length.ninch).append("\n").
                    append("Dop Foot: ").append(length.nfoot).append("\n").
                    append("Dop Mile: ").append(length.nmile).append("\n").
                    append("Dop Yard: ").append(length.nyard).append("\n")
            ;
        }

        textlength.setText(builder.toString());
    }
}
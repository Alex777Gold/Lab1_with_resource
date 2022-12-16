package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

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

public class WeightActivity extends AppCompatActivity {

    private TextView textweight;
    String grnum, kinum, tnum, canum, fonum, pudnum;
    String nkinum, ntnum, ncanum, nfonum, npudnum;

    //double res1;

    public static double killogram (double num, double form, double to){
        return num*form * to;
    }

    public double locgic_weight(Spinner datatemp_3, Spinner datatemp_4, double datatemp_5, double datatemp_6,
                                double gramm, double kilogramm, double tonna, double carat, double foont, double pud,
                                double nkilogramm, double ntonna, double ncarat, double nfoont, double npud
    ){
        switch(datatemp_3.getSelectedItem().toString()) {
            case "gramm":
                switch (datatemp_4.getSelectedItem().toString()) {
                    case "gramm":
                        datatemp_5 = datatemp_6;
                        break;
                    case "kilogramm":
                        datatemp_5 = killogram(gramm, datatemp_6, kilogramm);
                        break;
                    case "tonna":
                        datatemp_5 = killogram(gramm, datatemp_6, tonna);
                        break;
                    case "carat":
                        datatemp_5 = killogram(gramm, datatemp_6, carat);
                        break;
                    case "foont":
                        datatemp_5 = killogram(gramm, datatemp_6, foont);
                        break;
                    case "pud":
                        datatemp_5 = killogram(gramm, datatemp_6, pud);
                        break;
                }
                break;
            case "kilogramm":
                switch (datatemp_4.getSelectedItem().toString()) {
                    case "gramm":
                        datatemp_5 = killogram(nkilogramm, datatemp_6, gramm);
                        break;
                    case "kilogramm":
                        datatemp_5 = datatemp_6;
                        break;
                    case "tonna":
                        datatemp_5 = killogram(nkilogramm, datatemp_6, tonna);
                        break;
                    case "carat":
                        datatemp_5 = killogram(nkilogramm, datatemp_6, carat);
                        break;
                    case "foont":
                        datatemp_5 = killogram(nkilogramm, datatemp_6, foont);
                        break;
                    case "pud":
                        datatemp_5 = killogram(nkilogramm, datatemp_6, pud);
                        break;
                }
                break;
            case "tonna":
                switch (datatemp_4.getSelectedItem().toString()) {
                    case "gramm":
                        datatemp_5 = killogram(ntonna, datatemp_6, gramm);
                        break;
                    case "kilogramm":
                        datatemp_5 = killogram(ntonna, datatemp_6, kilogramm);
                        break;
                    case "tonna":
                        datatemp_5 = datatemp_6;
                        break;
                    case "carat":
                        datatemp_5 = killogram(ntonna, datatemp_6, carat);
                        break;
                    case "foont":
                        datatemp_5 = killogram(ntonna, datatemp_6, foont);
                        break;
                    case "pud":
                        datatemp_5 = killogram(ntonna, datatemp_6, pud);
                        break;
                }
                break;
            case "carat":
                switch (datatemp_4.getSelectedItem().toString()) {
                    case "gramm":
                        datatemp_5 = killogram(ncarat, datatemp_6, gramm);
                        break;
                    case "kilogramm":
                        datatemp_5 = killogram(ncarat, datatemp_6, kilogramm);
                        break;
                    case "tonna":
                        datatemp_5 = killogram(ncarat, datatemp_6, tonna);
                        break;
                    case "carat":
                        datatemp_5 = datatemp_6;
                        break;
                    case "foont":
                        datatemp_5 = killogram(ncarat, datatemp_6, foont);
                        break;
                    case "pud":
                        datatemp_5 = killogram(ncarat, datatemp_6, pud);
                        break;
                }
                break;
            case "foont":
                switch (datatemp_4.getSelectedItem().toString()) {
                    case "gramm":
                        datatemp_5 = killogram(nfoont, datatemp_6, gramm);
                        break;
                    case "kilogramm":
                        datatemp_5 = killogram(nfoont, datatemp_6, kilogramm);
                        break;
                    case "tonna":
                        datatemp_5 = killogram(nfoont, datatemp_6, tonna);
                        break;
                    case "carat":
                        datatemp_5 = killogram(nfoont, datatemp_6, carat);
                        break;
                    case "foont":
                        datatemp_5 = datatemp_6;
                        break;
                    case "pud":
                        datatemp_5 = killogram(nfoont, datatemp_6, pud);
                        break;
                }
                break;
            case "pud":
                switch (datatemp_4.getSelectedItem().toString()) {
                    case "gramm":
                        datatemp_5 = killogram(npud, datatemp_6, gramm);
                        break;
                    case "kilogramm":
                        datatemp_5 = killogram(npud, datatemp_6, kilogramm);
                        break;
                    case "tonna":
                        datatemp_5 = killogram(npud, datatemp_6, tonna);
                        break;
                    case "carat":
                        datatemp_5 = killogram(npud, datatemp_6, carat);
                        break;
                    case "foont":
                        datatemp_5 = killogram(npud, datatemp_6, foont);
                        break;
                    case "pud":
                        datatemp_5 = datatemp_6;
                        break;
                }
                break;
        }
        return datatemp_5;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

            textweight = findViewById(R.id.activity_weight);
            parseXML();

            Spinner weightsp3, weightsp4;
            EditText weighted2;
            Button weightb2;

            final double gramm = Double.parseDouble(grnum);
            final double kilogramm = Double.parseDouble(kinum);
            final double tonna = Double.parseDouble(tnum);
            final double carat = Double.parseDouble(canum);
            final double foont = Double.parseDouble(fonum);
            final double pud = Double.parseDouble(pudnum);

            double nkilogramm = Double.parseDouble(nkinum);
            double ntonna = Double.parseDouble(ntnum);
            double ncarat = Double.parseDouble(ncanum);
            double nfoont = Double.parseDouble(nfonum);
            double npud = Double.parseDouble(npudnum);

            weighted2 = findViewById(R.id.editTextTextPersonName5);
            weightsp3 = findViewById(R.id.spinner8);
            weightsp4 = findViewById(R.id.spinner9);
            weightb2 = findViewById(R.id.button5);

            String[] from = {"gramm", "kilogramm", "tonna", "carat", "foont", "pud"};
            ArrayAdapter ad3 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
            weightsp3.setAdapter(ad3);

            String[] to = {"gramm", "kilogramm", "tonna", "carat", "foont", "pud"};
            ArrayAdapter ad4 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
            weightsp4.setAdapter(ad4);

            weightb2.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                    Double weighttot1 = Double.valueOf(0);
                    Double weightamount1 = Double.parseDouble(weighted2.getText().toString());

                    Spinner datatempone = weightsp3;
                    Spinner datatemptwo = weightsp4;
                    Double datatemptree = weightamount1;
                    String resulted;

                    resulted = String.valueOf(locgic_weight(datatempone, datatemptwo, weighttot1, datatemptree,
                    gramm, kilogramm, tonna, carat, foont, pud,
                            nkilogramm, ntonna, ncarat, nfoont, npud));

                    Toast.makeText(getApplicationContext(), resulted, Toast.LENGTH_LONG).show();

                    }
                });

            }
        private void parseXML() {
            XmlPullParserFactory parserFactory;
            try {
                parserFactory = XmlPullParserFactory.newInstance();
                XmlPullParser parser = parserFactory.newPullParser();
                InputStream is = getAssets().open("dataweight.xml");
                parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                parser.setInput(is, null);

                processParsing(parser);

            } catch (XmlPullParserException e) {

            } catch (IOException e) {

            }
        }

        private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
            ArrayList<Weight> weights = new ArrayList<Weight>();
            int eventType = parser.getEventType();
            Weight currenWeight = null;

            while(eventType != XmlPullParser.END_DOCUMENT){
                String eltName = null;

                switch(eventType){
                    case XmlPullParser.START_TAG:
                        eltName = parser.getName();
                        //switch no work
                        if ("weight".equals(eltName)) {
                            currenWeight = new Weight();
                            weights.add(currenWeight);
                        } else if (currenWeight != null){
                            if ("kilogram".equals(eltName)) {
                                currenWeight.kilogram = parser.nextText();
                            } else if ("gram".equals(eltName)) {
                                currenWeight.gram = parser.nextText();
                            } else if ("tonna".equals(eltName)) {
                                currenWeight.tonna = parser.nextText();
                            } else if ("carat".equals(eltName)) {
                                currenWeight.carat = parser.nextText();
                            } else if ("foont".equals(eltName)) {
                                currenWeight.foont = parser.nextText();
                            } else if ("pud".equals(eltName)) {
                                currenWeight.pud = parser.nextText();
                            } else if ("nkilogramm".equals(eltName)) {
                                currenWeight.nkilogramm = parser.nextText();
                            } else if ("ntonna".equals(eltName)) {
                                currenWeight.ntonna = parser.nextText();
                            }else if ("ncarat".equals(eltName)) {
                                currenWeight.ncarat = parser.nextText();
                            } else if ("nfoont".equals(eltName)) {
                                currenWeight.nfoont = parser.nextText();
                            } else if ("npud".equals(eltName)) {
                                currenWeight.npud = parser.nextText();
                            }
                        }
                    break;
            }
            eventType = parser.next();
        }
        printWeights(weights);
    }

    private void printWeights(ArrayList<Weight> weights) {
        StringBuilder builder = new StringBuilder();

        for (Weight weight : weights) {
            grnum = weight.gram;
            kinum = weight.kilogram;
            tnum = weight.tonna;
            canum = weight.carat;
            fonum = weight.foont;
            pudnum = weight.pud;
            nkinum = weight.ntonna;
            ntnum = weight.ncarat;
            ncanum = weight.ncarat;
            nfonum = weight.nfoont;
            npudnum = weight.npud;

            builder.append("Gram: ").append(weight.gram).append("\n").
                    append("Kilogram: ").append(weight.kilogram).append("\n").
                    append("Tonna: ").append(weight.tonna).append("\n").
                    append("Carat: ").append(weight.carat).append("\n").
                    append("Foont: ").append(weight.foont).append("\n").
                    append("Pud: ").append(weight.pud).append("\n").
                    append("Dop Kilogramm: ").append(weight.nkilogramm).append("\n").
                    append("Dop Tonna: ").append(weight.ntonna).append("\n").
                    append("Dop Carat: ").append(weight.ncarat).append("\n").
                    append("Dop Foont: ").append(weight.nfoont).append("\n").
                    append("Dop Foot: ").append(weight.nfoont).append("\n").
                    append("Dop Pud: ").append(weight.npud).append("\n")
            ;
        }

        textweight.setText(builder.toString());
    }

}
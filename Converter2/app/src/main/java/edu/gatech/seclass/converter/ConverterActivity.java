package edu.gatech.seclass.converter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ConverterActivity extends AppCompatActivity {

    private Spinner spinnerSrc;
    private Spinner spinnerDst;
    private EditText distValue;
    private EditText distResult;
    private ArrayAdapter<String> adapterItems;
    private Context context;
    private String[] items = {"Mile", "Foot", "Inch", "Km", "M", "Cm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        context = this.getApplicationContext();

        spinnerSrc = (Spinner)findViewById(R.id.spinnerSrc);
        spinnerDst = (Spinner)findViewById(R.id.spinnerDst);
        distValue = (EditText)findViewById(R.id.distValue);
        distResult = (EditText)findViewById(R.id.distResult);

        adapterItems = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        adapterItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerSrc.setAdapter(adapterItems);
        spinnerDst.setAdapter(adapterItems);

        spinnerSrc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "Your choice is " + items[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerDst.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "Your choice is " + items[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    public void handleClick(View view){
        String unitFrom = "Mile";
        String unitTo = "Mile";

        switch(view.getId()){
            case R.id.btReset:
                distValue.setText("");
                distResult.setText("");
                spinnerSrc.setSelection(0);
                spinnerDst.setSelection(0);
                break;

            case R.id.btConvert:

                String value = distValue.getText().toString();
                if(value.length() > 0) {
                    switch (spinnerSrc.getSelectedItemPosition()) {
                        case 0:
                            unitFrom = "Mile";
                            break;
                        case 1:
                            unitFrom = "Foot";
                            break;
                        case 2:
                            unitFrom = "Inch";
                            break;
                        case 3:
                            unitFrom = "Km";
                            break;
                        case 4:
                            unitFrom = "M";
                            break;
                        case 5:
                            unitFrom = "Cm";
                            break;
                    }

                    switch (spinnerDst.getSelectedItemPosition()) {
                        case 0:
                            unitTo = "Mile";
                            break;
                        case 1:
                            unitTo = "Foot";
                            break;
                        case 2:
                            unitTo = "Inch";
                            break;
                        case 3:
                            unitTo = "Km";
                            break;
                        case 4:
                            unitTo = "M";
                            break;
                        case 5:
                            unitTo = "Cm";
                            break;
                    }

                    if (unitFrom.contentEquals(unitTo)) {
                        distResult.setText(value);
                    }
                    else{

                        //mile to others
                        if(unitFrom.contentEquals("Mile") && unitTo.contentEquals("Foot"))
                            distResult.setText(mileToFoot(value));

                        else if(unitFrom.contentEquals("Mile") && unitTo.contentEquals("Inch"))
                            distResult.setText(mileToInch(value));

                        else if(unitFrom.contentEquals("Mile") && unitTo.contentEquals("Km"))
                            distResult.setText(mileToKm(value));

                        else if(unitFrom.contentEquals("Mile") && unitTo.contentEquals("M"))
                            distResult.setText(mileToMeter(value));

                        else if(unitFrom.contentEquals("Mile") && unitTo.contentEquals("Cm"))
                            distResult.setText(mileToCM(value));

                        // foot to others
                        else if(unitFrom.contentEquals("Foot") && unitTo.contentEquals("Mile"))
                            distResult.setText(footToMile(value));
                        else if(unitFrom.contentEquals("Foot") && unitTo.contentEquals("Inch"))
                            distResult.setText(footToInch(value));
                        else if(unitFrom.contentEquals("Foot") && unitTo.contentEquals("Km"))
                            distResult.setText(footToKm(value));
                        else if(unitFrom.contentEquals("Foot") && unitTo.contentEquals("M"))
                            distResult.setText(footToMeter(value));
                        else if(unitFrom.contentEquals("Foot") && unitTo.contentEquals("Cm"))
                            distResult.setText(footToCM(value));


                        //inch to others
                        else if(unitFrom.contentEquals("Inch") && unitTo.contentEquals("Mile"))
                            distResult.setText(inchToMile(value));
                        else if(unitFrom.contentEquals("Inch") && unitTo.contentEquals("Foot"))
                            distResult.setText(inchToFoot(value));
                        else if(unitFrom.contentEquals("Inch") && unitTo.contentEquals("Km"))
                            distResult.setText(inchToKm(value));
                        else if(unitFrom.contentEquals("Inch") && unitTo.contentEquals("M"))
                            distResult.setText(inchToMeter(value));
                        else if(unitFrom.contentEquals("Inch") && unitTo.contentEquals("Cm"))
                            distResult.setText(inchToCM(value));

                        //km to others
                        else if(unitFrom.contentEquals("Km") && unitTo.contentEquals("Mile"))
                            distResult.setText(kmToMile(value));
                        else if(unitFrom.contentEquals("Km") && unitTo.contentEquals("Foot"))
                            distResult.setText(kmToFoot(value));
                        else if(unitFrom.contentEquals("Km") && unitTo.contentEquals("Inch"))
                            distResult.setText(kmToInch(value));
                        else if(unitFrom.contentEquals("Km") && unitTo.contentEquals("M"))
                            distResult.setText(kmToMeter(value));
                        else if(unitFrom.contentEquals("Km") && unitTo.contentEquals("Cm"))
                            distResult.setText(kmToCM(value));


                        //meter to others
                        else if(unitFrom.contentEquals("M") && unitTo.contentEquals("Mile"))
                            distResult.setText(meterToMile(value));
                        else if(unitFrom.contentEquals("M") && unitTo.contentEquals("Foot"))
                            distResult.setText(meterToFoot(value));
                        else if(unitFrom.contentEquals("M") && unitTo.contentEquals("Inch"))
                            distResult.setText(meterToInch(value));
                        else if(unitFrom.contentEquals("M") && unitTo.contentEquals("Km"))
                            distResult.setText(meterToKm(value));
                        else if(unitFrom.contentEquals("M") && unitTo.contentEquals("Cm"))
                            distResult.setText(meterToCM(value));

                        //cm to others
                        else if(unitFrom.contentEquals("Cm") && unitTo.contentEquals("Mile"))
                            distResult.setText(cmToMile(value));
                        else if(unitFrom.contentEquals("Cm") && unitTo.contentEquals("Foot"))
                            distResult.setText(cmToFoot(value));
                        else if(unitFrom.contentEquals("Cm") && unitTo.contentEquals("Inch"))
                            distResult.setText(cmToInch(value));
                        else if(unitFrom.contentEquals("Cm") && unitTo.contentEquals("Km"))
                            distResult.setText(cmToKm(value));
                        else if(unitFrom.contentEquals("Cm") && unitTo.contentEquals("M"))
                            distResult.setText(cmToMeter(value));
                    }
                }


                else{
                    Toast.makeText(context, "Empty Value",Toast.LENGTH_SHORT).show();
                }

        }

    }

    //convert mile to remaining
    public String mileToFoot(String strMile){
        double mile = Double.parseDouble(strMile);
        double foot = mile * 5280;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(foot));
    }

    public String footToMile(String strFoot){
        double foot = Double.parseDouble(strFoot);
        double mile = foot / 5280;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(mile));
    }

    public String mileToInch(String strMile){
        double mile = Double.parseDouble(strMile);
        double inch = mile * 63360;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(inch));
    }

    public String inchToMile(String strInch){
        double inch = Double.parseDouble(strInch);
        double mile = inch / 63360;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(mile));
    }

    public String mileToKm(String strMile){
        double mile = Double.parseDouble(strMile);
        double km = mile * 1.60934;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(km));
    }

    public String kmToMile(String strKm){
        double km = Double.parseDouble(strKm);
        double mile = km / 1.60934;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(mile));
    }

    public String mileToMeter(String strMile){
        double mile = Double.parseDouble(strMile);
        double meter = mile * 1609.344;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(meter));
    }

    public String meterToMile(String strMeter){
        double meter = Double.parseDouble(strMeter);
        double mile = meter / 1609.344;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(mile));
    }

    public String mileToCM(String strMile){
        double mile = Double.parseDouble(strMile);
        double cm = mile * 160934.4;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(cm));
    }

    public String cmToMile(String strCM){
        double cm = Double.parseDouble(strCM);
        double mile = cm / 160934.4;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(mile));
    }


    //convert foot to remaining
    public String footToInch(String strFoot){
        double foot = Double.parseDouble(strFoot);
        double inch = foot * 12;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(inch));
    }

    public String inchToFoot(String strInch){
        double inch = Double.parseDouble(strInch);
        double foot = inch / 12;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(foot));
    }

    public String footToKm(String strFoot){
        double foot = Double.parseDouble(strFoot);
        double km = foot * 0.0003048;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(km));
    }

    public String kmToFoot(String strKm) {
        double km = Double.parseDouble(strKm);
        double foot = km / 0.0003048;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(foot));
    }

    public String footToMeter(String strFoot){
        double foot = Double.parseDouble(strFoot);
        double meter = foot * 0.3048;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(meter));
    }

    public String meterToFoot(String strMeter){
        double meter = Double.parseDouble(strMeter);
        double mile = meter / 0.3048;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(mile));
    }

    public String footToCM(String strFoot){
        double foot = Double.parseDouble(strFoot);
        double cm = foot * 30.48;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(cm));
    }

    public String cmToFoot(String strCM){
        double cm = Double.parseDouble(strCM);
        double foot = cm / 30.48;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(foot));
    }



    //convert inch to remaining
    public String inchToKm(String strInch){
        double inch = Double.parseDouble(strInch);
        double km = inch * 2.54e-5;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(km));
    }

    public String kmToInch(String strKm){
        double km = Double.parseDouble(strKm);
        double inch = km / 2.54e-5;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(inch));
    }

    public String inchToMeter(String strInch){
        double inch = Double.parseDouble(strInch);
        double meter = inch * 2.54e-2;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(meter));
    }

    public String meterToInch(String strMeter){
        double meter = Double.parseDouble(strMeter);
        double inch = meter / 2.54e-2;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(inch));
    }

    public String inchToCM(String strInch){
        double inch = Double.parseDouble(strInch);
        double cm = inch * 2.54;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(cm));
    }

    public String cmToInch(String strCM){
        double cm = Double.parseDouble(strCM);
        double inch = cm / 2.54;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(inch));
    }

    //convert km to remaining
    public String kmToMeter(String strKm){
        double km = Double.parseDouble(strKm);
        double meter = km * 1000;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(meter));
    }

    public String meterToKm(String strMeter){
        double meter = Double.parseDouble(strMeter);
        double km = meter / 1000;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(km));
    }

    public String kmToCM(String strKm){
        double km = Double.parseDouble(strKm);
        double cm = km * 100000;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(cm));
    }

    public String cmToKm(String strCM){
        double cm = Double.parseDouble(strCM);
        double km = cm / 100000;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(km));
    }

    //convert meter to remaining
    public String meterToCM(String strMeter){
        double meter = Double.parseDouble(strMeter);
        double cm = meter * 100;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(cm));
    }

    public String cmToMeter(String strCM){
        double cm = Double.parseDouble(strCM);
        double meter = cm / 100;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(meter));
    }

}


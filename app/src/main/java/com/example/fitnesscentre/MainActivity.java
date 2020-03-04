package com.example.fitnesscentre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mainName;
    EditText mainAge;
    EditText mainGender;
    Button mainOption;
    String gender;
    double bodyFat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainOption = (Button)findViewById(R.id.btn_optin);

    }

    public void calculateBmi(View v){

        ImageView imageView =(ImageView)findViewById(R.id.imageView2);
        Button btn_BMI20 = (Button)findViewById(R.id.btn_bmi20);
        Button mainBmi = (Button)findViewById(R.id.btn_bmi);
        Button mainBmi_20 = (Button)findViewById(R.id.btn_bmi20);
        EditText mainHeight = (EditText)findViewById(R.id.tex_height);
        EditText mainDecimal = (EditText)findViewById(R.id.tex_dicimal);
        EditText mainWeight = (EditText)findViewById(R.id.tax_weight);
        EditText mainCategory = (EditText)findViewById(R.id.getCategory);
        EditText mainRisk = (EditText)findViewById(R.id.editText20);
        mainName = (EditText)findViewById(R.id.getName);
        mainAge = (EditText)findViewById(R.id.getAge);
        mainGender = (EditText)findViewById(R.id.getGander);
        int h = 12*(Integer.parseInt(mainHeight.getText().toString()));
        double d  = Double.parseDouble(mainDecimal.getText().toString());
        double w = Double.parseDouble(mainWeight.getText().toString());
        double height = h+d;
        double inche = Math.pow(height,2);
        Toast.makeText(this,String.valueOf(inche),Toast.LENGTH_LONG).show();
        Double bmi = (w/inche)*703;
        String text = String.valueOf(bmi);
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();

        if(mainGender.getText().toString().equals("Male")){

            if(bmi > 27.5) {
                imageView.setImageResource(R.drawable.mimg6);
               btn_BMI20.setBackgroundResource(R.drawable.redddd_bmi20);
                mainCategory.setText("Morbid obesity");
                mainRisk.setText("High risk of developing heart disease,high blood pressure,diabetes");
            }
            if(bmi > 23 & bmi <27.4){
                imageView.setImageResource(R.drawable.mimg5);
                mainCategory.setText("obesity");
                mainRisk.setText("Moderate risk of developing heart disease,high blood pressure,Stroke,diabetes");
            }
            if(bmi > 18.5 & bmi <22.9){
                imageView.setImageResource(R.drawable.mimg4);
                mainCategory.setText("Highest Normal");
                mainRisk.setText("Low Risk(health range)");
            }
            if(bmi < 18.4){
                btn_BMI20.setBackgroundResource(R.drawable.orang_bmi20);
                imageView.setImageResource(R.drawable.mimg1);
                mainCategory.setText("Anorexia");
                mainRisk.setText("Risk of developing problems such as untritional deficieney and osteoproosis");
            }

        }

         if(mainGender.getText().toString().equals("Female")){


            if(bmi > 27.5) {
                imageView.setImageResource(R.drawable.img6);
                btn_BMI20.setBackgroundResource(R.drawable.redddd_bmi20);
                mainCategory.setText("Morbid obesity");
                mainRisk.setText("High risk of developing heart disease,high blood pressure,diabetes");
            }
            if(bmi > 23 & bmi <27.4){
                imageView.setImageResource(R.drawable.img5);
                mainCategory.setText("obesity");
                mainRisk.setText("Moderate risk of developing heart disease,high blood pressure,Stroke,diabetes");
            }
            if(bmi > 18.5 & bmi <22.9){
                imageView.setImageResource(R.drawable.img4);
                mainCategory.setText("Highest Normal");
                mainRisk.setText("Low Risk(health range)");
            }
            if(bmi < 18.4){
                btn_BMI20.setBackgroundResource(R.drawable.orang_bmi20);
                imageView.setImageResource(R.drawable.img1);
                mainCategory.setText("Anorexia");
                mainRisk.setText("Risk of developing problems such as untritional deficieney and osteoproosis");
            }

        }
    }
    public void calculateBodyFat(View v ){
        Button mainBmi = (Button)findViewById(R.id.btn_bmi);
        Button mainBmi_20 = (Button)findViewById(R.id.btn_bmi20);
        EditText mainHeight = (EditText)findViewById(R.id.tex_height);
        EditText mainDecimal = (EditText)findViewById(R.id.tex_dicimal);
        EditText mainWeight = (EditText)findViewById(R.id.tax_weight);
        EditText mainCategory = (EditText)findViewById(R.id.getCategory);
        EditText mainRisk = (EditText)findViewById(R.id.editText20);
        mainName = (EditText)findViewById(R.id.getName);
        mainAge = (EditText)findViewById(R.id.getAge);
        int age = Integer.parseInt(mainAge.getText().toString());
        mainGender = (EditText)findViewById(R.id.getGander);
        int h = 12*(Integer.parseInt(mainHeight.getText().toString()));
        double d  = Double.parseDouble(mainDecimal.getText().toString());
        double w = Double.parseDouble(mainWeight.getText().toString());
        double height = h+d;
        double inche = Math.pow(height,2);
        Toast.makeText(this,String.valueOf(inche),Toast.LENGTH_LONG).show();
        Double bmi = (w/inche)*703;
        String text = String.valueOf(bmi);


        if(mainGender.getText().toString().equals("Male")){
           bodyFat = (1.2 * bmi)+(.23 *age)-(10.8*0)-5.4;

        }

        if(mainGender.getText().toString().equals("Female")){
             bodyFat = (1.2 * bmi)+(.23 *age)-(10.8*1)-5.4;
        }
        String str = String.valueOf(bodyFat);

         Toast.makeText(this,str,Toast.LENGTH_LONG).show();


    }

    public void customAlert(View V){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // Get the layout inflater
        final LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_template, null);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        alertDialogBuilder.setView(view);
             mainName = (EditText)findViewById(R.id.getName);
             mainAge = (EditText)findViewById(R.id.getAge);
             mainGender = (EditText)findViewById(R.id.getGander);

        //get elements from the dialog view
        final EditText passName = (EditText)view.findViewById(R.id.etFname);
        final EditText passAge = (EditText)view.findViewById(R.id.etFage);
        final RadioGroup passradioGroup = (RadioGroup)view.findViewById(R.id.groupradio);
        final RadioButton passMale = (RadioButton)view.findViewById(R.id.radiomale);
        final RadioButton passFemale = (RadioButton)view.findViewById(R.id.radiofemale);
        final Button passEnter = (Button)view.findViewById(R.id.btn_enter);
        final Button passCancel = (Button)view.findViewById(R.id.btn_cancel);

        //3. Set positive buton
        passEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(passMale.isChecked()){
                    gender = "Male";
                }else if (passFemale.isChecked()){
                    gender = "Female";
                }
                String msg = "";
                msg += "Name: " +passName.getText() + "\n";
                msg += "Age: " + passAge.getText() + "\n";
                msg +="Gander: " + gender +"\n";

                mainName.setText(passName.getText());
                mainAge.setText(passAge.getText());
                mainGender.setText(gender);
                Toast.makeText(getApplicationContext(),"Your login info: \n" + msg,Toast.LENGTH_LONG).show();
            }
        });

        passCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissDialog();
            }
        });




        //4. Set negative buton


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    public void reset(View v){
        ImageView imageView =(ImageView)findViewById(R.id.imageView2);
        Button btn_BMI20 = (Button)findViewById(R.id.btn_bmi20);
        Button mainBmi = (Button)findViewById(R.id.btn_bmi);
        Button mainBmi_20 = (Button)findViewById(R.id.btn_bmi20);
        EditText mainHeight = (EditText)findViewById(R.id.tex_height);
        EditText mainDecimal = (EditText)findViewById(R.id.tex_dicimal);
        EditText mainWeight = (EditText)findViewById(R.id.tax_weight);
        EditText mainCategory = (EditText)findViewById(R.id.getCategory);
        EditText mainRisk = (EditText)findViewById(R.id.editText20);
        mainName = (EditText)findViewById(R.id.getName);
        mainAge = (EditText)findViewById(R.id.getAge);
        mainGender = (EditText)findViewById(R.id.getGander);

        imageView.setImageResource(R.drawable.android);
        btn_BMI20.setBackgroundResource(R.drawable.green_bmi20);
        mainHeight.setText("");
        mainDecimal.setText("");
        mainWeight.setText("");
        mainName.setText("");
        mainAge.setText("");
        mainGender.setText("");
        mainCategory.setText("");
        mainRisk.setText("");

    }
    public void close(View v ){
        finish();
    }


}

package com.ml.ot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editTextCompany;
    Button buttonAddJob;
    Spinner spinnerType;

    DatabaseReference databaseJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseJobs = FirebaseDatabase.getInstance().getReference("jobs");

        editTextCompany = (EditText) findViewById(R.id.editTextCompany);
        buttonAddJob = (Button) findViewById(R.id.buttonAddJob);
        spinnerType = (Spinner) findViewById(R.id.spinnerType);

        buttonAddJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addJob();
            }
        });
    }
        private void addJob(){
            String company = editTextCompany.getText().toString().trim();
            String type = spinnerType.getSelectedItem().toString();

            if(TextUtils.isEmpty(company)){
                Toast.makeText(this, "Please enter the company name",Toast.LENGTH_LONG).show();


            }else{

                String id = databaseJobs.push().getKey();

                Job job = new Job(id, company, type);

                databaseJobs.child(id).setValue(job);

                Toast.makeText(this, "Job Added", Toast.LENGTH_LONG).show();



            }
    }


}

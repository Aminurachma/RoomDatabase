package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.roomdatabase.models.Register;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class HomeActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private Button btDatePicker;
    public static final String Key_Register = "Key_Register";
    EditText editTextNama, editTextTanggalLahir, editTextAlamat;
    RadioButton radioButtonJK;
    RadioGroup rgJk;
   // private Button btPlacesAPI;
    //private TextView tvPlaceAPI;
    // konstanta untuk mendeteksi hasil balikan dari place picker
    //private int PLACE_PICKER_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tvDateResult = (TextView) findViewById(R.id.tv_dateresult);
        btDatePicker = (Button) findViewById(R.id.bt_datepicker);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });
        editTextNama = findViewById(R.id.edt_txt_nama);
        editTextTanggalLahir = findViewById(R.id.edt_tanggal_lahir);
        editTextAlamat = findViewById(R.id.edt_alamat);

        rgJk = findViewById(R.id.rg_jenis_kelamin);
   //     tvPlaceAPI = (TextView) findViewById(R.id.tv_place_id);
/*
        btPlacesAPI = (Button)findViewById(R.id.bt_ppicker);
        btPlacesAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // membuat Intent untuk Place Picker
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    //menjalankan place picker
                    startActivityForResult(builder.build(HomeActivity.this), PLACE_PICKER_REQUEST);

                    // check apabila <a title="Solusi Tidak Bisa Download Google Play Services di Android" href="https://www.twoh.co/2014/11/solusi-tidak-bisa-download-google-play-services-di-android/" target="_blank">Google Play Services tidak terinstall</a> di HP
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });
*/
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // menangkap hasil balikan dari Place Picker, dan menampilkannya pada TextView
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format(
                        "Place: %s \n" +
                                "Alamat: %s \n" +
                                "Latlng %s \n", place.getName(), place.getAddress(), place.getLatLng().latitude + " " + place.getLatLng().longitude);
                tvPlaceAPI.setText(toastMsg);
            }
        }
    }*/

    private void showDateDialog() {

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                editTextTanggalLahir.setText("Tanggal dipilih : "+dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();

    }


    public void postSignUp(View view){
        String alamat = editTextAlamat.getText().toString();
        String nama = editTextNama.getText().toString();

        // String jk = radioButtonPr.isChecked() ? "Perempuan" : "Laki-Laki";

        int selectedJK = rgJk.getCheckedRadioButtonId();
        radioButtonJK = findViewById(selectedJK);
        String tgllahir = editTextTanggalLahir.getText().toString();
//        Log.d(TAG,"postSignUp: "+ password);
//        Log.d(TAG,"postSignUp: "+ username);
//        Log.d(TAG,"postSignUp: "+ nama);
//        Log.d(TAG,"postSignUp: "+ jk);
//        Log.d(TAG,"postSignUp: "+ tgllahir);
//        Intent intent = new Intent(Register.this,RegisterResult.class);
//        intent.putExtra(Key_Register,new String[]{nama,tgllahir,jk,username});
//        startActivity(intent);

        String jk = radioButtonJK.getText().toString();

        //       String tanggal_lahir = editTextTanggalLahir.getText().toString();

        //polinema.ac.id.dtschapter03_starter.models.Register register = new polinema.ac.id.dtschapter03_starter.models.Register(nama,tgllahir,jk,username,password);

        Register entitasBiodata = new Register(nama, tgllahir, jk, alamat);
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        intent.putExtra(Key_Register, entitasBiodata);
        startActivity(intent);

    }



}

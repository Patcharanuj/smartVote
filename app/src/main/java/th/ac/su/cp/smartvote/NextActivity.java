package th.ac.su.cp.smartvote;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Intent i = getIntent();

        Button button = (Button) findViewById(R.id.check_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text = (TextView) findViewById(R.id.result_textView);

                EditText number = (EditText) findViewById(R.id.editTextNumberSigned);
                String idNum = number.getText().toString();

                if(idNum.length()<13||idNum.length()>13){
                    text.setText("กรุณากรอกหมายเลขบัตรประชาชน 13 หลัก");
                }
                else if(idNum.length()==13){
                    text.setText("");
                    AlertDialog.Builder dialog = new AlertDialog.Builder(NextActivity.this);
                    if(idNum.equals("1111111111111")||idNum.equals("2222222222222")){
                        dialog.setMessage("คุณเป็นผู้มีสิทธิเลือกตั้ง");
                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                        dialog.show();                 }
                    else{
                        dialog.setMessage("คุณไม่มีสิทธิเลือกตั้ง");
                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                        dialog.show();
                    }

                }


            }
        });

    }
}
package vn.edu.ntu.hoaiphong.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import vn.edu.ntu.hoaiphong.util.MyDateDialog;
import vn.edu.ntu.hoaiphong.util.MyTimeDialog;

public class MainActivity extends AppCompatActivity implements MyDateDialog.OnMyDateChangedListener, MyTimeDialog.OnMyTimeChangedListener {

    EditText edtDate, edtTime;
    ImageView imvDate, imvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvent();
    }

    private void addView()
    {
        edtDate = findViewById(R.id.edtDate);
        edtDate.setEnabled(false);
        imvDate = findViewById(R.id.imvDate);
        edtTime = findViewById(R.id.edtTime);
        edtTime.setEnabled(false);
        imvTime = findViewById(R.id.imvTime);
    }
    private void addEvent()
    {
        imvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDateDialog myDateDialog = new MyDateDialog(Calendar.getInstance(), MainActivity.this, MainActivity.this);
                myDateDialog.showDateDialog();
            }
        });

        imvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTimeDialog myTimeDialog = new MyTimeDialog(Calendar.getInstance(), MainActivity.this, MainActivity.this);
                myTimeDialog.showTimeDialog();
            }
        });
    }

    @Override
    public void dateUpdate(Calendar newDate) {
        StringBuilder builder = new StringBuilder();
        builder.append(newDate.get(Calendar.DAY_OF_MONTH)).append("/")
                .append(newDate.get(newDate.MONTH) + 1)
                .append("/")
                .append(newDate.get(newDate.YEAR));
        edtDate.setText(builder.toString());
    }

    @Override
    public void timeUpdate(Calendar newTime) {
        StringBuilder builder = new StringBuilder();
        builder.append(newTime.get(Calendar.HOUR_OF_DAY)).append("h")
                .append(newTime.get(Calendar.MINUTE)).append("m");
        edtTime.setText(builder.toString());
    }
}

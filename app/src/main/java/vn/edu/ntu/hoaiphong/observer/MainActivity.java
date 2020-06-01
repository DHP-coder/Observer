package vn.edu.ntu.hoaiphong.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

import vn.edu.ntu.hoaiphong.util.MyDateDialog;

public class MainActivity extends AppCompatActivity implements MyDateDialog.OnMyDateChangedListener {

    EditText edtDate;
    ImageView imvDate;

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

}

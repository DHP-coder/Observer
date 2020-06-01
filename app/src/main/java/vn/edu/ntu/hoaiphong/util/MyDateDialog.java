package vn.edu.ntu.hoaiphong.util;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

public class MyDateDialog
{
    Calendar calendar;
    OnMyDateChangedListener onMyDateChangedListener;
    Context context;

    public MyDateDialog(Calendar calendar, OnMyDateChangedListener onMyDateChangedListener, Context context) {
        this.calendar = calendar;
        this.onMyDateChangedListener = onMyDateChangedListener;
        this.context = context;
    }

    //Public static dung de su dung qua ten
    public  void showDateDialog()
    {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //thiet lap ngay
                calendar.set(year, month, dayOfMonth);
                if(onMyDateChangedListener!=null)
                    onMyDateChangedListener.dateUpdate(calendar);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, listener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
    public static interface OnMyDateChangedListener
    {
        public void dateUpdate(Calendar newDate);
    }
}

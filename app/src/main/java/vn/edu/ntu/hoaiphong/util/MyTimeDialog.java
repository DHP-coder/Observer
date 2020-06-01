package vn.edu.ntu.hoaiphong.util;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyTimeDialog {
    Calendar calendar;
    OnMyTimeChangedListener onMyTimeChangedListener;
    Context context;

    public MyTimeDialog(Calendar calendar, MyTimeDialog.OnMyTimeChangedListener onMyTimeChangedListener, Context context) {
        this.calendar = calendar;
        this.onMyTimeChangedListener = onMyTimeChangedListener;
        this.context = context;
    }

    //Public static dung de su dung qua ten
    public  void showTimeDialog()
    {
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                calendar.set(hourOfDay, minute);
                if (onMyTimeChangedListener!=null)
                    onMyTimeChangedListener.timeUpdate(calendar);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, listener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }
    public static interface OnMyTimeChangedListener
    {
        public void timeUpdate(Calendar newTime);
    }
}

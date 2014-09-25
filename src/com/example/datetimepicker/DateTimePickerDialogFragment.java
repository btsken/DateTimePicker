package com.example.datetimepicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

/**
 * Datetimepicker dialog
 * @author Ken Huang
 *
 */
public class DateTimePickerDialogFragment extends DialogFragment {

    private Button okBtn;
    private DatePicker datePicker;
    private TimePicker timePicker;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (DateTimePickerDialogListener) getTargetFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_datetime_picker, container, false);
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        datePicker = (DatePicker) v.findViewById(R.id.datePicker1);
        timePicker = (TimePicker) v.findViewById(R.id.timePicker1);
        okBtn = (Button) v.findViewById(R.id.okBtn);

        okBtn.setOnClickListener(okBtnListener);

        datePicker.updateDate(year, month, day);
        timePicker.setCurrentHour(hour);
        timePicker.setCurrentMinute(minute);
        return v;
    }

    private OnClickListener okBtnListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            GregorianCalendar dateTime = new GregorianCalendar(
                    datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
                    timePicker.getCurrentHour(), timePicker.getCurrentMinute());

            mListener.onDateTimePicked(dateTime);

            DateTimePickerDialogFragment.this.dismiss();
        }
    };

    private DateTimePickerDialogListener mListener;

    public interface DateTimePickerDialogListener {
        public void onDateTimePicked(GregorianCalendar c);
    }
}

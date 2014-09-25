package com.example.datetimepicker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class DateTimePicker {

	public static class TimePickerFragment extends DialogFragment
			implements TimePickerDialog.OnTimeSetListener {

		private TimePickerDialogListener mListener;

		public interface TimePickerDialogListener {
			public void onTimePicked(String time);
		}

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current time as the default values for the picker
			final Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);

			// Create a new instance of TimePickerDialog and return it
			return new TimePickerDialog(getActivity(), this, hour, minute,
					DateFormat.is24HourFormat(getActivity()));
		}

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			mListener.onTimePicked(hourOfDay + ":" + minute);
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			try {
				mListener = (TimePickerDialogListener) getTargetFragment();
			} catch (ClassCastException e) {
				throw new ClassCastException(activity.toString()
						+ " must implement NoticeDialogListener");
			}
		}
	}

	public static class DatePickerFragment extends DialogFragment
			implements DatePickerDialog.OnDateSetListener {

		private DatePickerDialogListener mListener;

		public interface DatePickerDialogListener {
			public void onDatePicked(Calendar c);
		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
		}

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		public void onDateSet(DatePicker view, int year, int month, int day) {
			Calendar c = Calendar.getInstance();
			c.set(year, month, day);
			mListener.onDatePicked(c);
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			try {
				mListener = (DatePickerDialogListener) getTargetFragment();
			} catch (ClassCastException e) {
				throw new ClassCastException(activity.toString()
						+ " must implement NoticeDialogListener");
			}
		}
	}

}

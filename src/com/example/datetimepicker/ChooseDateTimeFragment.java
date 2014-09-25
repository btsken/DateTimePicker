package com.example.datetimepicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.datetimepicker.DateTimePicker.DatePickerFragment.DatePickerDialogListener;
import com.example.datetimepicker.DateTimePicker.TimePickerFragment.TimePickerDialogListener;
import com.example.datetimepicker.DateTimePickerDialogFragment.DateTimePickerDialogListener;

/**
 * Fragment for show how to use datetimepicker dialog
 * @author Ken Huang
 *
 */
public class ChooseDateTimeFragment extends Fragment implements
		DatePickerDialogListener, TimePickerDialogListener, DateTimePickerDialogListener {

	private TextView dateTv, timeTv, dateTimeTv;
	private Button dateBtn, timeBtn, dateTimeBtn;
	private ChooseDateTimeFragment context;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.fragment_datetime, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		context = this;
		findViews();
		setViews();
	}

	private void findViews() {
		dateTv = (TextView) getView().findViewById(R.id.textView1);
		timeTv = (TextView) getView().findViewById(R.id.textView2);
		dateTimeTv = (TextView) getView().findViewById(R.id.textView3);
		dateBtn = (Button) getView().findViewById(R.id.button1);
		timeBtn = (Button) getView().findViewById(R.id.button2);
		dateTimeBtn = (Button) getView().findViewById(R.id.button3);
	}

	private void setViews() {
		dateBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DialogFragment datePicker = new DateTimePicker.DatePickerFragment();
				datePicker.setTargetFragment(context, 0);
				datePicker.show(getFragmentManager(), "datePicker");
			}
		});

		timeBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DialogFragment timePicker = new DateTimePicker.TimePickerFragment();
				timePicker.setTargetFragment(context, 0);
				timePicker.show(getFragmentManager(), "timePicker");
			}
		});
		
		dateTimeBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DateTimePickerDialogFragment dateTimePicker = new DateTimePickerDialogFragment();
				dateTimePicker.setTargetFragment(context, 0);
				dateTimePicker.show(getFragmentManager(), "dateTimePicker");
			}
		});
	}

	@Override
	public void onDatePicked(Calendar c) {
		String strdate = null;

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.TAIWAN);

		if (c != null) {
			strdate = sdf.format(c.getTime());
			Log.e("onDatePicked", strdate);
		}
		Log.e("onDatePicked", strdate);
		dateTv.setText(strdate);
	}

	@Override
	public void onTimePicked(String time) {
		timeTv.setText(time);
	}

	@Override
	public void onDateTimePicked(GregorianCalendar c) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.TAIWAN);
		dateTimeTv.setText(sdf.format(c.getTime()));
	}
}

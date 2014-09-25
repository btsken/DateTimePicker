DateTimePicker
==============

A datepicker, timepicker and datetimepicker app. Using DialogFragment and Comunicating with fragment.

Usage
------

implements DatePickerDialogListener, TimePickerDialogListener, DateTimePickerDialogListener(up to what you want)

To start picker dialogFragment

```java
 DialogFragment datePicker = new DateTimePicker.DatePickerFragment();
 datePicker.setTargetFragment(context, 0);
 datePicker.show(getFragmentManager(), "datePicker");
```

Then recive in onDatePicked, onTimePicked or onDateTimePicked


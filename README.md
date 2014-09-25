DateTimePicker
==============

A datepicker, timepicker and datetimepicker app. 

Using DialogFragment and Comunicating with fragment.

Usage
------

First, you should include appcompat_v7 library.

Implements DatePickerDialogListener, TimePickerDialogListener, DateTimePickerDialogListener(up to what you want) in your Fragment

To start picker dialogFragment

```java
 DialogFragment datePicker = new DateTimePicker.DatePickerFragment();
 datePicker.setTargetFragment(context, 0);
 datePicker.show(getFragmentManager(), "datePicker");
```

Then recive in onDatePicked, onTimePicked or onDateTimePicked


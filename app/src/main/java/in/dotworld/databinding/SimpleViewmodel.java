package in.dotworld.databinding;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Calendar;
import java.util.TimeZone;

import static in.dotworld.databinding.R.drawable.ic_launcher_background;

public class SimpleViewmodel extends ViewModel{

    private String name="santhosh";
    private String lastname="kumar";
    private int Imageid;
    private static int number=10;

    public String getName()
    {
        return name;
    }
    public String getLastname() {
        return lastname;
    }

    public int getImageid() {
        return Imageid;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setImageid(int imageid) {
        Imageid = imageid;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @BindingAdapter("android:greeting")
    public static void setMessage(TextView textView, String str) {
        textView.setText("Welcome "+str);
        textView.setAllCaps(true);
        textView.setTextColor(Color.parseColor("#008577"));
    }

    @BindingAdapter("android:paddingLeft")
    public static void padding(View view,int padding) {
        view.setPadding(padding,view.getPaddingTop(),view.getPaddingRight(),view.getPaddingBottom());
    }

    @BindingAdapter("app:ImageUrl")
    public static void icimagView(ImageView imageView,int Imageid) {
        imageView.setImageResource(R.drawable.ic_launcher_foreground);
    }

    @BindingAdapter("android:text")
    public static void setText(EditText editText, int number) {
        editText.setText(String.valueOf(number));

    }

    @InverseBindingAdapter(attribute = "android:text")
    public static int getdata(EditText editText)
    {
      String num=editText.getText().toString();
      try {
          int value =Integer.parseInt(num);
           Log.d("SimpleViewmodel", String.valueOf(value));
          return value;
      }catch (NumberFormatException e) {
          e.printStackTrace();
      }
      return number;
    }
}
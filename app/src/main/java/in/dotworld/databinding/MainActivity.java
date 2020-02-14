package in.dotworld.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import in.dotworld.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mbinding;
    SimpleViewmodel simpleViewmodel;
    static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           mbinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

       /*    mbinding.setName("firstname");
           mbinding.setLastName("World!");*/


           simpleViewmodel= new ViewModelProvider(this).get(SimpleViewmodel.class);

           Data data=new Data("prabha","jeeva");

           mbinding.setData(data);

           mbinding.setClick(new MainActivity());

           mbinding.setLifecycleOwner(this);
           mbinding.setViewmodel(simpleViewmodel);


           Handler handler=new Handler(this);
           mbinding.setHandler(handler);


          /*  ObservableArrayMap<String,Object> map=new ObservableArrayMap<>();
            map.put("firstname","santhosh");
            map.put("lastname","M");
            map.put("middlename","kumar");

            mbinding.setMap(map);*/

    }



    public void onbutton(View view) {
        count++;
        Toast.makeText(view.getContext(),String.valueOf(count),Toast.LENGTH_SHORT).show();
    }

    public boolean onLongClick(View view,String string) {
        Toast.makeText(view.getContext(),"Longclicked by "+string,Toast.LENGTH_LONG).show();
        return false;
    }

    public class Handler{
        private Context context;
        Handler(Context context)
        {
            this.context=context;
        }
        public void onClicking(View view) {

            Toast.makeText(context,"clicked handler class button",Toast.LENGTH_LONG).show();
        }
    }
}

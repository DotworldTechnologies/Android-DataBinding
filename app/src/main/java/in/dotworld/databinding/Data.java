package in.dotworld.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Data extends BaseObservable {

    private String firstName;
    private String lastName;

    public Data(String firstname,String lastname) {
        this.firstName=firstname;
        this.lastName=lastname;
    }

    public String getLastName() {
        return lastName;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }


    @Bindable
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

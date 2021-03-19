package nikolay.nikolov.mqtt.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
  // Binding the data
  public MutableLiveData<String>temp_f = new MutableLiveData<>();
  public MutableLiveData<String> getTemp_f() {
    if (temp_f == null) {
      temp_f = new MutableLiveData<>();
    }
    return temp_f;
  }



  public MutableLiveData<String>temp_c = new MutableLiveData<>();
  public MutableLiveData<String>humid = new MutableLiveData<>();
  public MutableLiveData<String> led1_status = new MutableLiveData<>();
  public MutableLiveData<String> led2_status = new MutableLiveData<>();






}
package nikolay.nikolov.mqtt.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import nikolay.nikolov.mqtt.R;
import nikolay.nikolov.mqtt.databinding.MainFragmentBinding;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MainFragment extends Fragment {

  public MainFragmentBinding binding;

  public TextView tempFView;
  private static final String SERVERURL = "tcp://10.0.0.198:1883";
  private MqttAndroidClient client;

  public static MainFragment newInstance() {
    return new MainFragment();
  }

  @Nullable
  @Override

  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = DataBindingUtil.inflate(inflater,R.layout.main_fragment, container, false);
    binding.setLifecycleOwner(this);

    return binding.getRoot();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    MainViewModel mViewModel;
    mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    final Observer<String> temp_fObserverObserver = new Observer<String>() {

      /**
       * Called when the data is changed.
       *
       * @param newTempF The new data
       */
      @Override
      public void onChanged(@Nullable final String newTempF) {
        // Update the UI, in this case, a TextView.
        tempFView.setText(newTempF);

      }
    };

    mViewModel.getTemp_f().observe(getViewLifecycleOwner(), temp_fObserverObserver);
    try {
      startServer();
    } catch (MqttException e) {
      e.printStackTrace();
    }

  }

  public void startServer() throws MqttException {
    String clientId = MqttClient.generateClientId();
    Context context = null;
    client = new MqttAndroidClient(null,SERVERURL,clientId );
     MqttConnectOptions options = new MqttConnectOptions();
      options.setCleanSession(true);
     options.setUserName("pi");
      String password = "Let-niko-in-1987";
    char [] pass = password.toCharArray();
    options.setPassword(pass);
    options.setAutomaticReconnect(true);
//    String [] uri = new String[1];
//    uri[0] = SERVERURL;
//    options.setServerURIs(uri);
      //client.connect();
     // client.subscribe("TEMP_F", 0);

  }


}
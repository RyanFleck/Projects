package com.rcf.bluetoothexperiment;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rcf.bluetoothexperiment.ui.home.HomeFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements Runnable {

    private BluetoothAdapter ba;
    private InputStream input;
    private Thread thread;
    private TextView tv;
    private String heartrate;
    private HomeFragment hf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        attemptBluetoothConnection();

        List<Fragment> x = getSupportFragmentManager().getFragments();

        for (Fragment y : x) {
            System.out.println("\nFragment found: " + x.toString());
        }

        System.out.println("Total fragments: " + x.size());

        /*
        hf = (HomeFragment)getSupportFragmentManager().findFragmentByTag("fragment_home");
        hf.setHeartRate("40");
        */

         // Currently I cannot update the text in the home fragment from the main activity. Blergh.git

        // hf.setHeartRate("Test");


    }

    private void attemptBluetoothConnection() {
        try {
            ba = BluetoothAdapter.getDefaultAdapter();
        } catch (Exception e) {
            Toast.makeText(this, "Exception! Could not connect to adapter.", Toast.LENGTH_LONG).show();
        }

        if (ba == null) {
            Toast.makeText(this, "Please enable Bluetooth and restart the application.", Toast.LENGTH_LONG).show();
            //finish();
        }
    }

    public void connectToHXM(View view) {
        if (ba == null) {
            Toast.makeText(this, "Please enable Bluetooth and restart the application.", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            Set<BluetoothDevice> devices = ba.getBondedDevices();

            for (BluetoothDevice device : devices) {
                if (device.getName().startsWith("NXM")) {

                    // connect to the NXM Heartbeat monitor.
                    BluetoothSocket socket = device.createRfcommSocketToServiceRecord(device.getUuids()[0].getUuid());
                    socket.connect();
                    input = socket.getInputStream();

                    // Heartbeat monitor processing will start in a new thread.
                    thread = new Thread(this);
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Exception! Could not connect to adapter.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void run() {
        while (input != null) {
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            try {
                byte[] data = new byte[200];
                int length = input.read(data);

                // Check for correct HXM data format.
                if (data[0] == 2 && data[1] == 0x26) {
                    heartrate = String.valueOf(data[12]);
                }
            } catch (Exception e) {
            }
        }
    }
}

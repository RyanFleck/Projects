package com.rcf.bluetoothexperiment;

import java.util.concurrent.TimeUnit;

public class BluetoothMonitor implements Runnable {

    @Override
    public void run() {
        while(true){
            System.out.println("Running...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("Interrupted.");
            }
        }
    }
}

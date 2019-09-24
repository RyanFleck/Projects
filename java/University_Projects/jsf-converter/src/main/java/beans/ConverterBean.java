package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.event.ValueChangeEvent;

@Named(value = "converterBean")
@SessionScoped
public class ConverterBean implements Serializable {
    
    private double celsius;
    private double fahrenheit;
    private boolean celsiusChanged;
    private boolean fahrenheitChanged;

    /**
     * Creates a new instance of ConverterBean
     */
    public ConverterBean() {
    }

    /**
     * @return the celsius
     */
    public double getCelsius() {
        return celsius;
    }

    /**
     * @param celsius the celsius to set
     */
    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    /**
     * @return the fahrenheit
     */
    public double getFahrenheit() {
        return fahrenheit;
    }

    /**
     * @param fahrenheit the fahrenheit to set
     */
    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public void celsiusChanged(ValueChangeEvent e) {
        celsiusChanged = true;
        fahrenheitChanged = false;
    }

    public void fahrenheitChanged(ValueChangeEvent e) {
        fahrenheitChanged = true;
        celsiusChanged = false;
    }

    public String convert() {
        if (celsiusChanged) {
            // celsius to fahrenheit conversion
            fahrenheit = ((celsius * 9) / 5 + 32);
        } else if (fahrenheitChanged) {
            // fahrenheit to celsius conversion
            celsius = ((fahrenheit - 32) * 5) / 9;
        }
        return null;
    }
}

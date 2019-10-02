/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author ssome
 */
@FacesValidator("dateValidator")
public class DateValidator implements Validator {

    /**
     *
     * @param context
     * @param component
     * @param value
     */
    @Override
    public void validate(FacesContext context,
            UIComponent component,
            Object value) throws ValidatorException {
        String sdate = (String) value;
        try {
            Date vdate = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(sdate);
        } catch (ParseException ex) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Date is not valid.");
            message.setDetail("Date is not valid. Try yyyy-mm-dd format.");
            context.addMessage("", message);
            throw new ValidatorException(message);
        }
    }

}

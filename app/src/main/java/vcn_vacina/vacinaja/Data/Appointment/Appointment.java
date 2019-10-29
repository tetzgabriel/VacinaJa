package vcn_vacina.vacinaja.Data.Appointment;

import java.util.List;

public class Appointment {

    String data;
    String local;
    String vaccines;


    public Appointment(String data, String local, String vaccines) {
        this.data = data;
        this.local = local;
        this.vaccines = vaccines;
    }
}

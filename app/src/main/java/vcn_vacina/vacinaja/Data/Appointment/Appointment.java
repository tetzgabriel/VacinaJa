package vcn_vacina.vacinaja.Data.Appointment;

import java.util.List;

public class Appointment {

    String data;
    String horarios;
    String local;
    String vaccines;
    String status;


    public Appointment(String data, String horario, String local, String vaccines) {
        this.data = data;
        this.local = local;
        this.vaccines = vaccines;
        this.horarios = horario;
        this.status = "Efetuada";
    }

    public String getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public String getVaccines() {
        return vaccines;
    }

    public String getStatus() {
        return status;
    }

    public String getHorarios() {
        return horarios;
    }
}

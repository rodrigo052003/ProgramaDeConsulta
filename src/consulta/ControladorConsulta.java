package consulta;

import java.util.ArrayList;
import java.util.List;

public class ControladorConsulta {
    private static ControladorConsulta instance;
    private List<ConsultaInfo> consultas;

    private ControladorConsulta() {
        consultas = new ArrayList<>();
    }

    public static ControladorConsulta getInstance() {
        if (instance == null) {
            instance = new ControladorConsulta();
        }
        return instance;
    }

    public void agendarConsulta(ConsultaInfo consulta) {
        consultas.add(consulta);
    }

    public List<ConsultaInfo> getConsultas() {
        return consultas;
    }
}

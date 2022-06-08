package cristianhsv;

import java.util.ArrayList;
import java.sql.*;

public class DAOConsulta extends Conexao {

    public ArrayList listar() {
        try {
            ResultSet result = this.getResultSet("select consulta.id, concat(medico.id, \" - \", medico.nome) as medico, concat(paciente.id, \" - \", paciente.nome) as paciente, convenio from consulta "
                    + " left join paciente on paciente.id = consulta.idpaciente "
                    + " left join medico on medico.id = consulta.idmedico order by convenio");

            ArrayList list = new ArrayList();
            while (result.next()) {
                ConsultaDaTabela consulta = new ConsultaDaTabela();

                consulta.setId(result.getInt("id"));
                consulta.setMedico(result.getString("medico"));
                consulta.setPaciente(result.getString("paciente"));
                consulta.setConvenio(result.getString("convenio"));

                list.add(consulta);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String atualizar(Consulta consulta) {
        try {
            return this.atualizarBanco("update consulta set idmedico = " + Integer.toString(consulta.getIdMedico())
                    + " , idpaciente = " + Integer.toString(consulta.getIdPaciente())
                    + " , convenio = '" + consulta.getConvenio()
                    + "' where id = " + Integer.toString(consulta.getId()));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String cadastrar(Consulta consulta) {
        try {
            return this.atualizarBanco("insert into consulta(idmedico, idpaciente, convenio) values ("
                    + Integer.toString(consulta.getIdMedico()) + ", "
                    + Integer.toString(consulta.getIdPaciente()) + ", '"
                    + consulta.getConvenio() + "')");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String excluir(int id) {
        try {
            return this.atualizarBanco("delete from consulta where id = " + Integer.toString(id));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

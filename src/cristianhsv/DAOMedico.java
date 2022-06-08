package cristianhsv;

import java.util.ArrayList;
import java.sql.*;

public class DAOMedico extends Conexao {

    public String cadastrar(Medico medico) {
        try {
            return this.atualizarBanco("insert into medico(nome, especialidade, crm, cpf) values ('"
                    + medico.getNome() + "', "
                    + Integer.toString(medico.getEspecialidade()) + ", "
                    + Integer.toString(medico.getCrm()) + ", '"
                    + medico.getCpf() + "')");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String atualizar(Medico medico) {
        try {
            return this.atualizarBanco("update medico set nome = '" + medico.getNome()
                    + "' , especialidade = " + Integer.toString(medico.getEspecialidade())
                    + " , crm = " + Integer.toString(medico.getCrm())
                    + " , cpf = '" + medico.getCpf()
                    + "' where id = " + Integer.toString(medico.getId()));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String excluir(int id) {
        try {
            return this.atualizarBanco("delete from medico where id = " + Integer.toString(id));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ArrayList listar() {
        try {
            ResultSet result = this.getResultSet("select * from medico order by nome");
            ArrayList list = new ArrayList();
            while (result.next()) {
                Medico med = new Medico();
                med.setId(result.getInt("id"));
                med.setNome(result.getString("nome"));
                med.setEspecialidade(result.getInt("especialidade"));
                med.setCrm(result.getInt("crm"));
                med.setCpf(result.getString("cpf"));
                list.add(med);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}

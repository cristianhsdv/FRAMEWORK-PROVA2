package cristianhsv;

import java.sql.*;
import java.util.*;

public class DAOPaciente extends Conexao {



    public String cadastrar(Paciente pac) {
        try {
            return this.atualizarBanco("insert into paciente(nome, cpf, idade) values ('"
                    + pac.getNome() + "', '"
                    + pac.getCpf() + "', "
                    + Integer.toString(pac.getIdade()) + ")");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String atualizar(Paciente pac) {
        try {
            return this.atualizarBanco("update paciente set nome = '" + pac.getNome()
                    + "' , cpf = '" + pac.getCpf()
                    + "' , idade = " + Integer.toString(pac.getIdade())
                    + " where id = " + Integer.toString(pac.getId()));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
        public ArrayList listar() {
        try {
            ResultSet resultado = this.getResultSet("select * from paciente order by nome");

            ArrayList array = new ArrayList();

            while (resultado.next()) {
                Paciente pac = new Paciente();

                pac.setId(resultado.getInt("id"));
                pac.setNome(resultado.getString("nome"));
                pac.setCpf(resultado.getString("cpf"));
                pac.setIdade(resultado.getInt("idade"));

                array.add(pac);
            }

            return array;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String excluir(int id) {
        try {
            return this.atualizarBanco("delete from paciente where id = " + Integer.toString(id));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

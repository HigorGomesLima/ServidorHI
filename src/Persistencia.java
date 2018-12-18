
import PastaImoveis.Apartamento;
import PastaImoveis.Casa;
import PastaImoveis.Chacara;
import PastaImoveis.Imovel;
import PastaImoveis.Situacao;
import PastaImoveis.Terreno;
import PastaPessoa.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import outros.Corretor;

public class Persistencia {

    private Connection con;
    
    public Persistencia() {
        try {
            con = DriverManager.getConnection("jdbc:sqlite:imobiliaria.db");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private ResultSet getRS(String query) {
        ResultSet rs = null;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
    public Imovel getImovel(String codigo) {
        Imovel retorno = null;
        try {
            ResultSet rs = getRS("SELECT * FROM imovel WHERE CODIGO = '" + codigo + "'");
            retorno = new Imovel();
            retorno.setCodigo(codigo);
            retorno.setEndereco(rs.getString("ENDERECO"));
            retorno.setBairro(rs.getString("BAIRRO"));
            retorno.setCidade(rs.getString("CIDADE"));
            retorno.setCep(rs.getString("CEP"));
            retorno.setAreaTotal((float) rs.getDouble("AREATOTAL"));
            retorno.setValor(rs.getDouble("VALOR"));
            retorno.setTipo(rs.getString("TIPO"));
            String sit = (rs.getString("SITUACAO"));
            switch (sit) {
                case "SOB_VENDA":
                    retorno.setSituacaoatual(Situacao.SOB_VENDA);
                    break;
                case "SOB_ALUGUEL":
                    retorno.setSituacaoatual(Situacao.SOB_ALUGUEL);
                    break;
                case "SOB_VENDA_ALUGUEL":
                    retorno.setSituacaoatual(Situacao.SOB_VENDA_ALUGUEL);
                    break;
                case "ALUGADO":
                    retorno.setSituacaoatual(Situacao.ALUGADO);
                    break;
                case "VENDIDO":
                    retorno.setSituacaoatual(Situacao.VENDIDO);
                    break;
            }
            String cDono = rs.getString("DONO");
            retorno.setDono(this.getPessoaCodigo(codigo));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    
    public Imovel getImovel(String endereco, String cep) {
        Imovel retorno = null;
        try {
            ResultSet rs = getRS("SELECT * FROM imovel WHERE ENDERECO = '" + endereco + "' AND WHERE CEP = '" + cep + "'");
            retorno = new Imovel();
            retorno.setCodigo(rs.getString("CODIGO"));
            retorno.setEndereco(rs.getString("ENDERECO"));
            retorno.setBairro(rs.getString("BAIRRO"));
            retorno.setCidade(rs.getString("CIDADE"));
            retorno.setCep(rs.getString("CEP"));
            retorno.setAreaTotal((float) rs.getDouble("AREATOTAL"));
            retorno.setValor(rs.getDouble("VALOR"));
            retorno.setTipo(rs.getString("TIPO"));
            String sit = (rs.getString("SITUACAO"));
            switch (sit) {
                case "SOB_VENDA":
                    retorno.setSituacaoatual(Situacao.SOB_VENDA);
                    break;
                case "SOB_ALUGUEL":
                    retorno.setSituacaoatual(Situacao.SOB_ALUGUEL);
                    break;
                case "SOB_VENDA_ALUGUEL":
                    retorno.setSituacaoatual(Situacao.SOB_VENDA_ALUGUEL);
                    break;
                case "ALUGADO":
                    retorno.setSituacaoatual(Situacao.ALUGADO);
                    break;
                case "VENDIDO":
                    retorno.setSituacaoatual(Situacao.VENDIDO);
                    break;
            }
            String cDono = rs.getString("DONO");
            retorno.setDono(this.getPessoaCodigo(cDono));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    
    public Corretor getCorretor(String cpf) {
        Corretor retorno = null;
        try {
            ResultSet rs = getRS("SELECT * FROM imovel WHERE CODIGO = '" + cpf + "'");
            retorno = new Corretor();
            retorno.setCpf(cpf);
            retorno.setEndereco(rs.getString("ENDERECO"));
            retorno.setBairro(rs.getString("BAIRRO"));
            retorno.setCep(rs.getString("CEP"));
            retorno.setTipo(rs.getString("TIPO"));
            retorno.setSenha(rs.getString("SENHA"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    
    public void setPessoa(Pessoa novo) {        
        try {
            if (novo.getCodigo() == null) {
                String cliente = "'" + novo.getNome() + "','" + novo.getEndereco() + "','"
                        + novo.getNumero() + "','" + novo.getBairro() + "','" + novo.getCidade()
                        + "','" + novo.getEstado() + "','" + novo.getEmail() + "','"
                        + novo.getTipo() + "'";
                String update = "INSERT INTO pessoa(NOME,ENDERECO,NUMERO,BAIRRO,CIDADE,ESTADO,EMAIL,TIPO) VALUES(" + cliente + ")";
                System.out.println(update);
                Statement stmt = con.createStatement();
                stmt.executeUpdate(update);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Pessoa getPessoa(String nome) {        
        Pessoa retorno = null;
        try {
            ResultSet rs = getRS("SELECT * FROM pessoa WHERE NOME = '" + nome + "'");
            retorno = new Pessoa();
            retorno.setNome(nome);
            retorno.setCodigo(rs.getString("CODIGO"));
            retorno.setEndereco(rs.getString("ENDERECO"));
            retorno.setBairro(rs.getString("BAIRRO"));
            retorno.setCidade(rs.getString("CIDADE"));
            retorno.setTipo(rs.getString("TIPO"));
            retorno.setEstado(rs.getString("ESTADO"));
            retorno.setNumero(rs.getInt("NUMERO"));
            retorno.setEmail(rs.getString("EMAIL"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    
    public Pessoa getPessoaCodigo(String codigo) {        
        Pessoa retorno = null;
        try {
            ResultSet rs = getRS("SELECT * FROM pessoa WHERE CODIGO = '" + codigo + "'");
            retorno = new Pessoa();
            retorno.setNome(rs.getString("NOME"));
            retorno.setCodigo(rs.getString("CODIGO"));
            retorno.setEndereco(rs.getString("ENDERECO"));
            retorno.setBairro(rs.getString("BAIRRO"));
            retorno.setCidade(rs.getString("CIDADE"));
            retorno.setTipo(rs.getString("TIPO"));
            retorno.setEstado(rs.getString("ESTADO"));
            retorno.setNumero(rs.getInt("NUMERO"));
            retorno.setEmail(rs.getString("EMAIL"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    
    public void setPessoaFisica(String codigo, String cpf) {        
        try {
            if (codigo != null) {
                String update = "INSERT INTO pessoafisica(CODIGO,CPF) VALUES('" + codigo + "','" + cpf + "')";
                System.out.println(update);
                Statement stmt = con.createStatement();
                stmt.executeUpdate(update);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void setPessoaJuridica(String codigo, String cnpj) {        
        try {
            if (codigo != null) {
                String update = "INSERT INTO pessoafisica(CODIGO,CNPJ) VALUES('" + codigo + "','" + cnpj + "')";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(update);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void setImovel(Imovel novo) {        
        try {
            if (novo.getCodigo() == null) {
                String cliente = "'" + novo.getEndereco() + "','" + novo.getBairro() + "','" + novo.getCidade() + "','"
                        + novo.getCep() + "','" + novo.getAreaTotal() + "','" + novo.getValor() + "','"
                        + novo.getSituacaoatual() + "','" + novo.getDono().getCodigo() + "','" + novo.getTipo() + "'";
                String update = "INSERT INTO imovel(ENDERECO,BAIRRO,CIDADE,CEP,AREATOTAL,VALOR,SITUACAO,DONO,TIPO) VALUES(" + cliente + ")";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(update);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void setCasa(String codigo, Casa novo) {        
        try {
            if (codigo != null) {
                String cliente = "'" + codigo + "','" + novo.getAreaContruida() + "','" + novo.getNumeroQuartos() + "','" + novo.getNumeroVagasGaragem() + "','"
                        + novo.getAnoConstrucao() + "','" + novo.getNumeroAndares() + "'";
                String update = "INSERT INTO casa(CODIGO,AREA,QUANTIDADEDEQUARTOS,NUMEROVAGAS,ANO,ANDARES) VALUES(" + cliente + ")";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(update);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void setApartamento(String codigo, Apartamento novo) {        
        try {
            if (codigo != null) {
                String cliente = "'" + codigo + "','" + novo.getAndarApartamento() + "','" + novo.getNumeroApartamento() + "','"
                        + novo.getNomeEdificio() + "','" + novo.getQuantidadeQuartos() + "','" + novo.getNumeroVagasGaragem() + "','"
                        + novo.getAnoConstrucao() + "','" + novo.getValorCondominio() + novo.getTipoDeApartamento() + "'";
                String update = "INSERT INTO apartamento(CODIGO,ANDAR,NUMERO,EDIFICIO,QUANTIDADEDEQUARTOS,NUMEROVAGAS,"
                        + "ANO,VALORDOCONDOMINIO,TIPOAPARTAMENTO) VALUES(" + cliente + ")";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(update);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void setChacara(String codigo, Chacara novo) {        
        try {
            if (codigo != null) {
                String cliente = "'" + codigo + "','" + novo.getAreaConstruida() + "','" + novo.getNumeroQuartos() + "','"
                        + novo.getAnoConstrucao() + "','" + novo.getDistanciaCidade() + "'";
                String update = "INSERT INTO chacara(CODIGO,AREA,QUANTIDADEQUARTOS,ANO,DISTANCIACIDADE) VALUES(" + cliente + ")";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(update);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void setTerreno(String codigo, Terreno novo) {        
        try {
            if (codigo != null) {
                String cliente = "'" + codigo + "','" + novo.getDimensaoFrente() + "','" + novo.getDimensaoLado() + "'";
                String update = "INSERT INTO terreno(CODIGO,FRENTE,LADO) VALUES(" + cliente + ")";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(update);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        public void alterarImovel(String codigo, Terreno novo) {        
        try {
            if (codigo != null) {
                String update = "UPDATE imovel SET "+cliente+" WHERE codconsulta = '"+novo.getCodigo()+"'";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(update);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}


import PastaImoveis.Imovel;
import PastaImoveis.Situacao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Persistencia {
       private Connection con;
    
    public Persistencia(){
        try {
            con = DriverManager.getConnection("jdbc:sqlite:imobiliaria.db");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private ResultSet getRS(String query){
        ResultSet rs = null;
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
    public Imovel getImovel(String codigo){
        Imovel retorno = null;
        try{
            ResultSet rs = getRS("SELECT * FROM imovel WHERE CODIGO = '"+codigo+"'");
            retorno = new Imovel();
            retorno.setCodigo(codigo);
            retorno.setEndereco(rs.getString("ENDERECO"));
            retorno.setBairro(rs.getString("BAIRRO"));
            retorno.setCidade(rs.getString("CIDADE"));
            retorno.setCep(rs.getLong("CEP"));
            retorno.setAreaTotal((float) rs.getDouble("AREATOTAL"));
            retorno.setValor(rs.getDouble("VALOR"));
            String sit = (rs.getString("SITUACAO"));
            switch(sit){
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
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
}

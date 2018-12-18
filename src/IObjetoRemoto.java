
import PastaImoveis.Imovel;
import PastaPessoa.Pessoa;
import java.rmi.Remote;
import java.rmi.RemoteException; 

public interface IObjetoRemoto extends Remote{
    public String logar(String cpf,String senha) throws RemoteException;
    public void cadastrarPessoa(Pessoa novo) throws RemoteException;
    public void cadastrarImovel(Imovel novo) throws RemoteException;
}

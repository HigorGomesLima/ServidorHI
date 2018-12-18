
import PastaImoveis.Apartamento;
import PastaImoveis.Casa;
import PastaImoveis.Chacara;
import PastaImoveis.Imovel;
import PastaImoveis.Terreno;
import PastaPessoa.Pessoa;
import PastaPessoa.PessoaFisica;
import PastaPessoa.PessoaJuridica;
import java.rmi.RemoteException;
import outros.Corretor;

public class ObjetoRemoto implements IObjetoRemoto{
    
    private Persistencia db;

    public ObjetoRemoto(){
        db = new Persistencia();
    }
    
    @Override
    public String logar(String cpf, String senha) throws RemoteException{
        String r = "";
        Corretor c = db.getCorretor(cpf);
        if(senha.equals(c.getSenha())){
            r = c.getTipo();
        }
        return r;
    }

    @Override
    public void cadastrarPessoa(Pessoa novo) throws RemoteException{
        db.setPessoa(novo);
        String c = db.getPessoa(novo.getNome()).getCodigo();
        System.out.println(c);
        if("FISICA".equals(novo.getTipo())){
            System.out.println("fisica");
            PessoaFisica aux = (PessoaFisica)novo;
            System.out.println(aux.getCpf());
            db.setPessoaFisica(c, (aux.getCpf()+""));
        }else{
            PessoaJuridica aux = (PessoaJuridica)novo;
            db.setPessoaFisica(c, aux.getCnpj());
        }
    }

    @Override
    public void cadastrarImovel(Imovel novo) throws RemoteException{
        db.setImovel(novo);
        String c = db.getImovel(novo.getEndereco(),novo.getCep()).getCodigo();
        switch(novo.getTipo()){
            case "CASA":
                db.setCasa(c, (Casa) novo);
                break;
            case "APARTAMENTO":
                db.setApartamento(c, (Apartamento) novo);
                break;
            case "TERRENO":
                db.setTerreno(c, (Terreno) novo);
                break;
            case "CHACARA":
                db.setChacara(c, (Chacara) novo);
                break;
        }
    }
    
}

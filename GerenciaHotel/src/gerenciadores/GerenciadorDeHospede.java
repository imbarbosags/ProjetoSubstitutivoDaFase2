package gerenciadores;
import java.time.LocalDate;
import java.util.HashSet;

import entidades.Hospede;

public class GerenciadorDeHospede {
    private HashSet<Hospede> todosHospedes = new HashSet<>();

    public String cadastrarNovoHospede(String nome, String cpf, LocalDate dataNascimento, String endereco, String telefone) {
        if (getHospedeByCpf(cpf) != null)
            return "Ja existe um hospede cadastrado com esse CPF";
        Hospede novoHospede = new Hospede(nome, cpf, dataNascimento, endereco, telefone);
        todosHospedes.add(novoHospede);
        return "Novo hóspede cadastrado com sucesso!";
    }

    public Hospede getHospedeByCpf(String cpf) {
        Hospede hospede = null;
        for (Hospede h : todosHospedes) {
            if (h.getCpf().equals(cpf))
                return h;
        }
        return hospede;
    }

    public String removerHospede(String cpf){
        Hospede hospede = getHospedeByCpf(cpf);
        if(hospede == null) return "Nao há nenhum hospede cadastrado com esse CPF";
        todosHospedes.remove(hospede);
        return "Hospede removido com sucesso!";
    }

}

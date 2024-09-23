package entidades;

public class Funcionarios {
    private String nome;
    private String cpf;
    private String cargo;
    private double salario;
    private String turnoTrabalho;
    public String getNome() {
        return nome;
    }

    
    public Funcionarios(String nome, String cpf, String cargo, double salario, String turnoTrabalho) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salario = salario;
        this.turnoTrabalho = turnoTrabalho;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public String getTurnoTrabalho() {
        return turnoTrabalho;
    }
    public void setTurnoTrabalho(String turnoTrabalho) {
        this.turnoTrabalho = turnoTrabalho;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionarios other = (Funcionarios) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    
}

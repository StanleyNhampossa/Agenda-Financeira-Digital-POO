package model;

import java.util.Date;

/**
 *Classe modelo para definir um utilizador do sistema
 * @author Grácio Macuácua
 */
public final class Utilizador {
    
    private int id;
    private String nome = "";//
    private Date dataNascimento;
    private String genero = "";//
    private String profissao = "";//
    private String email = "";//
    private String senha = "";
    private String fotoPerfil = "src\\icones\\icons8_user_120px.png";//

    public Utilizador(String nome, String apelido, Date dataNascimento, String genero, String profissao, String email, String senha, String fotoPerfil) {
        this.nome = nome + " " + apelido;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.profissao = profissao;
        this.email = email;
        this.senha = senha;
        this.fotoPerfil = fotoPerfil;
    }
    
    public Utilizador() {             
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }        

    @Override
    public String toString() {
        return "Utilizador{" + "id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", genero=" + genero + ", profissao=" + profissao + ", email=" + email + ", senha=" + senha + ", fotoPerfil=" + fotoPerfil + '}';
    }    
       
}

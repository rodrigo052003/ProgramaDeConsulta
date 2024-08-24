package repository;

import Entrada.Usuario; // Certifique-se de que o pacote e a classe estão corretos

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private List<Usuario> usuarios;

    public UsuarioRepository() {
        this.usuarios = new ArrayList<>();
        // Adiciona um usuário exemplo
        usuarios.add(new Usuario("Rodrizezox", "Palmeirasnaotemmundial"));
        usuarios.add(new Usuario("Viniciuscastelino", "#carros2"));
        usuarios.add(new Usuario("123", "123"));



    }

    public boolean validarLogin(String nome, String senha) {
        return usuarios.stream().anyMatch(u -> u.getNome().equals(nome) && u.getSenha().equals(senha));
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);}
}


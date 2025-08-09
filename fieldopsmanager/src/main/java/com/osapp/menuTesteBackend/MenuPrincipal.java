package com.osapp.menuTesteBackend;

import com.osapp.controller.*;
import com.osapp.model.*;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private static final Scanner scanner = new Scanner(System.in);

    public void menu() {

        ColaboradorMenuTeste.menu();
        
    }

    public void cadastrarEndereco(EnderecoController enderecoController, CidadeController cidadeController,EstadoController estadoController){
        CadastroTeste.cadastrarEndereco(enderecoController, cidadeController, estadoController);
    }

    

}

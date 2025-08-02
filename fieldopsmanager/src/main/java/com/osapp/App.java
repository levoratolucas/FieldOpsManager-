package com.osapp;

import com.osapp.controller.ColaboradorController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        ColaboradorController controller = new ColaboradorController();

        controller.criar("Lucas Levorato", "RE001");
        controller.listar();

        controller.finalizar();
    }
}

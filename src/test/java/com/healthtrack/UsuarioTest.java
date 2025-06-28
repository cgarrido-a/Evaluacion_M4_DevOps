package com.healthtrack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testPesoInicial() {
        Usuario usuario = new Usuario("Luis", 80.0);
        assertEquals(80.0, usuario.getPeso(), 0.01, "El peso inicial no es el esperado.");
    }

    @Test
    public void testActualizarPeso() {
        Usuario usuario = new Usuario("Ana", 70.0);
        usuario.actualizarPeso(72.5);
        assertEquals(72.5, usuario.getPeso(), 0.01, "El peso no se actualiz\u00f3 correctamente.");
    }

    @Test
    public void testActualizarPesoConValorCero() {
        Usuario usuario = new Usuario("Carlos", 65.0);
        usuario.actualizarPeso(0.0);
        assertEquals(0.0, usuario.getPeso(), 0.01, "El peso no se actualiz\u00f3 correctamente a cero.");
    }

    @Test
    public void testActualizarPesoConValorNegativo() {
        Usuario usuario = new Usuario("María", 55.0);
        usuario.actualizarPeso(-3.5);
        assertEquals(-3.5, usuario.getPeso(), 0.01, "El peso negativo no se actualiz\u00f3 correctamente.");
    }
}

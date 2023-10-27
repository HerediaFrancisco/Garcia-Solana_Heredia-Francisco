package com.backend.parcial.test;

import com.backend.parcial.model.Odontologo;
import com.backend.parcial.service.OdontologoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OdontologoServiceTest {

    private OdontologoService odontologoService;


    @BeforeAll
    static void doBefore() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/testParcial;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    void deberiaRegistrarAlgunosOdontologos(){
        Odontologo odontologo = new Odontologo(15483, "Solana", "Garcia Navarro");
        Odontologo odontologo1 = new Odontologo(41656, "Francisco", "Heredia");

        Odontologo odontologoRegistrado = odontologoService.registrar(odontologo);

        assertTrue(odontologoRegistrado.getId() != 0);

    }

    @Test
    public void deberiaRetornarUnaListaNoVacia(){
        assertFalse(odontologoService.listarOdontologos().isEmpty());
    }

}

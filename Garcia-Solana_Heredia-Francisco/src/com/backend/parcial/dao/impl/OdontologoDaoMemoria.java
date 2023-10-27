package com.backend.parcial.dao.impl;


import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;


import java.util.List;
import org.apache.log4j.Logger;

public class OdontologoDaoMemoria implements IDao<Odontologo> {


    private final Logger LOGGER = Logger.getLogger(OdontologoDaoMemoria.class);

    private List<Odontologo> odontologoRepository;

    public OdontologoDaoMemoria(List<Odontologo> odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        int id= odontologoRepository.size() + 1;
        odontologoRepository.add(odontologo);
        Odontologo odontologoRegistrado = new Odontologo(id, odontologo.getMatricula(), odontologo.getNombre(), odontologo.getApellido());
        LOGGER.info("Odontologo registrado: " + odontologoRegistrado);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        return odontologoRepository;

    }
}

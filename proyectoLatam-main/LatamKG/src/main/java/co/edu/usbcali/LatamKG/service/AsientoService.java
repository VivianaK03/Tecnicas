package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.dto.AsientoDTO;

import java.util.List;

public interface AsientoService {
    List<AsientoDTO> obtenerAsientos();
    AsientoDTO obtenerAsiento(Integer id) throws Exception;

    //No se si hacer el metodo de agregar asientos, porque lo podriamos dejar definido
    AsientoDTO agregarAsiento(AsientoDTO asientoDTO) throws Exception;
}
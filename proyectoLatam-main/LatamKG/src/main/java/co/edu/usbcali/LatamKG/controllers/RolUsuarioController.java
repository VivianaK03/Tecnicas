package co.edu.usbcali.LatamKG.controllers;

import co.edu.usbcali.LatamKG.dto.MessageVuelo;
import co.edu.usbcali.LatamKG.dto.RolUsuarioDTO;
import co.edu.usbcali.LatamKG.domain.RolUsuario;
import co.edu.usbcali.LatamKG.service.RolUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rolusuario")
public class RolUsuarioController {
    private final RolUsuarioService rolUsuarioService;


    public RolUsuarioController(RolUsuarioService rolUsuarioService) {
        this.rolUsuarioService = rolUsuarioService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<RolUsuario>> todos() {
        return new ResponseEntity(
                rolUsuarioService.obtenerTodos()
                , HttpStatus.OK);
    }
    @GetMapping("/obtenerRolUsuario")
    public ResponseEntity<RolUsuarioDTO> obtenerRolUsuario(@PathVariable("idRolusuario") Integer idRolusuario) {
        try {
            return new ResponseEntity(rolUsuarioService.obtenerRolUsuario(idRolusuario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MessageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(path = "/guardarNuevoRolUsuario",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarNuevoRolUsuario(@RequestBody RolUsuarioDTO rolUsuarioDTO) {
        try {
            return new ResponseEntity(rolUsuarioService.guardarNuevoRolUsuario(rolUsuarioDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MessageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
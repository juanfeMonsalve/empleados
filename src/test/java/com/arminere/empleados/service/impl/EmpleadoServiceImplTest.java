package com.arminere.empleados.service.impl;

import com.arminere.empleados.dto.EmpleadoDto;
import com.arminere.empleados.entity.Empleado;
import com.arminere.empleados.repository.EmpleadoRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmpleadoServiceImplTest {

    @InjectMocks
    EmpleadoServiceImpl empleadoService;

    @Mock
    EmpleadoRepository empleadoRepository;

    @Test
    void insertEmpleados() {
        Empleado empleado = new Empleado();
        empleado.setEstado("Activo");
        empleado.setArea("TI");
        empleado.setFoto("foto");
        empleado.setPais("Colombia");
        empleado.setIdentificacion("12312341");
        empleado.setFechaIngreso(LocalDateTime.now());
        empleado.setOtrosNombre("");
        empleado.setPrimerApellido("A");
        empleado.setPrimerNombre("A");
        empleado.setSegundoApellido("A");
        empleado.setTipoId("A");
        EmpleadoDto empleadoDto = new EmpleadoDto();
        empleadoDto.setEstado("Activo");
        empleadoDto.setArea("TI");
        empleadoDto.setFoto("foto");
        empleadoDto.setPais("Colombia");
        empleadoDto.setIdentificacion("12312341");
        empleadoDto.setFechaIngreso(LocalDateTime.now());
        empleadoDto.setOtrosNombre("");
        empleadoDto.setPrimerApellido("A");
        empleadoDto.setPrimerNombre("A");
        empleadoDto.setSegundoApellido("A");
        empleadoDto.setTipoId("A");

        Mockito.when(empleadoRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        Mockito.when(empleadoRepository.getEmpleadoByCorreoElectronico(Mockito.anyString())).thenReturn(null);
        Mockito.when(empleadoRepository.save(Mockito.any())).thenReturn(empleado);

        assertEquals(empleado.getIdentificacion(), empleadoService.insertarEmpleado(empleadoDto).getIdentificacion());
    }
}
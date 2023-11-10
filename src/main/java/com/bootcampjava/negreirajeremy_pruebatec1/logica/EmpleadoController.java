/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bootcampjava.negreirajeremy_pruebatec1.logica;

import com.bootcampjava.negreirajeremy_pruebatec1.exceptions.NonexistentEntityException;
import com.bootcampjava.negreirajeremy_pruebatec1.persistencia.PersistanceController;
import java.util.List;

/**
 *
 * @author jerem
 */
public class EmpleadoController {

    PersistanceController controlador = new PersistanceController();

    public void crearEmpleado(Empleado empleado) {
        controlador.crearEmpleado(empleado);
    }
    
    public void eliminarEmpleado(Long id) throws NonexistentEntityException {
        controlador.eliminarEmpleado(id);
    }
    
    public void actualizarEmpleado(Empleado empleado) throws NonexistentEntityException, Exception {
        controlador.actualizarEmpleado(empleado);
    }
    
    public Empleado buscarEmpleadoPorId(Long id) {
        return controlador.buscarEmpleadoPorId(id);
    }
    
    public List<Empleado> listarEmpleados() {
        return controlador.listarEmpleados();
    }
}

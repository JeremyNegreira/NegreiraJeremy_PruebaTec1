/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bootcampjava.negreirajeremy_pruebatec1.persistencia;

import com.bootcampjava.negreirajeremy_pruebatec1.exceptions.NonexistentEntityException;
import com.bootcampjava.negreirajeremy_pruebatec1.logica.Empleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jerem
 */
public class PersistanceController {

    EmpleadoJpaController empleadoJPAC = new EmpleadoJpaController();

    public void crearEmpleado(Empleado empleado) {
        empleadoJPAC.create(empleado);
    }

    public void eliminarEmpleado(Long id) throws NonexistentEntityException {
        empleadoJPAC.destroy(id);
    }

    public void actualizarEmpleado(Empleado empleado) throws NonexistentEntityException, Exception {
        empleadoJPAC.edit(empleado);
    }

    public Empleado buscarEmpleadoPorId(Long id) {
        return empleadoJPAC.findEmpleado(id);
    }

    public List<Empleado> listarEmpleados() {
        return empleadoJPAC.findEmpleadoEntities();
    }
}

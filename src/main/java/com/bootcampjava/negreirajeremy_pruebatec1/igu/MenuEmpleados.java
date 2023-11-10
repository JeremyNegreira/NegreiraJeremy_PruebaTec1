/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bootcampjava.negreirajeremy_pruebatec1.igu;

import com.bootcampjava.negreirajeremy_pruebatec1.exceptions.NonexistentEntityException;
import com.bootcampjava.negreirajeremy_pruebatec1.logica.Empleado;
import com.bootcampjava.negreirajeremy_pruebatec1.logica.EmpleadoController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 *
 * @author jerem
 */
public class MenuEmpleados {

    private EmpleadoController controlador = new EmpleadoController();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void ejecutarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("----------------------------------------");
            System.out.println("Menú de gestión de empleados");
            System.out.println("1. Agregar un nuevo empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Actualizar información de un empleado");
            System.out.println("4. Eliminar un empleado");
            System.out.println("5. Buscar empleados por cargo");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = scanner.nextInt();
                System.out.println("----------------------------------------");
                switch (opcion) {
                    case 1 ->
                        crearEmpleado();
                    case 2 ->
                        listarEmpleados();
                    case 3 ->
                        actualizarEmpleado();
                    case 4 ->
                        eliminarEmpleado();
                    case 5 ->
                        buscarEmpleadosPorCargo();
                    case 0 ->
                        System.out.println("Saliendo del programa.");
                    default ->
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número.");
                System.out.println("----------------------------------------");
                scanner.next();
            }
        } while (opcion != 0);
    }

    /**
     * Crea un nuevo empleado solicitando y validando sus atributos, como
     * nombre, apellido, cargo, salario y fecha de inicio. Permite cancelar la
     * operación ingresando "-1" en cualquier momento.
     */
    public void crearEmpleado() {
        Supplier<String> inputNombre = getInput("nombre", "El nombre no puede estar vacío");
        String nombre = inputNombre.get();
        if (nombre.equals("-1")) {
            System.out.println("Operación cancelada.");
            return;
        }

        Supplier<String> inputApellido = getInput("apellido", "El apellido no puede estar vacío");
        String apellido = inputApellido.get();
        if (apellido.equals("-1")) {
            System.out.println("Operación cancelada.");
            return;
        }

        Supplier<String> inputCargo = getInput("cargo", "El cargo no puede estar vacío");
        String cargo = inputCargo.get();
        if (cargo.equals("-1")) {
            System.out.println("Operación cancelada.");
            return;
        }

        Supplier<Double> inputSalario = getDoubleInput("salario", "El salario debe ser un número válido");
        Double salario = inputSalario.get();
        if (salario == -1) {
            System.out.println("Operación cancelada.");
            return;
        }

        Supplier<Date> inputFechaInicio = getDateInput("fecha de inicio", "Formato de fecha incorrecto");
        Date fechaIni = inputFechaInicio.get();
        if (fechaIni == null) {
            System.out.println("Operación cancelada.");
            return;
        }

        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setCargo(cargo);
        empleado.setSalario(salario);
        empleado.setFechaInicio(fechaIni);

        controlador.crearEmpleado(empleado);
    }

    /**
     * Lista e imprime los detalles de los empleados.
     *
     */
    public void listarEmpleados() {
        List<Empleado> empleados = controlador.listarEmpleados();

        if (empleados.isEmpty()) {
            System.out.println("No hay empleados para mostrar.");
        } else {
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        }
    }

    public void actualizarEmpleado() {
        try {
            System.out.println("Introduzca la id del empleado a editar. (-1 para cancelar)");
            long id;
            Scanner scanner = new Scanner(System.in);
            id = scanner.nextLong();
            if (id != -1) {
                Empleado empleado = controlador.buscarEmpleadoPorId(id);

                System.out.println("Nombre actual: " + empleado.getNombre());
                Supplier<String> inputNombre = getInput("nombre", "El nombre no puede estar vacío");
                String nombre = inputNombre.get();
                if (nombre.equals("-1")) {
                    System.out.println("Operación cancelada.");
                    return;
                }

                System.out.println("Apellido actual: " + empleado.getApellido());
                Supplier<String> inputApellido = getInput("apellido", "El apellido no puede estar vacío");
                String apellido = inputApellido.get();
                if (apellido.equals("-1")) {
                    System.out.println("Operación cancelada.");
                    return;
                }

                System.out.println("Cargo actual: " + empleado.getCargo());
                Supplier<String> inputCargo = getInput("cargo", "El cargo no puede estar vacío");
                String cargo = inputCargo.get();
                if (cargo.equals("-1")) {
                    System.out.println("Operación cancelada.");
                    return;
                }

                System.out.println("Salario actual: " + empleado.getSalario());
                Supplier<Double> inputSalario = getDoubleInput("salario", "El salario debe ser un número válido");
                Double salario = inputSalario.get();
                if (salario == -1) {
                    System.out.println("Operación cancelada.");
                    return;
                }

                System.out.println("Fecha de inicio actual: " + empleado.getFechaInicio());
                Supplier<Date> inputFechaInicio = getDateInput("fecha de inicio", "Formato de fecha incorrecto");
                Date fechaIni = inputFechaInicio.get();
                if (fechaIni == null) {
                    System.out.println("Operación cancelada.");
                    return;
                }

                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setCargo(cargo);
                empleado.setSalario(salario);
                empleado.setFechaInicio(fechaIni);

                controlador.actualizarEmpleado(empleado);
                System.out.println("Se ha borrado con éxito al empleado de id: " + id);
            } else if (id < -1) {
                throw new InputMismatchException();
            } else {
                System.out.println("Se ha cancelado el borrado de datos");
            }

        } catch (NonexistentEntityException e) {
            System.err.println("No existe un empleado con esa id");
        } catch (InputMismatchException e) {
            System.err.println("No ha introducido un número natural mayor que 0");
        } catch (Exception e) {
            System.err.println("Error inesperado");
        } finally {
            // Paramos el hilo para que se impriman los mensajes en orden
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

    /**
     * Elimina un empleado según el ID proporcionado por el usuario. Se manejan
     * excepciones si se introduce un ID no existente o un valor no válido.
     */
    public void eliminarEmpleado() {
        try {
            System.out.println("Introduzca la id del empleado a borrar. (-1 para cancelar)");
            long id;
            Scanner scanner = new Scanner(System.in);
            id = scanner.nextLong();
            if (id != -1) {
                controlador.eliminarEmpleado(id);
                System.out.println("Se ha borrado con éxito al empleado de id: " + id);
            } else if (id < -1) {
                throw new InputMismatchException();
            } else {
                System.out.println("Se ha cancelado el borrado de datos");
            }
        } catch (NonexistentEntityException e) {
            System.err.println("No existe un empleado con esa id");
        } catch (InputMismatchException e) {
            System.err.println("No ha introducido un número natural mayor que 0");
        } finally {
            // Paramos el hilo para que se impriman los mensajes en orden
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

    /**
     * Busca y muestra empleados filtrados por un cargo especificado. Si no hay
     * empleados o no hay coincidencias, se imprime un mensaje correspondiente.
     */
    public void buscarEmpleadosPorCargo() {
        List<Empleado> empleados = controlador.listarEmpleados();

        if (empleados.isEmpty()) {
            System.out.println("No hay empleados");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el cargo por el que filtrar:");
        String cargo = scanner.nextLine();
        List<Empleado> empleadosFiltradosPorCargo = empleados.stream().filter(empleado -> empleado.getCargo().contains(cargo)).toList();

        if (empleadosFiltradosPorCargo.isEmpty()) {
            System.out.println("No hay coincidencias");
        } else {
            System.out.println("Empleados con el cargo " + cargo + ":");
            for (Empleado empleado : empleadosFiltradosPorCargo) {
                System.out.println(empleado);
            }
        }
    }

    /**
     * Obtiene un valor de entrada del usuario y realiza validaciones.
     *
     * @param fieldName El nombre del campo de entrada.
     * @param errorMessage El mensaje de error a mostrar si la entrada es
     * inválida.
     * @return Un proveedor de tipo String para obtener el valor de entrada
     * validado.
     */
    private Supplier<String> getInput(String fieldName, String errorMessage) {
        return () -> {
            String value = "";
            do {
                System.out.print("Ingrese el " + fieldName + " del empleado: ");
                value = new Scanner(System.in).nextLine();
                if (value.isEmpty()) {
                    System.out.println(errorMessage);
                }
            } while (value.isEmpty());
            return value;
        };
    }

    /**
     * Obtiene un valor numérico de entrada del usuario y realiza validaciones.
     *
     * @param fieldName El nombre del campo de entrada.
     * @param errorMessage El mensaje de error a mostrar si la entrada es
     * inválida.
     * @return Un proveedor de tipo Double para obtener el valor numérico
     * validado.
     */
    private Supplier<Double> getDoubleInput(String fieldName, String errorMessage) {
        return () -> {
            Double value = -1.0;
            do {
                System.out.print("Ingrese el " + fieldName + " del empleado: ");
                String valueStr = new Scanner(System.in).nextLine();
                if (valueStr.equals("-1")) {
                    System.out.println("Operación cancelada.");
                    return -1.0;
                }
                try {
                    value = Double.valueOf(valueStr);
                } catch (NumberFormatException e) {
                    System.out.println(errorMessage);
                }
            } while (value == -1.0);
            return value;
        };
    }

    /**
     * Obtiene una fecha de entrada del usuario en el formato "dd/MM/yyyy" y
     * realizan validaciones.
     *
     * @param dateFormat El formato de fecha para la entrada.
     * @param fieldName El nombre del campo de entrada.
     * @param errorMessage El mensaje de error a mostrar si la entrada es
     * inválida.
     * @return Un proveedor de tipo Date para obtener la fecha de entrada
     * validada.
     */
    private Supplier<Date> getDateInput(String fieldName, String errorMessage) {
        return () -> {
            Date date = null;
            do {
                System.out.println("Ingrese la " + fieldName + " (dd/MM/yyyy): ");
                String dateStr = new Scanner(System.in).nextLine();
                if (dateStr.equals("-1")) {
                    System.out.println("Operación cancelada.");
                    return null;
                }
                try {
                    date = dateFormat.parse(dateStr);
                    // Al parsear puede hacer cosas como "09/13/2003" => 9/1/2004
                    // por eso se añade una validación adicional comparando con el string original
                    if (!dateFormat.format(date).equals(dateStr)) {
                        date = null;
                        System.out.println(errorMessage);
                    }
                } catch (ParseException e) {
                    System.out.println(errorMessage);
                }
            } while (date == null);
            return date;
        };
    }
}

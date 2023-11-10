# NegreiraJeremy_pruebatec1

## Prueba técnica Java básico

### Descripción

Este programa Java realiza operaciones básicas de gestión de empleados a través de un menú interactivo. A continuación se detallan las funciones disponibles:

1. **Crear empleado:** Permite la creación de un nuevo empleado con validación de datos. Se solicitan todos los datos necesarios uno a uno. Se puede abortar introduciendo `-1` en cualquier momento antes de completar la creación (la fecha de inicio es el último campo).

2. **Listar empleados:** Muestra todos los empleados y sus datos almacenados en la base de datos.

3. **Actualizar empleado:** Requiere conocer la ID del empleado a modificar. Una vez introducida, si existe, se permite cambiar campo a campo (mostrando el valor antiguo). Se puede abortar con `-1` antes de modificar la fecha de inicio del empleado (último campo).

4. **Eliminar empleado:** Necesita conocer la ID del empleado a eliminar. Si existe, se eliminará. Se puede abortar con `-1`.

5. **Buscar empleados por cargo:** Permite filtrar la lista de empleados ingresando el nombre o parte del nombre del cargo.

6. **Salir del programa:** Finaliza la ejecución del programa.

### Supuestos

- La validación de fechas ha sido mejorada para evitar problemas al convertir una fecha de cadena de texto a una fecha lógica. Por ejemplo, "09/13/2000" se transforma a "09/01/2001" como fecha.

- No se controlan "valores duplicados" ya que el único campo no repetible es la ID.

- El usuario puede abortar un proceso a la mitad sin afectar la base de datos.

- Los datos no están organizados en colecciones debido a la lógica del programa, pero se validan antes de afectar a la base de datos.

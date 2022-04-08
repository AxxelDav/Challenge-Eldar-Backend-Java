# Challenge Eldar-Backend-Java
Proyecto de Backend JAVA para Eldar

Algunas consideraciones:

EL paquete "modelo" posee la clase abstracta "Tipo Tarjeta" cuyos metodos y atributos son heredadas por las subclases Visa, Nara y Amex. A su vez se creo una clase FabricaTarjeta el cual posee el metodo de obtencion de tarjeta, en caso de que sea VISA o NARA o AMEX creara un nuevo objeto con sus caracteristicas y metodos correspondientes al tipo de tarjeta. 

La ejecucion del programa se encuentra en la clase "ejecutable". 
En el manejo de error se valida que la fecha ingresada tenga el formato adecuado, de lo contrario se captura la excepcion y se imprime un aviso. 

La API REST se ejecuta desde "ProyectoApplication", la misma posee Servicio en cuya implementacion se realiza la logica para calcular la tasa y luego setearla. 
Se corroboro la respuesta en la herramienta POSTMAN, llamando al endpoint http://localhost:8080/calculoTasa con un POST.

Por falta de conocimiento no llegue a realizar el Hosteo de la solución en algún cloud computing como lo requeria el ejercicio.






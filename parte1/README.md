
## Escuela Colombiana de Ingeniería
### Arquitecturas de Software – ARSW
### Laura Alvarado - Carlos Orduz


#### Ejercicio – programación concurrente, condiciones de carrera y sincronización de hilos. EJERCICIO INDIVIDUAL O EN PAREJAS.

##### Parte I – Antes de terminar la clase.

Control de hilos con wait/notify. Productor/consumidor.

1. Revise el funcionamiento del programa y ejecútelo. Mientras esto ocurren, ejecute jVisualVM y revise el consumo de CPU del proceso correspondiente. A qué se debe este consumo?, cual es la clase responsable?

![](https://github.com/lauraval19/LAB03-P1P2/blob/master/parte1/images/cpu-Consumo-1.PNG)

### Se observó que el consumo de la CPU aumenta a la hora de ejecutar la clase StartProduction. Esto, se debe a que cuando esta clase corre, el productor y el consumidor están compitiendo para agregar en el caso de produce o eliminar en el caso de consume en la cola, pues no se está controlando los hilos para que actuen de manera secuencial y el consumidor no duerme, mientras se produce los numeros en la cola. 

2. Haga los ajustes necesarios para que la solución use más eficientemente la CPU, teniendo en cuenta que -por ahora- la producción es lenta y el consumo es rápido. Verifique con JVisualVM que el consumo de CPU se reduzca.

![](https://github.com/lauraval19/LAB03-P1P2/blob/master/parte1/images/cpu-consumo-2.PNG)

### Para esto, sincronizamos los hilos para que se comporten de manera secuencial, controlando de que si la cola estavacía el hilo de consume espere a que el hilo de produce ponga valores en la cola. Y así n el caso de que la cola este llena, espera a que se consuma, y cada segundo vuelve a llenar la cola.

3. Haga que ahora el productor produzca muy rápido, y el consumidor consuma lento. Teniendo en cuenta que el productor conoce un límite de Stock (cuantos elementos debería tener, a lo sumo en la cola), haga que dicho límite se respete. Revise el API de la colección usada como cola para ver cómo garantizar que dicho límite no se supere. Verifique que, al poner un límite pequeño para el 'stock', no haya consumo alto de CPU ni errores.

### Para que se respete el número de stock, hicimos que cada vez que la cola este llena no produzca más, hasta que consume le notifique que ya se eliminó un valor.

## Clase Produce, sinronizandose para que se comporte de manera secuencial y espere a que la cola se desocupe si llega a stock.

![](https://github.com/lauraval19/LAB03-P1P2/blob/master/parte1/images/producerUpdated.PNG)

## Clase Consume, se sincroniza y espera a que la cola tenga valores, para comenzar a consumir.

![](https://github.com/lauraval19/LAB03-P1P2/blob/master/parte1/images/consumerUpdated.PNG)

## Pusimos que el hilo Produce se ponga mas lento, colocandolo en 500 milisegundos y el hilo Consume lo aumentamos a 2 segundos. De esta manera, no se afectó el consumo en la CPU 

![](https://github.com/lauraval19/LAB03-P1P2/blob/master/parte1/images/cpu-lowConsume.PNG)



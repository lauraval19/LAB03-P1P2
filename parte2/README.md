
### Escuela Colombiana de Ingeniería
### Arquitecturas de Software - ARSW
## Ejercicio Introducción al paralelismo - Hilos - Caso BlackListSearch


### Carlos Javier Orduz, Laura Valentina Alvarado
  

**Parte I - Introducción a Hilos en Java**

**De acuerdo con lo revisado en las lecturas, complete las clases CountThread, para que las mismas definan el ciclo de vida de un hilo que imprima por pantalla los números entre A y B.**

![](https://github.com/CarlosOrduz777/ARSW-LAB01/blob/master/img/counterClass.PNG)

Complete el método main de la clase CountMainThreads para que:

   1. Cree 3 hilos de tipo CountThread, asignándole al primero el intervalo [0..99], al segundo [99..199], y al tercero [200..299].
   
   ![](https://github.com/CarlosOrduz777/ARSW-LAB01/blob/master/img/threadCreation.PNG)
   
   2. Inicie los tres hilos con 'start()'.
   
   ![](https://github.com/CarlosOrduz777/ARSW-LAB01/blob/master/img/start.PNG)
   
   3. Ejecute y revise la salida por pantalla.
   
   ![](https://github.com/CarlosOrduz777/ARSW-LAB01/blob/master/img/startExecution.PNG)
   
   4. Cambie el incio con 'start()' por 'run()'. Cómo cambia la salida?, por qué?.
   
   ![imagen](https://user-images.githubusercontent.com/98195579/184055364-a8acd843-4e25-41dd-8b4c-944644d4594d.png)
   
	La salida cambia ya que, con start los hilos se crean y se ejectutan al tiempo. Con sólo run este será ejecutado como un método normal que llama al hilo actual y no habrá lugar para varios hilos.
   
   **Parte II - Ejercicio Black List Search**
   
1. Cree una clase de tipo Thread que represente el ciclo de vida de un hilo que haga la búsqueda de un segmento del conjunto de servidores disponibles. Agregue a dicha clase un método que permita 'preguntarle' a las instancias del mismo (los hilos) cuantas ocurrencias de servidores maliciosos ha encontrado o encontró.

![imagen](https://user-images.githubusercontent.com/98195579/184057393-fdd1b021-01a2-4442-8043-1ee07771ed96.png)

2. Agregue al método 'checkHost' un parámetro entero N, correspondiente al número de hilos entre los que se va a realizar la búsqueda (recuerde tener en cuenta si N es par o impar!). Modifique el código de este método para que divida el espacio de búsqueda entre las N partes indicadas, y paralelice la búsqueda a través de N hilos. Haga que dicha función espere hasta que los N hilos terminen de resolver su respectivo sub-problema, agregue las ocurrencias encontradas por cada hilo a la lista que retorna el método, y entonces calcule (sumando el total de ocurrencuas encontradas por cada hilo) si el número de ocurrencias es mayor o igual a BLACK_LIST_ALARM_COUNT. Si se da este caso, al final se DEBE reportar el host como confiable o no confiable, y mostrar el listado con los números de las listas negras respectivas. Para lograr este comportamiento de 'espera' revise el método join del API de concurrencia de Java. Tenga también en cuenta:

    Dentro del método checkHost Se debe mantener el LOG que informa, antes de retornar el resultado, el número de listas negras revisadas VS. el número de listas negras total (línea 60). Se debe garantizar que dicha información sea verídica bajo el nuevo esquema de procesamiento en paralelo planteado.

    Se sabe que el HOST 202.24.34.55 está reportado en listas negras de una forma más dispersa, y que el host 212.24.24.55 NO está en ninguna lista negra.
    
    ![imagen](https://user-images.githubusercontent.com/98195579/184057594-0821597e-4cf7-4038-8330-d144fb74e6f3.png)



	
	



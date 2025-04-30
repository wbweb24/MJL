

package ordenaryorganizar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OrdenarYOrganizar {
    
    public static void main(String[] args) {
        // Generar un array de números aleatorios
        int[] arrayAleatorio = generarArrayAleatorio(10000000, 200);
     

        double tiempoPersonalizado = medirTiempoPersonalizado(arrayAleatorio);
        double tiempoQuicksort = medirTiempoQuicksort(arrayAleatorio);

        System.out.println("Tiempo de ejecución del Método Personalizado: " + tiempoPersonalizado + " segundos");
        System.out.println("Tiempo de ejecución de Quicksort: " + tiempoQuicksort + " segundos");


        


    }

    public static int[] generarArrayAleatorio(int tamano, int rango) {
        Random rand = new Random();
        int[] arr = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            arr[i] = rand.nextInt(rango);
        }
        return arr;
    }
    /********************************************************************/
    public static double medirTiempoPersonalizado(int[] array) {
    long inicio = System.nanoTime();
    List<Object> resultadoOrdenado = arrayOrdenado(array);
    long fin = System.nanoTime();
    return (fin - inicio) / 1e9; // Convertir a segundos
}

    public static double medirTiempoQuicksort(int[] array) {
    long inicio = System.nanoTime();
    int[] resultadoQuicksort = quicksort(array);
    long fin = System.nanoTime();
    return (fin - inicio) / 1e9; // Convertir a segundos
}


    public static List<Object> arrayOrdenado(int[] arr) {
        List<Object> resultado = new ArrayList<>();
        for (int num : arr) {
            while (resultado.size() <= num) {
                resultado.add(null);
            }
            if (resultado.get(num) == null) {
                resultado.set(num, num);
            } else if (resultado.get(num) instanceof List) {
                ((List<Integer>) resultado.get(num)).add(num);
            } else {
                resultado.set(num, new ArrayList<>(Arrays.asList((Integer) resultado.get(num), num)));
            }
        }
        resultado.removeIf(el -> el == null);
        return resultado;
    }

    public static int[] quicksort(int[] arr) {
        if (arr.length <= 1) return arr;
        int pivot = arr[arr.length / 2];
        int[] left = Arrays.stream(arr).filter(x -> x < pivot).toArray();
        int[] right = Arrays.stream(arr).filter(x -> x > pivot).toArray();
        int[] middle = Arrays.stream(arr).filter(x -> x == pivot).toArray();
        
        return mergeArrays(quicksort(left), middle, quicksort(right));
    }

    public static int[] mergeArrays(int[] left, int[] middle, int[] right) {
        int[] merged = new int[left.length + middle.length + right.length];
        System.arraycopy(left, 0, merged, 0, left.length);
        System.arraycopy(middle, 0, merged, left.length, middle.length);
        System.arraycopy(right, 0, merged, left.length + middle.length, right.length);
        return merged;
    }

   

    
}

/*ORIGINAL JS
let arrayOrdenado = (arr) => {
  let resultado = [];  

  arr.forEach(element => {
   
    if (Array.isArray(resultado[element])) {
      resultado[element].push(element);
    } else if (resultado[element] !== undefined) {
      resultado[element] = [resultado[element], element];
    } else {
      resultado[element] = element; // Asignar si es el primer valor.
    }
  });

  // Eliminar índices vacíos (undefined) antes de retornar
  return resultado.filter(value => value !== undefined);
};
*/
package ciclos;

import java.util.Scanner;

public class Ej3NotasFinales {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double notas=0;
        double sumatotal=0;
        double sumatoria1=0;
        double sumatoria2=0;
        int a=0;
        int b=0;
        
        for(int i=1; i <= 20; i++){
            
            System.out.print("Introduce los valores de 20 notas del Alumno: " + "nota " + i + " : ");
            notas = entrada.nextDouble();
                
                sumatotal= sumatotal+notas;
                if (notas < 6){ // if para contar las notas menores a 6
                    sumatoria1 = sumatoria1+notas;
                    a += 1;
                }else if(notas >= 6){ // if para contar las notas mayores a 6
                    sumatoria2 = sumatoria2+notas;
                    b += 1;
                }else if(notas != 0 && notas <= 10){ //if para comprobar que las notas no son 0 o mayores a 10
    
                    System.out.println("Una nota tiene un valor erroneo y no se puede continuar, verifique las notas");
                    return;
                }
            } 
            System.out.println("El promedio del Alumno es: " + (sumatotal/20));
            System.out.println("El promedio de las notas menores a 6 del Alumno es: " + (sumatoria1/a)+ " numeor de notas " + a);
            System.out.println("El promedio de las notas mayores a 6 del Alumno es: " + (sumatoria2/b) + " numeor de notas " + b);
            entrada.close();
        }

    }

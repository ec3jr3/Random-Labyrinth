
import java.util.*;
public class laberinto2
{  public int [][] arr; 
    public Queue <String> cola;
    public Stack <String> pila;
    public  int[][] construir()
    {
        System.out.print('\u000c');
        Scanner datos1 = new Scanner(System.in);
        int uno = datos1.nextInt();//the size of the matriz 
                                   //*It has to be an odd number

        arr = new int [uno][uno];
        LinkedList Vecino2 = new LinkedList();
        LinkedList Vecino1 = new LinkedList();       
        for(int a =1;a<arr.length;a+=2)//llenandolo de 3 en las filas/columnas impares
        {
            for(int b=1;b<arr[a].length;b+=2)
            {
                arr[a][b]=3;
            }
        }
        for(int a=0;a<arr.length;a++)//imprimiento la primera matris
        {
            for(int b=0; b<arr[a].length;b++)
            {
                System.out.print(arr[a][b]);
            }
            System.out.println();
        }
        int fila=(int)(Math.random()*arr.length-1);//asignando un "3" random
        int columna=(int)(Math.random()*arr.length-1);
        if(fila%2==0)//si numero es par
        {
            fila=fila+1;
        }
        if(columna%2==0)//si numero es par
        {
            columna=columna+1;
        }
        arr[fila][columna]=2;//convirtiendo el 3 en 2
        Vecino2.add(fila+ ","+columna);
        while(!Vecino2.isEmpty())
        {
            int x =(int)(Math.random()*Vecino2.size());//sacando de la lista una pocision al azar
            String g = (String)Vecino2.remove(x);
            String [] corta = g.split(",", 2);
            int f = Integer.parseInt(corta[0]);
            int c = Integer.parseInt(corta[1]);
            arr[f][c]=1;
            if(c+2<arr.length)
            {
                if(arr[f][c+2]==3)//movimiento a la derecha
                {
                    arr[f][c+2]=2;
                    Vecino2.add(f+","+(c+2));                      
                }
                else if(arr[f][c+2]==1)
                {
                    Vecino1.add(f+","+(c+1));
                }
            }
            if(f+2<arr.length)
            {
                if (arr[f+2][c]==3)//movimiento abajo
                {  
                    arr[f+2][c]=2;
                    Vecino2.add((f+2)+","+c);                      
                }
                else if (arr[f+2][c]==1)//movimiento abajo
                {  
                    Vecino1.add((f+1)+","+c);                      
                }
            }
            if(c-2>=0)
            {
                if(arr[f][c-2]==3)//movimiento izquierda
                {
                    arr[f][c-2]=2;
                    Vecino2.add(f+","+(c-2));
                } 
                else if(arr[f][c-2]==1)//movimiento izquierda
                {
                    Vecino1.add(f+","+(c-1));
                } 
            }
            if(f-2>=0)
            {
                if(arr[f-2][c]==3)//movimiento arriba
                {
                    arr[f-2][c]=2;
                    Vecino2.add((f-2)+","+c);
                }
                else if(arr[f-2][c]==1)//movimiento arriba
                {
                    Vecino1.add((f-1)+","+c);
                }
            }
            if(!Vecino1.isEmpty())
            {
                int y =(int)(Math.random()*Vecino1.size());
                String w = (String)Vecino1.remove(y);
                String [] corta1 = w.split(",", 2);
                int f1 = Integer.parseInt(corta1[0]);
                int c1 = Integer.parseInt(corta1[1]);
                arr[f1][c1]=1;
                Vecino1.clear(); //borrando todo lo que haya en la lista de vecinos1
            }
        } 
        System.out.println();

        int fa=(int)(Math.random()*arr.length-1);//asignando entrada
        int ca = 0;
        if(fa%2==0)//si numero es par
        {
            fa=fa+1;
        }
        arr[fa][ca]=1;

        int cs=(int)(Math.random()*arr.length-1);
        int fs =arr.length-1;
        if(cs%2==0)//si numero es par
        {
            cs=cs+1;
        }
        arr[fs][cs]=1;      
        for(int a=0;a<arr.length;a++)//imprimiento la primera matris
        {
            for(int b=0; b<arr[a].length;b++)
            {
                System.out.print(arr[a][b]);
            }
            System.out.println();
        }

        cola = new LinkedList<String>(); 
        pila = new Stack();
        int b = 0;        
        while(!(fa==fs&&ca==cs))
        {
            if(ca+1<arr.length)
            {
                if(arr[fa][ca+1]==1)//movimiento a la derecha
                {
                    arr[fa][ca+1]=arr[fa][ca]+1;
                    cola.offer(String.valueOf(fa)+"y"+String.valueOf(ca+1));
                    b = arr[fa][ca];
                }
            }
            if(fa+1<arr.length)
            {
                if (arr[fa+1][ca]==1)//movimiento abajo
                {
                    arr[fa+1][ca]=arr[fa][ca]+1;
                    cola.offer(String.valueOf(fa+1)+"y"+String.valueOf(ca));
                    b = arr[fa][ca];
                }
            }
            if(ca-1>=0)
            {
                if(arr[fa][ca-1]==1)//movimiento izquierda
                {
                    arr[fa][ca-1]=arr[fa][ca]+1;
                    cola.offer(String.valueOf(fa)+"y"+String.valueOf(ca-1));
                    b = arr[fa][ca];
                }
            }
            if(fa-1>=0)
            {
                if(arr[fa-1][ca]==1)//movimiento arriba
                {
                    arr[fa-1][ca]=arr[fa][ca]+1;
                    cola.offer(String.valueOf(fa-1)+"y"+String.valueOf(ca));
                    b = arr[fa][ca];
                }
            }
            if(!cola.isEmpty())
            {
                String k = (String)cola.poll();
                String [] corta3 = k.split("y", 2);
                fa = Integer.parseInt(corta3[0]);
                ca = Integer.parseInt(corta3[1]);              
            }  

        }

        while(true)
        {

            if(ca+1<arr.length && arr[fa][ca+1]==b)//movimiento a la derecha
            {
                pila.push(String.valueOf(fa)+"y"+String.valueOf(ca));
                ca++;            
            }
            else if (fa+1<arr.length && arr[fa+1][ca]==b)//movimiento abajo
            {
                pila.push(String.valueOf(fa)+"y"+String.valueOf(ca));
                fa++;          
            }

            else if(ca-1>0 && arr[fa][ca-1]==b)//movimiento izquierda
            {
                pila.push(String.valueOf(fa)+"y"+String.valueOf(ca));
                ca--;              
            }

            else if(fa-1>0 && arr[fa-1][ca]==b)//movimiento arriba
            {
                pila.push(String.valueOf(fa)+"y"+String.valueOf(ca));
                fa--;            
            }
            if(b==1)
            {
                pila.push(String.valueOf(fa)+"y"+String.valueOf(ca));
                break;
            }
            b--;
        }      
        while(!pila.empty())
        {
            String x = (String) pila.pop();
            String[] parte = x.split("y",2);
            fa = Integer.parseInt(parte[0]);
            ca = Integer.parseInt(parte[1]);
            //arr [fa][ca]=-2;
            System.out.println(fa+"y"+ca);
        }  

        return arr;      
    }

    public static void main()
    {
        laberinto2 hola2 = new laberinto2();
        hola2.construir();         
    }
}
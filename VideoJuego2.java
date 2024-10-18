   
    public class VideoJuego2
    {
        public static void main (String [] args)
        {
            Soldado [][] tablero = new Soldado [10][10];
            crear               (tablero);
            mostrarTabla        (tablero);
            mostrarMayorVida    (tablero);
            double vida = mostrarPromedioVida (tablero);
            mostrar(tablero);

            // MOSTRAR VIDA DE TODOS LOS SOLDADOS
            System.out.println ("\n\t| VIDA TOTAL DEL EJERCITO |\n");
            System.out.println ("La vida total es: " + vida );
        }

        public static void crear (Soldado [][] tablero)
        {
            int     aleatorio = posicionRandom()+1, fila, columna;

            for (int i = 0 ; i < aleatorio ; i++)
            {
            // VERIFICA POSICION LIBRE
                do
                {
                    fila = posicionRandom();
                    columna = posicionRandom();
                }
                while ( tablero[fila][columna] != null );
            
            // CREA E INICIALIZA DATOS DEL SOLDADO
            tablero[fila][columna] = new Soldado();
            inicializar (tablero, fila, columna, i);
            }
        }
        
        public static void inicializar (Soldado [][] tablero, int f, int c, int cont)
        {
            String columnaLetras [] = {"A","B","C","D","E","F","G","H","I","J"};
             
            tablero[f][c].setNombre ("Soldado"+cont);
            tablero[f][c].setVida   ( vida() );
            tablero[f][c].setFila   (f+1);
            tablero[f][c].setColumna(columnaLetras[c]);
        }

        public static void mostrarTabla (Soldado [][] tablero)
        {
            String letras [] = {"A","B","C","D","E","F","G","H","I","J"};
            System.out.print ("     ");
            
            for (int i = 0 ; i < letras.length ; i++)
            {
                System.out.print (letras[i]+"            ");
            }
            System.out.println(" ");
            
            for (int i = 0 ; i < tablero.length ; i++)
            {
                System.out.print (i+1);
                for (int j = 0 ; j < tablero[i].length ; j++)
                {
                    if (tablero[i][j] == null)
                        System.out.print ("          |");
                    else
                        System.out.print (" "+tablero[i][j].getNombre()+" |");
                }
                System.out.println("\n--------------------------------------------------------------------------------------------------------------");
            }
        }
        
        public static int posicionRandom ()
        {
            return (int)(Math.random() * 10);
        }

        public static int vida ()
        {
            return (int)(Math.random() * 5 + 1);
        }
        
        public static void mostrarMayorVida (Soldado[][]tablero)
        {
            int fila = 0, columna = 0;
            
            // LOS MAYORES VALORES INICIALES
            for (int i = 0 ; i < tablero.length ; i++) {
                for (int j = 0 ; j < tablero[i].length ; j++)
                {
                        if ( !(tablero[i][j] == null) )
                        { fila = i; columna = j; break; }
                }
            }
           
           // BUSQUEDA DEL SOLDADO CON MAYOR VIDA 
           for (int i = 0 ; i < tablero.length ; i++)
           {
                for (int j = 0 ; j < tablero[i].length ; j++){
                    if ( !(tablero[i][j] == null) ) {
                        if ( tablero[fila][columna].getVida() < tablero[i][j].getVida() )
                        {
                            fila = i;
                            columna = j;
                        }
                    }        
                }
            }
            
            // MOSTRAR
            System.out.println ("\n\t| SOLDADO CON MAYOR VIDA |\n");
            System.out.println (tablero[fila][columna]+"\n");
        }
        
        public static double mostrarPromedioVida (Soldado[][] tablero)
        {
           double suma = 0, cont = 0;
           
           // PROMEDIO DE VIDA
           for (int i = 0 ; i < tablero.length ; i++)
           {
                for (int j = 0 ; j < tablero[i].length ; j++){
                    if ( !(tablero[i][j] == null) )
                    {
                         suma += tablero[i][j].getVida();
                         cont++;
                    }       
                }
           }
           
            // MOSTRAR
            System.out.println ("\n\t| PROMEDIO DE VIDA |\n");
            System.out.println ("El promedio de vida es: " + (suma/cont) );
            
            return suma;
        }
        
        public static void mostrarPorCreacion (Soldado[][]tablero)
        {
            
        }
        
        public static void mostrar (Soldado [][] tablero)
        {
           System.out.println("\n\t| SOLDADOS - EJERCITO |");
           for (int i = 0 ; i < tablero.length ; i++)
           {
                for (int j = 0 ; j < tablero[i].length ; j++){
                    if ( !(tablero[i][j] == null) )
                    {
                         System.out.println("\n"+tablero[i][j]);
                    }       
                }
           }
        }
        
        
        
        
        
    }


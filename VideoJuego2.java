   
    public class VideoJuego2
    {
        public static void main (String [] args)
        {
            Soldado [][] tablero = new Soldado [10][10];
            crear           (tablero);
            mostrarTabla    (tablero);
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
    }


public class VideoJuego2
{
    public static void main (String [] args)
    {
        Soldado [][] tablero = new Soldado [10][10];
        inicializar (tablero);
    }
    
    public static void inicializar (Soldado [][] tablero)
    {
        String columnaLetras [] = {"A","B","C","D","E","F","G","H","I","J"}; 
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
            
            tablero[fila][columna] = new Soldado();
            
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


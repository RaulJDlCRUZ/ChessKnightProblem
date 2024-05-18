import java.util.Scanner;

public class KnightProblem {
	public static void main(String[] args) throws Exception {
		//PRIMERA TOMA DE DATOS
		Scanner teclado=new Scanner(System.in);
		char[][] M=null;
		int contador=0;
		int d=LeerEntero("Introducir dimension del tablero NxN: ");
		if (d<=0){
			do{
				System.out.println("El valor de dimension introducido no es valido.");
				d=LeerEntero("Intentar de nuevo: ");
			} while(d<=0);
		}
		M=new char[d][d];
		inicializa(M);
		//TOMA DE DATOS PARA COLOCAR CABALLOS
		while(M!=null && !completa(M)){
				int fila=LeerEntero("Fila del caballo: ");
				int col=LeerEntero("Columna del caballo: ");
				String s=colocar(M,fila,col);
				if(s.equals("Posicion correcta."))
					contador++;
				System.out.println(s+" Caballos puestos actualmente: "+contador);
				System.out.println(mostrar(M));
			}
		//CERRAMOS EL PROGRAMA CUANDO EL TABLERO ESTA DOMINADO POR LOS CABALLOS
		if(completa(M)){
			System.out.println("Ya no se pueden poner mas caballos. Cantidad total de caballos: "+contador);
			System.out.println("Resultado final: \n");
			System.out.println(mostrar(M));
			teclado.close();
			System.exit(0);
		}
	}
	//METODO PARA CONVERTIR STRINGS EN ENTEROS. "LEER ENTERO A LA VEZ QUE PREGUNTAMOS"
	public static int LeerEntero(String s){
		Scanner teclado=new Scanner(System.in);
		System.out.println(s);
		return teclado.nextInt();
	}
	//METODO PARA INICIALIZAR EL TABLERO, LLENANDOLO DE "O"s
	public static void inicializa(char[][] M){
		for (int f=0;f<M.length;f++)
			for(int c=0;c<M[0].length;c++)
				M[f][c]='o';
	}
	//METODO PARA VERIFICAR Y COLOCAR LOS CABALLOS
	public static String colocar(char[][] M,int f, int c){
		String s="Posicion correcta.";
		if (f<0 || f>=M.length || c<0 || c>=M[0].length)
			s="Se han metido mal las filas o las columnas, revisa que has introducido los datos correctamente y/o que el caballo se encuentre dentro del tablero. \n";
		else{
			if(M[f][c]=='x' || M[f][c]=='C') s="Ese lugar ya esta ocupado o controlado por un caballo.";
			else{
				M[f][c]='C';
				if(f-2>=0&&c-1>=0)
					if(M[f-2][c-1]=='o') M[f-2][c-1]='x';
				if(f-2>=0&&c+1<=M.length-1)
					if(M[f-2][c+1]=='o') M[f-2][c+1]='x';
				if(f+2<=M.length-1&&c-1>=0)
					if(M[f+2][c-1]=='o') M[f+2][c-1]='x';
				if(f+2<=M.length-1&&c+1<=M.length-1)
					if(M[f+2][c+1]=='o') M[f+2][c+1]='x';
				if(f-1>=0&&c+2<=M.length-1)
					if(M[f-1][c+2]=='o') M[f-1][c+2]='x';
				if(f+1<=M.length-1&&c+2<=M.length-1)
					if(M[f+1][c+2]=='o') M[f+1][c+2]='x';
				if(f-1>=0&&c-2>=0)
					if(M[f-1][c-2]=='o') M[f-1][c-2]='x';
				if(f+1<=M.length-1&&c-2>=0)
					if(M[f+1][c-2]=='o') M[f+1][c-2]='x';
			}
		}
		return s;
	}
	//MOSTRAMOS EL TABLERO
	public static String mostrar(char[][] M){
		String s="\n";
		for(int f=0;f<M.length;f++){
			for(int c=0;c<M[0].length;c++) s=s+" "+M[f][c];
			s=s+"\n";
		}
		return s;
	}
	//VERIFICAMOS QUE EL TABLERO ESTA COMPLETO O DOMINADO POR CABALLOS
	private static boolean completa(char[][] M){
		boolean comp=true;
		for(int f=0;f<M.length && comp;f++)
			for(int c=0;c<M[0].length && comp;c++)
				if(M[f][c]=='o') comp=false;
		return comp;
	}
}
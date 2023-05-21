package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {



        Libro libro = new Libro(1, "El perfume", "Patrick Suskind");

        try{
            if (ldao.insertar(libro)){
                System.out.println("Se inserto correctamente");
            }else {
                System.out.println("No se pudo modificar...");
            }
        }catch (SQLException sqle){
            System.out.println("Error al insertar");
        }

        LibroDAO ldao = new LibroDAO();

        try{
            if(ldao.delete("11")){
                System.out.println("Se elimino correctamente");
            }else {
                System.out.println("No se pudo eliminar");
            }
        }catch (SQLException sqle){
            System.out.println("Error al eliminar");
            System.out.println(sqle.getMessage() );
        }

        LibroDAO ldao = new LibroDAO();

        try{
            Libro res = (libro)ldao.buscarPorId("1");
            System.out.println(res);
            System.out.println(------------------);
            for (Object lib: ldao.obtenerTodo()){
                System.out.println((libro)lib);
            }
        }catch (SQLException sqle){
            System.out.println("Error al eliminar");
            System.out.println(sqle.getMessage() );
        }

    }

}
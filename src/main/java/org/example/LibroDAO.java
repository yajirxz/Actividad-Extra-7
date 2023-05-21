package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibroDAO implements InterfazDAO{
    public LibroDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "Insert INTO libros(titulo,autor) VALUES(?, ?)";
        int rowCount = 0;

        PreparedStatement pstm = ConexionSingleton.getInstance("librosDB").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((libro)obj).getTitulo());
        pstm.setString(2, ((libro)obj).getAutor());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE libros SET titulo = ?, autor = ? WHERE id = ? ; ";
        int rowCount = 0;

        PreparedStatement pstm = ConexionSingleton.getInstance("librosDB").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((libro)obj).getTitulo());
        pstm.setString(2, ((libro)obj).getAutor());
        pstm.setInt( 3, ((libro)obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
       String sqlDelete = "DELETE FROM libros WHERE id = ? ;";
       int rowCount = 0;
       PreparedStatement pstm = ConexionSingleton.getInstance("librosDB.db").getConnection().PreparedStatement(sqlDelete);
       pstm.setInt(1, Integer.parseInt(id) );
       rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }
    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM libros";
        ArrayList<Libro> resultado = new ArrayList<>();
            Statement stm = ConexionSingleton.getInstance("librosDB.db").getConnection().createStatement();
                    ResultSet rst = stm.executeQuery(sql);
            while (rst.next()){
                resultado.add(new Libro (rst.getInt(1), rst.getString(2), rst.getString(3)));
            }
            return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM libros WHERE id = ? ;";
        Libro libro = null;
            PreparedStatement pstm = ConexionSingleton.getInstance("librosDB.db").getConnection().prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(id));
            ResultSet rst = pstm.executeQuery();
            if(rst.next()) {
                libro = new Libro(rst.getInt(1), rst.getString(2), rst.getString(3));
                return libro;
            }
        return null;
    }
}

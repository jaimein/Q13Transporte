/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q13transporte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vlc
 */
public class ConectaBBDD {

    private Connection conn = null;
    private Statement sentenciaSQL = null;
    private ResultSet rs = null;
    boolean nuevoRegistro = false;

    /**
     * Constructor vacio
     */
    public ConectaBBDD() {
    }

    /**
     * metodo en el que haremos la conexión física a la BBDD del servidor MySql.
     *
     * @throws SQLException
     */
    public void conecta() throws SQLException {
        String jdbcUrl = null;
        String driver = null;
        try {
            //Registrando el Driver
            driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();
            System.out.println("Driver " + driver + " Registrado correctamente");
            //Abrir la conexión con la Base de Datos
            System.out.println("Conectando con la Base de datos...");
            jdbcUrl = "jdbc:mysql://localhost:3306/Autobuses";
            conn = DriverManager.getConnection(jdbcUrl, "root", "");
            System.out.println("Conexión establecida con la Base de datos...");
        } catch (SQLException se) {
            //Errores de JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Errores de Class.forName
            e.printStackTrace();
        }
    }

    /**
     * Este método preparará el atributo sentenciaSQL de la clase para su
     * posterior utilización
     *
     * @throws SQLException
     */
    public void crearSentencia() throws java.sql.SQLException {
        // Crear una sentencia para enviar consultas a la base de datos
        sentenciaSQL = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("\nSentencia creada con éxito.");
    }

    /**
     * ejecuta la sentencia recibida como parámetro (sql) a taves de la
     * sentencia creada con l método anterior. Como resultado actualiza el
     * contenido del atributo rs (ResultSet) con lo obtenido
     *
     * @param sql
     * @throws SQLException
     */
    public void ejecutaSQL(String sql) throws java.sql.SQLException {
        // realiza la consulta y devuelve resultados
        rs = sentenciaSQL.executeQuery(sql);
    }

    /**
     * lanzar sentencia sql y modificar la BBDD utilizaremos otro método, al que
     * llamaremos updateSQL. Se recibe un String con la sentencia a ejecutar y
     * se devuelve un entero con el resultado de la ejecución, (-1 si no se
     * realizó satisfactoriamente).
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public int updateSQL(String sql) throws java.sql.SQLException {
        // actualiza la BBDD
        int upd = -1;
        try {
            upd = sentenciaSQL.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            upd = -1;
        }
        return upd;
    }

    /**
     * liberar la conexión a la BBDD
     *
     * @throws SQLException
     */
    public void cerrarConexion() throws java.sql.SQLException {
        // se cerrará la conexión a la BBDD.

        if (rs != null) {
            rs.close();
        }
        if (sentenciaSQL
                != null) {
            sentenciaSQL.close();
        }
        if (conn
                != null) {
            conn.close();
        }

        System.out.println(
                "\nConexión cerrada con éxito.");
    }

    /**
     * Metodo para ir a la ultima fila del resultset
     *
     * @throws SQLException
     */
    public void irAlFinal() throws java.sql.SQLException {
        try {
            rs.last();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para ir a la siguiente fila del resultSet
     *
     * @throws SQLException
     */
    public void irAlSiguiente() throws java.sql.SQLException {
        try {
            rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para ir a la fila anterior del resultSet
     *
     * @throws SQLException
     */
    public void irAlAnterior() throws java.sql.SQLException {
        try {
            rs.previous();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para ir a la primera fila del resultset
     *
     * @throws SQLException
     */
    public void irAlPrimero() throws java.sql.SQLException {
        try {
            rs.first();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * un método que nos dice el tamaño del rs sin perder la posición en la que se encuentra
     * @return
     * @throws SQLException
     */
    public int tamanyo() throws java.sql.SQLException {
        int tam = 0, origen = 0;
        origen = rs.getRow();
        rs.last();
        tam = rs.getRow();
        rs.absolute(origen);
        return tam;
    }

}

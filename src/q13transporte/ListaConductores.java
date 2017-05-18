/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q13transporte;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jaime
 */
public class ListaConductores {

    //Atributos
    private ArrayList<Conductor> listaConductores = new ArrayList<Conductor>();
    private int x = 0;

    public ListaConductores() throws ExcepcionPersonal, SQLException {
        cargarConductores();
    }

    /**
     * Metodo para añadir un conductor a la lista, previamente comprueba si
     * existe
     *
     * @param cond
     * @return
     * @throws q13transporte.ExcepcionPersonal
     */
    public boolean insertar(Conductor cond) throws ExcepcionPersonal, SQLException {
        boolean boo = false;
        existe(cond);
        if ("".equals(cond.getNombre())) {
            throw new ExcepcionPersonal("El nombre no puede estar en blanco");
        }
        if ("".equals(cond.getCodConductor())) {
            throw new ExcepcionPersonal("El codigo no puede estar en blanco");
        }
        if (cond.getCodConductor().length() > 4) {
            throw new ExcepcionPersonal("El codigo no tener mas de 4 caracteres");
        }
        ConectaBBDD con = new ConectaBBDD();
        String sentSql;

        try {

            con.conecta();
            con.crearSentencia();
            sentSql = "INSERT INTO Conductores (codConductor, nombre, salario, fecha_alta) VALUES ('" + cond.getCodConductor() + "', '" + cond.getNombre() + "', '" + cond.getSalario() + "', '" + cond.getFecha_alta() + "');";
            System.out.println(sentSql);
            con.updateSQL(sentSql);

            con.cerrarConexion();
            boo = true;
        } catch (SQLException ex) {
            throw new ExcepcionPersonal(ex.getMessage());
        }
        cargarConductores();
        return boo;
    }

    /**
     * nos devuelve el siguiente elemento
     *
     * @return
     * @throws q13transporte.ExcepcionPersonal
     */
    public Conductor siguiente() throws ExcepcionPersonal {
        hay();
        x++;
        return listaConductores.get(x);
    }

    /**
     * nos devuelve el anterior elemento
     *
     * @return
     * @throws q13transporte.ExcepcionPersonal
     */
    public Conductor anterior() throws ExcepcionPersonal {
        hay();
        x--;
        return listaConductores.get(x);
    }

    /**
     * nos devuelve el primer elemento
     *
     * @return
     * @throws ExcepcionPersonal
     */
    public Conductor primer() throws ExcepcionPersonal {
        hay();
        x = 0;
        return listaConductores.get(x);
    }

    /**
     * nos devuele el ultimo
     *
     * @return
     * @throws q13transporte.ExcepcionPersonal
     */
    public Conductor ultimo() throws ExcepcionPersonal {
        hay();
        x = listaConductores.size() - 1;
        return listaConductores.get(x);
    }

    /**
     * pregunta si el que se esta mostrando es el ultimo
     *
     * @return
     * @throws q13transporte.ExcepcionPersonal
     */
    public boolean isUltimo() throws ExcepcionPersonal {
        hay();
        return listaConductores.size() - 1 == x;
    }

    /**
     * pregunta si el que se esta mostrando es el primero
     *
     * @return
     * @throws ExcepcionPersonal
     */
    public boolean isPrimer() throws ExcepcionPersonal {
        hay();
        return 0 == x;
    }

    public int pos() throws ExcepcionPersonal {
        hay();
        return x;
    }

    /**
     * limpia la lista
     *
     * @throws q13transporte.ExcepcionPersonal
     */
    public void limpiar() throws ExcepcionPersonal {
        hay();
        listaConductores.clear();
    }

    /**
     * elimina el que se ha visualizado
     *
     * @throws q13transporte.ExcepcionPersonal
     */
    public void borrar() throws ExcepcionPersonal {
        hay();
        listaConductores.remove(x);
    }

    public void borrarPorNombre(String nombre) throws ExcepcionPersonal, SQLException {
        hay();
        if (!(listaConductores.isEmpty())) {
            int i = 0;
            boolean borrado = false;
            do {
                if (nombre.equalsIgnoreCase(listaConductores.get(i).getNombre())) {
                    ConectaBBDD con = new ConectaBBDD();
                    String sentSql;

                    try {

                        con.conecta();
                        con.crearSentencia();
                        sentSql = "DELETE FROM `Conductores` WHERE `nombre` = '"+nombre+"' ";
                        System.out.println(sentSql);
                        con.updateSQL(sentSql);

                        con.cerrarConexion();
                        borrado = true;
                    } catch (SQLException ex) {
                        throw new ExcepcionPersonal(ex.getMessage());
                    }

                }
                i++;
            } while ((i < listaConductores.size()) && (!borrado));
            if (!borrado) {
                throw new ExcepcionPersonal("No se ha encotrodo el conductor para borrarlo");
            }
        }
        cargarConductores();

    }

    /**
     * Comprueba si hay conductores y si no lanza un Excepcion
     *
     * @throws ExcepcionPersonal
     */
    public void hay() throws ExcepcionPersonal {
        if (listaConductores.isEmpty()) {
            throw new ExcepcionPersonal("No hay conductores");
        }
    }

    /**
     * Comprueba si existe un conductor
     *
     * @param cond
     * @throws ExcepcionPersonal
     */
    public void existe(Conductor cond) throws ExcepcionPersonal {
        if (!(listaConductores.isEmpty())) {
            int i = 0;
            do {
                if (cond.getNombre().equalsIgnoreCase(listaConductores.get(i).getNombre())) {
                    throw new ExcepcionPersonal("El conductor ya existe");
                }
                if (cond.getCodConductor().equalsIgnoreCase(listaConductores.get(i).getCodConductor())) {
                    throw new ExcepcionPersonal("El conductor ya existe");
                }
                i++;
            } while (i <= listaConductores.size() - 1);
        }
    }

    public boolean buscar(Conductor co) throws ExcepcionPersonal {
        boolean boovar = false;
        hay();
        int i = 0;
        do {
            if (co.getNombre().equalsIgnoreCase(listaConductores.get(i).getNombre())) {
                boovar = true;
            }
            i++;
        } while ((i <= listaConductores.size() - 1) || (boovar == false));
        return boovar;
    }

    public Conductor devConductorNom(String nom) throws ExcepcionPersonal {
        hay();
        int i = 0;
        boolean boovar = false;
        Conductor devo = null;
        if (!(listaConductores.isEmpty())) {
            do {
                if (nom.equalsIgnoreCase(listaConductores.get(i).getNombre())) {
                    boovar = true;
                    devo = listaConductores.get(i);
                }
                i++;
            } while ((i < listaConductores.size()) && (boovar == false));
            if (!boovar) {
                throw new ExcepcionPersonal("No existe ese conductor");
            }
        } else {
            throw new ExcepcionPersonal("No hay conductores");
        }

        return devo;
    }

    public Conductor devConductorId(String id) throws ExcepcionPersonal {
        hay();
        int i = 0;
        boolean boovar = false;
        Conductor devo = null;
        if (!(listaConductores.isEmpty())) {
            do {
                if (id.equalsIgnoreCase(listaConductores.get(i).getCodConductor())) {
                    boovar = true;
                    devo = listaConductores.get(i);
                }
                i++;
            } while ((i < listaConductores.size()) && (boovar == false));
            if (!boovar) {
                throw new ExcepcionPersonal("No existe ese conductor");
            }
        } else {
            throw new ExcepcionPersonal("No hay conductores");
        }
        return devo;
    }

    private void cargarConductores() throws ExcepcionPersonal, SQLException {
        ConectaBBDD con = new ConectaBBDD();
        String sentSql;
            listaConductores.clear();
       

            con.conecta();
            con.crearSentencia();
            sentSql = "SELECT * FROM `Conductores`";
            con.ejecutaSQL(sentSql);
            while (con.rs.next()) {
                //System.out.println(con.rs.getString(1) + ", " + con.rs.getString(2));
                Conductor cond = new Conductor(con.rs.getString(1), con.rs.getString(2), con.rs.getFloat(3), con.rs.getDate(4));
                listaConductores.add(cond);
            }
            con.cerrarConexion();

        
    }
    
    public void modificar(Conductor cond) throws ExcepcionPersonal, SQLException{
        hay();
        ConectaBBDD con = new ConectaBBDD();
        String sentSql;
        if (!(listaConductores.isEmpty())) {
            

                    try {

                        con.conecta();
                        con.crearSentencia();
                        sentSql = "UPDATE `Conductores` SET `nombre`='"+cond.getNombre()+"',`salario`='"+cond.getSalario()+"',`fecha_alta`="+cond.getFecha_alta()+" WHERE `codConductor`='"+cond.getCodConductor()+"'";
                        System.out.println(sentSql);
                        con.updateSQL(sentSql);

                        con.cerrarConexion();
                        
                    } catch (SQLException ex) {
                        throw new ExcepcionPersonal(ex.getMessage());
                    }

                
        }
        cargarConductores();
        
    }

}

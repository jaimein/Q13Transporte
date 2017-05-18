/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q13transporte;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jaime
 */
public class ListaAutobus {

    //Atributos
    private ArrayList<Autobus> listaBuses = new ArrayList<Autobus>();
    private int x = 0;
//Constructor

    public ListaAutobus() throws ExcepcionPersonal, SQLException {
        cargarAutobuses();
    }

    /**
     * Metodo para añadir un busuctor a la lista, previamente comprueba si
     * existe
     *
     * @param bus
     * @return
     * @throws q13transporte.ExcepcionPersonal
     */
    public boolean insertar(Autobus bus) throws ExcepcionPersonal {
        if ("".equals(bus.getId())) {
            throw new ExcepcionPersonal("El ID no puede estar en blanco");
        }
        existe(bus);

        boolean boo = false;
        ConectaBBDD con = new ConectaBBDD();
        String sentSql = null;

        try {

            con.conecta();
            con.crearSentencia();
            if (bus instanceof AutobusUrbano) {
                sentSql = "INSERT INTO `Autobuses` (`numIdent`, `codConductor`, `precioBase`, `matricula`, `tipo`, `ruta`, `km`) VALUES ('" + bus.getId() + "', '" + bus.getConductor().getCodConductor() + "', '" + bus.getPrecioBaseViaje() + "', '" + bus.getMatricula().MatriculaToString() + "', '1', '" + ((AutobusUrbano) bus).getRuta() + "', '0'); ";
            }
            if (bus instanceof AutobusInterurbano) {
                sentSql = "INSERT INTO `Autobuses` (`numIdent`, `codConductor`, `precioBase`, `matricula`, `tipo`, `km`) VALUES ('" + bus.getId() + "', '" + bus.getConductor().getCodConductor() + "', '" + bus.getPrecioBaseViaje() + "', '" + bus.getMatricula().MatriculaToString() + "', '1', '" + ((AutobusInterurbano) bus).getKm() + "'); ";
            }
            System.out.println(sentSql);
            con.updateSQL(sentSql);

            con.cerrarConexion();
            cargarAutobuses();
            boo = true;
        } catch (SQLException ex) {
            throw new ExcepcionPersonal(ex.getMessage());
        }
//        cargarConductores();
        return boo;

    }

    /**
     * nos devuelve el siguiente elemento
     *
     * @return
     * @throws q13transporte.ExcepcionPersonal
     */
    public Autobus siguiente() throws ExcepcionPersonal {
        hay();
        x++;
        return listaBuses.get(x);
    }

    /**
     * nos devuelve el anterior elemento
     *
     * @return
     * @throws q13transporte.ExcepcionPersonal
     */
    public Autobus anterior() throws ExcepcionPersonal {
        hay();
        x--;
        return listaBuses.get(x);
    }

    /**
     * nos devuelve el primer elemento
     *
     * @return
     * @throws ExcepcionPersonal
     */
    public Autobus primer() throws ExcepcionPersonal {
        hay();
        x = 0;
        return listaBuses.get(x);
    }

    /**
     * nos devuele el ultimo
     *
     * @return
     * @throws q13transporte.ExcepcionPersonal
     */
    public Autobus ultimo() throws ExcepcionPersonal {
        hay();
        x = listaBuses.size() - 1;
        return listaBuses.get(x);
    }

    /**
     * pregunta si el que se esta mostrando es el ultimo
     *
     * @return
     * @throws q13transporte.ExcepcionPersonal
     */
    public boolean isUltimo() throws ExcepcionPersonal {
        hay();
        return listaBuses.size() - 1 == x;
    }

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
        listaBuses.clear();
        x=0;
    }

    /**
     * elimina el que se ha visualizado
     *
     * @throws q13transporte.ExcepcionPersonal
     */
    public void borrar() throws ExcepcionPersonal {
        hay();
        listaBuses.remove(x);
    }

    /**
     * elimina un autobus por su id
     *
     * @param id
     * @throws ExcepcionPersonal
     */
    public void borrarPorId(String id) throws ExcepcionPersonal {
        hay();
        int i = 0;
        boolean borrado = false;
        do {
            if (id.equalsIgnoreCase(listaBuses.get(i).getId())) {
                //listaBuses.remove(i);
                boolean boo = false;
                ConectaBBDD con = new ConectaBBDD();
                String sentSql;
                try {
                    con.conecta();
                    con.crearSentencia();
                    sentSql = "DELETE FROM `Autobuses` WHERE numIdent = '" + listaBuses.get(i).getId() + "'";
                    System.out.println(sentSql);
                    con.updateSQL(sentSql);

                    con.cerrarConexion();
                    boo = true;

                } catch (SQLException ex) {
                    throw new ExcepcionPersonal(ex.getMessage());
                }

                /////////////////////////////////////
                borrado = boo;
            }
            i++;
        } while ((i < listaBuses.size()) && (!borrado));
        if (!borrado) {
            throw new ExcepcionPersonal("No se ha encotrodo el id del bus para borrarlo");
        }

    }

    /**
     * Comprueba si hay buses y si no lanza un Excepcion
     *
     * @throws ExcepcionPersonal
     */
    public void hay() throws ExcepcionPersonal {
        if (listaBuses.isEmpty()) {
            throw new ExcepcionPersonal("No hay buses");
        }
    }

    /**
     * Comprueba si existe un bus
     *
     * @param bus
     * @throws ExcepcionPersonal
     */
    public void existe(Autobus bus) throws ExcepcionPersonal {
        if (!listaBuses.isEmpty()) {
            int i = 0;
            do {
                if (bus.getMatricula().getLetras().equalsIgnoreCase(listaBuses.get(i).getMatricula().getLetras())) {
                    if (bus.getMatricula().getNumero() == listaBuses.get(i).getMatricula().getNumero()) {
                        throw new ExcepcionPersonal("La matricula del bus ya existe");
                    }
                }
                if (bus.getId().equalsIgnoreCase(listaBuses.get(i).getId())) {
                    throw new ExcepcionPersonal("El id del bus ya existe");
                }
                i++;
            } while (i <= listaBuses.size() - 1);
        }

    }

    /**
     * Busca un bus y devuele si existe o no
     *
     * @param bus
     * @return
     * @throws ExcepcionPersonal
     */
    public boolean buscar(Autobus bus) throws ExcepcionPersonal {
        boolean boovar = false;
        hay();
        int i = 0;
        do {
            if (bus.getMatricula().getLetras().equalsIgnoreCase(listaBuses.get(i).getMatricula().getLetras())) {
                if (bus.getMatricula().getNumero() == listaBuses.get(i).getMatricula().getNumero()) {
                    boovar = true;
                }

            }
            i++;
        } while ((i <= listaBuses.size() - 1) || (boovar = true));
        return boovar;
    }

    /**
     * Busca un autobus por el Id y lo devuelve, null si no existe
     *
     * @param num_ident
     * @return
     * @throws ExcepcionPersonal
     */
    public Autobus devAutobus(String num_ident) throws ExcepcionPersonal {
        Autobus devo = null;
        boolean boovar = false;
        hay();
        int i = 0;
        if (listaBuses.isEmpty()) {
            throw new ExcepcionPersonal("No hay conductores");
        } else {
            do {
                if (num_ident.equalsIgnoreCase(listaBuses.get(i).getId())) {
                    devo = listaBuses.get(i);
                    boovar = true;
                }
                i++;
            } while ((i < listaBuses.size()) && (boovar == false));
            if (!boovar) {
                throw new ExcepcionPersonal("No existe ese conductor");
            }
        }

        return devo;
    }

    public ArrayList<Conductor> devConductoresBuses() {
        ArrayList<Conductor> devo = new ArrayList<Conductor>();
        if (!(listaBuses.isEmpty())) {
            int i = 0;
            do {
                devo.add(listaBuses.get(i).getConductor());
                i++;
            } while (i < listaBuses.size());
        }

        return devo;

    }

    private void cargarAutobuses() throws SQLException, ExcepcionPersonal {
        ListaConductores lc;
        lc = new ListaConductores();
        ConectaBBDD con = new ConectaBBDD();
        String sentSql;
        listaBuses.clear();
        x = 0;
        try {

            con.conecta();
            con.crearSentencia();
            sentSql = "SELECT a.numIdent,a.codConductor,a.precioBase,a.matricula,t.descripcion,a.ruta,a.km FROM Autobuses a,Tipos t WHERE a.tipo = t.codigo ";
            con.ejecutaSQL(sentSql);
            while (con.rs.next()) {
                System.out.println(con.rs.getString(5).equalsIgnoreCase("Urbano"));
                if (con.rs.getString(5).equalsIgnoreCase("Urbano")) {
                    AutobusUrbano bus = new AutobusUrbano(con.rs.getString(1), lc.devConductorId(con.rs.getString(2)), con.rs.getFloat(3), new Matricula(con.rs.getString(4).substring(0, 3), Long.parseLong(con.rs.getString(4).substring(3, 7))), con.rs.getString(5));
                    listaBuses.add(bus);
                }
                if (con.rs.getString(5).equalsIgnoreCase("Interurbano")) {
                    AutobusInterurbano bus = new AutobusInterurbano(con.rs.getString(1), lc.devConductorId(con.rs.getString(2)), con.rs.getFloat(3), new Matricula(con.rs.getString(4).substring(0, 3), Long.parseLong(con.rs.getString(4).substring(3, 7))), con.rs.getInt(6));
                    listaBuses.add(bus);
                }

                System.out.println(con.rs.getString(1) + ", " + con.rs.getString(5));

            }
            con.cerrarConexion();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Atención!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modificar(Autobus bus) throws ExcepcionPersonal {

        boolean boo = false;
        ConectaBBDD con = new ConectaBBDD();
        String sentSql = null;

        try {

            con.conecta();
            con.crearSentencia();
            if (bus instanceof AutobusUrbano) {
                sentSql = "UPDATE `Autobuses` SET `codConductor`=" + bus.getConductor().getCodConductor() + ",`precioBase`=" + bus.getPrecioBaseViaje() + ",`matricula`=" + bus.getMatricula().MatriculaToString() + ",`tipo`=1,`ruta`=" + ((AutobusUrbano) bus).getRuta() + ",`km`=0 WHERE numIdent='" + bus.getId() + "'";
            }
            if (bus instanceof AutobusInterurbano) {
                sentSql = "UPDATE `Autobuses` SET `codConductor`=" + bus.getConductor().getCodConductor() + ",`precioBase`=" + bus.getPrecioBaseViaje() + ",`matricula`='" + bus.getMatricula().MatriculaToString() + "',`tipo`=1,`km`=" + ((AutobusInterurbano) bus).getKm() + " WHERE numIdent='" + bus.getId() + "'";
            }
            System.out.println(sentSql);
            con.updateSQL(sentSql);

            con.cerrarConexion();
            cargarAutobuses();
            boo = true;
        } catch (SQLException ex) {
            throw new ExcepcionPersonal(ex.getMessage());
        }
//        cargarConductores();

    }

}

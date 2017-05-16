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

    /**
     * Metodo para añadir un busuctor a la lista, previamente comprueba si
     * existe
     *
     * @param bus
     * @return
     * @throws q12transporte.ExcepcionPersonal
     */
    public boolean insertar(Autobus bus) throws ExcepcionPersonal {
        if ("".equals(bus.getId())) {
            throw new ExcepcionPersonal("El ID no puede estar en blanco");
        }
        existe(bus);
        return listaBuses.add(bus);
    }

    /**
     * nos devuelve el siguiente elemento
     *
     * @return
     * @throws q12transporte.ExcepcionPersonal
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
     * @throws q12transporte.ExcepcionPersonal
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
     * @throws q12transporte.ExcepcionPersonal
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
     * @throws q12transporte.ExcepcionPersonal
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
     */
    public void limpiar() throws ExcepcionPersonal {
        hay();
        listaBuses.clear();
    }

    /**
     * elimina el que se ha visualizado
     *
     * @throws q12transporte.ExcepcionPersonal
     */
    public void borrar() throws ExcepcionPersonal {
        hay();
        listaBuses.remove(x);
    }

    public void borrarPorId(int id) throws ExcepcionPersonal {
        hay();
        int i = 0;
        boolean borrado = false;
        do {
            if (id == listaBuses.get(i).getId()) {
                listaBuses.remove(i);
                borrado = true;
            }
            i++;
        } while ((i <= listaBuses.size()) && (!borrado));
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
                        throw new ExcepcionPersonal("El bus ya existe");
                    }
                }
                if (bus.getId() == listaBuses.get(i).getId()) {
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
    public Autobus devAutobus(int num_ident) throws ExcepcionPersonal {
        Autobus devo = null;
        boolean boovar = false;
        hay();
        int i = 0;
        if (listaBuses.isEmpty()) {
            throw new ExcepcionPersonal("No hay conductores");
        } else {
            do {
                if (num_ident == listaBuses.get(i).getId()) {
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
    
    
}

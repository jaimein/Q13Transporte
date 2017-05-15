/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q13transporte;

import java.util.ArrayList;

/**
 *
 * @author jaime
 */
public class ListaConductores {

    //Atributos
    private ArrayList<Conductor> listaConductores = new ArrayList<Conductor>();
    private int x = 0;

    /**
     * Metodo para añadir un conductor a la lista, previamente comprueba si
     * existe
     *
     * @param cond
     * @return
     * @throws q13transporte.ExcepcionPersonal
     */
    public boolean insertar(Conductor cond) throws ExcepcionPersonal {

        existe(cond);
        if ("".equals(cond.getNombre())) {
            throw new ExcepcionPersonal("El nombre no puede estar en blanco");
        }
        return listaConductores.add(cond);
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

    public void borrarPorNombre(String nombre) throws ExcepcionPersonal {
        hay();
        if (!(listaConductores.isEmpty())) {
            int i = 0;
            boolean borrado = false;
            do {
                if (nombre.equalsIgnoreCase(listaConductores.get(i).getNombre())) {
                    listaConductores.remove(i);
                    borrado = true;
                }
                i++;
            } while ((i < listaConductores.size()) && (!borrado));
            if (!borrado) {
                throw new ExcepcionPersonal("No se ha encotrodo el conductor para borrarlo");
            }
        }

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

    public Conductor devConductorId(int id) throws ExcepcionPersonal {
        hay();
        int i = 0;
        boolean boovar = false;
        Conductor devo = listaConductores.get(id);
        return devo;
    }

}

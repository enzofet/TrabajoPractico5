/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Vistas.VentanaPrincipal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Naiara
 */
public class Directorio_Telefónico {

    TreeMap<Long, Contactos> agenda;

    public TreeMap<Long, Contactos> getAgenda() {
        return agenda;
    }

    public Directorio_Telefónico() {
        this.agenda = new TreeMap<>();
    }

    public void agregarContacto(Long telefono, Contactos cont) {
        if (!agenda.containsKey(telefono)) {
            agenda.put(telefono, cont);
            System.out.println("Contacto agendado." + agenda.size());
        } else {
            System.out.println("Nro de teléfono registrado bajo el nombre "
                    + agenda.get(telefono).getApellido() + agenda.get(telefono).getNombre());
        }

    }

    public Contactos buscarContacto(Long telefono) {
        Contactos vacio = new Contactos();
        if (agenda.isEmpty()) {
            System.out.println("La agenda aun no tiene contactos.");
            return vacio;
        } else {
            if (agenda.containsKey(telefono)) {
                System.out.println("Contacto encontrado \n-->");
                return agenda.get(telefono);
            } else {
                System.out.println("Teléfono no encontrado");
                return vacio;
            }
        }
    }

    public Set<Long> buscarTelefono(String apellido) {
        Set<Long> telefono = new HashSet<>();
        if (agenda.isEmpty()) {
            System.out.println("Agenda vacía.");
            return telefono;
        }
        for (Map.Entry<Long, Contactos> cont : agenda.entrySet()) {
            Contactos c = cont.getValue();
            if (c.getApellido().equalsIgnoreCase(apellido)) {
                telefono.add(cont.getKey());
            }
        }
        if (telefono.isEmpty()) {
            System.out.println("No hay telefono/s con ese apellido");
        } else {
            System.out.println("Telefono/s encontrado/s.");
        }
        return telefono;
    }

    public ArrayList<Contactos> BuscarContactos(String Ciudad) {
        ArrayList<Contactos> ContactosCiudad = new ArrayList<>();

        if (agenda.isEmpty()) {
            System.out.println("la agenda esta vacia");
            return ContactosCiudad;
        }
        agenda.entrySet().forEach((entrada) -> {
            Contactos contacto = entrada.getValue();
            if (contacto.getCiudad().equalsIgnoreCase(Ciudad)) {
                ContactosCiudad.add(contacto);
            }
        });
        if (ContactosCiudad.isEmpty()) {
            System.out.println("no se encontraron contactos en la ciudad ");
        } else {
            System.out.println("contacto encontrado ");
        }
        return ContactosCiudad;
    }

    public boolean borrarContacto(Long numeroTelefono) {
        if (agenda.containsKey(numeroTelefono)) {
            agenda.remove(numeroTelefono);
            return true;
        }
        return false;
    }

    public boolean claveExistente(Long numero) {
        return agenda.containsKey(numero);

    }

    public boolean eliminarPorDni(Long dni) {
        Long telefonoAEliminar = null;

        for (Map.Entry<Long, Contactos> entry : agenda.entrySet()) {
            Contactos contacto = entry.getValue();
            if (contacto.getDni() == dni) {
                telefonoAEliminar = entry.getKey();
                break;
            }
        }

        if (telefonoAEliminar != null) {
            agenda.remove(telefonoAEliminar);
            return true;
        }

        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Naiara
 */
public class Directorio_Telefónico {
    
    TreeMap<Long, Contactos> agenda = new TreeMap<>();
    
    public void agregarContacto(Long telefono, Contactos cont) {
        if (!agenda.isEmpty()) {
            if (!agenda.containsKey(telefono)) {
                agenda.put(telefono, cont);
                System.out.println("Contato agendado.");
            } else {
                System.out.println("Nro de teléfono registrado bajo el nombre "
                        + agenda.get(telefono).getApellido() + agenda.get(telefono).getNombre());
            }
        } else {
            System.out.println("Aún no hay contactos agendados.");
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
        }else{
            System.out.println("Telefono/s encontrado/s.");
        }
        return telefono;
    }
    
    public void borrarContacto(Long telefono){
        agenda.remove(telefono);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Ruben Dario Guarnizo
 */
public class Profesor extends Persona implements Serializable {
    
    private Usuario usuario;
    private String materiaDictada;
    private double cobroPorHora;
    private ArrayList<Clase> listaClases ;
    transient private TableModel horario;
    private DefaultTableModel horarioExportado;

    public Profesor(Usuario usuario, String materiaDictada, double cobroPorHora, ArrayList<Clase> listaClases, TableModel horario, String nombre, String apellido, String direccionMonedero, String contraseña, String correo, long telefono) {
        super(nombre, apellido, direccionMonedero, contraseña, correo, telefono);
        this.usuario = usuario;
        this.materiaDictada = materiaDictada;
        this.cobroPorHora = cobroPorHora;
        this.listaClases = listaClases;
        this.horario = horario;
        this.horarioExportado = (DefaultTableModel) horario;
    }

    public DefaultTableModel getHorarioExportado() {
        return horarioExportado;
    }

    public void setHorarioExportado(DefaultTableModel horarioExportado) {
        this.horarioExportado = horarioExportado;
    }

    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMateriaDictada() {
        return materiaDictada;
    }

    public void setMateriaDictada(String materiaDictada) {
        this.materiaDictada = materiaDictada;
    }

    public double getCobroPorHora() {
        return cobroPorHora;
    }

    public void setCobroPorHora(double cobroPorHora) {
        this.cobroPorHora = cobroPorHora;
    }

    public ArrayList<Clase> getListaClases() {
        return listaClases;
    }

    public void setListaClases(Clase cita) {
        listaClases = new ArrayList<>();
        listaClases.add(cita);
    }

    public TableModel getHorario() {
        return horario;
    }

    public void setHorario(TableModel horario) {
        this.horario = horario;
    }

    public Profesor() {
        
    }
    
    public void transformarModeloTabla(){
        
        this.horario = (TableModel) horarioExportado;
    }

    @Override
    public String toString()
    {
        return "Nombre: "+getNombre()+", "+"Apellido:"+getApellido()+", "+"Materia que dicta: "+getMateriaDictada()+", "+"Cobro por hora: "+getCobroPorHora();
    }
    

    
}

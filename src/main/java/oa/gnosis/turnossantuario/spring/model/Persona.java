/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue dise?ado para la Santa Iglesia Gnostica Universal, por Nestor Arias -nestor_arias@hotmail.com
 */
package oa.gnosis.turnossantuario.spring.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import oa.gnosis.turnossantuario.interfaces.CSVExportable;

/**
 * Persona inscrita en un santuario que espera turno para asistir
 *
 * @author nesto
 */
@Entity
@Table(name="persona")
@Data
public class Persona extends CSVExportable
        implements Serializable{
    @Id
    private Integer id;
    private String telefono;
    private String nombres;
    private String apellidos;

    @Override
    public OutputStream exportCSV(OutputStream out) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        bw.append(id+getSeparator()+nombres+getSeparator()+apellidos+getSeparator()+telefono);
        bw.newLine();
        return out;
    }

    @Override
    public InputStream importCSV(InputStream in) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        final String[] fields = br.readLine().split(getSeparator());
        int col=1;
        //No se carga el id.
        setNombres(fields[col++]);
        setApellidos(fields[col++]);
        setTelefono(fields[col++]);
        return in;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}

/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue diseñado para la Santa Iglesia Gnóstica Universal, por Nestor Arias -nestor_arias@hotmail.com
 */
package oa.gnosis.turnossantuario.spring.model.pk;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import lombok.Data;
import oa.gnosis.turnossantuario.spring.model.Ceremonia;
import oa.gnosis.turnossantuario.spring.model.Persona;

/**
 *
 * @author nesto
 */
@Data
public class AsistenciaPK implements Serializable{
    private Ceremonia ceremonia;
    private Date fecha;
    private Persona persona;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.ceremonia);
        hash = 41 * hash + Objects.hashCode(this.fecha);
        hash = 41 * hash + Objects.hashCode(this.persona);
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
        final AsistenciaPK other = (AsistenciaPK) obj;
        if (!Objects.equals(this.ceremonia, other.ceremonia)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        return true;
    }
    
}

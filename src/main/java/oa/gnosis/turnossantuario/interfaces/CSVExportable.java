/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue dise�ado para la Santa Iglesia Gnostica Universal, por Nestor Arias -nestor_arias@hotmail.com
 */
package oa.gnosis.turnossantuario.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import lombok.Data;

/**
 * Exportador a CSV
 * @author nesto
 */
@Data
public abstract class CSVExportable {

    /**
     * Separador para exportar a CSV
     */
    private String separator = ";";

    /**
     * Sobreescriba esto.
     * @param out
     * @return 
     * @throws java.io.IOException
     */
    public abstract OutputStream exportCSV(OutputStream out) throws IOException;

    /**
     * Sobreescriba esto.
     * @param in
     * @return 
     */
    public abstract InputStream importCSV(InputStream in) throws IOException;
}

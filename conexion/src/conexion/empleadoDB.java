/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import entidades.empleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alulab14
 */
public class empleadoDB {
    
    public ArrayList<empleado> devolverLista(){
        ArrayList<empleado> listaEmpleados = new ArrayList<empleado>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = 
                    DriverManager.getConnection("jdbc:mysql://50.62.209.73/inf282", 
                            "inf282", "inf282lp2");
            System.out.println("La conexion se ha realizado");
            Statement sentencia = con.createStatement();
            String query = "SELECT * FROM a20104699";
            ResultSet rs = sentencia.executeQuery(query);
            while(rs.next())
            {
                empleado e = new empleado();
                e.setDni(rs.getString("dni"));
                e.setApellido_materno(rs.getString("apellido_materno"));
                e.setApellido_paterno(rs.getString("apellido_paterno"));
                e.setNombres("nombre");
                listaEmpleados.add(e);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return listaEmpleados;
    }
}

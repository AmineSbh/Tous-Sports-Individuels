package test;

import java.util.Date;
import java.util.Iterator;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import data.Course;
import data.DBConnection;
import process.AddDataVisitor;

public class TestInscription {
	
	public static void main(String[] args) throws Exception {
		AnnotationConfiguration config = DBConnection.getConfig();
		SchemaExport schemaExport = new SchemaExport(config);
		schemaExport.create(true, true);
	  }

}

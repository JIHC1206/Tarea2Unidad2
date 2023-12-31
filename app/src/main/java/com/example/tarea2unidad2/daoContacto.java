package com.example.tarea2unidad2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoContacto {
    SQLiteDatabase bd;
    ArrayList<Contacto>lista = new ArrayList<Contacto>();
    Contacto c;
    Context ct;
    String nombreBD = "BDContactos";
    String tabla = "create table if not exists contacto(id integer primary key autoincrement, nombres text, telefono text, direccion text, pedido text)";

    public daoContacto(Context c){
        this.ct=c;
        bd = c.openOrCreateDatabase(nombreBD, Context.MODE_PRIVATE, null);
        bd.execSQL(tabla);
    }
    public boolean insertar(Contacto c){
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombres());
        contenedor.put("telefono", c.getTelefono());
        contenedor.put("direccion", c.getDireccion());
        contenedor.put("pedido", c.getPedido());
        return (bd.insert("contacto", null, contenedor))>0;
    }
    public boolean eliminar (int id){
        return (bd.delete("contacto","id= "+id, null))>0;
    }
    public boolean editar(Contacto c){
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombres());
        contenedor.put("telefono", c.getTelefono());
        contenedor.put("direccion", c.getDireccion());
        contenedor.put("pedido", c.getPedido());
        return (bd.update("contacto", contenedor,"id="+c.getId(),null))>0;
    }
    public ArrayList<Contacto>verTodo(){
        lista.clear();
        Cursor cursor = bd.rawQuery("select * from contacto",null);
        if (cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                lista.add(new Contacto(cursor.getInt(0),
                        cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4)));
            }while (cursor.moveToNext());
        }
        return lista;
    }
    public Contacto verUno(int posicion){
        Cursor cursor = bd.rawQuery("select * from contacto", null);
        cursor.moveToPosition(posicion);
        c=new Contacto(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4));
        return c;
    }

}

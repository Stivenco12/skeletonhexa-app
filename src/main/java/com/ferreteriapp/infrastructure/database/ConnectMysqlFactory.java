package com.ferreteriapp.infrastructure.database;

public class ConnectMysqlFactory {
    public static ConnectionDb crearConexion() {
        return new ConnMySql();
    }
}

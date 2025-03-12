package com.ferreteriapp;

import java.util.Scanner;

import com.ferreteriapp.application.usecase.Epscase;
import com.ferreteriapp.domain.Repositoy.EpsRepository;
import com.ferreteriapp.domain.entities.eps;
import com.ferreteriapp.infrastructure.Persistencia.EpsRepositoryImlp;
import com.ferreteriapp.infrastructure.database.ConnectMysqlFactory;

public class Main {
    public static void main(String[] args) {
        EpsRepository repositorio = new EpsRepositoryImlp(ConnectMysqlFactory.crearConexion());
        Epscase casoEps = new Epscase(repositorio);
        try (Scanner sc = new Scanner(System.in)){
            String menu;
            do {
                System.out.println("Menus de clientes");
                System.out.println("1.)Registrar cliente");
                System.out.println("2.)Buscar clientes");
                System.out.println("3.)Actualizar datos de un cliente");
                System.out.println("4.)Mostrar todos los clientes ");
                System.out.println("5.)Eliminar cliente");
                System.out.println("6.)Salir");
                System.out.print("Elige una opcion = ");
                menu = sc.nextLine();
                System.out.println("");
                switch (menu) {
                    case "1":
                        try {
                            System.out.print("Ingrese Nombre: ");
                            String nombre = sc.nextLine();
                            casoEps.save(nombre);    
                        } catch (Exception e) {
                            System.out.println("error vuelve a intentarlo");
                        }
                        break;
                    case "2":
                        try {
                            System.out.print("Ingrese el Id del cliente = ");
                            int idBuscar = sc.nextInt();
                            sc.nextLine();
                   
                            System.out.println("");
                        } catch (Exception e) {
                            System.out.println("error vuelve a intentarlo");
                            System.out.println("");
                        }

                        break;
                    case "3":
                        try {
                            System.out.print("Ingrese el Id de la persona a editar = ");
                            int idNuevo = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Ingrese el nuevo nombre del cliente = ");
                            String NombreNuevo = sc.nextLine();
                            casoEps.actualizarEps(NombreNuevo);
                        
                        } catch (Exception e) {
                            System.out.println("error vuelve a intentarlo");
                            System.out.println("");
                        }

                        break;
                    case "4":
                        try {
                            casoEps.ListarEps();
                            System.out.println("");
                        } catch (Exception e) {
                            System.out.println("error vuelve a intentarlo");
                            System.out.println("");
                        }

                        break;
                    case "5":
                        try {
                            System.out.print("Ingrese el Id de la persona a eliminar = ");
                            int idEliminar = sc.nextInt();
                            sc.nextLine();
                            casoEps.eliminarEps(idEliminar);
                            System.out.println("");
                        } catch (Exception e) {
                            System.out.println("error vuelve a intentarlo");
                            System.out.println("");
                        }

                        break;
                    case "6":
                        System.out.println("Saliendo.......");
                        System.out.println();
                        break;
                    default:
                        System.out.println("Dato seleccionado no existe, volviendo a menu........");
                        System.out.println();
                        break;
                }
            }while(!menu.equals("6"));
        }catch(Exception e) {
            System.out.println("Error por favor vuelve a iniciar el programa");
        }
    }
}
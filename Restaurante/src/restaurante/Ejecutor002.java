package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Ejecutor002 {
    public static void main(String[] args) {
        String[][] datos001 = {
                {"Niños 01", "2.00", "1", "1.5","1.5"},
                {"Niños 02", "3.00", "1", "1.5","1.5"},
                {"Niños 03", "2.00", "1.5","1.5"}
        };

        String[][] datos002 = {
                {"Econo 001", "4", "25"},
                {"Econo 002", "4", "15"},
                {"Econo 003", "4", "35"}
        };

        String[][] datos003 = {
                {"Dia 001", "5", "1", "1"},
                {"Dia 002", "6", "2", "2"},
                {"Dia 003", "5.5", "3", "1"},
        };

        String[][] datos004 = {
                {"Carta 001", "6", "1.5", "2", "10", "5"},
                {"Carta 002", "7", "1.7", "2.1", "5", "5"},
                {"Carta 003", "8", "1.9", "2.2", "5", "5"},
                {"Carta 004", "9", "2.5", "2.9", "5", "5"},
        };

        List<Menu> listaMenus = new ArrayList<>();

        // Generar objetos de tipo MenuNinos y agregarlos a la lista
       // Generar objetos de tipo MenuNinos y agregarlos a la lista
for (String[] datos : datos001) {
    String nombrePlato = datos[0];
    double valorMenu = Double.parseDouble(datos[1]);
    double valorInicial = Double.parseDouble(datos[2]);
    double valorHelado = Double.parseDouble(datos[3]);
    double valorPastel = Double.parseDouble(datos[4]);

    MenuNinos menuNinos = new MenuNinos(nombrePlato, valorMenu, valorInicial, valorHelado,valorPastel);
    listaMenus.add(menuNinos);
}


        // Generar objetos de tipo MenuEconomico y agregarlos a la lista
        for (String[] datos : datos002) {
            String nombrePlato = datos[0];
            double valorMenu = Double.parseDouble(datos[1]);
            double valorInicial = Double.parseDouble(datos[2]);
            double porcentajeDescuento = Double.parseDouble(datos[3]);

            MenuEconomico menuEconomico = new MenuEconomico(nombrePlato, valorMenu, valorInicial, porcentajeDescuento);
            listaMenus.add(menuEconomico);
        }

        // Generar objetos de tipo MenuDia y agregarlos a la lista
        for (String[] datos : datos003) {
            String nombrePlato = datos[0];
            double valorMenu = Double.parseDouble(datos[1]);
            double valorInicial = Double.parseDouble(datos[2]);
            double valorBebida = Double.parseDouble(datos[3]);
            double valorPostre = Double.parseDouble(datos[4]);

            MenuDia menuDia = new MenuDia(nombrePlato, valorMenu, valorInicial, valorBebida, valorPostre);
            listaMenus.add(menuDia);
        }

        // Generar objetos de tipo MenuCarta y agregarlos a la lista
        for (String[] datos : datos004) {
            String nombrePlato = datos[0];
            double valorMenu = Double.parseDouble(datos[1]);
            double valorInicial = Double.parseDouble(datos[2]);
            double valorGuarnicion = Double.parseDouble(datos[3]);
            double valorBebida = Double.parseDouble(datos[4]);
            double porcentajeServicio = Double.parseDouble(datos[5]);

            MenuCarta menuCarta = new MenuCarta(nombrePlato, valorMenu, valorInicial, valorGuarnicion, valorBebida, porcentajeServicio);
            listaMenus.add(menuCarta);
        }

        // Un objeto de tipo Cuenta
        Cuenta cuenta = new Cuenta("René Elizalde", 10);

        for (Menu menu : listaMenus) {
            cuenta.agregarMenu(menu);
        }

        cuenta.imprimirFactura();
    }
}

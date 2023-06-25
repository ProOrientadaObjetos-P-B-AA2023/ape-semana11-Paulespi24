package restaurante;

public class Ejecutor001 {
    public static void main(String[] args) {
        MenuNinos menuNinos1 = new MenuNinos("Niños 01", 4.50, 2.00, 1.00, 1.50);
        MenuNinos menuNinos2 = new MenuNinos("Niños 02", 5.50, 3.00, 1.00, 1.50);
        MenuEconomico menuEconomico = new MenuEconomico("Econo 001", 3.00, 4.00, 25.00);
        MenuDia menuDia = new MenuDia("Dia 001", 7.00, 5.00, 1.00, 1.00);
        MenuCarta menuCarta = new MenuCarta("Carta 001", 10.10, 6.00, 1.50, 2.00, 10.00);

        Cuenta cuenta = new Cuenta("René Elizalde", 10.0);

        cuenta.agregarMenu(menuNinos1);
        cuenta.agregarMenu(menuNinos2);
        cuenta.agregarMenu(menuEconomico);
        cuenta.agregarMenu(menuDia);
        cuenta.agregarMenu(menuCarta);

        cuenta.imprimirFactura();
    }
}
    


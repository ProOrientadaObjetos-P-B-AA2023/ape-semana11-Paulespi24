package restaurante;
import java.util.ArrayList;
import java.util.List;

abstract class Menu {
    private String nombrePlato;
    private double valorMenu;
    private double valorInicial;

    public Menu(String nombrePlato, double valorMenu, double valorInicial) {
        this.nombrePlato = nombrePlato;
        this.valorMenu = valorMenu;
        this.valorInicial = valorInicial;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public double getValorMenu() {
        return valorMenu;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public abstract void imprimirDetalles();
}

class MenuNinos extends Menu {
    private double valorHelado;
    private double valorPastel;

    public MenuNinos(String nombrePlato, double valorMenu, double valorInicial, double valorHelado, double valorPastel) {
        super(nombrePlato, valorMenu, valorInicial);
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
    }

    public double getValorHelado() {
        return valorHelado;
    }

    public double getValorPastel() {
        return valorPastel;
    }

    public void imprimirDetalles() {
        System.out.println("\tValor helado: " + getValorHelado());
        System.out.println("\tValor pastel: " + getValorPastel());
    }
}

class MenuEconomico extends Menu {
    private double porcentajeDescuento;

    public MenuEconomico(String nombrePlato, double valorMenu, double valorInicial, double porcentajeDescuento) {
        super(nombrePlato, valorMenu, valorInicial);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void imprimirDetalles() {
        System.out.println("\tPorcentaje Descuento: " + getPorcentajeDescuento());
    }
}

class MenuDia extends Menu {
    private double valorBebida;
    private double valorPostre;

    public MenuDia(String nombrePlato, double valorMenu, double valorInicial, double valorBebida, double valorPostre) {
        super(nombrePlato, valorMenu, valorInicial);
        this.valorBebida = valorBebida;
        this.valorPostre = valorPostre;
    }

    public double getValorBebida() {
        return valorBebida;
    }

    public double getValorPostre() {
        return valorPostre;
    }

    public void imprimirDetalles() {
        System.out.println("\tValor bebida: " + getValorBebida());
        System.out.println("\tValor postre: " + getValorPostre());
    }
}

class MenuCarta extends Menu {
    private double valorGuarnicion;
    private double valorBebida;
    private double porcentajeServicio;

    public MenuCarta(String nombrePlato, double valorMenu, double valorInicial, double valorGuarnicion, double valorBebida, double porcentajeServicio) {
        super(nombrePlato, valorMenu, valorInicial);
        this.valorGuarnicion = valorGuarnicion;
        this.valorBebida = valorBebida;
        this.porcentajeServicio = porcentajeServicio;
    }

    public double getValorGuarnicion() {
        return valorGuarnicion;
    }

    public double getValorBebida() {
        return valorBebida;
    }

    public double getPorcentajeServicio() {
        return porcentajeServicio;
    }

    public void imprimirDetalles() {
        System.out.println("\tValor guarnición: " + getValorGuarnicion());
        System.out.println("\tValor bebida: " + getValorBebida());
        System.out.println("\tPorcentaje Adicional: " + getPorcentajeServicio());
    }
}

class Cuenta {
    private String nombreCliente;
    private double iva;
    private List<Menu> menus;
    private double subtotal;
    private double valorTotal;

    public Cuenta(String nombreCliente, double iva) {
        this.nombreCliente = nombreCliente;
        this.iva = iva;
        this.menus = new ArrayList<>();
        this.subtotal = 0.0;
        this.valorTotal = 0.0;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIva() {
        return iva;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void agregarMenu(Menu menu) {
        menus.add(menu);
        subtotal += menu.getValorMenu();
        calcularTotal();
    }

    private void calcularTotal() {
        valorTotal = subtotal + (subtotal * (iva / 100));
    }

    public void imprimirFactura() {
        System.out.println("Factura");
        System.out.println("Cliente: " + nombreCliente);

        for (Menu menu : menus) {
            System.out.println();
            System.out.println(menu.getClass().getSimpleName() + ":");
            System.out.println("\tPlato: " + menu.getNombrePlato());
            System.out.println("\tValor Inicial: " + menu.getValorInicial());
            menu.imprimirDetalles();
            System.out.println("\tValor del Menú: " + menu.getValorMenu());
        }

        System.out.println();
        System.out.println("Subtotal: " + subtotal);
        System.out.println("IVA: " + iva + "%");
        System.out.println("Total a pagar: " + valorTotal);
    }
}







package producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

class Producto {
    String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double calcularValor() {
        return precio * cantidad;
    }
}

public class Inventario extends JFrame {
    private final LinkedList<Producto> listaProductos;
    private final DefaultTableModel tableModel;
    private final JTable jTable;

    public Inventario() {
        listaProductos = new LinkedList<>();

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Precio");
        tableModel.addColumn("Cantidad");

        jTable = new JTable(tableModel);

        JButton agregarButton = new JButton("Agregar Producto");
        agregarButton.addActionListener(e -> agregarProducto());

        JButton borrarButton = new JButton("Borrar Producto");
        borrarButton.addActionListener(e -> borrarProducto());

        JButton modificarButton = new JButton("Modificar Producto");
        modificarButton.addActionListener(e -> modificarProducto());

        JButton calcularTotalButton = new JButton("Calcular Total");
        calcularTotalButton.addActionListener(e -> calcularTotal());

        JPanel panel = new JPanel();
        panel.add(agregarButton);
        panel.add(borrarButton);
        panel.add(modificarButton);
        panel.add(calcularTotalButton);

        add(new JScrollPane(jTable));
        add(panel, "South");

        setTitle("Inventario");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarProducto() {
        String nombre = JOptionPane.showInputDialog("Nombre del producto:");
        double precio = obtenerValorNumerico("Precio del producto:");
        int cantidad = (int) obtenerValorNumerico("Cantidad del producto:");

        boolean productoExistente = listaProductos.stream()
                .anyMatch(producto -> producto.nombre.equalsIgnoreCase(nombre));

        if (productoExistente) {
            listaProductos.stream()
                    .filter(producto -> producto.nombre.equalsIgnoreCase(nombre))
                    .findFirst()
                    .ifPresent(producto -> producto.cantidad += cantidad);
        } else {
            Producto nuevoProducto = new Producto(nombre, precio, cantidad);
            listaProductos.add(nuevoProducto);
            agregarProductoATabla(nuevoProducto);
        }

        actualizarTabla();
    }

    private double obtenerValorNumerico(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido.");
            }
        }
    }

    private void borrarProducto() {
        int filaSeleccionada = jTable.getSelectedRow();

        if (filaSeleccionada != -1) {
            listaProductos.remove(filaSeleccionada);
            tableModel.removeRow(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para borrar.");
        }
    }

    private void modificarProducto() {
        int filaSeleccionada = jTable.getSelectedRow();

        if (filaSeleccionada != -1) {
            String nombre = JOptionPane.showInputDialog("Nuevo nombre del producto:");
            double precio = obtenerValorNumerico("Nuevo precio del producto:");
            int cantidad = (int) obtenerValorNumerico("Nueva cantidad del producto:");

            Producto productoModificado = new Producto(nombre, precio, cantidad);
            listaProductos.set(filaSeleccionada, productoModificado);
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para modificar.");
        }
    }

    private void calcularTotal() {
        double valorTotal = listaProductos.stream()
                .mapToDouble(Producto::calcularValor)
                .sum();

        JOptionPane.showMessageDialog(this, "El valor total del inventario es: $" + valorTotal);
    }

    private void agregarProductoATabla(Producto producto) {
        Object[] fila = {producto.nombre, producto.precio, producto.cantidad};
        tableModel.addRow(fila);
    }

    private void actualizarTabla() {
        tableModel.setRowCount(0);
        listaProductos.forEach(this::agregarProductoATabla);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Inventario::new);
    }
}


    
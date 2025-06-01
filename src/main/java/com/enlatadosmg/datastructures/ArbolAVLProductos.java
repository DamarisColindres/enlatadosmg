package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Producto;

public class ArbolAVLProductos {
    private NodoProducto raiz;

    public void insertar(Producto producto) {
        raiz = insertarRec(raiz, producto);
    }

    private NodoProducto insertarRec(NodoProducto nodo, Producto producto) {
        if (nodo == null) return new NodoProducto(producto);

        if (producto.getCodigo().compareTo(nodo.getProducto().getCodigo()) < 0)
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), producto));
        else if (producto.getCodigo().compareTo(nodo.getProducto().getCodigo()) > 0)
            nodo.setDerecho(insertarRec(nodo.getDerecho(), producto));
        else
            return nodo; // Código duplicado

        nodo.setAltura(1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));
        int balance = getBalance(nodo);

        // Rotaciones
        if (balance > 1 && producto.getCodigo().compareTo(nodo.getIzquierdo().getProducto().getCodigo()) < 0)
            return rotacionDerecha(nodo);

        if (balance < -1 && producto.getCodigo().compareTo(nodo.getDerecho().getProducto().getCodigo()) > 0)
            return rotacionIzquierda(nodo);

        if (balance > 1 && producto.getCodigo().compareTo(nodo.getIzquierdo().getProducto().getCodigo()) > 0) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && producto.getCodigo().compareTo(nodo.getDerecho().getProducto().getCodigo()) < 0) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    public Producto buscar(String codigo) {
        NodoProducto actual = raiz;
        while (actual != null) {
            int cmp = codigo.compareTo(actual.getProducto().getCodigo());
            if (cmp == 0) return actual.getProducto();
            actual = (cmp < 0) ? actual.getIzquierdo() : actual.getDerecho();
        }
        return null;
    }

    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(NodoProducto nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.getIzquierdo());
            System.out.println(nodo.getProducto());
            inOrdenRec(nodo.getDerecho());
        }
    }

    // Auxiliares
    private int altura(NodoProducto n) {
        return (n == null) ? 0 : n.getAltura();
    }

    private int getBalance(NodoProducto n) {
        return (n == null) ? 0 : altura(n.getIzquierdo()) - altura(n.getDerecho());
    }

    private NodoProducto rotacionDerecha(NodoProducto y) {
        NodoProducto x = y.getIzquierdo();
        NodoProducto t2 = x.getDerecho();

        x.setDerecho(y);
        y.setIzquierdo(t2);

        y.setAltura(Math.max(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);
        x.setAltura(Math.max(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);

        return x;
    }

    private NodoProducto rotacionIzquierda(NodoProducto x) {
        NodoProducto y = x.getDerecho();
        NodoProducto t2 = y.getIzquierdo();

        y.setIzquierdo(x);
        x.setDerecho(t2);

        x.setAltura(Math.max(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);
        y.setAltura(Math.max(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);

        return y;
    }

    // Actualizamos stock
    public boolean actualizarStock(String codigo, int nuevoStock) {
        NodoProducto nodo = buscarNodo(raiz, codigo);
        if (nodo == null) return false;

        nodo.getProducto().setStock(nuevoStock);
        return true;
    }

    private NodoProducto buscarNodo(NodoProducto nodo, String codigo) {
        if (nodo == null) return null;

        int cmp = codigo.compareTo(nodo.getProducto().getCodigo());
        if (cmp == 0) return nodo;
        if (cmp < 0) return buscarNodo(nodo.getIzquierdo(), codigo);
        return buscarNodo(nodo.getDerecho(), codigo);
    }

    // Buscamos por nombre o categoria
    public void buscarPorNombre(String nombreBuscado) {
        System.out.println("Productos con nombre que contiene '" + nombreBuscado + "':");
        buscarPorNombreRec(raiz, nombreBuscado.toLowerCase());
    }

    private void buscarPorNombreRec(NodoProducto nodo, String nombreBuscado) {
        if (nodo != null) {
            buscarPorNombreRec(nodo.getIzquierdo(), nombreBuscado);
            if (nodo.getProducto().getNombre().toLowerCase().contains(nombreBuscado)) {
                System.out.println(nodo.getProducto());
            }
            buscarPorNombreRec(nodo.getDerecho(), nombreBuscado);
        }
    }

    public void buscarPorCategoria(String categoriaBuscada) {
        System.out.println("Productos de la categoría '" + categoriaBuscada + "':");
        buscarPorCategoriaRec(raiz, categoriaBuscada.toLowerCase());
    }

    private void buscarPorCategoriaRec(NodoProducto nodo, String categoriaBuscada) {
        if (nodo != null) {
            buscarPorCategoriaRec(nodo.getIzquierdo(), categoriaBuscada);
            if (nodo.getProducto().getCategoria().toLowerCase().equals(categoriaBuscada)) {
                System.out.println(nodo.getProducto());
            }
            buscarPorCategoriaRec(nodo.getDerecho(), categoriaBuscada);
        }
    }

    // Para eliminar productos
    public void eliminar(String codigo) {
        raiz = eliminarRec(raiz, codigo);
    }

    private NodoProducto eliminarRec(NodoProducto nodo, String codigo) {
        if (nodo == null) return null;

        int cmp = codigo.compareTo(nodo.getProducto().getCodigo());

        if (cmp < 0) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), codigo));
        } else if (cmp > 0) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), codigo));
        } else {
            // Nodo encontrado

            // Caso 1: un solo hijo o sin hijos
            if (nodo.getIzquierdo() == null)
                return nodo.getDerecho();
            else if (nodo.getDerecho() == null)
                return nodo.getIzquierdo();

            // Caso 2: dos hijos — obtener sucesor (mínimo en el subárbol derecho)
            NodoProducto sucesor = minValorNodo(nodo.getDerecho());
            nodo.setProducto(sucesor.getProducto());
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), sucesor.getProducto().getCodigo()));
        }

        // Actualizar altura y balancear
        nodo.setAltura(1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));
        int balance = getBalance(nodo);

        // Rotaciones necesarias
        if (balance > 1 && getBalance(nodo.getIzquierdo()) >= 0)
            return rotacionDerecha(nodo);

        if (balance > 1 && getBalance(nodo.getIzquierdo()) < 0) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && getBalance(nodo.getDerecho()) <= 0)
            return rotacionIzquierda(nodo);

        if (balance < -1 && getBalance(nodo.getDerecho()) > 0) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private NodoProducto minValorNodo(NodoProducto nodo) {
        NodoProducto actual = nodo;
        while (actual.getIzquierdo() != null)
            actual = actual.getIzquierdo();
        return actual;
    }

    public String generarDot() {
        StringBuilder dot = new StringBuilder();
        dot.append("node [shape=record];\n");
        generarDotRecursivo(raiz, dot);
        return dot.toString();
    }

    private void generarDotRecursivo(NodoProducto nodo, StringBuilder dot) {
        if (nodo == null) return;

        Producto p = nodo.getProducto();
        dot.append(String.format("\"%s\" [label=\"{%s | Stock: %d}\"];\n",
                p.getCodigo(), p.getNombre(), p.getStock()));

        if (nodo.getIzquierdo() != null) {
            dot.append(String.format("\"%s\" -> \"%s\";\n",
                    p.getCodigo(), nodo.getIzquierdo().getProducto().getCodigo()));
            generarDotRecursivo(nodo.getIzquierdo(), dot);
        }

        if (nodo.getDerecho() != null) {
            dot.append(String.format("\"%s\" -> \"%s\";\n",
                    p.getCodigo(), nodo.getDerecho().getProducto().getCodigo()));
            generarDotRecursivo(nodo.getDerecho(), dot);
        }
    }
}

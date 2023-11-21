package com.example.proyectodbp.Back.Controllers;

import com.example.proyectodbp.Back.Entities.Categoria;
import com.example.proyectodbp.Back.Entities.Producto;
import com.example.proyectodbp.Back.Services.CategoriaService;
import com.example.proyectodbp.Back.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProductoService productoService;


    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.findAllCategorias();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getCategoriaById(@PathVariable String id) {
        return categoriaService.findCategoriaById(id);
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    @PutMapping("/{id}")
    public Categoria updateCategoria(@PathVariable String id, @RequestBody Categoria categoria) {
        categoria.setId(id); // Asegurarse de que la categoría tenga el ID correcto
        return categoriaService.saveCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable String id) {
        categoriaService.deleteCategoria(id);
    }


    @GetMapping("/{categoriaId}/productos")
    public List<Producto> getProductosByCategoriaId(@PathVariable String categoriaId) {
        Optional<Categoria> categoria = categoriaService.findCategoriaById(categoriaId);
        if (categoria.isPresent()) {
            return categoria.get().getProductos();
        } else {
            // Manejar el caso en el que la categoría no existe
            // Puedes devolver un error 404 o un mensaje adecuado
            return null;
        }
    }

    @GetMapping("/{categoriaId}/productos/{productoId}")
    public Optional<Producto> getProductoById(
            @PathVariable String categoriaId,
            @PathVariable Long productoId) {
        Optional<Categoria> categoria = categoriaService.findCategoriaById(categoriaId);
        if (categoria.isPresent()) {
            // Obtener la lista de productos de la categoría
            List<Producto> productos = categoria.get().getProductos();
            // Buscar el producto por ID en la lista de productos
            Optional<Producto> producto = productos.stream()
                    .filter(p -> p.getId().equals(productoId))
                    .findFirst();
            return producto;
        } else {
            // Manejar el caso en el que la categoría no existe
            // Puedes devolver un error 404 o un mensaje adecuado
            return null;
        }
    }

    @PostMapping("/{categoriaId}/productos")
    public Producto createProducto(
            @PathVariable String categoriaId,
            @RequestBody Producto producto) {
        Optional<Categoria> categoria = categoriaService.findCategoriaById(categoriaId);
        if (categoria.isPresent()) {
            producto.setCategoria(categoria.get()); // Asignar la categoría al producto
            return productoService.saveProducto(producto);
        } else {
            // Manejar el caso en el que la categoría no existe
            // Puedes devolver un error 404 o un mensaje adecuado
            return null;
        }
    }

    @PutMapping("/{categoriaId}/productos/{productoId}")
    public Producto updateProducto(
            @PathVariable String categoriaId,
            @PathVariable Long productoId,
            @RequestBody Producto producto) {
        Optional<Categoria> categoria = categoriaService.findCategoriaById(categoriaId);
        if (categoria.isPresent()) {
            // Verificar si el producto existe en la categoría
            List<Producto> productos = categoria.get().getProductos();
            Optional<Producto> existingProducto = productos.stream()
                    .filter(p -> p.getId().equals(productoId))
                    .findFirst();
            if (existingProducto.isPresent()) {
                // Actualizar los datos del producto y guardarlos
                producto.setId(existingProducto.get().getId());
                producto.setCategoria(categoria.get()); // Asegurarse de que la categoría sea la correcta
                return productoService.saveProducto(producto);
            } else {
                // Manejar el caso en el que el producto no existe en la categoría
                // Puedes devolver un error 404 o un mensaje adecuado
                return null;
            }
        } else {
            // Manejar el caso en el que la categoría no existe
            // Puedes devolver un error 404 o un mensaje adecuado
            return null;
        }
    }

    @DeleteMapping("/{categoriaId}/productos/{productoId}")
    public void deleteProducto(
            @PathVariable String categoriaId,
            @PathVariable Long productoId) {
        Optional<Categoria> categoria = categoriaService.findCategoriaById(categoriaId);
        if (categoria.isPresent()) {
            // Verificar si el producto existe en la categoría
            List<Producto> productos = categoria.get().getProductos();
            Optional<Producto> existingProducto = productos.stream()
                    .filter(p -> p.getId().equals(productoId))
                    .findFirst();
            if (existingProducto.isPresent()) {
                // Eliminar el producto
                productoService.deleteProducto(productoId);
            } else {
                // Manejar el caso en el que el producto no existe en la categoría
                // Puedes devolver un error 404 o un mensaje adecuado
            }
        } else {
            // Manejar el caso en el que la categoría no existe
            // Puedes devolver un error 404 o un mensaje adecuado
        }
    }
}
package com.example.erp.service;

import com.example.erp.dto.ProductDTO;
import com.example.erp.entity.Product;
import com.example.erp.exception.ResourceNotFoundException;
import com.example.erp.repository.InventoryRepository;
import com.example.erp.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<ProductDTO> getAllProducts() {
        return inventoryRepository.findAll().stream()
                .map(MapperUtil::mapToProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = MapperUtil.mapToProduct(productDTO);
        Product savedProduct = inventoryRepository.save(product);
        return MapperUtil.mapToProductDTO(savedProduct);
    }

    public ProductDTO updateProductQuantity(Long id, int quantity) {
        Product product = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setQuantity(quantity);
        product.setLastUpdated(java.time.LocalDateTime.now());
        Product updatedProduct = inventoryRepository.save(product);
        return MapperUtil.mapToProductDTO(updatedProduct);
    }
}

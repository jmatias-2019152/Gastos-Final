package com.gastos.seguimiento.repository;



import com.gastos.seguimiento.model.gasto.Gastos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastosRepository extends MongoRepository<Gastos, String> {
}
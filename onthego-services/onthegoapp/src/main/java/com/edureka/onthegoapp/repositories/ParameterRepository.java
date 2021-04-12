package com.edureka.onthegoapp.repositories;

import com.edureka.onthegoapp.models.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {
    public List<Parameter> findByParamName(String paramName);
}

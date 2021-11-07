package com.comp303.lab2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comp303.lab2.Models.Program;

public interface ProgramRepository extends JpaRepository<Program, String>{

}

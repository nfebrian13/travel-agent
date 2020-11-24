package com.travel.nana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.nana.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}

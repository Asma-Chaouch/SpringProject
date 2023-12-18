package com.SDE.demo.Repository;

import com.SDE.demo.Enities.Admin;
import com.SDE.demo.Enities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends  JpaRepository<Contact,Long> {
    @Query("select count(*) from  Contact")
    long countById();
}

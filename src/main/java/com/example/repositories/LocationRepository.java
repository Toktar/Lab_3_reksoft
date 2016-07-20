package com.example.repositories;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//import io.spring.guides.gs_producing_web_service.Location;
import com.example.models.Contact;
import com.example.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
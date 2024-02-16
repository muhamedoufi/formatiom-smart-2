package smart.formation.starter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.formation.starter.entity.Server;

@Repository
public interface ServerRepository extends JpaRepository<Server, Long>{
    
}
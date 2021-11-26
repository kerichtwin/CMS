package com.cinocms.demo.repositories;

import com.cinocms.demo.model.ChildrensRoomsEntity;
import com.cinocms.demo.model.ChildrensRoomsGalleriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildrensRoomsGalleriesRepository extends JpaRepository<ChildrensRoomsGalleriesEntity,Integer> {
    List<ChildrensRoomsGalleriesEntity> findByChildrensRoomsByChildrensRoomFk(ChildrensRoomsEntity childrensRoomsEntity);
}

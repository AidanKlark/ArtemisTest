package com.test.artemistest.repository;

import com.test.artemistest.models.ArtemisLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtemisRepository extends JpaRepository<ArtemisLogEntity, Long> {
}

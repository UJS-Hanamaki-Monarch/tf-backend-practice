package org.tf.web.backend.dao;

import org.springframework.data.repository.CrudRepository;
import org.tf.web.backend.dto.BucketCallbackDTO;

public interface BucketRepository extends CrudRepository<BucketCallbackDTO, Integer> {
}

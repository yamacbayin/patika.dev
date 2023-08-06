package com.yamacbayin.erp.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

/**
 * A custom repository interface that extends JpaRepository for common CRUD operations
 * on entities. It provides additional methods for working with entities based on UUIDs.
 *
 * <p>By extending this interface, other repositories can inherit its functionality
 * while adding specific methods tailored to the requirements of different entity types.
 *
 * @param <T> The type of entity managed by the repository.
 */
@NoRepositoryBean
public interface IRepository<T> extends JpaRepository<T, Long> {
    /**
     * Retrieves an entity by its unique identifier (UUID).
     *
     * @param uuid The UUID of the entity to retrieve.
     * @return An Optional containing the entity, or an empty Optional if not found.
     */
    Optional<T> findByUuid(UUID uuid);

    /**
     * Deletes an entity by its unique identifier (UUID).
     *
     * @param uuid The UUID of the entity to delete.
     */
    @Modifying
    void deleteByUuid(UUID uuid);
}

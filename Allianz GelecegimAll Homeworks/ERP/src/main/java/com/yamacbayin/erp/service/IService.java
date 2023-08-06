package com.yamacbayin.erp.service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * The base service interface for performing common CRUD operations on entities.
 * This interface provides methods for creating, retrieving, updating, and deleting
 * entities based on their UUIDs.
 *
 * @param <T> The type of entity managed by the service.
 * @param <A> The type of object used for creating entities.
 */
public interface IService<T, A> {

    /**
     * Creates a new entity based on the provided object.
     *
     * @param a The object containing data for creating the entity.
     * @return The created entity.
     */
    @Transactional
    T create(A a);

    /**
     * Retrieves a list of all entities.
     *
     * @return A list containing all entities.
     */
    List<T> findAll();

    /**
     * Retrieves an entity by its unique identifier (UUID).
     *
     * @param uuid The UUID of the entity to retrieve.
     * @return The retrieved entity, or null if not found.
     */
    T findByUuid(UUID uuid);

    /**
     * Updates an entity based on its unique identifier (UUID) and the provided entity object.
     *
     * @param uuid The UUID of the entity to update.
     * @param t    The updated entity object.
     * @return The updated entity.
     */
    @Transactional
    T updateByUuid(UUID uuid, T t);

    /**
     * Deletes an entity by its unique identifier (UUID).
     *
     * @param uuid The UUID of the entity to delete.
     * @return True if the entity was successfully deleted, false otherwise.
     */
    @Transactional
    Boolean deleteByUuid(UUID uuid);

}

package com.yamacbayin.erp.service;

import com.yamacbayin.erp.database.entity.SettingsEntity;
import com.yamacbayin.erp.database.repository.SettingsRepository;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class responsible for managing application settings.
 */
@Service
public class SettingsService {
    private final SettingsRepository settingsRepository;

    private final JdbcTemplate jdbcTemplate;


    /**
     * A map containing key-value pairs of application settings.
     */
    @Getter
    private Map<String, Integer> settingsMap;

    /**
     * Constructs a new SettingsService with the specified repositories and template.
     *
     * @param settingsRepository The repository for managing settings entities.
     * @param jdbcTemplate       The JDBC template for executing SQL queries.
     */
    @Autowired
    public SettingsService(SettingsRepository settingsRepository, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.settingsRepository = settingsRepository;
    }

    /**
     * Initializes the settings map by populating it with values from the database.
     * If the database is empty, default settings are inserted and loaded.
     */
    @PostConstruct
    public void initSettingsMap() {
        settingsMap = new HashMap<>();
        List<SettingsEntity> settingsList = settingsRepository.findAll();

        if (settingsList.isEmpty()) {
            insertData("TAX", 18);
            settingsList = settingsRepository.findAll();
        }

        for (SettingsEntity setting : settingsList) {
            settingsMap.put(setting.getKey(), setting.getValue());
        }
    }

    /**
     * Inserts default settings data into the database.
     *
     * @param key   The key of the setting.
     * @param value The value of the setting.
     */
    private void insertData(String key, int value) {
        String sql = "INSERT INTO settings (key, value) VALUES (?, ?)";
        jdbcTemplate.update(sql, key, value);
    }

}

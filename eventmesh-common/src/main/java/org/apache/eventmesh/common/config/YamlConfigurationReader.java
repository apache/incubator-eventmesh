package org.apache.eventmesh.common.config;

import org.apache.eventmesh.common.EventMeshRuntimeException;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class YamlConfigurationReader {

    private Map<String, Object> configProperties;

    public YamlConfigurationReader(String yamlFilePath) throws IOException {
        loadAllConfig(yamlFilePath);
    }

    /**
     * get int property
     *
     * @param configKey    config key
     * @param defaultValue default value
     * @return if configKey is not exist, return the default value
     */
    public int getInt(String configKey, int defaultValue) {
        Object configValue = getProperty(configKey);
        if (configValue == null) {
            return defaultValue;
        }
        if (!(configValue instanceof Integer)) {
            throw new EventMeshRuntimeException(
                    String.format("configKey: %s, configValue: %s is invalid", configKey, configValue));
        }
        return (int) configValue;
    }

    /**
     * get boolean property
     *
     * @param configKey    config key
     * @param defaultValue default value
     * @return if config key is not exist, return the default value
     */
    public boolean getBool(String configKey, boolean defaultValue) {
        Object configValue = getProperty(configKey);
        if (configValue == null) {
            return defaultValue;
        }
        if (!(configValue instanceof Boolean)) {
            throw new EventMeshRuntimeException(
                    String.format("configKey: %s, configValue: %s is invalid", configKey, configValue)
            );
        }
        return Boolean.parseBoolean(configValue.toString());
    }

    /**
     * get string property
     *
     * @param configKey    config key
     * @param defaultValue default value
     * @return if configKey is not exist, return the default value
     */
    public String getString(String configKey, String defaultValue) {
        Object configValue = getProperty(configKey);
        if (configValue == null) {
            return defaultValue;
        }
        return configValue.toString();
    }

    /**
     * get string property
     *
     * @param configKey    config key
     * @param defaultValue default value
     * @return if configKey is not exist, return the default value
     */
    public List<String> getList(String configKey, List<String> defaultValue) {
        Object configValue = getProperty(configKey);
        if (!(configValue instanceof List)) {
            return defaultValue;
        }
        return (List<String>) configValue;
    }

    private Object getProperty(String configKey) {
        Map<String, Object> config = configProperties;
        String[] subKeys = configKey.split("\\.");
        for (int i = 0; i < subKeys.length - 1; i++) {
            if (config == null) {
                break;
            }
            Object subConfig = config.get(subKeys[i]);
            if (!(subConfig instanceof Map) && i != subKeys.length - 1) {
                config = null;
            } else {
                config = (Map<String, Object>) config.get(subKeys[i]);
            }
        }
        if (config == null) {
            return null;
        }
        return config.get(subKeys[subKeys.length - 1]);
    }

    private void loadAllConfig(String yamlFilePath) throws IOException {
        try (FileReader fileReader = new FileReader(yamlFilePath)) {
            Yaml yaml = new Yaml();
            configProperties = yaml.load(fileReader);
            if (configProperties == null) {
                throw new EventMeshRuntimeException(String.format("Yaml config file: %s is empty", yamlFilePath));
            }
        }
    }

}

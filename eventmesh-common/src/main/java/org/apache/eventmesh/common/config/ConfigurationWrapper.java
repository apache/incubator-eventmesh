/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.eventmesh.common.config;

import org.apache.eventmesh.common.file.FileChangeContext;
import org.apache.eventmesh.common.file.FileChangeListener;
import org.apache.eventmesh.common.file.WatchFileManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;

public class ConfigurationWrapper {

    public static final Logger LOG = LoggerFactory.getLogger(ConfigurationWrapper.class);

    private final transient String directoryPath;

    private final transient String fileName;

    private final transient Properties properties = new Properties();

    private final transient String file;

    private final transient boolean reload;

    private final transient FileChangeListener fileChangeListener = new FileChangeListener() {
        @Override
        public void onChanged(FileChangeContext changeContext) {
            load();
        }

        @Override
        public boolean support(FileChangeContext changeContext) {
            return changeContext.getWatchEvent().context().toString().contains(fileName);
        }
    };

    public ConfigurationWrapper(String directoryPath, String fileName, boolean reload) {
        Preconditions.checkArgument(Strings.isNotEmpty(directoryPath), "please configure environment variable 'confPath'");
        this.directoryPath = directoryPath
                .replace('/', File.separator.charAt(0))
                .replace('\\', File.separator.charAt(0));
        this.fileName = fileName;
        this.file = (directoryPath + File.separator + fileName)
                .replace('/', File.separator.charAt(0))
                .replace('\\', File.separator.charAt(0));
        this.reload = reload;
        init();
    }

    private void init() {
        load();
        if (this.reload) {
            WatchFileManager.registerFileChangeListener(directoryPath, fileChangeListener);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                LOG.info("Configuration reload task closed");
                WatchFileManager.deregisterFileChangeListener(directoryPath);
            }));
        }
    }

    private void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            LOG.info("loading config: {}", file);
            properties.load(reader);
        } catch (IOException e) {
            LOG.error("loading properties [{}] error", file, e);
        }
    }

    public String getProp(String key) {
        return StringUtils.isEmpty(key) ? null : properties.getProperty(key, null);
    }

    public int getIntProp(String configKey, int defaultValue) {
        String configValue = StringUtils.deleteWhitespace(getProp(configKey));
        if (StringUtils.isEmpty(configValue)) {
            return defaultValue;
        }
        Preconditions.checkState(StringUtils.isNumeric(configValue),
                String.format("key:%s, value:%s error", configKey, configValue));
        return Integer.parseInt(configValue);
    }

    public boolean getBoolProp(String configKey, boolean defaultValue) {
        String configValue = StringUtils.deleteWhitespace(getProp(configKey));
        if (StringUtils.isEmpty(configValue)) {
            return defaultValue;
        }
        return Boolean.parseBoolean(configValue);
    }

    private String removePrefix(String key, String prefix, boolean removePrefix) {
        String newPrefix = prefix.endsWith(".") ? prefix : prefix + ".";
        return removePrefix ? key.replace(newPrefix, "") : key;
    }

    public Properties getPropertiesByConfig(String prefix, boolean isRemovePrefix) {
        Properties properties = new Properties();
        for (Entry<Object, Object> entry : this.properties.entrySet()) {
            String key = (String) entry.getKey();
            if (key.startsWith(prefix)) {
                properties.put(removePrefix(key, prefix, isRemovePrefix), entry.getValue());
            }
        }
        return properties;
    }

    @SuppressWarnings("unchecked")
    public <T> T getPropertiesByConfig(String prefix, Class<?> clazz, boolean removePrefix) {
        ObjectMapper objectMapper = new ObjectMapper();
        return (T) objectMapper.convertValue(getPropertiesByConfig(prefix, removePrefix), clazz);
    }

    public Properties getProperties() {
        return this.properties;
    }

}
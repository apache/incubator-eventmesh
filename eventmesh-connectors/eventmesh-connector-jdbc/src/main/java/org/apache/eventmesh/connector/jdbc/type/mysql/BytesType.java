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

package org.apache.eventmesh.connector.jdbc.type.mysql;

import org.apache.eventmesh.connector.jdbc.dialect.DatabaseDialect;
import org.apache.eventmesh.connector.jdbc.table.catalog.Column;
import org.apache.eventmesh.connector.jdbc.type.eventmesh.BytesEventMeshDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BytesType extends BytesEventMeshDataType {

    public static final BytesType INSTANCE = new BytesType();

    private static final List<String> BINARY_REGISTRATION_KEYS = Arrays.asList("BINARY", "binary", "VARBINARY", "varbinary");

    private static final List<String> BLOB_REGISTRATION_KEYS = Arrays.asList("TINYBLOB", "tinyblob", "BLOB", "blob", "MEDIUMBLOB", "mediumblob",
        "LONGBLOB", "longblob");

    @Override
    public List<String> ofRegistrationKeys() {
        List<String> registrationCodes = new ArrayList<>();
        registrationCodes.addAll(super.ofRegistrationKeys());
        registrationCodes.addAll(BINARY_REGISTRATION_KEYS);
        registrationCodes.addAll(BLOB_REGISTRATION_KEYS);
        return registrationCodes;
    }

    @Override
    public String getDefaultValue(DatabaseDialect<?> databaseDialect, Column<?> column) {
        // https://dev.mysql.com/doc/refman/8.0/en/blob.html
        // BLOB and TEXT columns cannot have DEFAULT values
        if (BLOB_REGISTRATION_KEYS.contains(column.getNativeType())) {
            return "";
        }
        // binary use hex string,e.g: 0x01020304
        return column.getDefaultValue() != null ? "0x" + column.getDefaultValue() : "NULL";
    }

    @Override
    public String getTypeName(Column<?> column) {
        if (BLOB_REGISTRATION_KEYS.contains(column.getNativeType())) {
            return column.getNativeType();
        }
        if (BINARY_REGISTRATION_KEYS.contains(column.getNativeType())) {
            final int lengthValue = Optional.ofNullable(column.getColumnLength()).orElse(1L).intValue();
            return String.format("%s(%d)", column.getNativeType(), lengthValue);
        }
        return "binary(1)";
    }
}

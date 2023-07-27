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

package org.apache.eventmesh.metrics.prometheus.metrics;

import static org.apache.eventmesh.metrics.prometheus.utils.PrometheusExporterUtils.observeOfValue;

import org.apache.eventmesh.metrics.api.model.Metric;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.opentelemetry.api.metrics.GlobalMeterProvider;
import io.opentelemetry.api.metrics.Meter;

public abstract class PrometheusExporter<T> {

    /**
     * Map structure : [metric name, description of name] -> the method of get corresponding metric.
     */
    protected final Map<String[], Function<T, Number>> paramPairs = new HashMap<>();

    protected abstract String getMetricName(String[] metricInfo);

    protected abstract String getMetricDescription(String[] metricInfo);

    protected abstract String getProtocol();

    public void export(final String meterName, final Metric metric) {
        final Meter meter = GlobalMeterProvider.getMeter(meterName);
        paramPairs.forEach((metricInfo, getMetric) ->
            observeOfValue(meter, getMetricName(metricInfo), getMetricDescription(metricInfo), getProtocol(), metric, getMetric));
    }
}

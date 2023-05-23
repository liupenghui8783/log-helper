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

package com.redick.support.mysql;

import static com.redick.constant.TraceTagConstant.SQL_EXEC_AFTER;
import static com.redick.constant.TraceTagConstant.SQL_EXEC_BEFORE;
import static net.logstash.logback.marker.Markers.append;

import com.mysql.cj.MysqlConnection;
import com.mysql.cj.Query;
import com.mysql.cj.interceptors.QueryInterceptor;
import com.mysql.cj.log.Log;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.ServerSession;
import com.redick.util.LogUtil;
import java.util.Properties;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 * @author Redick01
 */
@Slf4j
public class Mysql8QueryInterceptor implements QueryInterceptor {

    @Override
    public QueryInterceptor init(MysqlConnection mysqlConnection, Properties properties, Log log) {
        return null;
    }

    @Override
    public <T extends Resultset> T preProcess(Supplier<String> supplier, Query query) {
        String start = String.valueOf(System.currentTimeMillis());
        MDC.put("sql_exec_time", start);
        log.info(LogUtil.customizeMarker(LogUtil.kLOG_KEY_TRACE_TAG, SQL_EXEC_BEFORE), "开始执行sql");
        return null;
    }

    @Override
    public boolean executeTopLevelOnly() {
        return false;
    }

    @Override
    public void destroy() {

    }

    @Override
    public <T extends Resultset> T postProcess(Supplier<String> supplier, Query query, T t,
            ServerSession serverSession) {
        long start = Long.parseLong(MDC.get("sql_exec_time"));
        long end = System.currentTimeMillis();
        log.info(LogUtil.customizeMarker(LogUtil.kLOG_KEY_TRACE_TAG, SQL_EXEC_AFTER)
                .and(append(LogUtil.kLOG_KEY_DURATION, end - start)), "结束执行sql");
        return null;
    }
}

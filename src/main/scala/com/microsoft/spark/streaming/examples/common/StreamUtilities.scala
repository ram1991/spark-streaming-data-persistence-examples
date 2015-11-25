/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.microsoft.spark.streaming.examples.common

object StreamUtilities {

  def getSqlJdbcConnectionString(sqlServerFQDN: String, sqlDatabaseName: String,
                             databaseUsername: String, databasePassword: String): String = {

    val serverName = sqlServerFQDN.split('.')(0)
    val certificateHostname = sqlServerFQDN.replace(serverName, "*")
    val serverPort = "1433"

    val sqlDatabaseConnectionString = f"jdbc:sqlserver://$sqlServerFQDN:$serverPort;database=$sqlDatabaseName;" +
      f"user=$databaseUsername@$serverName;password=$databasePassword;" +
      f"encrypt=true;hostNameInCertificate=$certificateHostname;loginTimeout=30;"

    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")

    sqlDatabaseConnectionString
  }
}
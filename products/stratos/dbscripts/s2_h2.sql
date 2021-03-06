/*
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements. See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership. The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied. See the License for the
* specific language governing permissions and limitations
* under the License.
*/ 

--
-- Create schema s2_db
--

-- CREATE SCHEMA  IF NOT EXISTS s2_db; 
-- SET SCHEMA s2_db;

--
-- Definition of table s2_db.CARTRIDGE_INSTANCE
--

DROP TABLE IF EXISTS CARTRIDGE_INSTANCE;
CREATE TABLE  CARTRIDGE_INSTANCE (
  ID int(11) NOT NULL AUTO_INCREMENT,
  INSTANCE_IP varchar(255) NOT NULL,
  TENANT_ID int(11) DEFAULT NULL,
  TENANT_DOMAIN varchar(255) DEFAULT NULL,
  CARTRIDGE_TYPE varchar(255) NOT NULL,
  STATE varchar(255) NOT NULL,
  CLUSTER_DOMAIN varchar(255) NOT NULL,
  CLUSTER_SUBDOMAIN varchar(255) NOT NULL,
  PRIMARY KEY (ID)
);

--
-- Definition of table CARTRIDGE_SUBSCRIPTION
--

DROP TABLE IF EXISTS CARTRIDGE_SUBSCRIPTION;
CREATE TABLE  CARTRIDGE_SUBSCRIPTION (
  SUBSCRIPTION_ID int(11) NOT NULL AUTO_INCREMENT,
  TENANT_ID int(11) NOT NULL,
  CARTRIDGE varchar(30) NOT NULL,
  PROVIDER varchar(30) NOT NULL,
  HOSTNAME varchar(255) NOT NULL,
  POLICY varchar(50) NULL,
  CLUSTER_DOMAIN varchar(255) NOT NULL,
  CLUSTER_SUBDOMAIN varchar(255) NOT NULL,
  MGT_DOMAIN varchar(255) NOT NULL,
  MGT_SUBDOMAIN varchar(255) NOT NULL,
  STATE varchar(30) NOT NULL,
  ALIAS varchar(255) NOT NULL,
  TENANT_DOMAIN varchar(255) NOT NULL,
  BASE_DIR varchar(255) NOT NULL,
  REPO_ID int(11) DEFAULT NULL,
  DATA_CARTRIDGE_ID int(11) DEFAULT NULL,
  MAPPED_DOMAIN varchar(255),
  PRIMARY KEY (SUBSCRIPTION_ID)
);



--
-- Definition of table DATA_CARTRIDGE
--

DROP TABLE IF EXISTS DATA_CARTRIDGE;
CREATE TABLE  DATA_CARTRIDGE (
  DATA_CART_ID int(11) NOT NULL AUTO_INCREMENT,
  TYPE varchar(30) NOT NULL,
  USER_NAME varchar(255) NOT NULL,
  PASSWORD varchar(255) NOT NULL,
  STATE varchar(255) NOT NULL,
  PRIMARY KEY (DATA_CART_ID) 
);


--
-- Definition of table PORT_MAPPING
--

DROP TABLE IF EXISTS PORT_MAPPING;
CREATE TABLE  PORT_MAPPING (
  PORT_MAPPING_ID int(11) NOT NULL AUTO_INCREMENT,
  SUBSCRIPTION_ID int(11) NOT NULL,
  TYPE varchar(30) NOT NULL,
  PRIMARY_PORT varchar(30) NOT NULL,
  PROXY_PORT varchar(30) NOT NULL,
  STATE varchar(30) NOT NULL,
  PRIMARY KEY (PORT_MAPPING_ID)
);


--
-- Definition of table REPOSITORY
--

DROP TABLE IF EXISTS REPOSITORY;
CREATE TABLE  REPOSITORY (
  REPO_ID int(11) NOT NULL AUTO_INCREMENT,
  REPO_NAME varchar(255) NOT NULL,
  STATE varchar(30) NOT NULL,
  REPO_USER_NAME varchar(255) NOT NULL,
  REPO_USER_PASSWORD varchar(255) NOT NULL,
  PRIMARY KEY (REPO_ID)
);

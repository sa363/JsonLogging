/*
 *
 *  * Copyright 2002-2022 the Sergey Anisimov <s.anisimov@gmail.com>
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 *
 */

-- liquibase formatted sql

-- changeset Sergey:1655727571727-1
CREATE TABLE json_data
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    uuid      UUID NOT NULL,
    json_data VARCHAR,
    CONSTRAINT pk_json_data PRIMARY KEY (id)
);

-- changeset Sergey:1655727571727-2
ALTER TABLE json_data
    ADD CONSTRAINT uc_json_data_uuid UNIQUE (uuid);


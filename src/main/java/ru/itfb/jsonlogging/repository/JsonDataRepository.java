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

package ru.itfb.jsonlogging.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itfb.jsonlogging.model.JsonData;

import java.util.Optional;
import java.util.UUID;

public interface JsonDataRepository extends CrudRepository<JsonData, Long> {
    public Optional<JsonData> findByUuid(UUID uuid);
    public boolean existsByUuid(UUID uuid);
}
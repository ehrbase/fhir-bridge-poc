/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehrbase.fhirbridge.ehr.converter.generic;

import com.nedap.archie.rm.generic.PartySelf;
import org.ehrbase.client.classgenerator.interfaces.EntryEntity;
import org.hl7.fhir.r4.model.Resource;
import org.springframework.lang.NonNull;

public abstract class EntryEntityConverter<R extends Resource, E extends EntryEntity> implements RMEntityConverter<R, E> {
    @Override
    public E convert(@NonNull R resource) {
        E entity = convertInternal(resource);
        // FIXME: this considers the entry is not null, there could be cases where the entry is optional and there is no data in the fhir resource to map with
        entity.setLanguage(resolveLanguageOrDefault(resource));
        entity.setSubject(new PartySelf());
        return entity;
    }

    protected abstract E convertInternal(R resource);
}

/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.dmn.engine.feel.function.helper;

import org.camunda.feel.impl.spi.JavaFunction;
import org.camunda.feel.impl.spi.JavaFunctionProvider;
import org.camunda.feel.interpreter.impl.ValString;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SpiFunctionProvider extends JavaFunctionProvider {

  protected Map<String, JavaFunction> functions = new HashMap<>();

  public SpiFunctionProvider(String name, String value) {
    functions.put(name, new JavaFunction(Collections.emptyList(),
      (args) -> new ValString(value)));
  }

  @Override
  public Optional<JavaFunction> resolveFunction(String functionName) {
    return Optional.ofNullable(functions.get(functionName));
  }

  @Override
  public Collection<String> getFunctionNames() {
    return functions.keySet();
  }

}

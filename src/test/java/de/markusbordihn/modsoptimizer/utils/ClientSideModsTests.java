/*
 * Copyright 2022 Markus Bordihn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.markusbordihn.modsoptimizer.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.markusbordihn.modsoptimizer.data.TestData;
import org.junit.jupiter.api.Test;

class ClientSideModsTests {

  @Test
  void testIsClientSide() {
    for (String clientMod : TestData.clientModList) {
      boolean isClientSide = ClientSideMods.isClientSide(clientMod);
      System.out.printf("Client Mod: %s = %s\n", clientMod, isClientSide);
      assertTrue(isClientSide);
    }
    for (String generalMod : TestData.modList) {
      boolean isClientSide = ClientSideMods.isClientSide(generalMod);
      System.out.printf("General Mod: %s = %s\n", generalMod, isClientSide);
      assertFalse(isClientSide);
    }
  }
}
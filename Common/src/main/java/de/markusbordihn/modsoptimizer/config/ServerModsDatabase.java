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

package de.markusbordihn.modsoptimizer.config;

import java.util.Arrays;
import java.util.List;

public class ServerModsDatabase {

  /** List of client side mods, which are confirmed to be client-side only! */
  private static final List<String> clientSideModsList =
      Arrays.asList(
          "adaptive_performance_tweaks",
          "adaptive_performance_tweaks_core",
          "adaptive_performance_tweaks_gamerules",
          "adaptive_performance_tweaks_items",
          "adaptive_performance_tweaks_player",
          "adaptive_performance_tweaks_spawn",
          "alternate-current",
          "discordsrv",
          "e4mc",
          "publicguiannouncement",
          "villagerdeathmessages");

  protected ServerModsDatabase() {}

  public static List<String> getServerSideModsList() {
    return clientSideModsList;
  }
}
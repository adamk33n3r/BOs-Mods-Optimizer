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

package de.markusbordihn.modsoptimizer;

import de.markusbordihn.modsoptimizer.client.TitleScreenHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkConstants;

@Mod(de.markusbordihn.modsoptimizer.Constants.MOD_ID)
public class ModsOptimizer {

  public ModsOptimizer() {
    final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

    // Make sure the mod being absent on the other network side does not cause the client to display
    // the server as incompatible
    ModLoadingContext.get()
        .registerExtensionPoint(
            IExtensionPoint.DisplayTest.class,
            () ->
                new IExtensionPoint.DisplayTest(
                    () -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));

    // Time measurement event.
    DistExecutor.unsafeRunWhenOn(
        Dist.CLIENT,
        () ->
            () -> {
              Constants.LOG.info(
                  "{} Adding time measurement event listener ...", Constants.LOG_PREFIX);
              forgeEventBus.addListener(TitleScreenHandler::handleInitScreenEvent);
              forgeEventBus.addListener(TitleScreenHandler::handleScreenOpenEvent);
            });
  }
}
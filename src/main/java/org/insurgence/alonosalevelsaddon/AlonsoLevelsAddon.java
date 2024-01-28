package org.insurgence.alonosalevelsaddon;

import org.insurgence.alonosalevelsaddon.listeners.AlonsoLevelsEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;
import org.insurgencedev.insurgenceboosters.libs.fo.Common;

@IBoostersAddon(name = "AlonsoLevelsAddon", version = "1.0.0", author = "InsurgenceDev", description = "AlonsoLevels Support")
public class AlonsoLevelsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadAblesStart() {
        if (Common.doesPluginExist("AlonsoLevels")) {
            registerEvent(new AlonsoLevelsEventListener());
        }
    }
}

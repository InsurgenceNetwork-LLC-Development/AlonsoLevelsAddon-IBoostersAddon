package org.insurgence.alonosalevelsaddon;

import org.bukkit.Bukkit;
import org.insurgence.alonosalevelsaddon.listeners.AlonsoLevelsEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "AlonsoLevelsAddon", version = "1.0.0", author = "InsurgenceDev", description = "AlonsoLevels Support")
public class AlonsoLevelsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        if (Bukkit.getPluginManager().isPluginEnabled("AlonsoLevels")) {
            registerEvent(new AlonsoLevelsEventListener());
        }
    }
}

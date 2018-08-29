package uk.co.siterwell.sitersdk

class PluginVer(var majorVer: Int, var middleVer: Int, var minVer: Int) {
    override fun toString() : String {
        return  "$majorVer.$middleVer.$minVer"
    }
}

class PluginItem(val pluginAppName: String,
                 val pluginDisplayName: String,
                 val pluginPackageName: String,
                 val pluginVer: PluginVer,
                 val iconRes: Int,
                 var installed: Boolean)
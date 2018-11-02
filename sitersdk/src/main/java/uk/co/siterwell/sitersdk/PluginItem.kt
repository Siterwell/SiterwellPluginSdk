package uk.co.siterwell.sitersdk

class PluginVer {
    var majorVer = 0
    var middleVer = 0
    var minVer = 0
    constructor(majorVer: Int, middleVer: Int, minVer: Int) {
        this.majorVer = majorVer
        this.middleVer = middleVer
        this.minVer = minVer
    }

    constructor(version: String) {
        val splitStr = version.split(".")
        splitStr.forEachIndexed{index, _ver ->
            when (index) {
                0 -> majorVer = _ver.toInt()
                1 -> middleVer = _ver.toInt()
                2 -> minVer = _ver.toInt()
            }
        }
    }

    override fun toString() : String {
        return  "$majorVer.$middleVer.$minVer"
    }
}

class PluginItem(val pluginAppName: String,
                 val pluginDisplayName: String,
                 val pluginPackageName: String,
                 val pluginProtocol: String,
                 val pluginLaunchActivity: String,
                 val pluginMainActivity: String,
                 var currPluginVer: PluginVer,
                 var latestPluginVer: PluginVer?,
                 val iconRes: Int,
                 var installed: Boolean)
package me.scoretwo.fastscript.expansion.kotlinscript

import me.scoretwo.fastscript.expansion.typeengine.TypeEngineExpansion
import org.jetbrains.kotlin.cli.common.repl.KotlinJsr223JvmScriptEngineBase

class KotlinScriptExpansion: TypeEngineExpansion() {
    override val name = "Kotlin"
    override val sign = "kts"
    override val fileSuffix = "kts"
    override val engine = scriptEngineManager.getEngineByExtension("kts")
}

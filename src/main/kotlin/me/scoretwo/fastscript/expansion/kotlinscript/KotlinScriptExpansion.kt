package me.scoretwo.fastscript.expansion.kotlinscript

import me.scoretwo.fastscript.expansion.typeengine.TypeEngineExpansion
import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory
import javax.script.ScriptEngine

class KotlinScriptExpansion: TypeEngineExpansion() {
    override val name = "KotlinScript"
    override val sign = "kts"
    override val fileSuffix = "kts"
    override val engine = KotlinJsr223JvmLocalScriptEngineFactory().scriptEngine
}
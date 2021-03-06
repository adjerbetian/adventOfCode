package day18.vault

sealed class MapElement
object Wall : MapElement()
object Tunnel : MapElement()

sealed class TunnelElement(val letter: Char): MapElement() {
    override fun equals(other: Any?) = if (other is TunnelElement) letter == other.letter else false
    override fun toString() = letter.toString()
    override fun hashCode() = letter.hashCode()
}

class Key(letter: Char) : TunnelElement(letter) {
    constructor(letter: String) : this(letter[0])

    fun opens(door: Door) = door.letter.toLowerCase() == letter
    fun getDoor() = Door(letter.toUpperCase())
}

class Door(letter: Char) : TunnelElement(letter) {
    fun getKey() = Key(letter.toLowerCase())
    fun isLocked(keys: Collection<Key>) = !keys.any { it.opens(this) }
}

object Entrance : TunnelElement('@')
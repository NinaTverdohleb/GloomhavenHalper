package com.rumpilstilstkin.gloomhavenhelper.domain.entity.quest

import kotlinx.serialization.KSerializer
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable(with = CharacterTaskItem.Serializer::class)
sealed interface CharacterTaskItem {
    val id: Int
    val type: String
    val completed: Boolean
    val priority: Int

    @Serializable
    data class Check(
        override val id: Int,
        override val priority: Int,
        val text: String,
        val isChecked: Boolean = false
    ) : CharacterTaskItem {
        override val completed: Boolean
            get() = isChecked
        override val type: String
            get() = TaskType.Check.name
    }

    @Serializable
    data class Count(
        override val id: Int,
        override val priority: Int,
        val text: String,
        val count: Int = 0,
        val currentCount: Int = 0
    ) : CharacterTaskItem {
        override val completed: Boolean
            get() = count <= currentCount
        override val type: String
            get() = TaskType.Count.name
    }

    object Serializer : KSerializer<CharacterTaskItem> {
        val json = Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = true
            prettyPrint = true
            coerceInputValues = true
        }
        override val descriptor: SerialDescriptor
            get() = PolymorphicSerializer(CharacterTaskItem::class).descriptor
        override fun serialize(encoder: Encoder, value: CharacterTaskItem) {
            when (value) {
                is Check -> encoder.encodeSerializableValue(Check.serializer(), value)
                is Count -> encoder.encodeSerializableValue(Count.serializer(), value)
            }
        }

        override fun deserialize(decoder: Decoder): CharacterTaskItem {
            val jsonElement = (decoder as JsonDecoder).decodeJsonElement()
            return when (val itemType = jsonElement.jsonObject["type"]?.jsonPrimitive?.content) {
                TaskType.Count.name -> json.decodeFromJsonElement(Count.serializer(), jsonElement)
                TaskType.Check.name -> json.decodeFromJsonElement(Check.serializer(), jsonElement)
                else -> throw SerializationException("Unknown itemType: $itemType")
            }
        }
    }
}